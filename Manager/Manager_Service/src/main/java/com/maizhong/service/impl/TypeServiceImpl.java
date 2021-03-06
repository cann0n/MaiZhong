package com.maizhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.maizhong.common.dto.carTypeDTO;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.common.utils.SqlUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.TbCarTypeMapper;
import com.maizhong.pojo.TbCarType;
import com.maizhong.pojo.TbCarTypeExample;
import com.maizhong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:汽车类别接口实现
 * User: 王存浩
 * Date: 2017-03-06
 * Time: 11:13
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TbCarTypeMapper tbCarTypeMapper;
    @Autowired
    private JedisClient jedisClient;


    @Value("${CAR_TYPE}")
    private String CAR_TYPE;


    @Override
    public TbCarType getCarTypeByid(Long id) {
        TbCarTypeExample tbCarTypeExample = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = tbCarTypeExample.createCriteria();
        criteria.andIdEqualTo(id).andDelflagEqualTo(0);
        List<TbCarType> carType = tbCarTypeMapper.selectByExample(tbCarTypeExample);
        if (carType == null || carType.size() == 0) return null;
        return carType.get(0);
    }

    @Override
    public PageResult getCarTypeList(PageSearchParam param) {
        PageHelper.startPage(param.getPageIndex(), param.getPageSize());

        TbCarTypeExample example = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = example.createCriteria();
        if (param.getFiled("typeName") != null) {
            criteria.andTypeNameLike(SqlUtils.getLikeSql(param.getFiled("typeName")));
        }

        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("type_sequence ASC,id ASC");
        List<TbCarType> list = tbCarTypeMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(list);

        return new PageResult(pageInfo);
    }


    @Override
    public String getCarTypeListAll() {

        TbCarTypeExample example = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("Type_sequence ASC,id ASC");
        List<TbCarType> list = tbCarTypeMapper.selectByExample(example);
        return JsonUtils.objectToJson(list);
    }

    @Override
    public OperateEnum insertCarType(TbCarType tbCarType) {

        TbCarTypeExample tbCarTypeExample = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = tbCarTypeExample.createCriteria();
        criteria.andTypeNameEqualTo(tbCarType.getTypeName());
        List<TbCarType> carType = tbCarTypeMapper.selectByExample(tbCarTypeExample);
        if (carType.size() > 0) {
            return OperateEnum.NAME_REPEAT;
        }

        int res = tbCarTypeMapper.insertSelective(tbCarType);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum updateCarType(TbCarType tbCarType) {
        int res = tbCarTypeMapper.updateByPrimaryKeySelective(tbCarType);
        if (res > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public OperateEnum deleteCarTypeById(long id) {
        TbCarType carType = new TbCarType();
        carType.setId(id);
        carType.setDelflag(1);
        int ret = tbCarTypeMapper.updateByPrimaryKeySelective(carType);
        if (ret > 0) {
            return OperateEnum.SUCCESS;
        } else {
            return OperateEnum.FAILE;
        }
    }

    @Override
    public int updateTypeAdvert(String carTypeAdvertImgUrl, long id) {
        //更新类别示例图片
        TbCarType carType = new TbCarType();
        carType.setId(id);
        carType.setTypeImg(carTypeAdvertImgUrl);
        int res = tbCarTypeMapper.updateByPrimaryKeySelective(carType);
        return res;
    }

    //更新汽车种类缓存
    @Override
    public JsonResult updateTypeRedis() {
        try {
          jedisClient.del(CAR_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TbCarTypeExample example = new TbCarTypeExample();
        TbCarTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("type_sequence ASC,id ASC");
        List<TbCarType> list = tbCarTypeMapper.selectByExample(example);
        List<carTypeDTO> resList = Lists.newArrayList();
        for (TbCarType tbCarType : list) {
            resList.add(new carTypeDTO(tbCarType.getId(), tbCarType.getTypeName(), tbCarType.getTypeImg()));
        }
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(resList);
            jedisClient.set(CAR_TYPE, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.build(OperateEnum.SUCCESS);
    }
}

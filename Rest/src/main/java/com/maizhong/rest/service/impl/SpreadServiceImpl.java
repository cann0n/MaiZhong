package com.maizhong.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.maizhong.common.dto.*;
import com.maizhong.common.enums.DicParentEnum;
import com.maizhong.common.enums.OperateEnum;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.dao.JedisClient;
import com.maizhong.mapper.*;
import com.maizhong.pojo.*;
import com.maizhong.rest.service.SpreadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-03-13
 * Time: 15:07
 */

@Service
public class SpreadServiceImpl implements SpreadService {

    @Autowired
    private TbAdvertMapper tbAdvertMapper;
    @Autowired
    private TbCarBrandMapper tbCarBrandMapper;
    @Autowired
    private TbCarTypeMapper tbCarTypeMapper;
    @Autowired
    private TbCarColumnMapper tbCarColumnMapper;
    @Autowired
    private TbFeedbackMapper tbFeedbackMapper;
    @Autowired
    private TbConsultMapper tbConsultMapper;
    @Autowired
    private TbCarBrandLineMapper tbCarBrandLineMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${AD_HOME}")
    private String AD_HOME;

    //基础库汽车品牌
    @Value("${CAR_BRAND}")
    private String CAR_BRAND;

    @Value("${CAR_TYPE}")
    private String CAR_TYPE;

    @Value("${CM_CONTENT}")
    private String CM_CONTENT;

    @Value("${DIC_KEY}")
    private String DIC_KEY;

    @Value("${CAR_SERIES}")
    private String CAR_SERIES;

    //热门10中 车的品牌
    @Value("${CAR_BRAND_HOT}")
    private String CAR_BRAND_HOT;


    /**
     * 根据栏目Id获取栏目下的所有汽车
     *
     * @param columnId
     * @return
     */
    @Override
    public JsonResult getCarColumnById(Integer columnId, Integer number) {

        if (number <= 0) {
            number = 1;
        }
        int size = 0;
        //缓存命中
        try {
            String json = jedisClient.get(CM_CONTENT);
            if (StringUtils.isNotBlank(json)) {
                return JsonResult.OK(JsonUtils.jsonToList(json, CarShowIndex.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dicJson = jedisClient.hget(DIC_KEY, DicParentEnum.CMID + "");
        List<KeyValue> dicList = JsonUtils.jsonToList(dicJson, KeyValue.class);
        List<CarShowIndex> carShowList = new ArrayList<>();
        for (KeyValue keyValue : dicList) {
            List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, Long.valueOf(keyValue.getKey()));
            if (list != null && list.size() > 0) {
                CarShowIndex car_show = new CarShowIndex(Long.valueOf(keyValue.getKey()), keyValue.getValue());

            }
        }

        List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, null);
        //获取列表


        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(CM_CONTENT, columnId + "", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list != null) {
            size = list.size();
            if (size <= number) {
                return JsonResult.OK(list);
            } else {
                return JsonResult.OK(list.subList(0, number));
            }

        } else {
            return JsonResult.OK(null);
        }
    }

    @Override
    public List<CarShowIndex> getHomeItem() {
        //缓存命中
        try {
            String json = jedisClient.get(CM_CONTENT);
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToList(json, CarShowIndex.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String dicJson = jedisClient.hget(DIC_KEY, DicParentEnum.CMID.getState() + "");
        List<KeyValue> dicList = JsonUtils.jsonToList(dicJson, KeyValue.class);
        List<CarShowIndex> carShowList = new ArrayList<>();
        for (KeyValue keyValue : dicList) {
            List<CarColumnJoinCar> list = tbCarColumnMapper.getListByColumn(1L, Long.valueOf(keyValue.getKey()));
            if (list != null && list.size() > 0) {
                CarShowIndex car_show = new CarShowIndex(Long.valueOf(keyValue.getKey()), keyValue.getValue());
                List<CarIndexDetail> carIndexList = new ArrayList<>();
                for (CarColumnJoinCar carColumnJoinCar : list) {
                    carIndexList.add(new CarIndexDetail(carColumnJoinCar.getCarId(), carColumnJoinCar.getName(),carColumnJoinCar.getFactoryPrice(),
                            carColumnJoinCar.getImage(),carColumnJoinCar.getReservePrice(),carColumnJoinCar.getSellPrice()));
                }
                car_show.setArry(carIndexList);
                carShowList.add(car_show);
            }
        }


        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(carShowList);
            jedisClient.set(CM_CONTENT, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carShowList;
    }


    /**
     * 用户反馈添加
     * @param phone  手机号
     * @param content  反馈内容
     * @param surname  称谓
     * @return
     */
    @Override
    public OperateEnum insertFeedback(String phone, String content, String surname) {
        TbFeedback tbFeedback=new TbFeedback();
        tbFeedback.setPhone(phone);
        tbFeedback.setDelflag(0);
        tbFeedback.setStatus(1);
        tbFeedback.setCheckStatus(0);
        tbFeedback.setCreateTime(new Date());
        tbFeedback.setContent(content);
        tbFeedback.setSurname(surname);

       int res= tbFeedbackMapper.insert(tbFeedback);

        if (res>0){
            return OperateEnum.SUCCESS;
        }else {
            return  OperateEnum.FAILE;
        }
    }

    /**
     * 用户咨询
     * @param phone
     * @param type
     * @return
     */
    @Override
    public OperateEnum insertConsult(String phone,String type) {
        TbConsult tbConsult=new TbConsult();
        tbConsult.setPhone(phone);
        try {
            tbConsult.setType(Integer.valueOf(type));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        tbConsult.setDelflag(0);
        tbConsult.setStatus(0);
        tbConsult.setConsultTime(new Date());
        int res= tbConsultMapper.insert(tbConsult);
        if (res>0){
            return OperateEnum.SUCCESS;
        }else {
            return  OperateEnum.FAILE;
        }
    }


    /**
     * 获取前十车系 key 存为hot
     * @return
     */

    @Override
    public JsonResult getHotSeries() {
        //缓存命中
        try {
            String json = jedisClient.hget(CAR_SERIES,"hot");
            if (StringUtils.isNotBlank(json)) {
                List<TbCarBrandLine> tbCarBrandLineList=JsonUtils.jsonToList(json, TbCarBrandLine.class);
                return JsonResult.OK(tbCarBrandLineList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageHelper.startPage(1,10);
        TbCarBrandLineExample example = new TbCarBrandLineExample();
        TbCarBrandLineExample.Criteria criteria = example.createCriteria();
        criteria.andDelflagEqualTo(0);
        example.setOrderByClause("line_sequence ASC");
        List<TbCarBrandLine> list = tbCarBrandLineMapper.selectByExample(example);
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(list);
            jedisClient.hset(CAR_SERIES,"hot", jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.OK(list);
    }

    /**
     * 首页数据 初次 获取
     * @author Xushd
     * @return
     */
    @Override
    public JsonResult getIndexBase() {

        /*step1 首页广告*/
        List<GgDTO> listGg = getListGg("14");
        /*step2 品牌*/
        List<CarBrandDTO> carBrandHot = getCarBrandHot();
        /*step3 车型*/
        List<carTypeDTO> carType = getCarType();

        return JsonResult.OK(new IndexBaseDTO(carBrandHot,listGg,carType));
    }

    /**
     * 用户咨询 从详情页面
     * @param phone
     * @param type
     * @param carId
     * @return
     */
    @Override
    public OperateEnum insertCarConsult(String phone, String type, String carId) {
        TbConsult tbConsult=new TbConsult();
        tbConsult.setPhone(phone);
        try {
            tbConsult.setCarid(Long.valueOf(carId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }
        try {
            tbConsult.setType(Integer.valueOf(type));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return OperateEnum.FAILE;
        }
        tbConsult.setDelflag(0);
        tbConsult.setStatus(0);
        tbConsult.setConsultTime(new Date());
        int res= tbConsultMapper.insert(tbConsult);
        if (res>0){
            return OperateEnum.SUCCESS;
        }else {
            return  OperateEnum.FAILE;
        }
    }


    /**
     * 广告信息获取
     * @author Xushd
     * @param ggType
     * @return
     */
    private List<GgDTO> getListGg(String ggType){
        try {
            String adJson = jedisClient.hget(AD_HOME,ggType);
            if(StringUtils.isNotBlank(adJson)){
                return JsonUtils.jsonToList(adJson,GgDTO.class);
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        List<TbAdvert> list = tbAdvertMapper.getAdvertPublish(Long.valueOf(ggType));
        List<GgDTO> ggDTOs = Lists.newArrayList();

        for (TbAdvert tbAdvert : list) {
            ggDTOs.add(new GgDTO(tbAdvert.getId(),tbAdvert.getAdvertUrl(),tbAdvert.getAdvertImg()));
        }
        try {
            jedisClient.hset(AD_HOME,ggType,JsonUtils.objectToJson(ggDTOs));

        }catch (Exception e){
            e.printStackTrace();
        }
        return ggDTOs;

    }

    /**
     * 获取热门车品牌
     * @author Xushd
     * @return
     */
    private List<CarBrandDTO> getCarBrandHot(){
        try {
            String carBrandHot = jedisClient.get(CAR_BRAND_HOT);
            if(StringUtils.isNotBlank(carBrandHot)){
                return JsonUtils.jsonToList(carBrandHot,CarBrandDTO.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        List<TbCarBrand> carBrandList= getCarBrand(10);
        List<CarBrandDTO> resList = Lists.newArrayList();
        for (TbCarBrand tbCarBrand : carBrandList) {
            resList.add(new CarBrandDTO(tbCarBrand.getId(),tbCarBrand.getBrandName(),tbCarBrand.getBrandImg()));
        }
        try {
            String carBrandHot = JsonUtils.objectToJson(resList);
            jedisClient.set(CAR_BRAND_HOT,carBrandHot);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resList;

    }

    /**
     * 获取汽车品牌（基础数据）
     * @author Xushd
     * @param rows
     * @return
     */
    private List<TbCarBrand> getCarBrand(int rows){
        try {
            List<TbCarBrand> list = jedisClient.getObjectList(CAR_BRAND, TbCarBrand.class, 0, rows);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<carTypeDTO> getCarType(){
        //缓存命中
        try {
            String carTypeJson = jedisClient.get(CAR_TYPE);
            if (StringUtils.isNotBlank(carTypeJson)) {
                return JsonUtils.jsonToList(carTypeJson, carTypeDTO.class);
            }
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
            resList.add(new carTypeDTO(tbCarType.getId(),tbCarType.getTypeName(),tbCarType.getTypeImg()));
        }
        //写入缓存
        try {
            String jsonStr = JsonUtils.objectToJson(resList);
            jedisClient.set(CAR_TYPE, jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }
}


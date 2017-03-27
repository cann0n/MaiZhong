package com.maizhong.portal.service.impl;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.maizhong.common.dto.IndexBaseDTO;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.HttpClientUtil;
import com.maizhong.common.utils.JsonUtils;
import com.maizhong.pojo.TbAdvert;
import com.maizhong.pojo.TbFeedback;
import com.maizhong.portal.service.IndexService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页服务接口实现
 * Created by Xushd on 2017/3/13.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Value("${REST_URL}")
    private String REST_URL;

    @Value("${INDEXBASE_URL}")
    private String INDEXBASE_URL;

    @Value("${FEEDBACK}")
    private String FEEDB_ACK;

    @Override
    public String getFeedBackUrl() {
        return REST_URL + FEEDB_ACK;
    }

    /**
     * 用户反馈
     *
     * @param feedback
     * @return
     */
    @Override
    public boolean saveFeedback(TbFeedback feedback) {
        Map<String, String> map = new HashMap<>();
        map.put("content", feedback.getContent());
        map.put("phone", feedback.getPhone());
        map.put("surname", feedback.getSurname());
        String res = HttpClientUtil.doPost(REST_URL + FEEDB_ACK, map);
        JsonResult result = JsonUtils.jsonToPojo(res, JsonResult.class);
        if (result.getStatus() == 200) return true;
        return false;
    }

    /**
     * 首页数据初次获取
     * @author Xushd
     * @return
     */

    @Override
    public Map<String,Object> getIndexBase() {

        String res = HttpClientUtil.doGet(REST_URL+INDEXBASE_URL);
        JsonResult result = JsonUtils.jsonToPojo(res,JsonResult.class);
        Map<String,Object> map = (Map) result.getData();
        if(result.getStatus()==200)return map;
        return null;
    }

}

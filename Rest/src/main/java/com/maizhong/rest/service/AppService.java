package com.maizhong.rest.service;

import com.maizhong.common.result.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: 王存浩
 * Date: 2017-04-18
 * Time: 9:57
 */
public interface AppService {
    JsonResult getTokenByDeciceId(String deviceId);

    JsonResult testGetToken(HttpServletRequest request);

    JsonResult getAdvert();

    JsonResult getProvince();

    JsonResult getCity();

    JsonResult getLine();

    JsonResult getLineSite();
}

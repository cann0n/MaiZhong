package com.maizhong.reckon.controller;

import com.maizhong.common.result.JsonResult;
import com.maizhong.reckon.DTO.IndexDTO;
import com.maizhong.reckon.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/4/18.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/")
    public String index(Model model){

        IndexDTO indexDTO = indexService.getIndexDTO();

        model.addAttribute("brandList",indexDTO.getBrandList());
        model.addAttribute("proviceList",indexDTO.getProviceList());
        return "index";
    }
    @RequestMapping(value = "/{page}")
    public String test(@PathVariable String page){
        return page;
    }


    /**
     * 获取车系
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/series/series_brand/{brandId}")
    @ResponseBody
    public JsonResult getSeries(@PathVariable String brandId){

        JsonResult result = indexService.getSeries(brandId);
        return result;
    }

    /**
     * 获取车型
     * @param seriesId
     * @return
     */
    @RequestMapping(value = "/model/model_series/{seriesId}")
    @ResponseBody
    public JsonResult getCarType(@PathVariable String seriesId){
        JsonResult result = indexService.getCarType(seriesId);
        return result;
    }

    @RequestMapping(value = "/getAllCity")
    @ResponseBody
    public JsonResult getAllCity(){
        JsonResult result = indexService.getAllCity();
        return result;
    }

}
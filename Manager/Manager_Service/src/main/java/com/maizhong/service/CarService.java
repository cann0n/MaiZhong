package com.maizhong.service;

import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.result.PageResult;
import com.maizhong.pojo.TbCar;
import java.util.List;

/**
 * Created by yangF on 2017/3/7.
 */
public interface CarService {

    public PageResult findListToShow(PageSearchParam param);

    public JsonResult addTbCar(TbCar tbCar);

    public  TbCar findCarById(Long id);

    public  JsonResult deleteCar(Long id);

    public JsonResult updateCar(TbCar car);

    JsonResult findBaseCar(Long carSeries, String carYear);

    JsonResult updateCarStatus(String ids, Integer unable);

    JsonResult changeSale(Long id);

    JsonResult updateCarIssale(String ids, Integer issale);

    PageResult findListSaleToShow(PageSearchParam param);
}

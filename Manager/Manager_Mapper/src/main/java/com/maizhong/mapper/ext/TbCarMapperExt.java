package com.maizhong.mapper.ext;

import com.maizhong.pojo.TbCarExample;
import com.maizhong.pojo.vo.TbCarBaseVo;
import com.maizhong.pojo.vo.TbCarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yangF on 2017/3/9.
 */
public interface TbCarMapperExt {
    public List<TbCarVo> findListNotContainsDesc(TbCarExample tbCarExample);
    public List<TbCarBaseVo> findByCarYearAndCarSeres(@Param("carSeries") String carSeries,@Param("carYear") String carYear);
    public List<TbCarVo> findDocsForSolrStore(TbCarExample tbCarExample);
    public List<Map<String,Object>> findDetailsByCarId(Long id);

    public List<Map<String,Object>> findByBussinessId(@Param("businessId")Long businessId,@Param("carSeries") Long carSeries,@Param("brandId") Long brandId,@Param("carYear")String carYear,
                                                        @Param("date")String date,@Param("sortString")String sortString);
    public List<Map<String,Object>> findByBasePropToCount(Long baseId);

    public String  findPriceByTypeToCount(@Param("type") String type,@Param("factory") String factory,@Param("gearbox") String gearbox,@Param("series") String series);
}

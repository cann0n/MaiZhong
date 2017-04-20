package com.maizhong.pojo;

import java.util.Date;

public class Series {
    private Integer seriesId;

    private String seriesName;

    private String seriesGroupName;

    private Date updateTime;

    private String seriesPic;

    private Integer brandId;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName == null ? null : seriesName.trim();
    }

    public String getSeriesGroupName() {
        return seriesGroupName;
    }

    public void setSeriesGroupName(String seriesGroupName) {
        this.seriesGroupName = seriesGroupName == null ? null : seriesGroupName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSeriesPic() {
        return seriesPic;
    }

    public void setSeriesPic(String seriesPic) {
        this.seriesPic = seriesPic == null ? null : seriesPic.trim();
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
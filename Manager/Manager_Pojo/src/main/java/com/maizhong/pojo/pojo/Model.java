package com.maizhong.pojo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Model {
    private Integer modelId;

    private String modelName;

    private BigDecimal modelPrice;

    private Integer modelYear;

    private Integer minRegYear;

    private Integer maxRegYear;

    private String liter;

    private String gearType;

    private String dischargeStandard;

    private String seatNumber;

    private Date updateTime;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public BigDecimal getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(BigDecimal modelPrice) {
        this.modelPrice = modelPrice;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Integer getMinRegYear() {
        return minRegYear;
    }

    public void setMinRegYear(Integer minRegYear) {
        this.minRegYear = minRegYear;
    }

    public Integer getMaxRegYear() {
        return maxRegYear;
    }

    public void setMaxRegYear(Integer maxRegYear) {
        this.maxRegYear = maxRegYear;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter == null ? null : liter.trim();
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType == null ? null : gearType.trim();
    }

    public String getDischargeStandard() {
        return dischargeStandard;
    }

    public void setDischargeStandard(String dischargeStandard) {
        this.dischargeStandard = dischargeStandard == null ? null : dischargeStandard.trim();
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber == null ? null : seatNumber.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
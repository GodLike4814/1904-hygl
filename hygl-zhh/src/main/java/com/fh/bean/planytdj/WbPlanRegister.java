package com.fh.bean.planytdj;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: 1904-hygl
 * @description: 委办计划议题
 * @author: 翟浩浩
 * @create: 2020-01-09 19:11
 **/
public class WbPlanRegister {

    private Integer id;
    //议题名称
    private String issueName;
    //上报单位
    private String dutyUnit;
    //审核状态
    private Integer status;
    //上报时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    //备注
    private String remark;
    //相关资料
    private String materials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getDutyUnit() {
        return dutyUnit;
    }

    public void setDutyUnit(String dutyUnit) {
        this.dutyUnit = dutyUnit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

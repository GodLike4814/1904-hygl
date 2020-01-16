package com.fh.bean.planytdj;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: 1904-hygl
 * @description: 计划议题登记实体类
 * @author: 翟浩浩
 * @create: 2020-01-08 16:19
 **/
public class PlanRegister {

    private Integer id;
    //议题名称
    private String issueName;
    //责任单位
    private String dutyUnit;
    //议会状态
    private Integer status;
    //拟上会议
    private String nsMeeting;
    //
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    private String timePlan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    //备注
    private String remark;
    //相关资料
    private String materials;

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

    public String getNsMeeting() {
        return nsMeeting;
    }

    public void setNsMeeting(String nsMeeting) {
        this.nsMeeting = nsMeeting;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public String getTimePlan() {
        return timePlan;
    }

    public void setTimePlan(String timePlan) {
        this.timePlan = timePlan;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

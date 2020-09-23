package com.alibaba.lcc.model.po;

public class DatahubMonitorFowVO {

    private String topicname;

    private String projectne;

    private Double inflow;

    private Double outflow;

    private String updatetime;

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getProjectne() {
        return projectne;
    }

    public void setProjectne(String projectne) {
        this.projectne = projectne;
    }

    public Double getInflow() {
        return inflow;
    }

    public void setInflow(Double inflow) {
        this.inflow = inflow;
    }

    public Double getOutflow() {
        return outflow;
    }

    public void setOutflow(Double outflow) {
        this.outflow = outflow;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
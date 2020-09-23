package com.alibaba.lcc.model.model;

public class DatahubMonitorFow {
    private Long id;

    private String topicname;

    private String projectne;

    private Double inflow;

    private Double inrps;

    private Double intps;

    private Double outflow;

    private Double outrps;

    private Double outtps;

    private String updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getInrps() {
        return inrps;
    }

    public void setInrps(Double inrps) {
        this.inrps = inrps;
    }

    public Double getIntps() {
        return intps;
    }

    public void setIntps(Double intps) {
        this.intps = intps;
    }

    public Double getOutflow() {
        return outflow;
    }

    public void setOutflow(Double outflow) {
        this.outflow = outflow;
    }

    public Double getOutrps() {
        return outrps;
    }

    public void setOutrps(Double outrps) {
        this.outrps = outrps;
    }

    public Double getOuttps() {
        return outtps;
    }

    public void setOuttps(Double outtps) {
        this.outtps = outtps;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
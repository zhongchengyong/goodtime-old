package com.mySSM.model;

public class Job {
    private Integer fid;

    private String ftitle;

    private String fcontent;

    private String fscore;

    private Integer fuserid;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }

    public String getFscore() {
        return fscore;
    }

    public void setFscore(String fscore) {
        this.fscore = fscore == null ? null : fscore.trim();
    }

    public Integer getFuserid() {
        return fuserid;
    }

    public void setFuserid(Integer fuserid) {
        this.fuserid = fuserid;
    }
}
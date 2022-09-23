package com.system.po;

public class Dati {
    private Integer id;

    private Integer stuid;

    private Integer zuoyeid;

    private String filename;

    private Integer fen;

    private String bz;

    private String riqi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getZuoyeid() {
        return zuoyeid;
    }

    public void setZuoyeid(Integer zuoyeid) {
        this.zuoyeid = zuoyeid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFen() {
        return fen;
    }

    public void setFen(Integer fen) {
        this.fen = fen;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi == null ? null : riqi.trim();
    }


    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
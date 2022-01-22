package com.example.trending;

import com.google.gson.annotations.SerializedName;

public class model {

    private int rank;
    private String username;
    private String rN;
    private String url;
    private String desc;
    private String lang;
    private String lC;
    private int tS;
    private int forks;
    private int SS;
    private String since;
    private String[] bB = new String[3];

    public int getRank() {
        return rank;
    }

    public String getUsername() {
        return username;
    }

    public String getrN() {
        return rN;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }

    public String getLang() {
        return lang;
    }

    public String getlC() {
        return lC;
    }

    public int gettS() {
        return tS;
    }

    public int getForks() {
        return forks;
    }

    public int getSS() {
        return SS;
    }

    public String getSince() {
        return since;
    }

    public String[] getbB() {
        return bB;
    }
}

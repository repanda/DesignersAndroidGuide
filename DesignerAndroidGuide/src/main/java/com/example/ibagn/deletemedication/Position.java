package com.example.ibagn.deletemedication;

/**
 * Created by gabi on 06.11.2015.
 */
public class Position {
    private Integer verb;
    private String anchor;
    public Position(){};
    public Position(Integer verb,String anchor){
        this.verb=verb;
        this.anchor=anchor;

    }

    public Integer getVerb() {
        return verb;
    }

    public void setVerb(Integer verb) {
        this.verb = verb;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
}

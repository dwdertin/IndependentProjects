/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class StaticPage {
    private int pageID;
    private String statTitle;
    private String statBody;
    private boolean isLive;

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public String getStatTitle() {
        return statTitle;
    }

    public void setStatTitle(String statTitle) {
        this.statTitle = statTitle;
    }

    public String getStatBody() {
        return statBody;
    }

    public void setStatBody(String statBody) {
        this.statBody = statBody;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.pageID;
        hash = 59 * hash + Objects.hashCode(this.statTitle);
        hash = 59 * hash + Objects.hashCode(this.statBody);
        hash = 59 * hash + (this.isLive ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StaticPage other = (StaticPage) obj;
//        if (this.pageID != other.pageID) {
//            return false;
//        }
        if (this.isLive != other.isLive) {
            return false;
        }
        if (!Objects.equals(this.statTitle, other.statTitle)) {
            return false;
        }
        if (!Objects.equals(this.statBody, other.statBody)) {
            return false;
        }
        return true;
    }

  
    
}

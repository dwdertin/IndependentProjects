/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.validator.constraints.*;

/**
 *
 * @author apprentice
 */
public class Post {
    private int postID;
    @NotEmpty(message="You must supply a title.")
    @Length(min=1, max=50, message="The title must be between 1 and 50 characters.")
    private String title;
    @NotEmpty(message="You have to write something!")
    @Length(min=10, message="Your post must be at least ten characters long.")
    private String contentBody;
    private Set<String> tags = new HashSet<>();
    private LocalDate datePosted;
    private String media;
    private boolean isLive = false;
    
    /**
     * @return the postID
     */
    public int getPostID() {
        return postID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.postID;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.contentBody);
        hash = 83 * hash + Objects.hashCode(this.tags);
        hash = 83 * hash + Objects.hashCode(this.datePosted);
        hash = 83 * hash + Objects.hashCode(this.media);
        hash = 83 * hash + (this.isLive ? 1 : 0);
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
        final Post other = (Post) obj;
//        if (this.postID != other.postID) {
//            return false;
//        }
        if (this.isLive != other.isLive) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.contentBody, other.contentBody)) {
            return false;
        }
        if (!Objects.equals(this.media, other.media)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        if (!Objects.equals(this.datePosted, other.datePosted)) {
            return false;
        }
        return true;
    }

   

    

    /**
     * @param postID the postID to set
     */
    public void setPostID(int postID) {
        this.postID = postID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the contentBody
     */
    public String getContentBody() {
        return contentBody;
    }

    /**
     * @param contentBody the contentBody to set
     */
    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }



    /**
     * @return the datePosted
     */
    public LocalDate getDatePosted() {
        return datePosted;
    }

     public String getFormattedDate() {
       return datePosted.toString();
    }
    
    /**
     * @param datePosted the datePosted to set
     */
    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the isLive
     */
    public boolean getIsLive() {
        return isLive;
    }

    /**
     * @param isLive the isLive to set
     */
    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

  
    
}

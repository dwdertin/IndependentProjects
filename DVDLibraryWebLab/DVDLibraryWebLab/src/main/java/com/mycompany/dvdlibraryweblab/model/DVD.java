/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    public int dvdId;
    @NotEmpty(message="You must supply a value for Title.")
    @Length(max=50, message="Title must be no more than 50 characters in length.")
    public String title;
    @NotEmpty(message="You must supply a value for Release Date.")
    @Length(max=50, message="Release Date must be no more than 50 characters in length.")
    public String releaseDate;
    @NotEmpty(message="You must supply a value for Rating.")
    @Length(max=50, message="Rating must be no more than 50 characters in length.")
    public String rating;
    @NotEmpty(message="You must supply a value for Director.")
    @Length(max=50, message="Director must be no more than 50 characters in length.")
    public String director;
    @NotEmpty(message="You must supply a value for Studio.")
    @Length(max=50, message="Studio must be no more than 50 characters in length.")
    public String studio;
    @NotEmpty(message="You must supply a value for User Notes.")
    @Length(max=50, message="User Notes must be no more than 50 characters in length.")
    public String userNotes;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.dvdId;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.releaseDate);
        hash = 41 * hash + Objects.hashCode(this.rating);
        hash = 41 * hash + Objects.hashCode(this.director);
        hash = 41 * hash + Objects.hashCode(this.studio);
        hash = 41 * hash + Objects.hashCode(this.userNotes);
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
        final DVD other = (DVD) obj;
//        if (this.dvdId != other.dvdId) {
//            return false;
//        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userNotes, other.userNotes)) {
            return false;
        }
        return true;
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
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the userNotes
     */
    public String getUserNotes() {
        return userNotes;
    }

    /**
     * @param userNotes the userNotes to set
     */
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    /**
     * @return the dvdId
     */
    public int getDvdId() {
        return dvdId;
    }

    /**
     * @param dvdId the dvdId to set
     */
    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }
}

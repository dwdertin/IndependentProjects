/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.dao;

import com.mycompany.dvdlibraryv2.dto.DVD;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDAO {
    
    public void writeToLibrary() throws IOException;
    public void readMeFromFile() throws IOException;
    public void addDVD(String title, String releaseDate, String rating, String director, String studio, String userNotes);
    public void removeDVD(String title);
    public String retrieveDVDByTitle(String movieTitletoView);
    public ArrayList<String> viewDVDList();
    public ArrayList<DVD> releasedSince(int years);
    public ArrayList<DVD> byRating(String rating);
    public ArrayList<DVD> byDirector(String director);
    public ArrayList<DVD> byStudio(String studio);
    public double averageAge();
    public DVD newestMovie();
    public DVD oldestMovie();
    public double averageNotes();
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.dao;

import com.mycompany.dvdlibraryv2.dto.DVD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class DVDLibraryimpl implements DVDLibraryDAO{
    
    DVDLibraryDataAccess dao = new DVDLibraryDataAccess();
    //ArrayList<DVD> dvdArrayList = new ArrayList<>();
    HashMap<String, DVD> dvdMap = new HashMap<>();
    int year = Calendar.getInstance().get(Calendar.YEAR);
    
    
    
    @Override
    public void writeToLibrary() throws IOException{
        
    dao.writeDVD(dvdMap, "DVDLibraryDocuments.txt");
    
    }
    
    @Override
    public void readMeFromFile() throws IOException{
        dao.readDVDLibrary(dvdMap, "DVDLibraryDocuments.txt");
    }
    
    
    
    
    
    @Override
    public void addDVD(String title, String releaseDate, String rating, String director, String studio, String userNotes){
        dvdMap.put(title, new DVD(title, releaseDate, rating, director, studio, userNotes));
        
    }
    
    @Override
    public void removeDVD(String title){
       dvdMap.remove(title);
    }
    
    @Override
    public String retrieveDVDByTitle(String movieTitletoView){
        String result;
        result = dvdMap.get(movieTitletoView).toString();
        return result;
    }
   
    @Override
    public ArrayList viewDVDList(){
        ArrayList<String> resultArray = new ArrayList<>();
        
        dvdMap.forEach((k, v) -> {
            resultArray.add(v.title);
            resultArray.add(v.releaseDate);
            resultArray.add(v.rating);
            resultArray.add(v.director);
            resultArray.add(v.studio);
            resultArray.add(v.userNotes);
        });
        
        return resultArray;
    }
    
    // needs to live in library class libraryAccessObject.writeDVD(dvdMap);

    @Override
    public ArrayList<DVD> releasedSince(int years) {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        dvdArray.stream()
                .filter(s -> s!=null)
                .filter(s -> s.getReleaseDate() != null)
                .filter((s) -> (Integer.parseInt(s.getReleaseDate()) > years)).forEach((s) -> {
                    resultArray.add(s);
                });
        return resultArray;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DVD> byRating(String rating) {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        
        dvdArray.stream()
                .filter(s -> s!=null)
                .filter(s -> s.getRating() != null)
                .filter((s) -> (s.getRating().contentEquals(rating))).forEach((s) -> {
                    resultArray.add(s);
                });
        return resultArray;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public ArrayList<DVD> byDirector(String director) {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        
        dvdArray.stream()
                .filter(s -> s!=null)
                .filter(s -> s.getDirector()!= null)
                .filter((s) -> (s.getDirector().contentEquals(director))).forEach((s) -> {
                    resultArray.add(s);
                });
        return resultArray;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DVD> byStudio(String studio) {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        
        dvdArray.stream()
                .filter(s -> s!=null)
                .filter(s -> s.getStudio()!= null)
                .filter((s) -> (s.getStudio().contentEquals(studio))).forEach((s) -> {
                    resultArray.add(s);
                });
        return resultArray;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double averageAge() {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        double averageReleaseDate = dvdArray
                .stream()
                .mapToLong((dvd) -> Integer.parseInt(dvd.getReleaseDate()))
                .average()
                .getAsDouble();
        //Date today = Calendar.getInstance().getTime();
        double age = year - averageReleaseDate;
        return age;
                
                

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD newestMovie() {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        //ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        //example of ascending sort
        Collections.sort(dvdArray, (DVD d1, DVD d2) -> d2.getReleaseDate().compareTo(d1.getReleaseDate()));
        return dvdArray.get(0);
             
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD oldestMovie() {
         ArrayList<DVD> dvdArray = new ArrayList<>();
        //ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        //example of ascending sort
        Collections.sort(dvdArray, (DVD d1, DVD d2) -> d1.getReleaseDate().compareTo(d2.getReleaseDate()));
        return dvdArray.get(0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double averageNotes() {
        ArrayList<DVD> dvdArray = new ArrayList<>();
        //ArrayList<DVD> resultArray = new ArrayList<>();
        dvdMap.forEach((k, v) -> {
            dvdArray.add(v);
        });
        double averageNotes = dvdArray
                .stream()
                .mapToLong((dvd) -> dvd.getUserNotes().length())
                .average()
                .getAsDouble();
     
        return averageNotes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}

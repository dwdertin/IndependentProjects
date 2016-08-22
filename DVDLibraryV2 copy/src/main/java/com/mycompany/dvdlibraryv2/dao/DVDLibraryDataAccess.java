/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.dao;

import com.mycompany.dvdlibraryv2.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDataAccess {
        
    public void writeDVD(HashMap<String, DVD> dvdMap, String file) throws IOException{
        try{
        ArrayList<String> resultArray = new ArrayList<>();    
        PrintWriter out = new PrintWriter(new FileWriter(file));
        dvdMap.forEach((k, v) -> {
           resultArray.add(v.title + "::" + v.releaseDate + "::" + v.rating + "::" 
                   + v.director + "::" + v.studio + "::" + v.userNotes);
           //resultArray.add(v.releaseDate);
           //resultArray.add(v.rating);
           //resultArray.add(v.director);
           //resultArray.add(v.studio);
           //resultArray.add(v.userNotes);
            });
        /*
        for (String s : resultArray){
            out.println();
        }*/
        Iterator<String> iter = resultArray.iterator();
        String current;
        while (iter.hasNext()){
            current = iter.next();
            out.println(current);
        }
     
        out.flush();
        out.close();
        
    } catch (IOException e) {
            System.out.println("Write failed.");
    }
        
}
    

    public void readDVDLibrary (HashMap<String, DVD> dvdMap, String file) throws IOException {
    //ArrayList<DVD> dvdArrayList = new ArrayList<>();
    try{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
        String temp;
        String[] tempStrings;
        
        while (sc.hasNextLine()){
            temp = sc.nextLine();
            tempStrings = temp.split("::");
            //dvdArrayList.add(new DVD(tempStrings[1], tempStrings[2], tempStrings[3], tempStrings [4], tempStrings[5], tempStrings[6]));
            dvdMap.put(tempStrings[0], new DVD(tempStrings[0], tempStrings[1], tempStrings[2], tempStrings [3], tempStrings[4], tempStrings[5]));
        }
        
        
        
    } catch (FileNotFoundException e) {
        //No relevant action to be performed
    }
  
    
}
   
}

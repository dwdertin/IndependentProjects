/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.dao;

import com.mycompany.dvdlibraryv2.dto.DVD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDataAccessTest {
    
    public DVDLibraryDataAccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
//    @Before
//    public void setUp() {
//    }
       @Before
    public void setUp() {
        try{
            PrintWriter out = new PrintWriter(new FileWriter("DVDLibraryTestFile.txt"));
            out.flush();
            out.close();
        } catch (IOException e) {
            //no action needed
        }
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of writeDVD method, of class DVDLibraryDataAccess.
     */
//    @Test
//    public void testWriteDVD() throws Exception {
//        System.out.println("writeDVD");
//        HashMap<String, DVD> dvdMap = null;
//        String file = "";
//        DVDLibraryDataAccess instance = new DVDLibraryDataAccess();
//        instance.writeDVD(dvdMap, file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readDVDLibrary method, of class DVDLibraryDataAccess.
//     */
//    @Test
//    public void testReadDVDLibrary() throws Exception {
//        System.out.println("readDVDLibrary");
//        HashMap<String, DVD> dvdMap = null;
//        String file = "";
//        DVDLibraryDataAccess instance = new DVDLibraryDataAccess();
//        instance.readDVDLibrary(dvdMap, file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testWriteDVD() throws Exception {
        HashMap<String, DVD> dvdMap = new HashMap<>();
        System.out.println("addDVD");
        String title = "Transformers";
        String releaseDate = "2010";
        String rating = "R";
        String director = "Spielberg";
        String studio = "Studio";
        String userNotes = "Funny Movie";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        DVD dvd = new DVD(title, releaseDate, rating, director, studio, userNotes);
        
        dvdMap.put(title, dvd);
             
        System.out.println("writeDVD");
        
        String file = "DVDLibraryTestFile.txt";
        DVDLibraryDataAccess instance1 = new DVDLibraryDataAccess();
        instance1.writeDVD(dvdMap, file);
        ArrayList<DVD> dvdArray = new ArrayList<>();
        Scanner sc = new Scanner (new BufferedReader(new FileReader("DVDLibraryTestFile.txt")));
        String temp;
        String[] tempStrings;
        
        while (sc.hasNextLine()){
            temp = sc.nextLine();
            tempStrings = temp.split("::");
            dvdArray.add(new DVD(tempStrings[0], tempStrings[1], tempStrings[2], tempStrings[3], tempStrings[4], tempStrings[5]));
        }
        String expResult = "[Transformers || 2010 || R || Spielberg || Studio || Funny Movie]";
        String result = dvdArray.toString();
        assertEquals(expResult, result);
        
        
        
    }

    /**
     * Test of readDVDLibrary method, of class DVDLibraryAccess.
     */
    @Test
    public void testReadDVDLibrary() throws Exception {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("DVDLibraryAccessTest2.txt"));
        
        out.println("Titanic::1999::R::Spielberg::Fox::Sad Movie");
        out.flush();
        out.close();
        } catch (IOException e) {
            System.out.println("Write Failed");
        }
     
        System.out.println("readDVDLibrary");
        HashMap<String, DVD> dvdMap = new HashMap<>();
        String file = "DVDLibraryAccessTest2.txt";
        //String title, releaseDate, rating, director, studio, userNotes;
        //DVD dvd = new DVD(title, releaseDate, rating, director, studio, userNotes);
        ArrayList<String> resultArray = new ArrayList<>();
        String title;
        DVDLibraryDataAccess instance = new DVDLibraryDataAccess();
        
        instance.readDVDLibrary(dvdMap, file);
        dvdMap.forEach((k, v) -> {
            resultArray.add(v.title);
        });
        
        title = resultArray.toString();
        String Result = "[Titanic]";
        assertEquals(title, Result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
}

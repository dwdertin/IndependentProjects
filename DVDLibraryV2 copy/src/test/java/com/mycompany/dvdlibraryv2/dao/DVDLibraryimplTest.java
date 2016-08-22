/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.dao;

import com.mycompany.dvdlibraryv2.dto.DVD;
import java.util.ArrayList;
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
public class DVDLibraryimplTest {
    
    public DVDLibraryimplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of writeToLibrary method, of class DVDLibraryimpl.
     */
//    @Test
//    public void testWriteToLibrary() throws Exception {
//        System.out.println("writeToLibrary");
//        DVDLibraryimpl instance = new DVDLibraryimpl();
//        instance.writeToLibrary();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of readMeFromFile method, of class DVDLibraryimpl.
     */
//    @Test
//    public void testReadMeFromFile() throws Exception {
//        System.out.println("readMeFromFile");
//        DVDLibraryimpl instance = new DVDLibraryimpl();
//        instance.readMeFromFile();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addDVD method, of class DVDLibraryimpl.
     */
    @Test
    public void testAddDVD() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "1995";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("viewDVDList");
        ArrayList result = instance.viewDVDList();
        assertNotNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeDVD method, of class DVDLibraryimpl.
     */
    @Test
    public void testRemoveDVD() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "1995";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("removeDVD");
        instance.removeDVD(title);
        String result = instance.viewDVDList().toString();
        String expResult = "[]";
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveDVDByTitle method, of class DVDLibraryimpl.
     */
    @Test
    public void testRetrieveDVDByTitle() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "1995";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        
        System.out.println("retrieveDVDByTitle");
        String movieTitletoView = "Jumanji";
        String expResult = "Jumanji || 1995 || PG || Dinosaur || Fox || Lots of animals.";
        String result = instance.retrieveDVDByTitle(movieTitletoView);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of viewDVDList method, of class DVDLibraryimpl.
     */
    @Test
    public void testViewDVDList() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "1995";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("viewDVDList");
        ArrayList result = instance.viewDVDList();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of releasedSince method, of class DVDLibraryimpl.
     */
    @Test
    public void testReleasedSince() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("releasedSince");
        int years = 2000;
        String result = instance.releasedSince(years).toString();
        String expResult = "[Jumanji || 2010 || PG || Dinosaur || Fox || Lots of animals.]";
        //ArrayList<DVD> expResult = null;
        //ArrayList<DVD> result = instance.releasedSince(years);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of byRating method, of class DVDLibraryimpl.
     */
    @Test
    public void testByRating() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        
        System.out.println("byRating");
        String rating2 = "PG";
        
        String expResult = "[Jumanji || 2010 || PG || Dinosaur || Fox || Lots of animals.]";
        String result = instance.byRating(rating2).toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of byDirector method, of class DVDLibraryimpl.
     */
    @Test
    public void testByDirector() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("byDirector");
        String director3 = "Dinosaur";
     
        String expResult = "[Jumanji || 2010 || PG || Dinosaur || Fox || Lots of animals.]";
        String result = instance.byDirector(director3).toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of byStudio method, of class DVDLibraryimpl.
     */
    @Test
    public void testByStudio() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("byStudio");
        String studio3 = "Fox";
        String expResult = "[Jumanji || 2010 || PG || Dinosaur || Fox || Lots of animals.]";
        String result = instance.byStudio(studio3).toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of averageAge method, of class DVDLibraryimpl.
     */
    @Test
    public void testAverageAge() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("averageAge");
        double expResult = 16.0;
        double result = instance.averageAge();
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of newestMovie method, of class DVDLibraryimpl.
     */
    @Test
    public void testNewestMovie() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("newestMovie");
        String expResult = "Jumanji || 2010 || PG || Dinosaur || Fox || Lots of animals.";
        String result = instance.newestMovie().toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of oldestMovie method, of class DVDLibraryimpl.
     */
    @Test
    public void testOldestMovie() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("oldestMovie");
        String expResult = "Karate Kid || 1990 || PG13 || Bruce Lee || Miramax || Fighting movie.";
        String result = instance.oldestMovie().toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of averageNotes method, of class DVDLibraryimpl.
     */
    @Test
    public void testAverageNotes() {
        System.out.println("addDVD");
        String title = "Jumanji";
        String releaseDate = "2010";
        String rating = "PG";
        String director = "Dinosaur";
        String studio = "Fox";
        String userNotes = "Lots of animals.";
        DVDLibraryimpl instance = new DVDLibraryimpl();
        instance.addDVD(title, releaseDate, rating, director, studio, userNotes);
        
        System.out.println("addDVD");
        String title1 = "Karate Kid";
        String releaseDate1 = "1990";
        String rating1 = "PG13";
        String director1 = "Bruce Lee";
        String studio1 = "Miramax";
        String userNotes1 = "Fighting movie.";
        instance.addDVD(title1, releaseDate1, rating1, director1, studio1, userNotes1);
        
        System.out.println("averageNotes");
        double expResult = 15.5;
        double result = instance.averageNotes();
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

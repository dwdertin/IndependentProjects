/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab;

import com.mycompany.dvdlibraryweblab.dao.DVDLibraryDao;
import com.mycompany.dvdlibraryweblab.dao.DVDLibraryDaoDbImpl;
import com.mycompany.dvdlibraryweblab.dao.SearchTerm;
import com.mycompany.dvdlibraryweblab.model.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoTest {
    
    private DVDLibraryDao dao;
    
    public DVDLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DVDLibraryDao)ctx.getBean("DVDLibraryDao");
        
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addGetDeleteDvd(){
        DVD d = new DVD();
        d.setTitle("Movie");
        d.setReleaseDate("Release Date");
        d.setRating("Rating");
        d.setDirector("Director");
        d.setStudio("Studio");
        d.setUserNotes("User Notes");
        
        dao.addDVD(d);
        
        DVD fromDAO = dao.getDVDById(d.getDvdId());
        assertEquals(d, fromDAO);
        
        dao.removeDVD(d.getDvdId());
        assertNull(dao.getDVDById(d.getDvdId()));
        
    }
    
    @Test
    public void updateDVDTest(){
        DVD d = new DVD();
        d.setTitle("Movie");
        d.setReleaseDate("Release Date");
        d.setRating("Rating");
        d.setDirector("Director");
        d.setStudio("Studio");
        d.setUserNotes("User Notes");

        dao.addDVD(d);
        
        DVD fromDAO = dao.getDVDById(d.getDvdId());
        fromDAO.setTitle("notTitle");
        assertThat(d, not(equalTo(fromDAO)));
        
    }
    
    @Test
    public void getDVDByIdTest(){
       DVD d = new DVD();
        d.setTitle("Movie");
        d.setReleaseDate("Release Date");
        d.setRating("Rating");
        d.setDirector("Director");
        d.setStudio("Studio");
        d.setUserNotes("User Notes");
        
        dao.addDVD(d);
        
        DVD fromDAO = dao.getDVDById(d.getDvdId());
        assertEquals(d, fromDAO);
    }
    
    @Test
    public void getAllDVDsTest(){
        DVD d = new DVD();
        d.setTitle("Movie");
        d.setReleaseDate("Release Date");
        d.setRating("Rating");
        d.setDirector("Director");
        d.setStudio("Studio");
        d.setUserNotes("User Notes");
        dao.addDVD(d);
        
        DVD d2 = new DVD();
        d2.setTitle("Second Movie");
        d2.setReleaseDate("Second Release Date");
        d2.setRating("Second Rating");
        d2.setDirector("Second Director");
        d2.setStudio("Second Studio");
        d2.setUserNotes("Second User Notes");
        dao.addDVD(d2);
        
        Set<DVD> manualList = new HashSet<>();
        manualList.add(d);
        manualList.add(d2);
        
        Set<DVD> testList = new HashSet<>(dao.getAllDVDs());
        
        assertEquals(manualList, testList);
        
    }
    
    
    
//    @Test
//    public void searchDVDsTest(){
//       
//        DVD d = new DVD();
//        d.setTitle("Movie");
//        d.setReleaseDate("Release Date");
//        d.setRating("Rating");
//        d.setDirector("Director");
//        d.setStudio("Studio");
//        d.setUserNotes("User Notes");
//        dao.addDVD(d);
//        
//        DVD d2 = new DVD();
//        d2.setTitle("Second Movie");
//        d2.setReleaseDate("Second Release Date");
//        d2.setRating("Second Rating");
//        d2.setDirector("Second Director");
//        d2.setStudio("Second Studio");
//        d2.setUserNotes("Second User Notes");
//        dao.addDVD(d2);
//        
//        
//        Map<String, String> searchMap = new HashMap<>();
//        searchMap.put("title", "Second Movie");
//        
//        Map<SearchTerm, String> criteriaMap = new HashMap<>();
//        criteriaMap.put(SearchTerm.TITLE, "Second Movie");
//      
//        List<DVD> resultList = dao.searchDVDs(criteriaMap);
//        
//        List<DVD> manualList = new ArrayList<>();
//        manualList.add(d2);
//        
//        assertEquals(resultList, manualList);
//    }
    
    
}

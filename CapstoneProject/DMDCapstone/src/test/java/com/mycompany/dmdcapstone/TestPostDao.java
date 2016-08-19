/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone;

import com.mycompany.dmdcapstone.dao.PostDao;
import com.mycompany.dmdcapstone.model.Post;
import com.mycompany.dmdcapstone.model.StaticPage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class TestPostDao {
    private PostDao dao;
    
    public TestPostDao() {
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
        dao = (PostDao)ctx.getBean("PostDao");
       JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
       cleaner.execute("delete from PostTags");
       cleaner.execute("delete from Posts");
       cleaner.execute("delete from StaticPages");
////        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeletePost(){
        Post p = new Post();
        Set<String> tags = new HashSet<>();
        tags.add("WhatAre");
        tags.add("YouDoing");
        p.setTitle("Something!");
        p.setDatePosted(LocalDate.now());
        p.setIsLive(true);
        p.setMedia("nah");
        p.setContentBody("NOTHING TO SAY");
        p.setTags(tags);
        
        dao.addPost(p);
        
        Post fromDao = dao.displayPostByID(p.getPostID());
        System.out.println(fromDao+"DOES THIS EXIST?");
        assertEquals(p, fromDao);
        
        dao.deletePost(p.getPostID());
        assertNull(dao.displayPostByID(p.getPostID()));
        
    }
    
    @Test
    public void editPostTest(){
         Post p = new Post();
        Set<String> tags = new HashSet<>();
        tags.add("ughFine");
        tags.add("secondThing");
        p.setTitle("Something!");
        p.setDatePosted(LocalDate.now());
        p.setIsLive(true);
        p.setMedia("nah");
        p.setContentBody("NOTHING TO SAY");
        p.setTags(tags);
        
        dao.addPost(p);
        
        Post fromDao = dao.displayPostByID(p.getPostID());
        
        Post notP = new Post();
        Set<String> tags2 = new HashSet<>();
        tags2.add("ughFine");
        tags2.add("secondThing");
        notP.setTitle("Something Else!");
        notP.setDatePosted(LocalDate.now());
        notP.setIsLive(true);
        notP.setMedia("nah");
        notP.setContentBody("NOTHING TO SAY");
        notP.setTags(tags2);
        notP.setPostID(p.getPostID());
        
        dao.editPost(notP);

        assertThat(fromDao, not(equalTo(notP)));
        
    }
    
    @Test
    public void getAllPostsTest(){
          Post p = new Post();
        Set<String> tags = new HashSet<>();
        tags.add("ughFine");
        tags.add("secondThing");
        p.setTitle("Something!");
        p.setDatePosted(LocalDate.now());
        p.setIsLive(true);
        p.setMedia("nah");
        p.setContentBody("NOTHING TO SAY");
        p.setTags(tags);
        
        dao.addPost(p);
        
        Post notP = new Post();
        Set<String> tags2 = new HashSet<>();
        tags2.add("things");
        tags2.add("secondThing??");
        notP.setTitle("Else!");
        notP.setDatePosted(LocalDate.now());
        notP.setIsLive(true);
        notP.setMedia("nah");
        notP.setContentBody("meanwhile back at the ranch");
        notP.setTags(tags2);

        dao.addPost(notP);
        
        List<Post> manualList = new ArrayList<>();
        manualList.add(p);
        manualList.add(notP);
        
        List<Post> testList = new ArrayList<>(dao.displayPosts());
        
        assertTrue(manualList.contains(testList.get(0)));
        assertTrue(manualList.contains(testList.get(1)));

    }
    
    @Test
    public void addGetDeletePage(){
        StaticPage p = new StaticPage();
        p.setStatTitle("test!");        
        p.setIsLive(true);
        p.setStatBody("ayyyo");

        
        dao.addPage(p);
        
        StaticPage fromDao = dao.displayPageByID(p.getPageID());
        System.out.println(fromDao+"DOES THIS EXIST?");
        assertEquals(p, fromDao);
        
        dao.deletePage(p.getPageID());
        assertNull(dao.displayPageByID(p.getPageID()));
        
    }
    
    @Test
    public void getAllPagesTest(){
        StaticPage p = new StaticPage();
        p.setStatTitle("test!");               
        p.setStatBody("ayyyo");
        p.setIsLive(true);
        
        dao.addPage(p);
        
        StaticPage notP = new StaticPage();
        notP.setStatTitle("test2!");          
        notP.setStatBody("Oofta");
        notP.setIsLive(true);

        dao.addPage(notP);
        
        List<StaticPage> manualList = new ArrayList<>();
        manualList.add(p);
        manualList.add(notP);
        
        List<StaticPage> testList = new ArrayList<>(dao.displayPage());
        
        assertTrue(manualList.contains(testList.get(0)));
        assertTrue(manualList.contains(testList.get(1)));

    }
    
    
}

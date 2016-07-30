/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.dao;

import com.mycompany.dvdlibraryweblab.model.DVD;
import com.mycompany.dvdlibraryweblab.model.Stats;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    
    public DVD addDVD(DVD dvd);
    
    public void removeDVD(int dvdId);
    
    public void updateDVD(DVD dvd);
    
    public List<DVD> getAllDVDs();
    
    public DVD getDVDById(int dvdId);
    
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
    
    public Stats searchRatedR();
}

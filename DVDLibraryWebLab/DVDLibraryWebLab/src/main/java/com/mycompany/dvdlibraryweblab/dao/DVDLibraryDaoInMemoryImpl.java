/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.dao;

import com.mycompany.dvdlibraryweblab.model.DVD;
import com.mycompany.dvdlibraryweblab.model.Stats;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoInMemoryImpl implements DVDLibraryDao {

    private Map<Integer, DVD> dvdMap = new HashMap<>();

    private static int contactIdCounter = 0;

    @Override
    public DVD addDVD(DVD dvd) {
        dvd.setDvdId(contactIdCounter);
        contactIdCounter++;
        dvdMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

    @Override
    public void removeDVD(int dvdId) {
        dvdMap.remove(dvdId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        Collection<DVD> d = dvdMap.values();
        return new ArrayList<>(d);
    }

    @Override
    public DVD getDVDById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String ratingCriteria = criteria.get(SearchTerm.RATING);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String userNotesCriteria = criteria.get(SearchTerm.USER_NOTES);

        Predicate<DVD> titleMatches;
        Predicate<DVD> releaseDateMatches;
        Predicate<DVD> ratingMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> userNotesMatches;

        Predicate<DVD> truePredicate = (d) -> {
            return true;
        };

        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getTitle().equals(titleCriteria);
        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getReleaseDate().equals(releaseDateCriteria);
        ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getRating().equals(ratingCriteria);
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getDirector().equals(directorCriteria);
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getStudio().equals(studioCriteria);
        userNotesMatches = (userNotesCriteria == null || userNotesCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getUserNotes().equals(userNotesCriteria);

        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(releaseDateMatches)
                        .and(ratingMatches)
                        .and(directorMatches)
                        .and(studioMatches)
                        .and(userNotesMatches))
                .collect(Collectors.toList());

    }

    @Override
    public Stats searchRatedR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

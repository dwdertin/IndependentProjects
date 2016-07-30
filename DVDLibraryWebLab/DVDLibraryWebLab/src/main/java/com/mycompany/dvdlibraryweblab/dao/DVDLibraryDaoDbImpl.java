/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.dao;

import com.mycompany.dvdlibraryweblab.model.DVD;
import com.mycompany.dvdlibraryweblab.model.Stats;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoDbImpl implements DVDLibraryDao {

    // #1 - All SQL code is in the form of Prepared Statements
    private static final String SQL_INSERT_DVD
            = "insert into dvds (title, release_date, rating, director, studio, user_notes) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from dvds where dvd_id = ?";
    private static final String SQL_SELECT_DVD
            = "select * from dvds where dvd_id = ?";
    private static final String SQL_UPDATE_DVD
            = "update dvds set title = ?, release_date = ?, rating = ?, director = ?, studio = ?, user_notes = ? where dvd_id = ?";
    private static final String SQL_SELECT_ALL_DVDS
            = "select * from dvds";
    private static final String SQL_SELECT_DVDS_BY_TITLE
            = "select * from dvds where title = ?";
    private static final String SQL_SEARCH_DVDS
            = "Select * from dvds where title like ? "
            + "AND release_date like ? "
            + "AND rating like ? "
            + "AND director like ? "
            + "AND studio like ? "
            + "AND user_notes like ? ";
    

    // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DVD addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserNotes());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        return dvd;
    }

    @Override
    public void removeDVD(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserNotes(),
                dvd.getDvdId());
    }

    @Override
    public List<DVD> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public DVD getDVDById(int dvdId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DVDMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
           
            return null;
        }
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        return jdbcTemplate.query(SQL_SEARCH_DVDS, new DVDMapper()
                , criteria.get(SearchTerm.TITLE) == null ? "%" : criteria.get(SearchTerm.TITLE)
                , criteria.get(SearchTerm.RELEASE_DATE) == null ? "%" : criteria.get(SearchTerm.RELEASE_DATE)
                , criteria.get(SearchTerm.RATING) == null ? "%" : criteria.get(SearchTerm.RATING)
                , criteria.get(SearchTerm.DIRECTOR) == null ? "%" : criteria.get(SearchTerm.DIRECTOR)
                , criteria.get(SearchTerm.STUDIO) == null ? "%" : criteria.get(SearchTerm.STUDIO)
                , criteria.get(SearchTerm.USER_NOTES) == null ? "%" : criteria.get(SearchTerm.USER_NOTES));
    }

    @Override
    public Stats searchRatedR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    private static final class DVDMapper implements RowMapper<DVD> {

        public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
            DVD dvd = new DVD();
            dvd.setDvdId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getString("release_date"));
            dvd.setRating(rs.getString("rating"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setUserNotes(rs.getString("user_notes"));
            
            return dvd;
           
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryweblab.controller;

import com.mycompany.dvdlibraryweblab.dao.DVDLibraryDao;
import com.mycompany.dvdlibraryweblab.model.DVD;
import com.mycompany.dvdlibraryweblab.model.Stats;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class StatsController {

    private DVDLibraryDao dao;
    private static final String SQL_SEARCH_RATED_R
            = "select * from dvds where rating = 'R'";

    @Inject
    public StatsController(DVDLibraryDao dao) {
        this.dao = dao;
    }

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String displayStats() {
        return "stats";
    }

    @RequestMapping(value = "/ratedR", method = RequestMethod.GET)
    public Stats searchRatedR() {
        List<DVD> sizeList = jdbcTemplate.query(SQL_SEARCH_RATED_R, new DVDMapper());
        Stats stats = new Stats();
        stats.setSize(sizeList.size());
        return stats;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibraryv2.ops;

import com.mycompany.dvdlibraryv2.dao.DVDLibraryimpl;
import com.mycompany.dvdlibraryv2.ui.ConsoleIO;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {
   //need to declare a construct that accepts a DVD librarydao object
    
    public void run()throws IOException {
        
    ConsoleIO console = new ConsoleIO();
    DVDLibraryimpl dvdObject = new DVDLibraryimpl();
    
    
    
        dvdObject.readMeFromFile();
        
        int userInput;
        
        do{
            console.write("Please choose an option:\n"
                    + "1) Add DVD to Library:\n"
                    + "2) Remove DVD from Library:\n"
                    + "3) Retrieve DVD by Title:\n"
                    + "4) View List of Entire DVD Library:\n"
                    + "5) View List of DVDs released since specified year:\n"
                    + "6) View List of DVDs by rating:\n"
                    + "7) View List of DVDs by studio:\n"
                    + "8) View average age of DVDs in Library:\n"
                    + "9) Find newest DVD in Library:\n"
                    + "10) Find oldest DVD in Library:\n"
                    + "11) Find average notes in DVD Library:\n"
                    + "12) View List of DVDs by Director:\n"
                    + "13) Quit\n"
                    + "> ");
                    
                    userInput = console.readInteger("", 1, 13);
                    
            switch (userInput){
                case 1:
                    String title, releaseDate, rating, director, studio, userNotes;
                    console.write("Please enter the following information to add a new DVD to the library: \n");
                    console.write("\n");
                    title = console.readString("Please enter the Title of the DVD:\n");
                    console.write("\n");
                    releaseDate = console.readString("Please enter the Release Date of the DVD:\n");
                    console.write("\n");
                    rating = console.readString("Please enter the Rating of the DVD:\n");
                    console.write("\n");
                    director = console.readString("Please enter the Director of the DVD:\n");
                    console.write("\n");
                    studio = console.readString("Please enter the Studio of the DVD:\n");
                    console.write("\n");
                    userNotes = console.readString("Please enter personal notes about this DVD:\n");
                    console.write("\n");
                    dvdObject.addDVD(title, releaseDate, rating, director, studio, userNotes);
                    
                    break;
                case 2: 
                    String movieTitle;
                    movieTitle = console.readString("Please enter the name of the DVD you would like to remove from the library:\n");
                    console.write("\n");
                    dvdObject.removeDVD(movieTitle);
                           
                    break;
                case 3: 
                    String viewMovieByTitle;
                    console.write("\n");
                    viewMovieByTitle = console.readString("Please enter the Title of the DVD you would like to view:\n ");
                    console.write("\n");
                    console.write(dvdObject.retrieveDVDByTitle(viewMovieByTitle) + "\n");
                    console.write("\n");
                    
                    break;
                case 4:
                    console.write("These are the DVDs in your library:\n");
                    console.write("\n");
                    console.write(dvdObject.viewDVDList().toString() + "\n");
                    console.write("\n");
                    break;
                case 5:
                     console.write("You have selected view DVDs newer than specified year:\n");
                    int year1 = console.readInteger("Please enter year:\n");
                    console.write(dvdObject.releasedSince(year1).toString() + "\n");
                    console.write("\n");
                    break;
                case 6:
                    console.write("You have selected view DVDs by rating.\n");
                    String rating1 = console.readString("Please enter the rating for which you would like to view a list.\n");
                    console.write(dvdObject.byRating(rating1).toString() + "\n");
                    console.write("\n");
                    break;
                case 7:
                    console.write("You have selected view DVDs by studio.\n");
                    String studio1 = console.readString("Please enter the studio for which you would like to view a list.\n");
                    console.write(dvdObject.byStudio(studio1).toString() + "\n");
                    console.write("\n");
                    break;
                case 8:
                    console.write("This is the average age of DVDs in your library:\n");
                    double average = dvdObject.averageAge();
                    console.write(Double.toString(average) + "\n");
                    break;
                case 9:
                    console.write("This is the newest movie in your collection:\n");
                    console.write(dvdObject.newestMovie().toString() + "\n");
                    break;
                case 10:
                    console.write("This is the oldest movie in your collection:\n");
                    console.write(dvdObject.oldestMovie().toString() + "\n");
                    break;
                case 11:
                    console.write("This is the average length of notes for your collection:\n");
                    console.write(dvdObject.averageNotes() + "\n");
                            
                    break;
                case 12:
                    console.write("You have selected view DVDs by director.\n");
                    String director1 = console.readString("Please enter the director for which you would like to view a list.\n");
                    console.write(dvdObject.byDirector(director1).toString() + "\n");
                    console.write("\n");
                    break;
                case 13:
                    break;
               
         
            }
                
            
        } while (userInput !=13);
        
         
        dvdObject.writeToLibrary(); 
    }
      
        
    }


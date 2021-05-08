/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektmovielibrary;

import MovieLibrary.MovieLibrary;
import java.awt.Color;

/**
 *
 * @authors batko, hoffman, downarowicz
 */
public class ProjektMovieLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MovieLibrary baza = new MovieLibrary();
        baza.getContentPane().setBackground( Color.WHITE );
        baza.setTitle("MovieLibrary");
        baza.setSize(830, 840);
        baza.setVisible(true);
        
        
        baza.aktualizujBaze();
    }
    
}

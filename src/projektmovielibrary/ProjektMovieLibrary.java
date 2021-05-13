/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektmovielibrary;

import MovieLibrary.Login;
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
        Login baza = new Login();
        baza.getContentPane().setBackground( Color.WHITE );
        baza.setTitle("MovieLibrary");
        baza.setSize(930, 350);
        baza.setVisible(true);
        
        
        
    }
    
}

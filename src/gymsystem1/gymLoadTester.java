/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class gymLoadTester {
    public static void main(String[] args) throws Exception {
       // get my stream object
       ObjectInputStream in = new ObjectInputStream(new FileInputStream("classes.dat"));
       
       ArrayList<FitnessClasses> classes;
       // read the list from the stream object
       classes = (ArrayList<FitnessClasses>) in.readObject();
       // close the stream
       in.close();
       
       // loop to display the classes nicely
       JOptionPane.showMessageDialog(null,classes);
       
    }
}

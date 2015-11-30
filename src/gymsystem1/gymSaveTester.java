/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class gymSaveTester {
    public static void main(String[] args) throws Exception {
        // construct a fitness class
        FitnessClasses one = new FitnessClasses("Circuits", "running", 5, 7.5, 60, 5);
        FitnessClasses two = new FitnessClasses("Running", "beginners running", 6, 5.0, 30, 5);
        ArrayList<FitnessClasses> classes = new ArrayList<FitnessClasses>();
        classes.add(one);
        classes.add(two);
        
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("classes.dat"));
   		os.writeObject(classes);
   		os.close();
    }
}

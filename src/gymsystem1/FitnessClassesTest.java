/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

/**
 *
 * @author David
 */
public class FitnessClassesTest {
    public static void main(String[] args) {
        FitnessClasses fc1 = new FitnessClasses();
        FitnessClasses fc2 = new FitnessClasses("Circuits", "workout", 10, 7.0, 30.0, 5);
        
        //Test the Null Constructor
        System.out.println(fc1);
        
        //Test the Full argument Constructor
	System.out.println(fc2);
        
        //Test the set method (ClassName)
        fc1.setClassName("Yoga");
        System.out.println(fc1.toString());
        
        //Test the set method (Activity)
        fc1.setActivity("Yoga");
        System.out.println(fc1.toString());
        
        //Test the set method (ClassCapacity)
        fc1.setClassCapacity(20);
        System.out.println(fc1.toString());
        
        //Test the set method (Price)
        fc1.setPrice(7);
        System.out.println(fc1.toString());
        
        //Test the set method (Duration)
        fc1.setDuration(20);
        System.out.println(fc1.toString());
        
        //Test the set method (NumberOfClasses)
        fc1.setNumberOfClasses(5);
        System.out.println(fc1.toString());
        
        //test the get method (ClassName)
	System.out.println(fc1.getClassName());
        
        //test the get method (Activity)
	System.out.println(fc1.getActivity());
        
        //test the get method (ClassCapacity)
	System.out.println(fc1.getClassCapacity());
        
        //test the get method (Price)
	System.out.println(fc1.getPrice());
        
        //test the get method (Duration)
	System.out.println(fc1.getDuration());
        
        //test the get method (NumberOfClasses)
	System.out.println(fc1.getNumberOfClasses());
    }
}

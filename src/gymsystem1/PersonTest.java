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
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Mary O' Connor", 25, 'f');

        //test null constructor
        System.out.println(p1);
	//test the full argument constructor
	System.out.println(p2);
        
        //Test the set method(Firstname)
        p1.setName("John");
        System.out.println(p1.toString());
              
        //Test the set method(Age)
        p1.setAge(21);
        System.out.println(p1.toString());
        
        //Test the set method(Gender)
        p1.setGender('m');
        System.out.println(p1.toString());
        
        //test the get method (name)
	System.out.println(p1.getName());
               
        //test the get method (Age)
	System.out.println(p1.getAge());
        
        //test the get method (Gender)
	System.out.println(p1.getGender());
    }
}

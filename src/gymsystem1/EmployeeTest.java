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
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee();
	Employee e2 = new Employee("Mary O' Connor", 25, 'f', "Tralee", 123456);
        
        //Test the Null Constructor
        System.out.println(e1);
        
        //Test the Full argument Constructor
	System.out.println(e2);
        
        
        //Test the set method(First Name)
        e1.setName("John");
        System.out.println(e1.toString());
        
        //Test the set method(Age)
        e1.setAge(24);
        System.out.println(e1.toString());
        
        //Test the set method(Gender)
        e1.setGender('m');
        System.out.println(e1.toString());
        
        //Test the set method(EmployeeID)
        e1.setEmployeeID(123);
        System.out.println(e1.toString());
        
        //Test the set method(EmployeeAddress)
        e1.setEmployeeAddress("Tralee");
        System.out.println(e1.toString());
        
        //Test the set method(EmployeePhoneNo)
        e1.setEmployeePhoneNo(1234);
        System.out.println(e1.toString());
        
        //test the get method (Name)
	System.out.println(e1.getName());
               
        //test the get method (Age)
	System.out.println(e1.getAge());
        
        //test the get method (Gender)
	System.out.println(e1.getGender());
        
        //test the get method (EmployeeID)
	System.out.println(e1.getEmployeeID());
        
        //test the get method (EmployeeAddress)
	System.out.println(e1.getEmployeeAddress());
        
        //test the get method (EmployeePhoneNo)
	System.out.println(e1.getEmployeePhoneNo());
        
    }
}

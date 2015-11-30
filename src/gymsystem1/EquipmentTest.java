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
public class EquipmentTest {
    public static void main(String[] args) {
        Equipment e1 = new Equipment();
        Equipment e2 = new Equipment("Treadmill", "used for running", 0.0);
        
        //Test the Null Constructor
        System.out.println(e1);
        
        //Test the Full argument Constructor
	System.out.println(e2);
        
        //Test the set method(EquipmentName)
        e1.setEquipmentName("Treadmil");
        System.out.println(e1.toString());
        
        //Test the set method(EquipmentDescription)
        e1.setEquipmentDescription("Cardio machine");
        System.out.println(e1.toString());
        
        //Test the set method(EquipmentSize)
        e1.setEquipmentSize(123);
        System.out.println(e1.toString());
        
        //test the get method (EquipmentName)
	System.out.println(e1.getEquipmentName());
        
        //test the get method (EquipmentDescription)
	System.out.println(e1.getEquipmentDescription());
        
        //test the get method (EquipmentSize)
	System.out.println(e1.getEquipmentSize());
    }
}

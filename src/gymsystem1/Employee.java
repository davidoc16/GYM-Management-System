/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

import java.io.Serializable;

/**
 *
 * @author David
 */
public class Employee extends Person implements Serializable {
    private int employeeID;
    private String employeeAddress;
    private int employeePhoneNo;
    private static int nextEmpID = 1;
    
    public Employee(){
        super();
        setEmployeeID (0);
        setEmployeeAddress("Unassigned");
        setEmployeePhoneNo(0);
    }
    
    public Employee(String nm, int a, char g, String eeAddr, int pNo){
        super(nm, a, g);
        setEmployeeID(nextEmpID);
        nextEmpID++;
        setEmployeeAddress(eeAddr);
        setEmployeePhoneNo(pNo);
    }
    
    public Employee(String nm, int eeID){
        super(nm);
        setEmployeeID(eeID);
     }
    
    public void setEmployeeID(int eeID){
    	employeeID = eeID;
    }
    
    public int getEmployeeID(){
	return employeeID;
    }
    
    public void setEmployeeAddress(String eeAddr){
        employeeAddress = eeAddr;
    }
    
    public String getEmployeeAddress(){
	return employeeAddress;
    }
    
    public void setEmployeePhoneNo(int pNo){
        employeePhoneNo = pNo;
    }
    
    public int getEmployeePhoneNo(){
        return employeePhoneNo;
    }
    
    public String toString(){
		return "\n" + super.toString()+ "\nEmployee ID: " + getEmployeeID() + "\nEmployee Address: " + getEmployeeAddress()+
			"\nEmployee Phone No: " + getEmployeePhoneNo();
	}
}

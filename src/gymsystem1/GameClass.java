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
public class GameClass extends Class implements Serializable{
    private int age;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
        
    // keep this just in case it's needed
    public GameClass() {
    }
    // need this for compatibility with the way Classes are constructed in the application
    public GameClass(String title) {
    	super(title);
    }
    
    public String toString() {
    	return super.toString() + " Age: " + getAge();
    }
    
}

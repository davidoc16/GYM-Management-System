
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

import java.io.*;

/**
 *
 * @author David
 */
public class FitnessClasses extends Class implements Serializable{
    private int classID;
    private String activity;
    private double price;
    private double duration;
    private int numberOfClasses;
    private static int nextClassID = 1;
    
    public FitnessClasses(){
        setClassName("unknown");
        setClassID(0);
        setActivity("unknown");
        setClassCapacity(0);
        setPrice(0.0);
        setDuration(0.0);
        setNumberOfClasses(0);
        //setPlacesTaken(0);
    }
    
    public FitnessClasses(String cn, String act, int cc, double pr, double durn, int NoCls){
        setClassName(cn);
        setClassID(nextClassID);
        nextClassID++;
        setActivity(act);
        setClassCapacity(cc);
        setPrice(pr);
        setDuration(durn);
        setNumberOfClasses(NoCls);
    }
    
    public FitnessClasses(String cn, int classID){
        setClassName(cn);
        setClassID(classID);
        nextClassID++;
    }    
    
     public void setClassID(int classID){
    	classID = classID;
    }
     
     public int getClassID(){
	return classID;
    }
    
    public void setActivity(String act){
        activity = act;
    }
    
    public String getActivity(){
        return activity;
    }
   
    public void setPrice(double pr){
        price = pr;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setDuration(double durn){
        duration = durn;
    }
    
    public double getDuration(){
        return duration;
    }
    
    public void setNumberOfClasses(int NoCls){
        numberOfClasses = NoCls;
    }
    
    public int getNumberOfClasses(){
        return numberOfClasses;
    }
    
    /*public void setPlacesTaken(int PlTaken){
        placesTaken = PlTaken;
    }
    
    public int getPlacesTaken(){
        return placesTaken;
    }*/
    
    public String toString(){
		return "\n" + super.toString()+ "\nActivity: " + getActivity() + 
                        "\nClass Price: " + getPrice() + "\nClass Duration: " + getDuration() + 
                        "\nNumber of Classes available: " + getNumberOfClasses();
    }
    
     public static int getNextClassID() {
    	return nextClassID;
    }

    public static void setNextMemID(int nextClassID){
    	FitnessClasses.nextClassID = nextClassID;
    }
    
}

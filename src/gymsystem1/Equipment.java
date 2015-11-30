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
public class Equipment implements Serializable{
    private String equipmentName;
    private String equipmentDescription;
    private double equipmentSize;
    
    public Equipment(){
        setEquipmentName("unknown");
        setEquipmentDescription("unknown");
        setEquipmentSize(0.0);
    }
    
    public Equipment(String en, String ed, double es){
        setEquipmentName(en);
        setEquipmentDescription(ed);
        setEquipmentSize(es);
    }
    
    public Equipment(String en){
        setEquipmentName(en);
    }
    
    public void setEquipmentName(String en){
        equipmentName = en;
    }
    
    public String getEquipmentName(){
        return equipmentName;
    }
    
    public void setEquipmentDescription(String ed){
        equipmentDescription = ed;
    }
    
    public String getEquipmentDescription(){
        return equipmentDescription;
    }
    
    public void setEquipmentSize(double es){
        equipmentSize = es;
    }
    
    public double getEquipmentSize(){
        return equipmentSize;
    }
    
    public String toString(){
		return "\nName of equipment: " + getEquipmentName() + "\nEquipment Description: " + getEquipmentDescription() +
                        "\nSize of equipment: " + getEquipmentSize();
    }
}

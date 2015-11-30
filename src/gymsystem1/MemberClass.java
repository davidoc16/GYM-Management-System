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
public class MemberClass implements Serializable {
    Member memberName;
    Class className;
    String date;
    double rate;
    
     public MemberClass() {
    	memberName = new Member();
    	className = new Class();
    	date = "no date";
        rate = (0.0);
    }
     
     public MemberClass(Member member, Class mClass){
    	setMember(member);
    	setClass(mClass);
    	date = "no date";
    }
     
     public MemberClass(Member member, Class mClass, String date, double rate){
    	setMember(member);
    	setClass(mClass);
    	setDate(date);
        setRate(rate);
    }
    
     public void setMember(Member member){
    	this.memberName = member;
    }
     
     public void setClass(Class mClass){
    	this.className = mClass;
    }
     
     public void setDate(String date){	
    	this.date = date;
    }
     
     public void setRate(double rate){
        this.rate = rate;
     }
     
     
     public String toString() {
    	return "\n\nMember: " + memberName + "\nClass: " + className + 
    		"\nClass Date: " + getDate();
    }
     
    public String getDate() { return date;}
    public Member getMember() { return memberName;}
    public Class getMClass() { return className;}
    public double getRate(){ return rate;}
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymsystem;

import java.io.Serializable;

/**
 *
 * @author t00130990
 */
public class Member extends Person implements Serializable{
    private int memberID;
    private String memberAddress;
    private int memberPhoneNo;
    private String memberEmail;
    private String memberType;
    private double membershipPrice;
    private String startDate;
    private String finishDate;
    private static int nextMemID = 1;
    
    public Member(){
        super();
        setMemberID (0);
        setMemberAddress("Unassigned");
        setMemberPhoneNo(0);
        setMemberEmail("Unassigned");
        setMemberType("Unknown");
        setMembershipPrice(0.0);
        setStartDate("Unassigned");
        setFinishDate("Unassigned");
    }
    
     public Member(String nm, int a, char g, String addr, int pNo, String eml, String memTyp, double memPrice,
             String sDate, String fDate){
    	super(nm, a, g);
    	setMemberID(nextMemID);
        nextMemID++;
    	setMemberAddress(addr);
    	setMemberPhoneNo(pNo);
        setMemberEmail(eml);
        setMemberType(memTyp);
        setMembershipPrice(memPrice);
        setStartDate(sDate);
        setFinishDate(fDate);
    }
         
     public Member(String nm, int memID){
     super(nm);
     setMemberID(memID);
     nextMemID++;
     }
     
     public void setMemberID(int memID){
    	memberID = memID;
    }
     
     public int getMemberID(){
	return memberID;
    }
     
     public void setMemberAddress(String addr){
	memberAddress = addr;
    }
     
     public String getMemberAddress(){
	return memberAddress;
    }
     
     public void setMemberPhoneNo(int pNo){
	memberPhoneNo = pNo;
	}

     public int getMemberPhoneNo(){
	return memberPhoneNo;
	}
     
     public void setMemberEmail(String eml){
        memberEmail = eml;
     }
     
     public String getMemberEmail(){
        return memberEmail;
     }
     
     public void setMemberType(String memTyp){
        memberType = memTyp;
     }
     
     public String getMemberType(){
        return memberType;
     }
     
     public void setMembershipPrice(double memPrice){
        membershipPrice = memPrice;
     }
     
     public double getMembershipPrice(){
        return membershipPrice;
     }
     
     public void setStartDate(String sDate){
        startDate = sDate;
     }
     
     public String getStartDate(){
        return startDate;
     }
     
     public void setFinishDate(String fDate){
        finishDate = fDate;
     }
     
     public String getFinishDate(){
        return finishDate;
     }
     public String toString(){
		return "\n" + super.toString()+ "\nMember ID: " + getMemberID() + "\nMember AddressL1: " + getMemberAddress()+
                        "\nMember Phone No: " + getMemberPhoneNo() + "\nMember Email: " + getMemberEmail() + 
                        "\nMembership Type: " + getMemberType() + "\nMembership Price: " + getMembershipPrice() +
                        "\nMembership Start Date: " + getStartDate() + "\nMembership Finish Date: " + getFinishDate()
                        ;
	}
     
     public static int getNextMemID() {
    	return nextMemID;
    }

    public static void setNextMemID(int nextMemID){
    	Member.nextMemID = nextMemID;
    }
}

import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * @author (Francois Ngwasho) 
 * @version (12-03-2023)
 * 
 * Here is the  class  of ShopItemReservation that stores
 * the reservation values and scanner reading into an HashMap code.
 */

public class ShopItemReservation
{
    private String reservationNo;       //number of reservation e.g. 000001

    private String itemID;             //ID of the customer e.g. RD2834

    private String customerID;         //ID of the customer e.g. AB-167034

    private Date startDate;            //date of hire e.g. 22-02-2022

    private int noOfDays;              //length of hire e.g. 7 (days)
    /**
     * Here is the Parameter constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }

    /**
     *The default parameter constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation() 
    {
        reservationNo = "000008";
        itemID="AB-9289067";
        customerID="AB-476592";
        startDate=DateUtil.convertStringToDate("22-03-2023");
        noOfDays=6;
    }

    /**
     *This method Returns field value of the <code>ShopItemReservation</code> object
     * 
     * and the resrvation number, as a <code>String</code>
     */
    public String getItemReservationNo()
    {
        return reservationNo;
    }

    /**
     * This method Returns the <code>customerID</code> field value of the <code>ShopItemReservation</code> object
     * 
     *  and return   the customers ID of certain reservation, as a <code>String</code>
     */
    public String getCustomerID()
    {
        return customerID;
    }

    /**
     *This method Returns the <code>itemID</code> field value of the <code>ShopItemReservation</code> object
     * 
     * and return   the item ID of certain reservation, as a <code>String</code>
     */
    public String getItemID()
    {
        return itemID;
    }

    /**
     *This method Returns the <code>startDate</code> field value of the <code>ShopItemReservation</code> object
     * 
     * and return   the start date of reservation, as a <code>Date</code>
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     * This method Returns the <code>noOfDays</code> field value of the <code>ShopItemReservation</code> object
     * 
     * and return  the length of reservation, as a <code>int</code>
     */
    public int getNoOfDays()
    {
        return noOfDays;
    }

    /**
     * Here is the Set the <code>reservationNo</code> field value of the <code>ShopItemReservation</code> object
     */
    public void setItemReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
    }
    
     public void setReservationNo(String num)
    {
        this.reservationNo = num;
    }
    
    public void setStartDate(Date date)
    {
        this.startDate = date;
    }
    
    /**
     * Here I have assigning the values for each <code>ShopItemReservation</code> object field from 
     * a line of the scanned text file.
     */
    public void readData(Scanner scanner2)
    {
        reservationNo = scanner2.next();
        itemID = scanner2.next();
        customerID = scanner2.next();
        startDate = DateUtil.convertStringToDate(scanner2.next());
        noOfDays = scanner2.nextInt();
    }

    /**
     * This method Writes item reservation data to a file
     *  
     */
    public void writeData(PrintWriter pWriter)
    {
       String lineOfOutput = reservationNo+", "+itemID+", "+customerID+", "+
       DateUtil.convertDateToShortString(startDate)+", "+noOfDays;
       pWriter.println(lineOfOutput);    
    }

    /**
     *This method Returns all the fields value of the <code>ShopItemReservation</code> object
     * 
     * And   the reservation details, as a <code>String</code>
     */
    public void printDetails()
    {
        System.out.println("Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID + 
            "; Date of hire: " + startDate + "; Hire duration: " + noOfDays);
    }

    /**
     * This method Returns all the fields values of the <code>ShopItemReservation</code> object
     * 
     * and return also the reservation details, as a <code>String</code>
     */
    public String toString()
    {
        String output = ("Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID + 
                "; Date of hire: " + startDate + "; Hire duration: " + noOfDays);
        return output;
    }
}

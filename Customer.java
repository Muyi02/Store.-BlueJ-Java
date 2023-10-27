import java.util.Scanner;
import java.io.*;
import java.awt.*;
/**
 * Write a description of class Customer here.
 * 
 * @author (Francois Ngwasho) 
 * @version (22-02-2023)
 */
public class Customer
{
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        // initialise instance variables
        customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }

    /**
     * Constructor for objects of class Customer
     * For testing purposes only 
     */
    public Customer()
    {
        // initialise instance variables
        customerID = "unknown";
        surname = "Dane";
        firstName = "Johns";
        otherInitials = "DJ";
        title = "Dr";
    }

    /**
     * Accessor Methods for the the class Customers
     */
    public String getCustomerID()
    {
        return customerID;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getOtherInitials()
    {
        return otherInitials;
    }

    public String getTitle()
    {
        return title;
    }
    
    /**
     * Mutator methods for the class Customer 
     */
    public void setID(String customerID)
    {
        this.customerID = customerID;
    }
    
    public void printDetails()
    {
        System.out.println("CustomerID:"+customerID+ "; Surname:"+surname+ "FirstName:" +firstName+ "OtheInitials:"+otherInitials+"Title:" +title);
    }

    /**
     * This method enables Shop class to read datafile according to the way the 
     * Data is being stored in the datafile 
     * 
     * @param scan      is a Scanner object, aids read of data from a data file
     */
    public void readCustomerData(Scanner scan) 
    {
        customerID = scan.next();
        surname = scan.next();
        firstName = scan.next();
        otherInitials = scan.next();
        title = scan.next();
    }
    
    /**
     * This method enables the Shop class to write data to a data file 
     * from the way the data is being stored in the Customer Class 
     * 
     * @param pWriter       is a PrintWriter object used to write data to a data file
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.print(customerID + ", ");
        pWriter.print(surname + ", ");
        pWriter.print(firstName + ", ");
        pWriter.print(otherInitials + ", ");
        pWriter.print(title);
        pWriter.println();
    }
    
   
        
}
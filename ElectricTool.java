import java.util.Scanner;
import java.io.PrintWriter;
/**
 * This class models the electrical devices in the shop Class
 * It contains the tools properties such as name, itemCode, number of times Borrowed
 * onLoan, rechargeble, cost, weight and power.
 * 
 * Some of the classes unique properties are declared in this class while the common
 * Properties are inherited from the Tool superClass
 * 
 * @author (Francois Ngwasho)
 * @version (22-02-2023)
 */
public class ElectricTool extends Tool
{
    private boolean rechargeable;  //Tells if the electric device can be recharged or not
    private String power;  //for the capacity of power that can be stored in the device

    /**
     * Accessor method for Electric Tool
     * 
     * that return The Electric fields values.
     */
    public boolean getRechargeable()
    {
        return rechargeable;
    }

    public String getPower()
    {
        return power;
    }

    /**
     * Here is the Mutator methods for ElectricTool 
     * 
     */
    public void setRechargeable(boolean recharge)
    {
        rechargeable = recharge;
    }

    public void setPower(String volts)
    {
        power = volts;
    }

    /**
     * This method will Print details of Electric tool fields to the terminal
     * 
     * and super calls the printDetails in the superClass Tools
     *        and print those values out before it prints out fields in this field 
     *        The positioning of super does not matter 
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Power:"+ power+"Rechargeable:" +rechargeable);

    }

    /**
     * This method is intended to help ElectricTool extract its own data 
     * to store in its class fields
     */
    public void readData(Scanner sc)
    {
        super.readData(sc);
        rechargeable = sc.nextBoolean();
        power = sc.next();

    }
    /**
     * This methode is for write data in the file.
     */
    // public void writeData(PrintWriter pWriter)
    // {
    //   String lineOfOutput = rechargeable+","+power+","+getTimesBorrowed()+","+getOnLoan()+","
    //                         +getToolName()+","+getToolCode()+","+getCost()+","+getWeight();
    //   pWriter.println(lineOfOutput);
    //   }
}  

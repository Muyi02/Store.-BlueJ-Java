import java.util.Scanner;
import java.io.PrintWriter;
/**
 * This class models a different kind of Tool that can be found in the 
 * Shop class. It contains properties that are unique to its operation
 * and inherits other properties from the Tool superClass
 * 
 * @author (Francois Ngwasho)
 * @version (22-02-2023)
 */
public class HandTool extends Tool
{
    private boolean sharpenable;

    /**
     * Accessor method for HandTools
     * 
     * @return The HandTool fields values.
     */
    public boolean getIsSharpenable()
    {
        return sharpenable;
    }

    /**
     * Mutator methods for HandTools 
     * 
     */
    public void setSharpenable(boolean sharpen)
    {
        sharpenable = sharpen;
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.print("sharpenable " +sharpenable);
    }

    /**
     * This is intended to help HandTool extract its own data 
     * to store in its class fields and pass the remaining data to be stored in the 
     * superClass tool 
     */
    public void readData(Scanner s)
    {
        super.readData(s);
        sharpenable = s.nextBoolean();
    }

   // public void writeData(PrintWriter pWriter)
   // {
      //  String lineOfOutput = sharpenable+","+getTimesBorrowed()+","+getOnLoan()+","+ getToolName()+","+getToolCode()+","+getCost()+","+getWeight();
      //  pWriter.println(lineOfOutput);
   // }
}


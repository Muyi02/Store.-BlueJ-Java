import java.util.Scanner;
//import java.io.PrintWriter;
/**
 * The class Workwear stores properties of the workwear items like
 * gloves and other protective clothing in the shop.
 * 
 * This class extends the Accesory class
 * 
 * @author (Francois Ngwasho) 
 * @version (27-02-2022)
 */
public class Workwear extends Accessory
{
    private String manStandard;
    private String colour;
    private String size;
    
    /**
     * Accessor methods for the class WorkWear
     */

    public String getManStandard()
    {
        return manStandard;
    }

    public String getColour()
    {
        return colour;
    }

    public String getSize()
    {
        return size;
    }

    /**
     * Mutator methods for the class Perishable
     */

    public void setManStandard(String manStandard)
    {
        this.manStandard = manStandard;
    }

    /**
     * Mutator methods for the class Perishable
     */

    public void setUseByDate(String colour)
    {
        this.colour = colour;
    }

    public void setVolume(String size)
    {
        this.size = size;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Manufacturing Standard:"+manStandard+ "Colour:" +colour+ "Size:"+size);
        
    }

    public void readData(Scanner s)
    {
        super.readData(s);
        manStandard = s.next();
        colour = s.next();
        size = s.next();
    }
    
    //public void writeData(PrintWriter pWriter)
    //{
      //  String lineOfOutput = manStandard+","+colour+","+size+","+getPosition()+","+getItemName()+","+getItemCode()+","+getCost();
        //pWriter.println(lineOfOutput);
    //}
}

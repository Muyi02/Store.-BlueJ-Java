import java.util.Scanner;
import java.io.PrintWriter;
/**
 * This superClass stores common fields between the the subclasses 
 * Perishable and Workwear 
 * 
 * @author (Francois Ngwasho) 
 * @version (27-02-2023)
 */
public abstract class Accessory extends ShopItem
{
    private boolean isRecyclabe;
    /**
     * Accessor methods for the Accessory Class
     */

    public boolean getPosition()
    {
        return isRecyclabe;
    }

    /**
     * Mutator methods for the Accessory Class
     */

    public void setIs(String position)
    {
    //  this.position = position;
    }

    public void printDetails()
    {
        System.out.printf("recyclable:",isRecyclabe);
        super.printDetails();
    }

    public void readData(Scanner s)
    {
        isRecyclabe = s.nextBoolean();
        super.readData(s);
    }
    
    //abstract public void writeData(PrintWriter pWriter);
}

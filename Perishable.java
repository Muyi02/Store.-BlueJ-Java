import java.util.Scanner;
import java.io.PrintWriter;
/**
 * The Perishable class stores the properties of perishable items in
 * the shop.
 * Perishable items are assumed to be liquids such as cleaning agents etc
 * 
 * @author Francois Ngwasho 
 * @version 27-02-2023
 */
public class Perishable extends Accessory
{
    private boolean isIrritant;
    private String useByDate;
    private int volume;

    /**
     * Accessor methods for the class Perishable
     */

    public boolean getIsIrritant()
    {
        return isIrritant;
    }

    public String getUseByDate()
    {
        return useByDate;
    }

    public int getVolume()
    {
        return volume;
    }

    /**
     * Mutator methods for the Perishable class
     */

    public void setUseByDate(String useByDate)
    {
        this.useByDate = useByDate;
    }

    public void setVolume(int volume)
    {
        this.volume = volume;
    }

    public void setIsIrritant(boolean isIrritant)
    {
        this.isIrritant = isIrritant;
    }

    public void printDetails()

    {
        super.printDetails();
        System.out.println("; Irritant: " + isIrritant + "; Use-By-Date: " + useByDate +
            "; Volume: " + volume);
    }

    public void readData(Scanner s)
    {
        super.readData(s);
        isIrritant = s.nextBoolean();
        useByDate = s.next().trim();
        volume = s.nextInt();
        s.hasNextLine();
    }

    public void writeData(PrintWriter pWriter)
    {
        String lineOfOutput = isIrritant+","+useByDate+","+volume+","+getPosition()+","+ getItemName()+","+getItemCode()+","+getCost();
        pWriter.println(lineOfOutput);
    }
}

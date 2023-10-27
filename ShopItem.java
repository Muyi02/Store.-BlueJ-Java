import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Here is the ShopItem class is the super class for subclass Tool and Accessory 
 * and also their indiviual subclasses 
 * 
 * and here is the fields for these three classes are itemCode,itemName and cost
 * 
 * @author  Francois Ngwasho
 * @version (25-02-2022)
 */
public  class ShopItem
{
    private String itemName; 
    private String itemCode;
    private int cost;

    /**
     * Here is the accessors method for superClass ShopItem
     */
    public String getItemCode()
    {
        return itemCode;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getCost()
    {
        return cost;
    }

    /**
     * Here is the  Mutators methods for the superClass ShopItem
     */

    public void setItemCode(String itemName)
    {
        this.itemCode = itemName;
    }

    public void setItemName(String itemCode)
    {
        this.itemName = itemCode;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public void printDetails()
    {

        System.out.println("ItemName :"+ itemName+ ",ItemCode:"+ itemCode+ ",Cost:"+ cost);
    }

    public void readData(Scanner s)// read data for ShopItem class
    {
        itemName = s.next();
        itemCode = s.next();
        cost = s.nextInt();
    }

    // public void writeData(PrintWriter pWriter);
}

import java.util.Scanner;
import java.io.File;

/**
 * Here is the tool class 
 *
 * @author (Francois Ngwasho)
 * @version (22-02-2023
 */
public abstract class Tool extends ShopItem
{
    //private String toolName; // the name of the tools
    // private String itemCode;// used to identify each tool
    private int timesBorrowed; // number of times the tool has been borrowed
    private boolean onLoan; //whether or not an item is on loan 
    //private int cost; // cost of the item when new in pounds
    private int weight; // the weight in whole grammes
    //private boolean rechargeable; //checks whether the item is rechargeable or not
    //private String power;// checks the capacity of power of the tool.

    /**
     * Constructor for objects of class Tool
     */
    //public Tool(String toolName, String code, int timesBorrowed, boolean onLoan, int cost, int weight)
    //{
    //  this.toolName = toolName;
    // this.itemCode = code;
    //this.timesBorrowed = timesBorrowed;
    // this.onLoan = onLoan;
    //  this.cost = cost;
    //this.weight = weight;
    // this.rechargeable = true;
    //this.power = "8V";

    
    /**
     * This constructor is for the purpose of testing
     */
    public Tool(){
        //toolName = "DeWalt Circular Saw";
        // itemCode = "RD6582";
        //timesBorrowed=203;
        //onLoan = true;
        // cost = 450;
        //weight =420;
        // rechargeable= true;
        // power="4v";

    }

    /**
     * This method prints out details about the item to the terminal window.
     */
    public void printDetails(){
        super.printDetails();
        System.out.println( " timeBorrowed: " + timesBorrowed + ";" +
            "\nonLoan: "+ onLoan + "; "+ " weight: " + weight );
    }

    /**
     * Accessor method to value stored in the private field toolName
     * 
     * @return toolName - <code>String</code> the name of the tool is
     */
    //public String getToolName()
    {
        // return toolName; 
    }

    /**
     * Accessor method to value stored in the private field itemCode
     * 
     * @return itemCode - <code>String</code> the code of the item is
     */
    //public String getItemCode()
    {
        //   return itemCode; 
    }

    /**
     * Accessor method to value stored in the private field timesBorrowed
     * 
     * @return timesBorrowed - <code>int</code> the number of times the item is borrowed is
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed; 
    }

    /**
     *Here is the accessor method to value stored in the private field onLoan
     * 
     * @return onLoan - <code>boolean</code> is the item on loan or not
     */
    public boolean getOnLoan()
    {
        return onLoan; 
    }

    /**
     * Accessor method to value stored in the private field cost
     * 
     * @return cost- <code>int</code> the cost of the item is
     */
    //public int getCost()
    {
        // return cost; 
    }

    /**
     * Accessor method to value stored in the private field weight
     * 
     * @return weight - <code>int</code> the weight of the item is
     */
    public int getWeight()
    {
        return weight; 
    }

    /**
     * Accessor method to check whether the tool is rechargeable or not
     * 
     * @return rechargeable - <code>boolean</code> is the rechargeable 
     */
    //public boolean getRechargeable()
    {
        //  return rechargeable; 
    }

    /**
     * Accessor method to check the amount of power of the tool
     * 
     * @return power - <code>int</code> the amount of power is
     */
    //public String getPower()
    {
        //   return power; 
    }

    /**
     * mutator method to set the name of the tool
     * 
     * @param toolName <code>String</code> the name of the tool is
     */
    //public void setToolName(String toolName)
    {
        //this.toolName= toolName;
    }

    /**
     * mutator method to set the code of the tool
     * 
     * @param itemCode <code>String</code> the code of item is
     */
    public void setItemCode(String itemCode)
    {
        //this.itemCode = itemCode;
    }

    /**
     * mutator method to set times the item is borrowed
     * 
     * @param timesBorrowed <code>int</code> times the item has been borrowed is
     */
    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed =timesBorrowed;
    }

    /**
     * mutator method to set if the item is on loan or not
     * 
     * @param onLoan <code>boolean</code> if the item is on loan or not 
     */
    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }

    /**
     * mutator method to set cost of the item
     * 
     * @param cost <code>int</code> cost of the item is
     */
    //public void setCost(int cost)
    {
        //this.cost = cost;
    }

    /**
     * mutator method to set the weight of the item
     * 
     * @param weight <code>int</code> the weight of the item is
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * Mutator methods to set whether the tool is rechargeable or not
     * 
     */
    //public void setRechargable(boolean rechargeable)
    {
        //   this.rechargeable = rechargeable;
    }

    /**
     * Mutator method to set the power of the tool
     */

    //public void setPower(String power)
    {
        //this.power = power;
    }

    public String toString() {
        return //"Tool Name: " + toolName +
        //", Item Code: " + itemCode + 
        ", Times Borrowed: " + timesBorrowed + 
        ", On Loan: " + onLoan + 
            //", Cost: £" + cost + 
        ", Weight: " + weight + "g";
    }

    /**
     * This mutator method is designed to let each tool read its own data using a scanner object
     */
    public void readData(Scanner lineScanner) {
        super.readData(lineScanner);
        //toolName = lineScanner.next();
        //itemCode = lineScanner.next();
        timesBorrowed = lineScanner.nextInt();
        onLoan = lineScanner.nextBoolean();
        //cost = lineScanner.nextInt();
        weight = lineScanner.nextInt();


    }
}

import java.util.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;

/**
 * The Shop class stores different types of items.
 * 
 * Here is the details of each item in the shop is displayed to the Terminal 
 * and the data for each file is read off a text file with the help of flags 
 * item types are stored in appropraite classes.
 * 
 * @author Francois Ngwasho
 * @version(22-03-2023)
 */

public class Shop
{
    private List<Customer> customerList;
    private List<ShopItem> itemList;
    private Map<String,Customer> customerMap;
    private Map<String,ShopItem> itemsMap;
    private Random randomGenerator ;
    private Set<String> uniqueNum;
    private Map<String,ShopItemReservation> itemReservationMap;
    private Diary diary;
    /**
     * The constructor for the shop class
     */
    public Shop()
    {
        //toolList = new ArrayList<Tool>();
        itemList=new ArrayList<ShopItem>();
        customerList = new ArrayList<>();
        randomGenerator = new Random();
        uniqueNum= new HashSet<String>();
        customerMap = new HashMap<>();
        itemsMap = new HashMap<>();
        itemReservationMap = new HashMap<>();
    }

    /**
     * Returns the number of ShopItems that are in the Shop Class 
     * 
     * @retun int 
     */
    public int getNumberOfItems()
    {
        return itemsMap.size();
    }

    /**
     * This method Returns the number of Customers of Shop Class  
     */
    public int getNumberOfCustomers()
    {
        return customerMap.size();
    }

    /**
     * This method Returns the number of Reserved items in the Shop Class 
     */
    public int getNumberOfItemReservations()
    {
        return itemReservationMap.size();
    }

    /**
     *This method Store items to the itemsMap
     * 
     * @param  item   a ShopItem object
     */
    public void storeItem(ShopItem item)
    {
        if (!item.getItemCode().startsWith("AB-") || itemsMap.containsKey(item.getItemCode()))
        {
            item.setItemCode(generateCustomerID("AB-", 6));
        }
        itemsMap.put(item.getItemCode(),item);
    }

    /**
     * This method Returns customer object based on uniqueId for customer 
     * 
     * @return customer, a Customer Object
     */
    public Customer getCustomer(String uniqueID)
    {
        Customer customer = null;
        if(customerMap.containsKey(uniqueID)) 
        {
            customer = customerMap.get(uniqueID);
            customer.printDetails();
        }
        else
        {
            System.out.println("Customer doesn't exist");
        }
        return customer;
    }

    /**
     *This method Returns item based on uniqueID from the itemsMap
     * 
     * @param uniqueID is a String object
     * 
     * @return a ShopItem object
     */
    public ShopItem getItem(String uniqueID)
    {
        ShopItem item = null;
        if(itemsMap.containsKey(uniqueID))
        {
            item = itemsMap.get(uniqueID);
            item.printDetails();
        }
        else 
        {
            System.out.println("Item doesn't exists!");
        }
        return item;
    }

    /**
     * Here is the method stores the name of customers from the Customer class.
     * Store customers to the customersMap.
     */
    public void storeCustomer(Customer customer) 
    {
        //customerList.add(customer);
        if (customer.getCustomerID()== null || customer.getCustomerID().equals("unkown"))
        {
            String newID = generateCustomerID("AB-",6);
            while (customerMap.containsKey(newID))
            {
                generateCustomerID("AB-", 6);
            }
        }
        customerMap.put(customer.getCustomerID() , customer);
    }

    /**
     * This method will print all tools in the shop items 
     */
    public void printAllTools()
    {
    
        for (ShopItem item : itemList)
        {
            item.printDetails();
        }

    }

    /**
     * Here is the set method for the customer identification
     */

    public void readToolData() throws FileNotFoundException
    {
        Frame frame = null;
        FileDialog fileBox = new FileDialog(frame,"Open",FileDialog.LOAD);
        fileBox.setVisible(true);
        String filename=fileBox.getFile();
        String directory= fileBox.getDirectory();

        fileBox.setDirectory("Downloads://");
        File file = new File(directory + filename);

        Scanner scanner= new Scanner (file);
        String typeOfData= "";
        // String lineOfText = new Scanner(new File("dataFile")).useDelimiter("//Z").next();
        while(scanner.hasNextLine()) 
        {
            String lineOfText = scanner.nextLine().trim();
            if (lineOfText.startsWith("//")){
                continue;
            }

            else if (lineOfText.isEmpty())
            {
                continue;
            }
            else if(lineOfText.startsWith("[") )
            {
                if (lineOfText.startsWith("[HandTool data]"))  
                {

                    typeOfData="HandTool data";

                    //toolList.add(HT);

                }
                else if (lineOfText.startsWith("[ElectricTool data]"))  
                {

                    typeOfData="ElectricTool data";

                }
                else if(lineOfText.startsWith("[electricTool data]"))
                {
                    typeOfData="electricTool data";
                }
                else if(lineOfText.startsWith("[Perishable data]"))
                {
                    typeOfData="Perishable data";
                }
                else if(lineOfText.startsWith("[Workwear data]"))
                {
                    typeOfData="Workwear data";
                }

            }
            else 
            {

                Scanner scanner3=new Scanner(lineOfText);

                scanner3.useDelimiter("\\s*,\\s*");
                ShopItem fn = new ShopItem();

                if (typeOfData== "ElectricTool data") 
                {
                    fn= new ElectricTool();
                    fn.readData(scanner3);
                    storeItem(fn);
                }
                else if (typeOfData=="HandTool data")
                {
                    fn= new HandTool();
                    fn.readData(scanner3);
                    storeItem(fn);
                }
                else if( typeOfData=="Perishable data") 

                { 
                    fn= new Perishable();
                    fn.readData(scanner3);
                    storeItem(fn);

                }
                else if(typeOfData=="Workwear data")
                {
                    fn= new Workwear();
                    fn.readData(scanner3);
                    storeItem(fn);
                }
                else if(typeOfData=="electricTool data")
                {
                    fn = new ElectricTool();
                    fn.readData(scanner3);
                    storeItem(fn);
                }
            }

        }
        scanner.close();
        printAllTools();

    }
 
    /**
     * This method prints all the customer names from the customer class.
     */
    public void printAllCustomers(List<Customer>customerList) {
        System.out.println("All customers:");
        for (Customer customer : customerMap.values()) {
            customer.printDetails();

        }
    }
    /**
     * This method will read the customer data.[ 
     */
    public void readCustomerData() {
        Frame myFrame = null;
        FileDialog fileDialog = new FileDialog(myFrame , "open" , FileDialog.LOAD);
        fileDialog.setDirectory(".");
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        System.out.println("Selected file: " + directory + fileName);

        try {
            //Creating a scanner object 
            Scanner sc = new Scanner(new File(directory + fileName));
            while (sc.hasNextLine()) {
                String lineOfText = sc.nextLine().trim();
                if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
                    System.out.println("Line of data: " + lineOfText);
                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter(",");

                    Customer fn = new Customer();
                    fn.readCustomerData(lineScanner);
                    //customerList.add(fn);
                    storeCustomer(fn);
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    /**
     * Writes Customer data to a new file, using the FileDialog box to retrived 
     * pathName which 
     * is sent to the writeCustomerData() with the name the file to 
     * be written to and its directory
     */
    public void writeData()
    {

        try {
            PrintWriter writer = new PrintWriter("customer_data.txt");
            for (Customer customer : customerList) {
                customer.writeData(writer);
            }
            writer.close();
            System.out.println("Customer data written to file successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Failed to write customer data: file not found");
        }
    }

    /**
     * Generates UniqueIds for itemsId and CustomerId
     *              
     * Returns a String number as the generated UNIQUEID
     * 
     *
     */
    public String generateCustomerID(String prefix, int numDigits)
    {
        String number = ""; boolean look = false;
        while(look == false)
        {
            for(int i =0; i < numDigits; i++)
            {
                number += randomGenerator.nextInt(10);
            }
            look = isUnique(prefix + number);
        }
        return prefix + number;
    }

    /**
     * Generates the reservationNo field value of the ShopItemReservation object
     */
    public String generateReservationNo()
    {
        Random rand = new Random();
        String ReservationNo = "";

        for (int i=0; i<6; i++) {
            ReservationNo += rand.nextInt(10);
        }
        return ReservationNo;
    }

    public boolean isUnique(String unique)
    {
        boolean look = false;
        look = uniqueNum.add(unique);
        if(look == true)
            return true;
        else
            return false;
    }

    /**
     * This method returns if the customers ID is removed or not.
     * If it is removed the return will not be null.
     */
    public boolean removeCustomer(int customerID) {
        Customer removed = customerMap.remove(customerID);
        return removed != null;
    }

    /**
     * This method shows if an item has been removed or not.
     * If it has been removed the return will not be null.
     */
    public boolean removeItem(String itemCode) {
        ShopItem removed = itemsMap.remove(itemCode);
        return removed != null;
    }

    /**
     * Adds an item reservation to the itemReservationMap
     * An object of the ShopItemReservation class
     */
    private void storeItemReservation(ShopItemReservation itemReservation)
    {
        itemReservationMap.put(itemReservation.getItemReservationNo(), itemReservation);
        diary.addReservation(itemReservation);
    }

    /**
     * Get reservation by its key <code>reservationNo</code>
     */
    public ShopItemReservation getItemReservation(String reservationNo)
    {
        if (itemReservationMap.containsKey(reservationNo))
        {
            ShopItemReservation reservation = itemReservationMap.get(reservationNo);
            return reservation;
        }
        else
        {
            System.out.println("Reservation No does not exists!");
            return null;
        }
    }

    /**
     *generate a reservation number for the reservation;
     * create a ShopItemReservation object;
     * add it to the list of reservations.
     * if they are valid, the method should return true;
     * otherwise the method should output a message to the terminal window and return false
     * without creating a ShopItemReservation object, etc
     */
    public boolean makeItemReservation(String itemID, String customerID, String startDate, int noOfDays)
    {
        // Check if the parameters are valid
        if (customerID == null || customerID.isEmpty()) {
            System.out.println("Invalid customer ID.");
            return false;
        }
        if (itemID == null || itemID.isEmpty()) {
            System.out.println("Invalid item ID.");
            return false;
        }
        if (startDate == null || startDate.isEmpty()) {
            System.out.println("Invalid start date.");
            return false;
        }
        if (noOfDays <= 0) {
            System.out.println("Invalid number of days.");
            return false;
        }

        // Generate a reservation number for the reservation
        String reservationNumber = generateReservationNo();

        // Check if the item exists
        ShopItem item = getItem(itemID);
        if (item == null) {
            System.out.println("Item does not exist.");
            return false;
        }

        // Create a ShopItemReservation object
        ShopItemReservation reservation = new ShopItemReservation(reservationNumber, customerID, itemID, startDate, noOfDays);

        // Add it to the list of reservations
        storeItemReservation(reservation);

        return true;
    }

    /**
     *This method prints the details of all reservation objects from the customerMap.  
     *Checks that a "valid" reservation has beencorrectly added to the reservation list.
     */

    public void printItemReservation()
    {
        if (itemReservationMap.size() != 0)
        {
            for (ShopItemReservation itemReservation: itemReservationMap.values())
            {
                itemReservation.printDetails();
            }
        }
        else
        {
            System.out.println("Reservation list is empty!");
        }
    }

    /**
     * This mutator method reads data from the customer class, creates  objects and adds the objects to customerList
     */
    public void  readItemReservationData() {
        Frame myFrame = null;
        FileDialog fileDialog = new FileDialog(myFrame , "open" , FileDialog.LOAD);
        fileDialog.setDirectory(".");
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        System.out.println("Selected file: " + directory + fileName);

        try {
            //Creating a scanner object 
            Scanner sc = new Scanner(new File(directory + fileName));
            while (sc.hasNextLine()) {
                String lineOfText = sc.nextLine().trim();
                if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
                    System.out.println("Line of data: " + lineOfText);
                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter(",");

                    ShopItemReservation ir = new ShopItemReservation();
                    ir.readData(lineScanner);
                    storeItemReservation(ir);
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    /**
     * Writes Item Reservation data to a new file, using the FileDialog box to retrived 
     * pathName which is sent to the writeItemReservationData() with the name the file to 
     * be written to and its directory
     */
    public void writeItemReservationData()
    {

        Frame myFrame = new Frame();
        FileDialog fileName = new FileDialog (myFrame,"Open", FileDialog.LOAD);
        fileName.setVisible(true);
        if (fileName !=null) {
            String filePath = fileName.getDirectory() + fileName.getFile();
        }
        if (!itemReservationMap.isEmpty())
        {
            PrintWriter pWriter = null;
            try {
                pWriter = new PrintWriter("");
            }
            catch (FileNotFoundException ex) {
                System.err.println("\n\n*** File Not Found Exception ***");
                pWriter = null;
            }
            for (ShopItemReservation itemReservation: itemReservationMap.values())
            {
                itemReservation.writeData(pWriter);
            }
            System.out.println("Reservation list successfully saved!");
            pWriter.close();
        }
        else
        {
            System.out.println("Reservation list is empty!");
        }
    }

    /**
     * This method prints details of the diary class from the DiaryEntries method 
     */
    public void printDiaryEntries(String startDate, String endDate)
    {
        if (diary != null)
        {
            diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
        }
    }

    /**
     * Remove reservation from the itemReservationMap
     *
     */
    public void deleteItemReservation(String reservationNo)
    {
        if ( itemReservationMap.containsKey(reservationNo) )
        {
            diary.deleteReservation(getItemReservation(reservationNo));
            itemReservationMap.remove(reservationNo);
            System.out.println("Reservation removed!");
            printItemReservation();
        }
        else
        {
            System.out.println("Invalid reservation!");
            System.out.println("Please enter a valid reservation Number!");
        }
    }

}



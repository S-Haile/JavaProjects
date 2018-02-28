/**
 * 
 * 
 * This class simulates a shopping list that takes user input, where the user can add, empty, and/or print the list
 * 
 * @author Samson Haile
 * @version Standard
 * 
 */

public class ShoppingList {
    
   //declaring the scanner
    private java.util.Scanner scan;
   
    // declare storage for the list items
     private String[] list;
     int counter;
      
   
   /**
    * 
    * Constructor for the class ShoppingList
    * 
    */
     
    public ShoppingList() {
      
        //initializes the scanner
        scan = new java.util.Scanner(System.in);
      
        // initialize storage for list items
        list = new String[10];
        counter = 0;
    }
    
    /**
     * 
     * 
     * This method checks if an item this is being added to the list is a duplicate item
     * 
     * @param item the input of the user
     * 
     * @return whether or not it is a duplicate item
     * 
     */
    
    private boolean duplicate(String item) {
      boolean s = false;
      
      //for each loop that checks if the input is a duplicate
      for(String index : list){
        if(index != null && index.equals(item)){
          return true;
            
      }
            }
      return s;
    }
    
    /**
     * 
     * This method prints out the list
     * 
     */
    
    public void printList() {
       
        System.out.println("Your shopping list:");
        
        //This checks if the list is empty
        //If it is, it prints a special message
        if (list[0] == null){
           System.out.println(" * No items on list.");
           System.out.println("");
     
           
        }else{
          
          //This loop prints out the shopping list
          for(int i = 0; i <list.length; i++){
     
            if(list[i] == null){
              break;
            }else{
              
              // print the list
              System.out.println( i+1 + ". " + list[i]);
            }
          }
        }
    }  
    
    /**
     * 
     * 
     * This is the method that controls adding items to the list
     * 
     * @param item the input from the user
     * 
     */
    
    public void addToList(String item) {
      
        // This loop checks if the items
        // is a duplicate item
        for(int i = 0; i<list.length; i++){
          if(duplicate(item) == true){
            break;
          }
          // This checks if there is empty space
          // on the shopping list
          if(list[i] == null){
            list[i] = item;
            
            // prints a message letting the user know
            //the item was added to the list
            
            System.out.println("item '" + item + "' was added to the list.");
            counter++;
            break;
          }
          
        }
        
    }
    /**
     * 
     * This method handles emptying the list
     * 
     * 
     */
    
    public void emptyList() {
      
      //this loop sets all values in the array
      //to null, effectively emptying the list
      for(int i = 0; i < list.length; i++){
        list[i] = null;
       
    }
      //prints a special message letting the user know
      //that the array has been emptied
      System.out.println("your list has been emptied.");
      System.out.println("");
    }
    
    /**
     * 
     * This method handles taking in the user input
     * 
     * @return the user input
     * 
     */
    public String getInput() {
        System.out.print("Enter your item or command: ");
        return scan.next().trim();
    }
    
    /**
     * 
     * This method prints the welcome message
     * 
     */
    
    public void printWelcome() {
        System.out.println("Welcome to the XYZ Shopping List Program.");
    }
    
    /**
     * 
     *This method prints the goodbye message
     * 
     */ 
    public void printThankYou() {
        System.out.println("Thank you for using the XYZ Shopping List Program.");
    }
    
    /**
     * 
     * This method prints the help menu
     *
     */
    
    public void printHelp() {
        System.out.println("Here are the list of commands:");
        System.out.println("  -p : Print the list");
        System.out.println("  -e : Empty the list");
//      System.out.println("  -r n : Remove the nth item from the list");
        System.out.println("  -x : Exit the application");
        System.out.println("  -h : Print this command list");
    }
    /**
     * 
     * This is the driver method that handles the inputs of the menu
     * 
     */
    public void go() {
        String input;
        
        printWelcome();
        printHelp();
        input = getInput();
        
        //switch statement that handles the menu inputs
        while( ! input.equals("-x")) {
            switch(input) {
                case "-h":
                    printHelp();
                    break;
                case "-p":
                    printList();
                    break;
                case "-x":
                    break;
                case "-e":
                    emptyList();
                    break;
              default:
                if (duplicate(input) == true){
                 System.out.println("Item is already on list, duplicate item '" + input + "' was not added.");
                 System.out.print("");
              }
                  if(list[9] != null){
                    System.out.println("List is full, item '" + input + "' was not added.");
                  }else{
                    addToList(input);
                  }
                
            }
/* alternate (pre-Java 1.7) implementation
            if(input.equals("-h")) {
                printHelp();
            } else if(input.equals("-p")) {
                printList();
            } else if(input.equals("-e")) {
                emptyList();
            } else {
                addToList(input);
            }
//*/
            input = getInput();
        }
        printThankYou();
    }
    
    public static void main(String[] args) {
        ShoppingList list;
        
        list = new ShoppingList();

        list.go();
    }
    
}
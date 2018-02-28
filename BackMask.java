package csc143.backmasking;

import csc143.data_structures.*;
import java.io.*;
import java.util.*;

/**
 * 
 * This class will backmask (AKA reverse) audio in the DAT format
 * 
 * @author Samson Haile
 * @version Standard
 * 
 * 
 * 
 */
public class BackMask{

  String header1;
  String header2;
  Scanner scan;
  File inputfile;
  File outputfile;
  PrintWriter writer;
  UnboundedArrayStack AS;
  UnboundedArrayQueue AQ;
  UnboundedLinkedListStack LS;
  UnboundedLinkedListQueue LQ;
  
  /**
   * 
   * 
   * Backmasks the dat file using with stacks and queues which use an underlying array
   * @param input the name of the input file
   * @param output the name of the output file
   * @throws Underempty thrown we we try to remove from an empty stack or queue
   * 
   * 
   */
  public void BackMaskArray(String input,String output) throws Underempty {  
    
    //Creates the two files for reading/writing
    inputfile = new File(input);
    outputfile = new File(output);
    
    //instantiates the stack/queue
    AS = new UnboundedArrayStack();
    AQ = new UnboundedArrayQueue();
    
    //Try/catch block for the potential FileNotFoundException
    try{
      
      scan = new Scanner(inputfile);
      
      //gets the header info
      header1 = scan.nextLine();
      header2 = scan.nextLine();
      
      //Loop that gets the time and wave offset data
      //time data is stored in the queue
      //and offset data is stored in the stack
      while(scan.hasNext() == true){
        AQ.enqueue(scan.next());
        AS.push(scan.next());
      }
      
    //Catches possible FileNotFoundException
    //if it does, it prints a small error to let the user know an error has occured
    }catch(FileNotFoundException e){
      System.err.println("No file with that name was found.");
    }
    
    //Gets size
    int size = AS.size();
    
    //Try/catch block for the potential FileNotFoundException
    try{
      writer = new PrintWriter(outputfile);
      
      //writes header info to new file
      writer.println(header1);
      writer.println(header2);
      
      //writes time and wave offset data to the new file
      while(size != 0){
        writer.format("%16s  " , (String)AQ.dequeue()); 
        writer.format("%16s \n", (String)AS.pop()); 
        size--;
      }
    //Catches possible FileNotFoundException
    //if it does, it prints a small error to let the user know an error has occured
    }catch(FileNotFoundException e){
      System.err.println("No file with that name was found.");
      return;
    }
  }
  
  /**
   * 
   * Backmasks the dat file using with stacks and queues which use an underlying LinkedList
   * @param input the name of the input file
   * @param output the name of the output file
   * @throws Underempty thrown we we try to remove from an empty stack or queue
   * 
   */
  public void BackMaskLinkedList(String input, String output) throws Underempty { 
    
    //Creates the two files for reading/writing
    inputfile = new File(input);
    outputfile = new File(output);
    
    //instantiates the stack/queue
    LS = new UnboundedLinkedListStack();
    LQ = new UnboundedLinkedListQueue();
    
    //Try/catch block for the potential FileNotFoundException
    try{
      
      scan = new Scanner(inputfile);
      
      //gets the header info
      header1 = scan.nextLine();
      header2 = scan.nextLine();
      
      //Loop that gets the time and wave offset data
      //time data is stored in the queue
      //and offset data is stored in the stack
      while(scan.hasNext() == true){
        LQ.enqueue(scan.next());
        LS.push(scan.next());
      }
    
    //Catches possible FileNotFoundException
    //if it does, it prints a small error to let the user know an error has occured
    }catch(FileNotFoundException e){
      System.err.println("No file with that name was found.");
    }
    
    //Gets size
    int size = LS.size();
    
    //Try/catch block for the potential FileNotFoundException
    try{
      writer = new PrintWriter(outputfile);
      
      //writes header info to new file
      writer.println(header1);
      writer.println(header2);
      
      //writes time and wave offset data to the new file
      while(size != 0){
        writer.format("%16s  " , (String)LQ.dequeue()); 
        writer.format("%16s \n", (String)LS.pop()); 
        size--;
      }
    //Catches possible FileNotFoundException
    //if it does, it prints a small error to let the user know an error has occured
    }catch(FileNotFoundException e){
      System.err.println("No file with that name was found.");
      return;
    }
  }

  /**
   * 
   * 
   * Application method. Allows this class to be runnable.
   * 
   * @param args the command line arguments
   * @throws Underempty if we try to remove from an empty stack/queue
   * 
   * 
   */
  public static void main(String[] args) throws Underempty{
    
    BackMask x;
    x = new BackMask();
    
    //checks if there are the proper amount of command line arguments
    if(args.length < 3){
      System.err.println("You do not have enough command line arguments.");
      System.err.println("usage of this application is like so:");
      System.err.print("BackMask.jar {input file name} {output file name} {true/false}");
      return;
    }
    
    //checks if there are too many command line arguments
    if(args.length > 3){
      System.err.println("You have too many command line arguments.");
      System.err.println("usage of this application is like so:");
      System.err.print("BackMask.jar {input file name} {output file name} {true/false}");
      return;
    }
    //checks if the third commandline argument is true
    //if so, we use the array implementation
    if(Boolean.parseBoolean(args[2].toLowerCase()) == true){
      x.BackMaskArray(args[0], args[1]);
    }
    //if it's not true, we use the linked list implementation
    else{
      x.BackMaskLinkedList(args[0],args[1]);
    }
  }
}
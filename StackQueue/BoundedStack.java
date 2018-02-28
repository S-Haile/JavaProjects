package csc143.data_structures;
/**
 * 
 * Interface that gives you a bounded stack
 * 
 * @author Samson Haile
 * @version 1.0
 */
public interface BoundedStack {
  /**
   * 
   * The method adds an item to the stack
   * @param o the item we want to add to the stack
   * @throws Overfill adding the item goes over the stack capacity
   * 
   */
  public void push(Object o) throws Overfill;
  
  /**
   * 
   * The method removes an item from the stack
   * @return The item we are removing from the stack
   * @throws Underempty if the stack is empty
   */
  public Object pop() throws Underempty;
  
  /**
   * 
   * Checks if the stack isn't empty
   * @return if the stack is empty or not
   * 
   */
  public boolean isNotEmpty();
  
  /**
   * 
   * Checks if the stack isn't full
   * @return if the stack is full or not
   * 
   */
  public boolean isNotFull();
  
  /**
   * 
   * Gives you the current number of items in the stack
   * @return the number of items in the stack
   * 
   */
  public int size();
  
  /**
   * 
   * Gives you back the stack as a String
   * @return the String version of the stack
   * 
   */
  public String toString();
   
  /**
   * 
   * Gives you back the total number of items the queue can hold
   * @return the total number of items the queue can hold
   * 
   */
  public int capacity();
}

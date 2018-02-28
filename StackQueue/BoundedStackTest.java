package csc143.test.data_structures;
import  csc143.data_structures.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * 
 * Class designed to test the implementationf of the BoundedStack method
 * 
 * @author Samson Haile
 * @version 1.0
 * 
 */
public class BoundedStackTest{
  
  MyBoundedStack mbs;
  MyBoundedStack mbs2;
  boolean empty;
  int size;
  int size2;
  
@Before
public void Setup(){
  empty = true;
  size = 5;
  size2 = 7;
  mbs = new MyBoundedStack(5);
  } 

  /*Push Test. Standard Processing*/
  @Test
  public void pushTest() throws Overfill,Underempty{
    mbs = new MyBoundedStack(5);
    mbs.push("S");
    assertEquals(mbs.pop(),"S");
  }
  
  /*Push Test. Standard Processing*/
  @Test
  public void pushTest2() throws Overfill,Underempty{
    mbs2 = new MyBoundedStack(9);
    mbs2.push("A");
    assertEquals(mbs2.pop(),"A");
  }
  
  /*Push Test. Adding up to the capacity. Boundary Test*/
  @Test
  public void pushBoundaryTest() throws Overfill{
    mbs = new MyBoundedStack(4);
    mbs.push("S");
    mbs.push("A");
    mbs.push("D");
    mbs.push("B");
    assertFalse(mbs.isNotFull());
  }
    
  
  /*Test for throwing the Overfill exception (trying to add when the stack is full). Error Case*/
  @Test(expected = Overfill.class)
  public void pushOverflowTest() throws Overfill {
    mbs2 = new MyBoundedStack(1);
    mbs.push("S");  
    mbs.push("A");
  }
  
  /*Pop Test. Standard Processing*/
  @Test
  public void popTest() throws Overfill,Underempty{
    mbs = new MyBoundedStack(5);
    mbs.push("Q");
    assertEquals("Q",mbs.pop());
  }
  
  /*Pop Test. Standard Processing*/
  @Test
  public void popTest2() throws Overfill,Underempty{
    mbs2 = new MyBoundedStack(9);
    mbs2.push("W");
    assertEquals("W",mbs2.pop());
  }
  
  /*Pop Test. Removing up until 0. Boundary Case*/
  @Test
  public void popTestBoundaries() throws Overfill, Underempty {
    mbs = new MyBoundedStack(2);
    mbs.push("E");
    mbs.push("R");
    mbs.pop();
    mbs.pop();
    assertFalse(mbs.isNotEmpty());
  }
  
  /*Test for the throwing the Underempty exception (trying to remove when the stack is empty). Error Case*/
  @Test(expected = Underempty.class)
  public void popUnderflowTest() throws Overfill, Underempty {
    mbs = new MyBoundedStack(6);
    mbs.pop();
  }
  
  /*Tests the isNotEmpty method. Standard Processing*/
  @Test
  public void isNotEmptyTest() throws Overfill{
    mbs2 = new MyBoundedStack(4);
    mbs2.push("T");
    mbs2.push("Y");
    empty = true;
    assertTrue("mbs is not empty", empty == mbs2.isNotEmpty());
    
  }
  
  /*Tests the isNotEmpty method. Standard Processing*/
  @Test
  public void isNotEmptyTest2() throws Overfill{
    mbs2 = new MyBoundedStack(1);
    empty = false;
    assertFalse("mbs is empty", empty == mbs2.isNotEmpty());
    
  }
  
  /*Tests the behavior of the isNotEmpty method at zero. Boundary Case*/
  @Test
  public void isNotEmptyTestZeroCase() throws Overfill {
    mbs = new MyBoundedStack(0); 
    empty = false;
    assertTrue("This queue is empty", empty == mbs.isNotEmpty());
  }
  
  /*Tests the isNotFull method. Standard Processing*/
  @Test
  public void isNotFullTest()throws Overfill{
    mbs2 = new MyBoundedStack(1);
    mbs2.push("Z");
    empty = false;
    assertTrue("mbs is full", empty == mbs2.isNotFull());
    
  }
  
  /*Tests the behavior of the isNotFull method at zero. Boundary Case*/
  @Test
  public void isNotFullTestZeroCase() throws Overfill {
  mbs = new MyBoundedStack(0);
  empty = false;
  assertFalse("this queue is full", empty = mbs.isNotEmpty());
  }
  
  /*Tests the isNotFull method. Standard Processing*/
  @Test
  public void isNotFullTest2(){
    mbs2 = new MyBoundedStack(1);
    empty = false;
    assertFalse("mbs is not full", mbs2.isNotFull());
    
  }
  
  /*Tests the size method. Standard Processing*/
  @Test
  public void sizeTest() throws Overfill{
  mbs = new MyBoundedStack(5);
  mbs.push("Z");
  mbs.push("Z");
  mbs.push("Z");
  size = 3;
  assertEquals(size,mbs.size());
  }
  
  /*Tests the size method. Standard Processing*/
  @Test
  public void sizeTest2() throws Overfill {
  mbs = new MyBoundedStack(7);
  mbs.push("Z");
  mbs.push("X");
  size2 = 2;
  assertEquals(size2,mbs.size());
  }
  /*Tests the behavior of the size method at 0. Boundary Case*/
  @Test
  public void sizeZeroCase() throws Overfill {
     mbs = new MyBoundedStack(7);
     size = 0;
     assertEquals(size,mbs.size());
  }
  
  /*Tests the to string method. Boundary Case*/
  @Test
  public void toStringTestUpperBoundary() throws Overfill{
    mbs = new MyBoundedStack(3);
    String name;
    name = "[ 3 : s, a, m ]";
    mbs.push("s");
    mbs.push("a");
    mbs.push("m");
    assertEquals(name,mbs.toString());
  }
  
  /*Tests the to string method. Boundary Case*/
  @Test
  public void toStringTestLowerBoundary() throws Overfill{
    mbs = new MyBoundedStack(0);
    String name;
    name = "[ 0 : ]";
    assertEquals(name,mbs.toString());
  }
  //Another test of the toString method. Standard Processing*/
  @Test
  public void toStringTest() throws Overfill{
    mbs = new MyBoundedStack(4);
    mbs.push(1);
    mbs.push(2);
    mbs.push(3);
    String name;
    name = "[ 3 : 1, 2, 3 ]";
    assertEquals(name,mbs.toString());
  }
  /*Another test of the toString method. Standard Processing*/
  @Test
  public void toStringTest2() throws Overfill{
    mbs = new MyBoundedStack(2);
    mbs.push(1);
    String name;
    name = "[ 1 : 1 ]";
    assertEquals(name,mbs.toString());
  }
  /*Test the capacity method. Standard Processing*/
  @Test
  public void capacityTest(){
    mbs = new MyBoundedStack(size);
    assertEquals(size,mbs.capacity());
  }
  
  /*Test the capacity method. Standard Processing*/
  @Test
  public void capacityTest2(){
    mbs = new MyBoundedStack(size2);
    assertEquals(size2,mbs.capacity());
  }
  
  /*Tests the constructorr of the MyBoundedStack class. Standard Processing*/
  @Test
  public void TestConstructor() {
    mbs = new MyBoundedStack(30);
    assertEquals(30, mbs.capacity());
  }
  
  /*Tests if it returns an error if they give a stack size less than 0. Error Case*/
  @Test (expected = IllegalArgumentException.class)
  public void negativeSizeTest(){
    mbs = new MyBoundedStack(-1);
  }
  
}

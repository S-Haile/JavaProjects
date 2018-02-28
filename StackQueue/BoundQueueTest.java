package csc143.test.data_structures;
import org.junit.*;
import static org.junit.Assert.*;
import csc143.data_structures.*;

public class BoundQueueTest{
  
 
  boolean empty;
  int size;
  int size2;
  MyBoundedQueue mbq;
  MyBoundedQueue mbq2;
  
@Before
public void Setup(){
 
  size = 5;
  size = 7;
  empty = true;
  }  
  
  /*Tests the ability to add to a queue Standard Processing*/
  @Test
  public void enqueueTest() throws Overfill,Underempty{
    mbq = new MyBoundedQueue(5);
    mbq.enqueue("A");
    assertEquals("A",mbq.dequeue());
  }
  
  /*Tests the ability to add to a queue. Standard Processing*/
  @Test
  public void enqueueTest2() throws Overfill,Underempty{
    mbq = new MyBoundedQueue(5);
    mbq.enqueue("E");
    assertEquals("E",mbq.dequeue());
  }  
  
  /*Test adding up to the capacity. Boundary Case*/
  @Test
  public void enqueueBoundaryTest() throws Overfill{
    mbq = new MyBoundedQueue(4);
    mbq.enqueue("S");
    mbq.enqueue("A");
    mbq.enqueue("D");
    mbq.enqueue("B");
    assertFalse(mbq.isNotFull());
  }
  
  /*Tests for when the enqueue method is supposed to incite the Overfill exception. Error Case*/
  @Test(expected = Overfill.class)
  public void enqueueTestError() throws Overfill{
    mbq = new MyBoundedQueue(1);
    mbq.enqueue("R");
    mbq.enqueue("F");
  }
  /*Tests removing from the queue. Standard Processing*/
  @Test
  public void dequeueTest() throws Overfill,Underempty{
    mbq = new MyBoundedQueue(3);
    mbq.enqueue("D");
    mbq.enqueue("C");
    assertEquals("D",mbq.dequeue());
  }
  
  /*Tests removing from the queue. Standard Processing*/
  @Test
  public void dequeueTest2() throws Overfill,Underempty{
    mbq = new MyBoundedQueue(3);
    mbq.enqueue("X");
    mbq.enqueue("Z");
    assertEquals("X",mbq.dequeue());
  }
  
  /*Test removing from capacity down to 0. Boundary Case*/
  @Test
  public void dequeueTestBoundary() throws Overfill,Underempty{
    mbq = new MyBoundedQueue(2);
    mbq.enqueue("V");
    mbq.enqueue("O");
    mbq.dequeue();
    assertEquals("O",mbq.dequeue());
  }
  
  /*Tests for when the dequeue method should invoke the Underempty exception. Error Case*/
  @Test (expected = Underempty.class)
  public void dequeueTestError() throws Underempty{
    mbq = new MyBoundedQueue(5);
    mbq.dequeue();
  }
  
  /*Testing the isNotEmpty method. Standard Processing*/
  @Test
  public void isNotEmptyTest() throws Overfill {
    mbq = new MyBoundedQueue(3); 
    mbq.enqueue("B");
    assertTrue("This queue is not empty", empty == mbq.isNotEmpty());
  }
  
  /*Testing the isNotEmpty method. Standard Processing*/
  @Test
  public void isNotEmptyTest2() throws Overfill {
    mbq = new MyBoundedQueue(4); 
    empty = false;
    assertTrue("This queue is empty", empty == mbq.isNotEmpty());
  }
  
  /*Tests the behavior of the isNotEmpty method at zero. Boundary Case*/
  @Test
  public void isNotEmptyTestZeroCase() throws Overfill {
    mbq = new MyBoundedQueue(0); 
    empty = false;
    assertTrue("This queue is empty", empty == mbq.isNotEmpty());
  }
  
  /*Testing the isNotFull method. Standard Processing*/
  @Test
  public void isNotFullTest() throws Overfill {
    mbq = new MyBoundedQueue(3); 
    mbq.enqueue("B");
    assertTrue("This queue is not full", empty == mbq.isNotEmpty());
  }
  
  /*Testing the isNotFull method. Standard Processing*/
  @Test
  public void isNotFullTest2() throws Overfill {
    mbq = new MyBoundedQueue(1);
    mbq.enqueue("M");
    empty = false;
    assertTrue("This queue is full", empty == mbq.isNotEmpty());
  }
  
  /*Tests the behavior of the isNotFull method at zero. Boundary Case*/
  @Test
  public void isNotFullTestZeroCase() throws Overfill {
  mbq = new MyBoundedQueue(0);
  empty = false;
  assertFalse("this queue is full", empty = mbq.isNotEmpty());
  }
  
  /*Tests the size method. Standard Processing*/
  @Test
  public void sizeTest() throws Overfill {
    mbq = new MyBoundedQueue(5);
    mbq.enqueue("Z");
    mbq.enqueue("X");
    size2 = 2;
    assertEquals(size2,mbq.size());
  }
  
  /*Tests the size method. Standard Processing*/
  @Test
  public void sizeTest2() throws Overfill {
    mbq = new MyBoundedQueue(7);
    mbq.enqueue("Z");
    mbq.enqueue("X");
    mbq.enqueue("Z");
    mbq.enqueue("X");
    size2 = 4;
    assertEquals(size2,mbq.size());
  }
  
  /*Tests the behavior of the size method at 0. Boundary Case*/
  @Test
  public void sizeZeroCase() throws Overfill {
     mbq = new MyBoundedQueue(7);
     assertEquals(0,mbq.size());
  }
  
  /*Tests toString. Standard Processing*/
  @Test
  public void toStringTest() throws Overfill {
    mbq = new MyBoundedQueue(3);
    mbq.enqueue(1);
    mbq.enqueue(3);
    String name = "[ 2 : 1, 3 ]";
    assertEquals(name,mbq.toString());
  }
  
  /*Tests the toString method with a full queue. Boundary Case*/
  @Test
  public void toStringTestUpperBoundary() throws Overfill {
    mbq = new MyBoundedQueue(3);
    mbq.enqueue(1);
    mbq.enqueue(2);
    mbq.enqueue(3);
    String name = "[ 3 : 1, 2, 3 ]";
    assertEquals(name,mbq.toString());
  }
  
  /*Tests the toString method. Standard Processing*/
  @Test
  public void toStringTest2() throws Overfill{
    mbq = new MyBoundedQueue(4);
    String name;
    name = "[ 3 : s, a, m ]";
    mbq.enqueue("s");
    mbq.enqueue("a");
    mbq.enqueue("m");
    assertEquals(name,mbq.toString());
  }
  
  /*Tests the toString method with an empty queue. Boundary Case*/
  @Test
  public void toStringTestZeroCase() throws Overfill {
    mbq = new MyBoundedQueue(0);
    String name = "[ 0 : ]";
    assertEquals(name,mbq.toString());
  }
  
  /*Tests the the capacity method. Standard Processing*/
  @Test
  public void capacityTest() throws Overfill {
    mbq = new MyBoundedQueue(5);
    assertEquals(size,mbq.size());
  }
  
  /*Tests the capacity method. Standard Processing*/
  @Test
  public void capacityTest2() throws Overfill {
    mbq = new MyBoundedQueue(7);
    assertEquals(size2,mbq.size());
  }
  
  /*Tests the constructor of the class. Standard Processing*/
  @Test
  public void TestConstructor() {
    mbq = new MyBoundedQueue(30);
    assertEquals(30, mbq.capacity());
  }
  
  /*Tests if it returns an error if they give a stack size less than 0. Error Case*/
  @Test (expected = IllegalArgumentException.class)
  public void negativeSizeTest(){
    mbq = new MyBoundedQueue(-1);
  }
    
}
  
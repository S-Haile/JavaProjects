import java.awt.Color;
/**
 * 
 * This class contains three methods that draw tic-tac-toe boards in 3 different ways
 * 
 * @author Samson Haile
 * 
 * @version 1.0 (Check)
 * 
 */
public class TicTacToeBoards {
  
  // assigns an NscWindow to variable "win"
  private NscWindow win;
 
  //Constructor that intializes field "win"
  //and calls methods
  public TicTacToeBoards() {
    
    //Initalizes field win, as a window 300 pixels wide, 330 pixels tall, at (10,10)
    win = new NscWindow(10,10,300,330);
    
    //draws plain tic-tac-board with the parameters setting the location
    drawTicTacToeBoard(40,40);
    
    //draws colored tic-tac-board with the parameters setting location, and color of the lines
    drawTicTacToeBoard(40,170,java.awt.Color.green);
    
    //draws tic-tac-board, with the parameters setting location, and the third setting the line thickness
    drawTicTacToeBoard(170,40,5);
    
    //draws another plain tic-toe-board with the parameters setting the location
    drawTicTacToeBoard(170,170);
   
}
  /**
   * This methods draws a tic-tac-toe board
   * 
   * @param x the x value of the endpoints of the lines
   * 
   * @param y the y value of the endpoints of the lines
   * 
   */
  
  public void drawTicTacToeBoard(int x, int y){
    
    //draws the top horizontal line of the tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line1;
    line1 = new NscLine(x,y,x+90,y);
    win.add(line1);
    
    //draws the bottom horizontal line of the tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line2;
    line2 = new NscLine(x,y+30,x+90,y+30);
    win.add(line2);
    
    //draws the leftmost vertical line of the tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line3;
    line3 = new NscLine(x+30,y-30,x+30,y+60);
    win.add(line3);
    
    //draws the rightmost vertical line of the tic-tac-toe board
    //using the parameters x and y, given in the method call
    NscLine line4;
    line4 = new NscLine(x+60,y-30,x+60,y+60);
    win.add(line4);
    
    //repaints the window
    win.repaint();
  
}
  /**
   * This method draws the colored tic-tac-toe board
   * 
   * @param x the x value of the endpoints of the lines
   * 
   * @param y the y value of the endpoints of the lines
   * 
   * @param rgb the color of the lines
   * 
   */
  public void drawTicTacToeBoard(int x, int y,java.awt.Color rgb){
    
    //draws the top horizontal line of the colored tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line1;
    line1 = new NscLine(x,y,x+90,y);
    
    //colors the top horizontal line with the color rgb, given in the method call
    line1.setForeground(rgb);
    win.add(line1);
    
    //draws the bottom horizontal line of the colored tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line2;
    line2 = new NscLine(x,y+30,x+90,y+30);
    
    //colors the bottom horizontal line with the color rgb, given in the method call
    line2.setForeground(rgb);
    win.add(line2);
    
     //draws the leftmost vertical line of the colored tic-tac-toe board 
    //using the parameters x and y, given in the method call
    NscLine line3;
    line3 = new NscLine(x+30,y-30,x+30,y+60);
    
    //colors the leftmost vertical line with the color rgb, given in the method call
    line3.setForeground(rgb);
    win.add(line3);
    
    //draws the rightmost vertical line of the colored tic-tac-toe board
    //using the parameters x and y, given in the method call
    NscLine line4;
    line4 = new NscLine(x+60,y-30,x+60,y+60);
    
    //colors the rightmost vertical line with the color rgb, given in the method call
    line4.setForeground(rgb);
    win.add(line4);
    
    //repaints the window
    win.repaint();
  }
  /**
   * 
   * This is the method that draws the board that can have thicker lines
   *
   * @param x the y value of the endpoints of the lines
   * 
   * @param y the y value of the endpoints of the lines
   * 
   * @param i the width of the lines
   */
  public void drawTicTacToeBoard(int x, int y , int i){
    
    //draws the top horizontal line of the tic-tac-toe board with adjustable thickness
    //using the parameters x and y, given in the method call
    NscLine line1;
    line1 = new NscLine(x,y,x+90,y);
    win.add(line1);
    
    //Draws a rectangle that uses the thrid parameter i
    //this will be drawn over the top horizontal line to simulate the lines getting thicker
    NscRectangle rect1;
    rect1 = new NscRectangle(x,y,90,i);
    
    //Colors the rectangle black
    rect1.setFilled(true);
    rect1.setBackground(Color.black);
    win.add(rect1);
    
    //draws the bottom horizontal line of the tic-tac-toe board with adjustable thickness
    //using the parameters x and y, given in the method call
    NscLine line2;
    line2 = new NscLine(x,y+30,x+90,y+30);
    win.add(line2);
    
    //Draws a rectangle that uses the thrid parameter i
    //this will be drawn over the bottom horizontal line to simulate the lines getting thicker
    NscRectangle rect2;
    rect2 = new NscRectangle(x,y+30,90,i);
    
    //Colors the rectangle black
    rect2.setFilled(true);
    rect2.setBackground(Color.black);
    win.add(rect2);
    
    //draws the leftmost vertical line of the tic-tac-toe board with adjustable thickness
    //using the parameters x and y, given in the method call
    NscLine line3;
    line3 = new NscLine(x+30,y-30,x+30,y+60);
    win.add(line3);
    
    //Draws a rectangle that uses the thrid parameter i
    //this will be drawn over the leftmost vertical line to simulate the lines getting thicker
    NscRectangle rect3;
    rect3 = new NscRectangle(x+30,y-30,i,90);
    
    //colors the rectangle black
    rect3.setFilled(true);
    rect3.setBackground(Color.black);
    win.add(rect3);
    
    //draws the rightmost vertical line of the tic-tac-toe board with adjustable thickness
    //using the parameters x and y, given in the method call
    NscLine line4;
    line4 = new NscLine(x+60,y-30,x+60,y+60);
    win.add(line4);
    
    //Draws a rectangle that uses the thrid parameter i
    //this will be drawn over the rightmost vertical line to simulate the lines getting thicker
    NscRectangle rect4;
    rect4 = new NscRectangle(x+60,y-30,i,90);
    
    //Colors the rectangle black
    rect4.setFilled(true);
    rect4.setBackground(Color.black);
    win.add(rect4);
    
    //repaints the window
    win.repaint();
  }
  
  /**
   * 
   * The application method that allows us to run the code like an application
   * 
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args){
    TicTacToeBoards f;
    f = new TicTacToeBoards();
    
  }
}

/**
 * This class draws 3 flags for Lab 2
 * 
 * @author Samson Haile
 * @version 1.0 (Check)
 * 
 */
public class Flags {
  /**
   * Calls the three functions that draw the flags
   * 
   * @param args
   */
  public static void main(String[] args){
    Flags test = new Flags();
    //Calls the three functions that draw the flags
    test.drawNigerFlag();
    test.drawSwedenFlag();
    test.drawNorwayFlag();
  }
  /**
   * The flag is 308x264, which is equivalent to 7x6
   * shown by 308/7 = 44
   * and then 264/44 = 6 , meaning that 308x264 is the ratio 7x6 multiplied by 44.
   * the stripe numbers I got due to the fact that the bars are 1/3 the height of the flag
   * so it would be 264/3 = 88
   * and the circle in the middle is 2/3 of the stripes, so it would be 88(2/3) = 66
   */
  public void drawNigerFlag() {
    
    //Creates and sets window "win", 400 wide, 400 tall
    NscWindow win;
    win = new NscWindow(0,0,400,400);
    win.setTitle("Niger Flag");
    
    //Creates the body of the flag, 308 wide, 264 tall
    NscRectangle body;
    body = new NscRectangle(40,40,308,264);
    
    //Colors the center stripe white
    body.setFilled(true);
    body.setBackground(java.awt.Color.white);
    win.add(body);
    
    //Creates top stripe, 308 wide, 88 tall
    NscRectangle stripe;
    stripe = new NscRectangle(40,40,308,88);
    
    //Colors top stripe orange
    stripe.setFilled(true);
    java.awt.Color orange = new java.awt.Color(255,127,0);
    stripe.setBackground(orange);
    win.add(stripe);
    
    //Creates bottom stripe, 308 wide, 88 tall
    NscRectangle stripe2;
    stripe2 = new NscRectangle(40,224,308,88);
    
    //Creates custom color, and colors the bottom stripe using it
    stripe2.setFilled(true);
    java.awt.Color green = new java.awt.Color(0,204,0);
    stripe2.setBackground(green);
    win.add(stripe2);
    
    //Creates center circle
    NscEllipse dot;
    dot = new NscEllipse (164,142,66,66);
    
    //Colors center circle orange
    dot.setFilled(true);
    dot.setBackground(orange);
    win.add(dot);
    
    win.repaint();
    
  }
  /**
   * The flag is 416 x 260, which is 8x5.
   * This can be shown when we do 416/8 = 52
   * and then we do 260/52 = 5
   * showing that this is the ratio 8x5, multipled by 52.
   * 
   * The color ratio for vertical side is 4:2:4, and the I got this number because the vertical ratio is 4:2:4 
   * and my total vertical height is 260, so I add the ratio number (4+2+4 = 10), and divide 260 by that.
   * 260/10 = 26, meaning I would need to multiply the ratio numbers by 26 to fill up the amount of space I have.
   */
  public void drawSwedenFlag(){
    
    //Creates window "win", 500 pixels wide, 500 pixels tall
    NscWindow win;
    win = new NscWindow(50,10,500,500);
    win.setTitle("Sweden Flag");
    
    //Creates body of the flag (aka the blue), 416 wide, 260 tall
    NscRectangle body;
    body = new NscRectangle(40,70,416,260);
    
    //Colors the body blue
    body.setFilled(true);
    body.setBackground(java.awt.Color.blue);
    win.add(body);
    
    //Creates horizontal stripe, 416 pixels wide, 52 pixels tall
    NscRectangle stripe;
    stripe = new NscRectangle(40,174,416,52);
    
    //Colors the stripe yellow
    stripe.setFilled(true);
    stripe.setBackground(java.awt.Color.yellow);
    win.add(stripe);
    
    //Creates vertical stripe, 52 pixels tall, 260 tall
    //since the bars share the same width, the y value of the horizontal stripe is the same
    //as the x value of the vertical stripe
    NscRectangle stripe2;
    stripe2 = new NscRectangle(150,70,52,260);
    
    //Colors the stripe yellow
    stripe2.setForeground(java.awt.Color.yellow);
    stripe2.setFilled(true);
    stripe2.setBackground(java.awt.Color.yellow);
    win.add(stripe2);
    
    win.repaint();
    
    
  }
  /**
   * The flag is 352x256, which is 22x16
   * as shown through 352/22 = 16
   * and then 256/16 = 16, which shows that 352x256 is 22x16 multiplied by 16
   * 
   * The color ratios come from the fact that the ratio vertically is 6:1:2:1:6, and the total is 256
   * so I add those numbers up (16) and divide 256 by it
   * so it becomes 256/16 = 16
   * which means that I would need to multiply these numbers by 16 in order to fill up the space on the flag
   */
  public void drawNorwayFlag(){
    NscWindow win;
    win = new NscWindow(10,100,450,450);
    win.setTitle("Norway Flag");
    
    //Creates main rectangle, 352 pixels wide, 256 tall
    NscRectangle body;
    body = new NscRectangle(40,80,352,256);
    body.setFilled(true);
    body.setBackground(java.awt.Color.red);
    
    //Creates vertical stripe, 352 wide, 64 tall
    NscRectangle wstripe;
    wstripe = new NscRectangle(40,176,352,64);
    
    //Colors the stripe white
    wstripe.setFilled(true);
    wstripe.setBackground(java.awt.Color.white);
    
    //creates horizontal stripe, 64 wide, 256 tall
    //since the bars are the same width, the y value of the vertical stripe is the same as the x value
    //of the horizontal stripe
    NscRectangle wstripe2;
    wstripe2 = new NscRectangle(136,80,64,256);
    
    //Colors the stripe white
    wstripe2.setFilled(true);
    wstripe2.setBackground(java.awt.Color.white);
    wstripe2.setForeground(java.awt.Color.white);
    
    //Creates horizontal stripe, 352 wide, 32 tall
    // The ratio multiplier as I found before is 16. since this is the one in the 6:1:2:1:6 ratio,
    //I do 2*16 = 32. So it was be 32 pixels tall
    NscRectangle bstripe;
    bstripe = new NscRectangle(40,192,352,32);
    
    //Colors the stripe blue
    bstripe.setFilled(true);
    bstripe.setBackground(java.awt.Color.blue);
    
    //Creates vertical stripe, 32 wide, 256 tall
    //Since the both blue bars share the same width, the y value of the horizonal bar is the same as the x value
    //of the vertical bar.
    NscRectangle bstripe2;
    bstripe2 = new NscRectangle(152,80,32,256);
    
    //Colors the stripe blue
    bstripe2.setForeground(java.awt.Color.blue);
    bstripe2.setFilled(true);
    bstripe2.setBackground(java.awt.Color.blue);
    
    win.add(body);
    win.add(wstripe);
    win.add(wstripe2);
    win.add(bstripe);
    win.add(bstripe2);
    win.repaint();
  }
}
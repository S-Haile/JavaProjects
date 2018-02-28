/**
 * This class contains three methods which all aid in drawing a stoplight for Lab 2.
 *  
 * @author Samson Haile
 * 
 * @version 1.0 
 * 
 */
public class TrafficLight {
  
/** 
 * This method contains all the code to draw and color the traffic light.
 */
 public void drawTheLight(){
   
      // Draws a new window win, at (10,10), 140 pixels wide, 330 pixels tall
      NscWindow win;
      win = new NscWindow(10,10,140,330);
      
      // Draws the body of the traffic light at (20,20) 90 pixels wide, 250 pixels tall
      NscRectangle body;
      body = new NscRectangle(20,20,90,250);
      
      // Colors the body and outline light gray
      body.setForeground(java.awt.Color.lightGray);
      body.setFilled(true);
      body.setBackground(java.awt.Color.lightGray);
      
      // Adds body to the window "win"
      win.add(body);
      
      // Creates stoplight circle at (30,30) 70 pixels in diameter
      NscEllipse stop;
      stop = new NscEllipse(30,30,70,70);
      
      // Colors the stoplight circle red
      stop.setForeground(java.awt.Color.red);
      stop.setFilled(true);
      stop.setBackground(java.awt.Color.red);
      
      // Adds the stoplight circle to window "win"
      win.add(stop);
      
      // Creates slowlight circle at (30,110), 70 pixels in diameter
      NscEllipse slow;
      slow = new NscEllipse(30,110,70,70);
      
      // Colors slowlight circle yellow
      slow.setForeground(java.awt.Color.yellow);
      slow.setFilled(true);
      slow.setBackground(java.awt.Color.yellow);
      
      // Adds slow light circle to window "win"
      win.add(slow);
      
      // Creates go light circle at (30,190), 70 pixels in diameter
      NscEllipse go;
      go = new NscEllipse (30,190,70,70);
      
      //Creates custom green color
      java.awt.Color green = new java.awt.Color(0,128,0);
      
      // Colors go light circle green
      go.setForeground(green);
      go.setFilled(true);
      go.setBackground(green);
      
      // Adds go light to window "win"
      win.add(go);
}
/**
 * This the application method that allows the traffic light to be drawn when you run the application.
 */
public static void main(String[] args) {
    new TrafficLight();
    
}
/**
 * This function is a liaison between "drawTheLight" and the application method.
 * Because the application methos is static, it can't call the non-static method "drawTheLight".
 */
public TrafficLight() {
  drawTheLight();
}
}
/**
 * 
 * 
 * This class rotates the image counter-clockwise
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */
public class RotateCounterClockwiseFilter implements Filter {
  
   /**
   * 
   * This method contains the algorithm to process the pixels to rotate the image
   * @param theImage the PixelImage we are processing
   * @throw IllegalStateException if the image being rotated is not square
   * 
   */
  public void filter (PixelImage theImage){
       
        //Checks if the image is square, if not, it throws and IllegalStateException 
        if(theImage.getHeight() != theImage.getWidth()){
           throw new IllegalStateException("The image you have provided is not square.");
        }
        
        // get the data from the image
        Pixel[][] data = theImage.getData();
        Pixel[][] rotateddata = new Pixel[data.length][data[0].length];
         
        for(int i = 0; i < theImage.getHeight(); i++){
            for(int row = 0; row < theImage.getHeight(); row++) {
          
                //Sets the value of the rightmost pixel of the row to the first pixel of the leftmost column
                 rotateddata[data[0].length -1 -row][i] = data[i][row];
          
           
       
        }
        }
  //updates the image     
  theImage.setData(rotateddata);
   
           
  }
}
/**
 * 
 * 
 * This class rotates the image clockwise
 * @author Samson Haile
 * @version Standard
 * 
 * 
 */

public class RotateClockwiseFilter implements Filter {
  
   
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
        
        //2D Pixel array to hold the PixelImage
        Pixel[][] data = theImage.getData();
        
        //2D Pixel Array to hold the rotated image
        Pixel[][] rotateddata = new Pixel[data.length][data[0].length];
         
        //Loop within a loop to process throw every row and column
        for(int i = 0; i < theImage.getHeight(); i++){
            for(int row = 0; row < theImage.getHeight(); row++) {
          
                //Sets the value of the rightmost pixel of the column to the first pixel of the leftmost row
                rotateddata[row][data[0].length -1 -i] = data[i][row];
           
           
           
           
       
         }
         }
  //updates the PixelImage   
  theImage.setData(rotateddata);
  }
}
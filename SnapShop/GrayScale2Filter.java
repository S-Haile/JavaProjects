/**
 * 
 * 
 * This class puts the PixelImage in grayscale, using the method of multiplying the rgb values
 * by different fractions of 32
 * 
 * @author Samson Haile
 * @version Standard
 * 
 */
public class GrayScale2Filter implements Filter {
  
   /**
   * 
   * This method contains the algorithm to process the pixels to grayscale the image
   * @param theImage the PixelImage we are processing
   * 
   * 
   */
  public void filter(PixelImage theImage) {
        
        // get the data from the image
        Pixel[][] data = theImage.getData();
     
        //A loop within a loop
        //one loop handles the rows
        //and the other handles the rows
         for (int row = 0; row < theImage.getHeight(); row++) {
             for (int col = 0; col < theImage.getWidth(); col++) {
           
                  //Extracting the current rgb values and storing them
                  int temp =  data[row][col].rgb[Pixel.RED];
                  int temp2 =  data[row][col].rgb[Pixel.BLUE];
                  int temp3 =  data[row][col].rgb[Pixel.GREEN];
        
                  //Here we multiply the rgb values by the different fractions of 32.
                  data[row][col].rgb[Pixel.RED] = (int)((11 * temp + 16 *temp3 + 5 * temp2) / 32);
                  data[row][col].rgb[Pixel.BLUE] = (int)((11 * temp + 16 *temp3 + 5 * temp2) / 32);
                  data[row][col].rgb[Pixel.GREEN] =  (int)((11 * temp + 16 *temp3 + 5 * temp2) / 32);
  }
}
  // update the image with the moved pixels
  theImage.setData(data);
  }
}
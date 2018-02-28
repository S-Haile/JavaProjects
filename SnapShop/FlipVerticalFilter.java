/**
 * Filter that flips the image horizontally.
 * @author Samson Haile
 * @version Standard
 *
 */
public class FlipVerticalFilter implements Filter {
  
  /**
  * 
  * This method contains the algorithm to process the pixels to flip the image vertically
  * (across the horizontal axis)
  * @param theImage the PixelImage we are processing
  * 
  * 
  */
  public void filter (PixelImage theImage){
    
   // get the data from the image
    Pixel[][] data = theImage.getData();
        
     //for each row, swap its contents from top to botoom
     for (int row = 0; row < theImage.getHeight() / 2; row++) {
          for (int col = 0; col < theImage.getWidth(); col++) {
            
                // given a row: i, its pair is row: width() - i - 1
                // e.g. with a width of 10
                // row 0 is paired with row 9
                // row 1 is paired with row 8 etc.
                Pixel temp = data[row][col];
                data[row][col] = data[theImage.getHeight() - row - 1][col];
                data[theImage.getHeight() - row - 1][col] = temp;
            }
        }
        
        // update the image with the moved pixels
        theImage.setData(data);
        
  }
}
      
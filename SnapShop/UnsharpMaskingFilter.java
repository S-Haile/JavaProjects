/**
 * 
 * This class applies the filter "Unsharp Masking" to the PixelImage
 * @author Samson Haile
 * @version Standard
 * 
 */
public class UnsharpMaskingFilter implements Filter{
  
   /**
   * 
   * This method contains the algorithm to process the pixels to apply the "Gaussian Blur"
   * @param theImage the PixelImage we are processing
   * 
   * 
   */
  public void filter(PixelImage theImage){
    
   //2D Pixel array to hold the PixelImage      
   Pixel[][] data = theImage.getData();
   
   //2D Pixel array to hold copy of PixelImage
   Pixel[][] temp = theImage.getData();
   
    //A loop within a loop
    //one loop handles the rows
    //and the other handles the rows
    for (int row = 1; row < theImage.getHeight()-1; row++){
         for (int col = 1; col < theImage.getWidth()-1; col++) {
              for(int i = 0; i < 3; i++){
                   
                  //These variables extract the rgb color values
                  //from the pixels and multiplies them by their weights
                  int Color = data[row-1][col-1].rgb[i] * -1;
                  int Color2 =data[row-1][col].rgb[i] * -2;
                  int Color3 =data[row-1][col + 1].rgb[i] * -1;
                  int Color4 =data[row][col + 1].rgb[i] * -2;
                  int Color5 =data[row+1][col+1].rgb[i] * -1;
                  int Color6 =data[row+1][col].rgb[i] * -2;
                  int Color7 =data[row+1][col-1].rgb[i] * -1;
                  int Color8 =data[row - 1][col].rgb[i] * -2;
                  int Color9 = data[row][col].rgb[i] * 28;
               
                  //adds all the weighted values together
                  int finalC = Color+Color2+Color3+Color4+Color5+Color6+Color7+Color8+Color9;
                  //Divides final number by scale factor, here 16.
                  int TFC = finalC/16;
                  
                   //checks if the final value is above 255 or below 0
                  //if true, it is set to 255 and 0, respectively.
                  if(TFC > 255){
                     TFC = 255;
                  }
                  if(TFC < 0){
                     TFC = 0;
                  }
              
              
                  //changes the pixels rgb value to the new calculated value
                  temp[row][col].rgb[i] = TFC;
         
       
                
            }
           }
           }
      
        
  // update the image with the moved pixels
  theImage.setData(temp);
  }
}
  

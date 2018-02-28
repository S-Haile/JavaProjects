public class GrayScaleFilter implements Filter {
  
  public void filter(PixelImage theImage) {
        
        // get the data from the image
        Pixel[][] data = theImage.getData();
     
        
         for (int row = 0; row < theImage.getHeight(); row++) {
            for (int col = 0; col < theImage.getWidth(); col++) {
           int temp =  data[row][col].rgb[Pixel.RED];
           int temp2 =  data[row][col].rgb[Pixel.BLUE];
           int temp3 =  data[row][col].rgb[Pixel.GREEN];
           
        data[row][col].rgb[Pixel.RED] = (int)(temp * .3) + (int)(temp2 * .59) + (int)(temp3 * .11);
        data[row][col].rgb[Pixel.BLUE] = (int)(temp * .3) + (int)(temp2 * .59) + (int)(temp3 * .11);
        data[row][col].rgb[Pixel.GREEN] =  (int)(temp * .3) + (int)(temp2 * .59) + (int)(temp3 * .11);
  }
}
             // update the image with the moved pixels
        theImage.setData(data);
  }
}
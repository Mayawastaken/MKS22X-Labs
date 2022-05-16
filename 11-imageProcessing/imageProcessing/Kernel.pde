
public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = new float[3][3];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        kernel[i][j] = init[i][j];
      }
    }
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    color c = color(0,0,0); //width - 1 height - 1 is bot right
    if (x == 0 || y == 0 || x == width - 1 || y == height - 1){
      return c;
    }
    for (int i = x - 1; i <= x + 1; i++){
      for (int j = y - 1; j <= y + 1; j++){
        //do the mathy mathy and add it to color
      }
    }
    // IF COL < 0 MAKE IT 0, IF COL > 255 MAKE 255
    // ADD CAR PNG OR WTV AS WELL !!
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    return c;
  }

  /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
  }

}


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
    if (x == 0 || y == 0 || x == img.width - 1 || y == img.height - 1){
      return color(0,0,0);
    }
    float redVal = 0; 
    float greenVal = 0;
    float blueVal = 0; 
    for (int i = 0; i <= 2; i++){
      for (int j = 0; j <= 2; j++){
        color current = img.get(x+j-1,y+i-1);
        redVal += (red(current) * kernel[i][j]);
        greenVal += (green(current) * kernel[i][j]);
        blueVal += (blue(current) * kernel[i][j]);
      }
    }
    if (redVal > 255){
      redVal = 255;
    }
    if (greenVal > 255){
      greenVal = 255;
    }
    if (blueVal > 255){
      blueVal = 255;
    }
    if (redVal < 0){
      redVal = 0;
    }
    if (greenVal < 0){
      greenVal = 0;
    }
    if (blueVal < 0){
      blueVal = 0;
    }
    color c = color(redVal, greenVal, blueVal);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    return c;
  }

  /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.width; i++){
      for (int j = 0; j < source.height; j++){
         destination.set(i,j,calcNewColor(source, i, j));
      }
    }
  }
}

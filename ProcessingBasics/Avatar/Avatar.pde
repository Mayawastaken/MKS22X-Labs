int xp, yp;

/** Avatar: a function that draws a face/character/animal/object,

 *at a particular x,y location.


 */


void avatar(int x, int y){
  fill(240,33,240);
  rect(x-50,y-25,100,50);
  rect(x-50,y+20,20,40);
  rect(x+30,y+20,20,40);
  arc(x-50.0,y-25.0,40,40,PI/2,PI *1.2);
  //ellipse(x+40,y-30,12,32); //ear(s) maybe
  
  fill(200,20,150);
  circle(x+50,y-25,50);
  
}

//to test your code, here is a setup/draw

int x,y;
int MODE;
void setup(){
         size(800,800);
         MODE = 3;
         x = width/2;
         y = height/2;
}
void draw(){
         background(255);
         x = change(x);
         y = change(y);
         avatar(x,y);
         avatar(mouseX,mouseY);
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
         wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return int(random(800));
   case 2:
     return value + int(random(-1, 2));
   case 3:
     if (value == 800){
       return 0;
      }
     return value + 1;
   default:
     return width/2;
  }
}
void mouseClicked(){
  if (MODE == 1){
    MODE = 2;
  }
  else if (MODE == 2){
    MODE = 3;
  }
  else if (MODE == 3){
    MODE = 1;
  }
}

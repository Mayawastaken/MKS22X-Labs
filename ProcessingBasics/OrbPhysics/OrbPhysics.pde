
ArrayList<Orb>orbList;
Orb center;
boolean background = true;
int GRAVITY = 0;
int ORBIT = 1;
int MODE = GRAVITY;


void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 20);
}
void mouseClicked() {
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
}
void keyPressed() {
  if (key == BACKSPACE) {
    orbList.clear();
  }
  else if (key == 'b' || key == 'B'){
    background = !background;
  }
  else if (key == ' '){
    MODE = (MODE+1)%2;
  }
}
void draw() {
  if (background == true){
     background(255);
  }
  for (Orb o : orbList) {
    o.move();
    //center.attract(o);
    o.display();   
  }
  center.display();
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text(MODE, 20, 60); //prints number as of now
}

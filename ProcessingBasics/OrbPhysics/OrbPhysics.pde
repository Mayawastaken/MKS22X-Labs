//OOPS flip other and center in like usage yk awkward
ArrayList<Orb>orbList;
Orb center;
boolean background = true;
boolean gravity = true;
final float SPRING_CONSTANT = .015;
final float SPRING_LENGTH = 150;
final float SPRING_DAMPEN = .995;
final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
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
    MODE = (MODE+1)%3;
  }
  else if (key == 'g' || key == 'G'){
    gravity = !gravity;
  }
}
void draw() {
  if (background == true){
     background(255);
  }
  else{
    fill(255);
    stroke(255);
    rect(0, 0, 80, 80);
    stroke(0);
  }
  for (Orb o : orbList) {
    if (MODE == 0){
      o.move();
    }
    if (MODE == 1){
      center.attract(o);
    }
    if (MODE == 2){
      center.attractSpring(o);
    }
    if (gravity == true){
      o.ySpeed += .15; 
    }
    o.display();   
  }
  center.display();
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text(MODE, 20, 60); //prints number as of now  -- use if statements
}

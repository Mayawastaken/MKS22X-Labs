
final static int SPRING = 2;
static float GRAVITY = 0.35;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
final static int MODE = SPRING;
static int CLICK_MODE = 0;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICK_MODE == 0){
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
  }
  else if (CLICK_MODE == 1){
    //orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30);
  }
  else if (CLICK_MODE == 2){
    //orbs.delete(orbs.getNodeAt(mouseX, mouseY));
  }
  
}
void draw() {
  background(255);
   String mode = "";
  if (CLICK_MODE == 0){
    mode += "Add";
  }
  else if (CLICK_MODE == 1){
    mode += "Insert";
  }
  else if (CLICK_MODE == 2){
    mode += "Delete";
  }
  text("S. CONSTANT: " + SPRING_CONSTANT,50,30);
  text("S. DAMPEN: " + SPRING_DAMPEN,250,30);
  text("S. LENGTH: " + SPRING_LENGTH,450,30);
  text("GRAVITY: " + GRAVITY,650,30);
  text("C. MODE: " + mode,850,30);
  orbs.processAll();
  orbs.display();
}

void keyPressed(){
  if (key == 49){ //48 = '0' etc
    SPRING_CONSTANT *= 1.1;
  }
  if (key == 50){ //48 = '0' etc
    SPRING_CONSTANT *= .9;
  }
  if (key == 51){ //48 = '0' etc
    if (SPRING_DAMPEN * 1.05 <= 1){
      SPRING_DAMPEN *= 1.05;
    }
    else{
      SPRING_DAMPEN = 1;
    }
  }
  if (key == 52){ //48 = '0' etc
    SPRING_DAMPEN *= .95;
  }
  if (key == 53){ //48 = '0' etc
    SPRING_LENGTH *= 1.1;
  }
  if (key == 54){ //48 = '0' etc
    SPRING_LENGTH *= .9;
  }
  if (key == 55){ //48 = '0' etc
    GRAVITY *= 1.1;
  }
  if (key == 56){ //48 = '0' etc
    GRAVITY *= .9;
  }
  if (key == ' '){
    CLICK_MODE = (CLICK_MODE + 1) % 3;
  }  
}

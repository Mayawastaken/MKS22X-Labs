
final static int SPRING = 2;
static float GRAVITY = 0.35;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}
void draw() {
  background(255);
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
  
}


public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    //insert orb at the end of the list before the last node.
    OrbNode temp = last.prev;
    orb.next = last;
    orb.prev = temp;
    temp.next = orb;
    last.prev = orb;
  }

  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    while (current != null){
      current.move();
      current = current.next;
    }
    //advance current to next until it is null, move() each of the nodes
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    while (current != null){
      current.display();
      current = current.next;
    }
    //advance current to next until it is null, display() each of the nodes
  }
  
  void add(int xcor,OrbNode toBeAdded){
    OrbNode current = first;
    if (xcor >= last.prev.x){
      add(toBeAdded);
    }
    else if (xcor <= first.next.x){
      OrbNode temp = first.next;
      toBeAdded.next = temp;
      toBeAdded.prev = first;
      temp.prev = toBeAdded;
      first.next = toBeAdded;
    }
    else{
      while (current != null && current.x < xcor){
        current = current.next;
      } // check edge cases like if xcore > last.prev then add it there
      toBeAdded.next = current.prev; // wont go null right bcs of else if
      toBeAdded.prev = current;
      (current.prev).next = toBeAdded;
      current.prev = toBeAdded;
    }
  }
  OrbNode getNodeAt(int x, int y){
    OrbNode current = first.next;
    while (current != null && current != last){
      if (dist(x, y, current.x, current.y) < 30){ //30 = radius
        return current;
      }
    }
    return null; // what do I return here
  
  }
  
  void delete(OrbNode target){
    target.prev.next = target.next;
    target.next.prev = target.prev;
  //target go poof
  }
}

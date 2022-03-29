import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = -1;
    end = 0;
  }

  public MyDeque(int initialCapacity){ //NOTE: assumes size at least 2 bcs start n end, check if I need to worry ab that
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = -1;
    end = 0;
  }

  public int size(){
    return size;
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size * 2 + 1]; //assuming we have a checker to see if size hits capacity
    int dind = 0;
    if (end < start){
      for (int i = start; i < data.length; i++){
        d[dind] = data[i];
        dind++;
      }
      for (int i = 0; i <= end; i++){
        d[dind] = data[i];
        dind++;
      }
    }
    else if (end > start){
      for (int i = 0; i <= end; i++){
        d[dind] = data[i];
      }
    }
    //um what if end = start like 0 elements 0 size?

  }
  //ugh toString debug here we go

  public String  toStringDebug(){
    String s = "[";
    for (int i = 0; i < data.length; i++){
      if (i != data.length-1){
        s += data[i] + ", ";
      }
      else{
        s += data[i];
      }
    }
    return s + "]";
  }

  public String toString(){
    String s = "[";
    if (start == end){
      return "[]";
    }
    int dind = 0;
    if (start < end){
      for (int i = start; i <= end; i++){
        if (i != end){
          s += data[i] + ", ";
        }
        else{
          s+= data[i] + "]";
        }
      }
    }
    else if (start > end){
      for (int i = start; i < data.length; i++){
        s += data[dind] + ", ";
        dind++;
      }
      for (int i = 0; i <= end; i++){
        if (i != end){
          s += data[dind] + ", ";
          dind++;
        }
        else{
          s+= data[dind] + "]";
          dind++;
        }
      }
    }
    return s;
  }


  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("can't add null to first");
    }
    if (size == data.length){
      this.resize();
    }
    if (start == 0){
      data[data.length-1] = element;
      start = data.length-1;
      size++;
    }
    else if (start == -1){
      data[0] = element;
      start++;
      end = 0;
      size++
    }
    else{
      data[start-1] = element;
      start--;
      size++;
    }
    // else {
    //   this.resize(); //data.resize? or j resize?
    //   addFirst(element);
    // }
  }
  public void addLast(E element) throws NullPointerException{
    if (element == null){
      throw new NullPointerException("can't add null to last");
    }
    if (size == data.length){
      this.resize();
    }
    if (start == -1){
      data[0] = element;
      end = 0;
      size++;
    }
    else if (end == data.length-1){
      data[0] = element;
      end = 0;
      size++;
    }
    else{
      data[end+1] = element;
      end++;
      size++;
    }
    // else {
    //   this.resize(); //data.resize? or j resize?
    //   addLast(element);
    // }
  }


  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("no elements in deque to remove first");
    }
    E removed = data[start];
    data[start] = null;
    size--;
    if (size == 1){ //front == end
      front = -1;
      end = -1;
    }
    else if (start == data.length-1){
      start = 0;
    }
    else{
      start++;
    } //bcs end will always be going ---> ie will never wrap around or uh
    return removed;
  }


  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException("no elements in deque to remove first");
    }
    E removed = data[start];
    data[start] = null;
    size--;
    if (size == 1){ //front == end
      front = -1;
      end = -1;
    }
    else if (end == 0){
      end = data.length-1;
    }
    else{
      end--;
    } //bcs end will always be going ---> ie will never wrap around or uh
    return removed;
  }


  public E getFirst(){
    if (size == 0){
      throw new NoSuchElementException("no elments in deque to get first");
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0){
      throw new NoSuchElementException("no elments in deque to get first");
    }
    return data[end];
  }

  public static void main(String[] args){
    MyDeque<Integer> test1 = new MyDeque<Integer>(5);
    System.out.println(test1.toString());
    test1.addLast(0);
    System.out.println(test1.toString()); //hmm it adds a null.. also what to do when start = end for like all of them? the start off is weird
    System.out.println(test1.toStringDebug());
    test1.addLast(1);
    System.out.println(test1.toString());
    System.out.println(test1.toStringDebug());
    test1.addFirst(2);
    System.out.println(test1.toString()); //oh lord
    System.out.println(test1.toStringDebug());
  }
}

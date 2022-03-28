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
    start = 10/2;
    end = 10/2 + 1;
  }

  public MyDeque(int initialCapacity){ //NOTE: assumes size at least 2 bcs start n end, check if I need to worry ab that
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = initialCapacity/2;
    end = initialCapacity/2 + 1;
  }

  public int size(){
    return size;
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size + 20]; //assuming we have a checker to see if size hits capacity
    int dind = 0;
    if (end < start){
      for (int i = start; i < data.length; i++){
        d[dind + 10] = data[i];
      } //wait i need to draw this out -- do later
    }

  }

  public String toString(){ }


  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("can't add null to first");
    }
    if (start == 0 && data.length-1 != end){
      data[data.length-1] = element;
      start = data.length-1;
      size++;
    }
    else if (start-1 != end){
      data[start-1] = element;
      start--;
      size++;
    }
    else {
      this.resize(); //data.resize? or j resize?
      addFirst(element);
    }
  }
  public void addLast(E element) throws NullPointerException{
    if (element == null){
      throw new NullPointerException("can't add null to last");
    }
    if (end == data.length-1 && 0 != start){
      data[0] = element;
      end = 0;
      size++;
    }
    else if (end+1 != start){
      data[end+1] = element;
      end++;
      size++;
    }
    else {
      this.resize(); //data.resize? or j resize?
      addLast(element);
    }
  }


  public E removeFirst(){ }


  public E removeLast(){ }


  public E getFirst() throws NoSuchElementException{
    return data[start];
  }
  public E getLast() throws NoSuchElementException{
    return data[end];
  }
}

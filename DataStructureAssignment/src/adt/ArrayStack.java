package adt;/** * ArrayStack.java A class that implements the ADT array by using an expandable * array. * * @author Frank M. Carrano * @version 2.0 * @param <T> */public class ArrayStack<T> implements StackInterface<T> {  private T[] array;  private int topIndex; // index of top entry  private static final int DEFAULT_CAPACITY = 50;  public ArrayStack() {    this(DEFAULT_CAPACITY);  }  public ArrayStack(int initialCapacity) {    array = (T[]) new Object[initialCapacity];    topIndex = -1;  }  @Override  public void push(T newEntry) {    topIndex++;    if (topIndex < array.length) {      array[topIndex] = newEntry;    }  }  @Override  public T peek() {    T top = null;    if (!isEmpty()) {      top = array[topIndex];    }    return top;  }     public T peek(int placementIndex) {      //this is for to loop each so it can get lower and lower (from top to down view)    T top = null;    if (!isEmpty()) {      top = array[topIndex-placementIndex];    }    return top;  }   @Override  public T pop() {    T top = null;         if (!isEmpty()) {      top = array[topIndex];      array[topIndex] = null;      topIndex--;               } // end if        return top;  }     public int getTopIndex(){      return topIndex;  }  @Override  public boolean isEmpty() {    return topIndex < 0;  }   public void clear() {    topIndex = -1;  }     public int checkIndex(int index){      return topIndex - index;  }    public ArrayStack<T> removeElementAt(int index){            ArrayStack<T> newArr = new ArrayStack<T>();            for(int i = topIndex ; 0 <= i ; i--){          //return the highest          peek(i);                    if(index!=i){              //if not the same index copy to new stack              T object = peek(i);              newArr.push(object);          }      }            return newArr;  }      public void deleteIndex(ArrayStack<T> st,int n, int curr,int index)    {                     // If stack is empty or all items            // are traversed            if (st.isEmpty() || curr == n)                return;            // Remove current item            T x = st.pop();            // Remove other items            deleteIndex(st, n, curr+1,index);            // Put all items back except middle            if (curr != index)                st.push(x);             }    public void deleteIndex(int index){        }} 
package PSSSampleSolutions.solutions_PSS_5.stackqueue;


public class ArrayQueue<E> implements Queue<E> {
  // instance variables
  /** Default array capacity. */
  public static final int CAPACITY = 10;      // default array capacity

  /** Generic array used for storage of queue elements. */
  protected E[] data;                             // generic array used for storage

  /** Current number of elements in the queue. */
  private int sz = 0;                           // current number of elements

  // constructors
  /** Constructs an empty queue using the default array capacity. */
  public ArrayQueue() {this(CAPACITY);}         // constructs queue with default capacity

  /**
   * Constructs and empty queue with the given array capacity.
   * @param capacity length of the underlying array
   */
  @SuppressWarnings({"unchecked"})
  public ArrayQueue(int capacity) {             // constructs queue with given capacity
    data = (E[]) new Object[capacity];          // safe cast; compiler may give warning
  }

  // methods
  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() { return sz; }

  /** Tests whether the queue is empty. */
  @Override
  public boolean isEmpty() { return (sz == 0); }

  /**
   * Inserts an element at the rear of the queue.
   * This method runs in O(1) time.
   * @param e   new element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  @Override
  public void enqueue(E e) throws IllegalStateException {
    if (sz == data.length) throw new IllegalStateException("Queue is full");
    data[data.length-1-sz]= e;
    sz++;
  }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() {
    if (isEmpty()) return null;
    return data[data.length-1];
  }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue() {
    if (isEmpty()) return null;
    E answer = data[data.length-1];

    for(int i=data.length-1; i>data.length-sz; i--){
      data[i]=data[i-1];

    }
    data[data.length-sz]= null;

    sz--;
    return answer;
  }

  /**
   * Returns a string representation of the queue as a list of elements.
   * This method runs in O(n) time, where n is the size of the queue.
   * @return textual representation of the queue.
   */
//  public String toString() {
//    StringBuilder sb = new StringBuilder("(");
//    int k = f;
//    for (int j=0; j < sz; j++) {
//      if (j > 0)
//        sb.append(", ");
//      sb.append(data[k]);
//      k = (k + 1) % data.length;
//    }
//    sb.append(")");
//    return sb.toString();
//  }
}
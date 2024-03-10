package source.LinkedList.SinglyLinkedList;

public class SinglyLinkedList<E> implements Cloneable {
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;
  public SinglyLinkedList() { }
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }
  public E first() {
    if (isEmpty()) return null;
    return head.getElement();
  }

  public E last() {
    if (isEmpty()) return null;
    return tail.getElement();
  }

  public void addFirst(E element) {
    head = new Node<>(element, head);
    if (size == 0)
      tail = head;
    size++;
  }

  public void addLast(E element) {
    Node<E> newest = new Node<>(element, null);
    if (isEmpty())
      head = newest;
    else
      tail.setNext(newest);
    tail = newest;
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) return null;
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0)
      tail = null;
    return answer;
  }


  public boolean equals(Object object) {
    if (object == null) return false;
    if (getClass() != object.getClass()) return false;
    SinglyLinkedList singlyLinkedList = (SinglyLinkedList) object;
    if (size != singlyLinkedList.size) return false;
    Node comparer = head;
    Node comparable = singlyLinkedList.head;
    while (comparer != null) {
      if (!comparer.getElement().equals(comparable.getElement())) return false;
      comparer = comparer.getNext();
      comparable = comparable.getNext();
    }
    return true;
  }

//  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
//    // always use inherited Object.clone() to create the initial copy
//    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
//    if (size > 0) {
//      other.head = new Node<E>(head.getElement(), null);
//      Node<E> walk = head.getNext();
//      Node<E> otherTail = other.head;
//      while (walk != null) {
//        Node<E> newest = new Node<>(walk.getElement(), null);
//        otherTail.setNext(newest);
//        otherTail = newest;
//        walk = walk.getNext();
//      }
//    }
//    return other;
//  }

public SinglyLinkedList<E> clone() {
  SinglyLinkedList<E> newSinglyLinkedList = new SinglyLinkedList<>();
  Node<E> currentNode = head;
  while (currentNode != null) {
    newSinglyLinkedList.addLast(currentNode.getElement());
    currentNode = currentNode.getNext();
  }
  return newSinglyLinkedList;
}


  public int hashCode() {
    int h = 0;
    for (Node walk = head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();
      h = (h << 5) | (h >>> 27);
    }
    return h;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}

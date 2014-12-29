package arrays;
import java.util.*;

public class LinkedListDemo {

   public static void main(String args[]) {
      // create a linked list
      LinkedList<String> ll = new LinkedList<String>();
      // add elements to the linked list
      ll.add("F");
      ll.add("B");
      ll.add("D");
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Original contents of ll: " + ll);

      // remove elements from the linked list
      ll.remove("F");
      ll.remove(2);
      System.out.println("Contents of ll after deletion: "
       + ll);
      
      // remove first and last elements
      ll.removeFirst();
      ll.removeLast();
      System.out.println("ll after deleting first and last: "
       + ll);

      // get and set a value
      Object val = ll.get(2);
      ll.set(2, (String) val + " Changed");
      System.out.println("ll after change: " + ll);
      
//ArrayList      
      List<String> l = new ArrayList<String>();
      // add elements to the linked list
      l.add("F");
      l.add("B");
      l.add("D");
      l.add("E");
      l.add("C");
//      l.addLast("Z");
//      l.addFirst("A");
      l.add(1, "A2");
      System.out.println("Original contents of l: " + ll);

      // remove elements from the linked list
      l.remove("F");
      l.remove(2);
      System.out.println("Contents of l after deletion: "
       + ll);
      
      // remove first and last elements
//      l.removeFirst();
//      l.removeLast();
      System.out.println("l after deleting first and last: "
       + l);

      // get and set a value
      Object val2 = l.get(2);
      l.set(2, (String) val2 + " Changed");
      System.out.println("l after change: " + l);

   }
}

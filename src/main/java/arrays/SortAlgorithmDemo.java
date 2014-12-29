package arrays;

import java.util.*;

public class SortAlgorithmDemo {

   public static void main(String args[]) {
      // Create and initialize linked list
      LinkedList<Integer> linkedList = new LinkedList<Integer>();
      linkedList.add(new Integer(-8));
      linkedList.add(new Integer(20));
      linkedList.add(new Integer(-20));
      linkedList.add(new Integer(8));

      System.out.println(linkedList);
      
      Collections.sort(linkedList);
      System.out.println(linkedList);

      // Create a reverse order comparator
      Comparator<Integer> r = Collections.reverseOrder();
      // Sort list by using the comparator
      Collections.sort(linkedList, r);

      System.out.println(linkedList);

      // Get iterator
      Iterator<Integer> linkedListIterator = linkedList.iterator();
      System.out.print("List sorted in reverse: ");
      while(linkedListIterator.hasNext()){
         System.out.print(linkedListIterator.next() + " ");
      }
      System.out.println();
      Collections.shuffle(linkedList);
      // display randomized list
      linkedListIterator = linkedList.iterator();
      System.out.print("List shuffled: ");
      while(linkedListIterator.hasNext()){
         System.out.print(linkedListIterator.next() + " ");
      }
      System.out.println();
      System.out.println("Minimum: " + Collections.min(linkedList));
      System.out.println("Maximum: " + Collections.max(linkedList));
   }
}
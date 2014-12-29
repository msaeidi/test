package arrays;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapDemo {

   public static void main(String args[]) {
      // Create a hash map
	   //TreeMap implements SortedMap
	   //SortedMap<K,V> extends Map<K,V>
      SortedMap<String, Double> sm = new TreeMap<String, Double>();
      // Put elements to the map
      sm.put("Zara", new Double(3434.34));
      sm.put("Mahnaz", new Double(123.22));
      sm.put("Ayan", new Double(1378.00));
      sm.put("Daisy", new Double(99.22));
      sm.put("Qadir", new Double(-19.08));
      
	  // Get a set of the entries
      Set<Entry<String, Double>> set = sm.entrySet();
      // Get an iterator
      Iterator<Entry<String, Double>> i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry<String, Double> me = (Map.Entry<String, Double>)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Deposit 1000 into Zara's account
      double balance = ((Double)sm.get("Zara")).doubleValue();
      sm.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " +
      sm.get("Zara"));
   }
}
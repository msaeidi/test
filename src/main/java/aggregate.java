import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class aggregate {

	public static void main(String[] args) {
	}	
    public static Character methodOne(String word) {
       Hashtable hash = new Hashtable();
       int i, len, k;
       Character ch, chReturn;
       Integer n;
   
       len = word.length();
   
       for (i = 0; i < len; i++)
       {
         ch = new Character( word.charAt(i) );
         n = (Integer) hash.get(ch);
   
         if ( null == n ) 
         {
           hash.put(ch, new Integer(1) );
         }
         else
         {
           hash.put(ch, new Integer(n.intValue() + 1));
         }
       }
   
       chReturn = null;
   
       for (k = 0; k < len; k++)
       {
         ch = new Character( word.charAt(k) );
   
         if (((Integer)hash.get(ch)).intValue() == 1)
         {
           chReturn = ch;
         }
       }
   
       return chReturn;
     }
	
	public static Collection getIntersect(Collection c1, Collection c2) {
		Set set = new HashSet();
		//c1.length <c2.lenth
		for (Object o: c1) {
			if (c2.contains(o)) {
				set.add(o);
			}
		}
		
		return set;
	}

	public static String getResult(String inputString, String removeString) {
		Set<Character> set = new HashSet<Character>();
		//c1.length <c2.lenth
		for (Character c: removeString.toCharArray()) {
			if (!inputString.contains(c.toString())) {
				set.add(c);
			}
		}
		return set.toString();
	}
}
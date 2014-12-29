import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

public class UnionIntersect {

    public static void main(String... args) throws Exception {

        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C", "B"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("B", "C", "D", "E", "F", "C"));

//        List<String> union = ListUtils.union(list1, list2);
//        System.out.println(union); //[A, B, C, B, B, C, D, E, F, C]
//        List<String> intersect = ListUtils.intersection(list1, list2);
//        System.out.println(intersect); //[B, C, C]
        
        System.out.println(new UnionIntersect().intersection(list1, list2)); //[B, C]
        System.out.println(new UnionIntersect().intersectFast(list1, list2)); //[B, C]
        System.out.println(new UnionIntersect().union(list1, list2)); //[D, E, F, A, B, C]
    }

    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t) && !list.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
    
    public <T> List<T> intersectFast(List<T> list1, List<T> list2) {
        if (list1.size() > list2.size()) {
        	return intersect(list1, list2);
        } else {
        	return intersect(list2, list1);
        }
    }

    public <T> List<T> intersect(List<T> list1, List<T> list2) {
        Set<T> set2 = new HashSet<T>(list2);
        Set<T> set = new HashSet<T>();

        for (T t : list1) {
            if (set2.contains(t)) {
                set.add(t);
            }
        }

        return new ArrayList<T>(set);
    }
}
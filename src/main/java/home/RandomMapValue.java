package home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomMapValue {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(11, "Jan");
		map.put(24, "Feb");
		map.put(13, "Mar");
		map.put(54, "Apr");
		map.put(5, "May");
		map.put(36, "Jun");
		
		Set<Integer> keySet = map.keySet();
		List<Integer> keyList = new ArrayList<Integer>(keySet);
		int listSize = keyList.size();
		
		for (int i=0;i<100;i++) {
			int index = (int) Math.floor(Math.random()*listSize);
			int key = keyList.get(index);
			String value = map.get(key);
			System.out.println("Index: " + index + " ,Key : " + key + " ,Value : " + value);
		}
	}

}

package sampletesting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class collectionImpl {
	
	public Integer[] hashsettoarray(HashSet<Integer> hs) {
		Integer[] arr = new Integer[hs.size()];
		
		hs.toArray(arr);
//		for (Integer integer : arr) {
//			System.out.println(integer);
//		}
		return arr;
	}
	
	public Integer[] listsettoarray(List<Integer> ls) {
		Integer[] arr = new Integer[ls.size()];
		ls.toArray(arr);
		return arr;
	}
	
	public void hashmapiterator(HashMap<Integer, Integer> hm) {
		Iterator it = hm.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry mapElement = (Map.Entry) it.next();
			System.out.print("Key :" + mapElement.getKey());
			System.out.println(" Value :" + mapElement.getValue());
		}
		
		//Using for each and lambda exp
		hm.forEach((k,v) -> System.out.println(k + " : " + v));
		
	}
	
	public TreeMap<Integer, Integer> sorthashmapbykey(HashMap<Integer, Integer> hm){
		
		TreeMap<Integer, Integer> sortedtm = new TreeMap<Integer, Integer>();
		sortedtm.putAll(hm);
		//sortedtm.forEach((k,v) -> System.out.println(k + " : "+ v));
		return sortedtm;
		
	}

}

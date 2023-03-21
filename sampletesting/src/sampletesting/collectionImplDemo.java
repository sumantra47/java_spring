package sampletesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class collectionImplDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		HashSet<Integer> hs = new HashSet<>(Arrays.asList(1,2,3,4,5));
//		collectionImpl ci = new collectionImpl();
//		Integer[] arr = ci.hashsettoarray(hs);
//		for (Integer integer : arr) {
//			System.out.println(integer.intValue());
//		}
//		System.out.println("-----------------------");
//		List<Integer> ls = Arrays.asList(1,2,3,4,5);
//		Integer[] arr1 = ci.listsettoarray(ls);
//		for (Integer integer : arr1) {
//			System.out.println(integer.intValue());
//		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(100, 3456);
		hm.put(90, 3006);
		hm.put(130, 30000);
		hm.put(120, 5600);
		hm.put(158, 4000);
		hm.put(118, 5674);
		hm.put(190, 9085);
		collectionImpl ci = new collectionImpl();
		TreeMap<Integer, Integer> hm1 = ci.sorthashmapbykey(hm);
		hm1.forEach((k,v) -> System.out.println(k + " : " + v));
		List<Integer> l1 = new ArrayList<Integer>(hm1.keySet());
		System.out.println(l1.get(1));
		
		

	}

}

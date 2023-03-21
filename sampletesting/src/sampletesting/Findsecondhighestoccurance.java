package sampletesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Findsecondhighestoccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<Integer> arr = Arrays.asList(1,2,2,3,3,3,4,4,4,4,5,5,5,5,5);
		//List<Integer> arr = Arrays.asList(1,1,2,2);
		List<Integer> arr = Arrays.asList(1,2,2,3,3,3,4,5,5,4,6,6,1,1,7,7,7,7,7,7);
		HashSet<Integer> uni_hs = new HashSet<Integer>(arr);
		System.out.println(uni_hs);
		HashMap<Integer, Integer> hm_arr = new HashMap<Integer, Integer>();
		HashSet<Integer> uni_count = new HashSet<Integer>();
		for (Integer i : uni_hs) {
			System.out.println(i + ": "+ Collections.frequency(arr, i));
			hm_arr.put(i, Collections.frequency(arr, i));
			uni_count.add(Collections.frequency(arr, i));
		}
		if(uni_count.size()>1) {
			List<Integer> count_list = new ArrayList<Integer>(uni_count);
			Collections.sort(count_list,Collections.reverseOrder());
			System.out.println(count_list);
			Iterator hm_it = hm_arr.entrySet().iterator();
			while(hm_it.hasNext()) {
				Map.Entry mapElement = (Map.Entry)hm_it.next();
				if(count_list.get(1).equals(mapElement.getValue())) {
					System.out.println("2nd highest occurance");
					System.out.println(mapElement.getKey());
					break;
				}
			}
		}else {
			System.out.println(-1);
		}

	}

}

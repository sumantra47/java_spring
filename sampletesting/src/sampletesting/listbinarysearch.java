package sampletesting;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class listbinarysearch {
	
	 static int binarySearch(List<Integer> a, int left , int right , int x) {
		//int left =0,right= a.size()-1;
		
		if(right< left) {
			return -1;
		}
		int mid = left + (right-left)/2;
		
		if(a.get(mid)==x) {
			return mid;
		}
		
		if(a.get(mid)>x) {
			return binarySearch(a, left ,mid-1,x);
		}
		
		return binarySearch(a,mid+1,right,x);
	}
	 
	 static int countOccurences(List<Integer> a,int length, int element) {
		 
		 //int ind = binarySearch(a, 0, length-1, element);
		 
		 
		 int ind = a.indexOf(element);
		 
		 System.out.println("Index :" + ind);System.out.println("Index :" + ind);
		 
		 if(ind == -1) {
			 return 0;
		 }
		 
		 //Count elements on left side
		 int count =1;
		 int left = ind -1;
		 while(left >= 0 && a.get(left)==element) {
			 System.out.println("left :" + left);
			 count++;
			 left--;
			 
		 }
		 
		 //count element on right side
		 int right =ind+1;
		 while(right < length && a.get(right)==element) {
			 
			 System.out.println("right :" + right);
			 count++;
			 right++;
			 
		 }
		 return count;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al = Arrays.asList(1,2,2,3,3,3,4,5,5,4,6,6,1,1,7,7,7,7,7,7);
		//List<Integer> al = Arrays.asList(1,1,2,2);
		Collections.sort(al); // Sort the arraylist
		//find unique elements
		HashSet<Integer> hs = new HashSet<Integer>(al); // find unique elements
		System.out.println(al);
		System.out.println(hs);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashSet<Integer> unique_counts = new HashSet<Integer>();
		int count =0;
		for(Integer i:hs) {
			System.out.print(i + " : " + countOccurences(al, al.size(), i));
			 count =countOccurences(al, al.size(), i);
			 hm.put(i,count); // calculate the occurance of unique elements
			 unique_counts.add(count); // create a hashset for the number of occurance
			 System.out.println(unique_counts);
		}
		System.out.println("-----------------------");
		if(unique_counts.size() > 1) { // if unique count > 1
			List<Integer> sort_occu = new ArrayList<Integer>(unique_counts);
			Collections.sort(sort_occu,Collections.reverseOrder());//find second highest occurrence
			System.out.println(sort_occu.get(1)); //find second highest occurrence
			int sec_high_value = sort_occu.get(1);
			Iterator hmiterator = hm.entrySet().iterator();
			while(hmiterator.hasNext()) {
				Map.Entry mapElement = (Map.Entry)hmiterator.next();
				System.out.println(mapElement.getKey() + ":" + mapElement.getValue());
				if(mapElement.getValue().equals(sec_high_value) ) {
					System.out.println(mapElement.getKey());
					break;
				}
				
			}
			
		}else {
			System.out.println(-1);
		}
		
		System.out.println("-----------------------");
		

	}

}

package sampletesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class flatmapdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> fnlst = new ArrayList<>();
		fnlst.add(Arrays.asList(1,2));
		fnlst.add(Arrays.asList(3,4));
		fnlst.add(Arrays.asList(5,8));
		fnlst.add(Arrays.asList(7,10));
		fnlst.add(Arrays.asList(9,12));
		fnlst.add(Arrays.asList(11,14));
		
		//convert list of arrays to stream
		List<Integer> l1 = fnlst.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(l1);
	}

}

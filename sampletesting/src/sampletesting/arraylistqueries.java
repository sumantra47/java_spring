package sampletesting;

import java.util.ArrayList;
import java.util.Scanner;

public class arraylistqueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//try {
			Scanner sc = new Scanner(System.in);
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int[] action = new int[2];
			for(int i =0;i<n;i++) {
				arr.add(Integer.parseInt(sc.next()));
				
			}
			System.out.println(arr);
			System.out.println(arr.size());
			int q = Integer.parseInt(sc.next());
			//String s1 = sc.next();
			q=2*q;
			while(q>0) {
				String s1 = sc.next();
				q--;
				if(s1.equals("Insert")) {
					for(int i =0;i<2;i++) {
						action[i]=Integer.parseInt(sc.next());
						System.out.println(i +" : "+action[i]  );
						q--;
					}
					if(arr.size() > action[0]) {
						arr.set(action[0]-1, action[1]);
					}else {
						int diff = (action[0]-arr.size());
						for(int i=0;i <diff;i++) {
							arr.add(0);
							//System.out.println(i + "; "+ arr.size());
						}
						arr.set(action[0]-1, action[1]);
					}
					//arr.add(action[0], action[1]);
					//q--;	
				}
				if(s1.equals("Delete")) {
					int ind = Integer.parseInt(sc.next());
					if(arr.size() > ind) {
						arr.remove(ind);
					}else {
						int diff = (ind-arr.size());
						for(int i=0;i <diff+1;i++) {
							arr.add(0);
							//System.out.println(i + "; "+ arr.size());
						}
						arr.remove(ind);
					}
					
					System.out.println("q :" +q);
					q--;
					
				}
				System.out.println(q);
			}
			System.out.println(arr.size());
			System.out.println("------------------------");
			arr.forEach(i -> System.out.print(i + " "));
		//} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

		

	}

}

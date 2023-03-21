package sampletesting;

public class app {

	public void process(String s1 , StringBuilder s2) {
		s1.concat("$$");
		s2.append("$$");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "WALMART";
//		StringBuilder s2 = new StringBuilder("WALMART");
//		new app().process(s1, s2);
//		System.out.println(s1 + " " +s2);
//		
//		try {
//			int a =10;
//			int b =0;
//			
//			System.out.println(a/b);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ArithmeticException ae) {
//			System.out.println(1);
//		}
//
//	
		int nd_arr[][] = new int[3][];
		nd_arr[0] = new int[1];
		nd_arr[1] = new int[2];
		nd_arr[2] = new int[3];
		
		int tot =0;
		for(int i=0;i<3;++i)
		{
			for(int j =0;j<i+1;++j) {
				nd_arr[i][j]= j+1;
			}
		}
		for(int i=0;i<3;++i)
		{
			for(int j =0;j<i+1;++j) {
				tot+=nd_arr[i][j];
			}
		}
		System.out.println(tot);
		}
		

}

package sampletesting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class exceptiontest {
	
	public static void writeToFile() throws Exception
    {
        BufferedReader bw = new BufferedReader(
            new FileReader("File.txt"));
        bw.read();
        bw.close();
    }
  
	
	public static void main(String[] args) throws Exception {
		try {
			writeToFile();
		}catch(Exception e){
			//e.printStackTrace();
			
		}
		
//		try {
////			int i[] = new int[3];
////			System.out.println(i[3]);
//		int z=5;
//		if( z> 0) {
//			throw new ArithmeticException("Test error");
//		}
//			
//		}catch(ArithmeticException e){
//			e.printStackTrace();
//			
//		}
		
	}
	
	

}

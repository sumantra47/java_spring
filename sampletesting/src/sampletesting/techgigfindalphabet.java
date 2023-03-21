package sampletesting;

import java.util.*;

public class techgigfindalphabet {

	public static void main(String[] args) {
		//Write code here
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        String[] str = new String[n];

        for(int i = 0;i<n;i++){
            str[i]= inp.next();
            List<Character> aplhalist = new ArrayList<Character>();
            for(int j=0;j<str[i].length();j++){
                aplhalist.add(str[i].charAt(j));
            }
            HashSet<Character> unicnt = new HashSet<>(aplhalist);
            //System.out.println(unicnt);
            TreeMap<Character,Integer> alphcnt = new TreeMap<Character,Integer>();
            HashSet<Integer> unifreq = new HashSet<Integer>();
            for(Character c : unicnt){
                alphcnt.put(c,Collections.frequency(aplhalist,c));
                unifreq.add(Collections.frequency(aplhalist,c));
            }
            int max = Collections.max(alphcnt.values());
            List<Character> outstr = new ArrayList<Character>();
            alphcnt.forEach((k,v)-> {
                System.out.println(k +":"+ v);
                if(v== max){
                    outstr.add(k);
                }});
            if(outstr.size()>1){
                char minch = outstr.get(0);
                for(Character c : outstr){
                    if(c < minch){  
                    	minch =c;
                    	//System.out.println("maxch "+ maxch);
                    	}
                }
                System.out.println(minch);
            }
            else
            {
            	System.out.println(outstr.get(0));
            }
        	}}

	}


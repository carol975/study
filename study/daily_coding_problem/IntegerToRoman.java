package daily_coding_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class IntegerToRoman {
	public static String intToRoman(int num) {
        if(num == 0){
            return "";
        }
        HashMap<Integer, String> itor = new HashMap<Integer, String>();
        itor.put(0,"");
        itor.put(1,"I");      
        itor.put(5,"V");       
        itor.put(10,"X");       
        itor.put(50,"L");
        itor.put(100,"C");
        itor.put(500,"D");       
        itor.put(1000,"M");

        HashMap<Integer, String> subtractitor = new HashMap<Integer, String>();
        subtractitor.put(4,"IV");
        subtractitor.put(9,"IX");
        subtractitor.put(40,"XL");
        subtractitor.put(90,"XC");
        subtractitor.put(400,"CD");
        subtractitor.put(900,"CM");
        
        
        
        String total = "";
        int place_value = -1;
        while(num != 0){
        	place_value ++;
            int val = (num % 10) * (int)Math.pow(10,place_value);            
            num /= 10;
            System.out.println(total);
            if(itor.get(val)!= null){
                total = itor.get(val) + total;
                System.out.println("41" + total);
            }
            else if(subtractitor.get(val)!= null){
                total = subtractitor.get(val) + total;
                System.out.println("45"+total);
            }
            else{
                 if(val < 4){
                     for(int i = 0; i<val;i++){
                         total = total + "I";
                     }
                 }
                else{
                    ArrayList<Integer> keyList = new ArrayList<Integer>(itor.keySet());
                    Collections.sort(keyList);
                    System.out.println(keyList);
                    for(int i = keyList.size()-1; i > 1; i--){
                     if(val > keyList.get(i)){
                    	 if(val % keyList.get(i) == 0){
                    		 for(int index = 0; index < val; index += keyList.get(i)){
                    			 String temp = itor.get(keyList.get(i));
                                 total = temp + total;
                    		 }
                    		 break;
                    	 }
                    	 else{
                    		 String temp = itor.get(keyList.get(i));
                             val = val - keyList.get(i);
                             int plus = (val/(int)Math.pow(10,place_value)) % 10;
                             //System.out.println("plus" + plus);
                             for(int j = 0; j<plus; j++){
                            	 //System.out.println(keyList.get(i-1));
                            	 //System.out.println("total" + total);
                                 temp = temp + itor.get(keyList.get(i-1));
                                 val = val - keyList.get(i-1);
                                 //System.out.println("total" + total);
                             }
                              if(val != 0){
                            	  //System.out.println("val: "+ val);
                                  plus = val % 10;
                                for(int k = 0; k < plus ; k++){
                                    temp = temp + "I";
                                }    
                        
                             }
                              total = temp + total;
                              break;
                    	 }
                         
                    
                    }
                 }
                }
                 
            }
            
        }
        return total;
    }
	
	public static void main(String[] args){
		System.out.println(intToRoman(3999));
	}
}

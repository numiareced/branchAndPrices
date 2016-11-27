package branchAndPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

	/*	if (args.length != 1) {
			System.out.println("Bad args!!!");
			System.exit(1);
		}
*/
		String file = "myciel3.col";
	
		//System.out.println("Filename is:" + args[0]);
		System.out.println("Will try to parse it now"); 
		Parser parser = new Parser(file);
		int[][] fileMatrix = parser.getMatrix();
		System.out.println("Parsed matrix:"); 
		for (int i = 0; i < fileMatrix.length; i++) {     
	        System.out.println(Arrays.toString(fileMatrix[i]));
	      }
		System.out.println("length is:"  + fileMatrix.length);
		HashMap<Integer, Integer> weightMap = new HashMap<Integer, Integer>(); 
		ArrayList<Integer> weights = new ArrayList<Integer>();
		for ( int i =0; i <fileMatrix.length; i++ ){
			int weight = 0; 
			for (int j =0; j <fileMatrix[i].length; j ++){
				if (fileMatrix[i][j]==1) {
					weight++; 
				}
			}
			weightMap.put(i+1, weight);
		}
		
		System.out.println("weights: " + weightMap.toString());
		weightMap = sortMapByValues(weightMap);
		int colors =0; 
		System.out.println("sorted weights: " + weightMap.toString());
		Iterator it = weightMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Integer node = (Integer)pair.getKey(); 
	        System.out.println("node number:" + node);
	        for ( int j = 0; j < fileMatrix.length; j ++){
	        	if ( j == node.intValue()-1){
	        		int[][] coloredValues;
        			colors ++; 
	        		for (int k = 0; k < fileMatrix[j].length; k++) {  
	        			if (fileMatrix[j][k] == 0){
	        				for ( int z =0; z < coloredValues.length; z ++){
	        					
	        				}
	        			}
	        	        System.out.print(fileMatrix[j][k] + " ");
	        	      }
	        		System.out.println(); 
	        	}
	        }
	    }
	}
	
	 private static  HashMap<Integer, Integer> sortMapByValues(Map<Integer, Integer> aMap) {
	        
	        Set<Entry<Integer,Integer>> mapEntries = aMap.entrySet();
	        List<Entry<Integer,Integer>> aList = new LinkedList<Entry<Integer,Integer>>(mapEntries);
	        Collections.sort(aList, new Comparator<Entry<Integer,Integer>>() {

	            @Override
	            public int compare(Entry<Integer, Integer> ele1,
	                    Entry<Integer, Integer> ele2) {
	                
	                return ele2.getValue().compareTo(ele1.getValue());
	            }
	        });
	        Map<Integer,Integer> aMap2 = new LinkedHashMap<Integer, Integer>();
	        for(Entry<Integer,Integer> entry: aList) {
	            aMap2.put(entry.getKey(), entry.getValue());
	        }
	        
	        // printing values after soring of map
	        System.out.println("Value " + " - " + "Key");
	        for(Entry<Integer,Integer> entry : aMap2.entrySet()) {
	            System.out.println(entry.getValue() + " - " + entry.getKey());
	        }
	        return (LinkedHashMap<Integer, Integer>)aMap2; 
	    }
}

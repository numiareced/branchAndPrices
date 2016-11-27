package branchAndPrice;

import java.util.Arrays;

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
			

	}
}

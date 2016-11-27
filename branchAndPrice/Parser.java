package branchAndPrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	private int [][] matrix;
	int edgeNumber;
	int vertexNumber; 
	int[][] graph; 
	public Parser(String filename){
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
			
			String str; 
			int t =0; 
			while ((str = br.readLine()) != null) {

				if ( str.startsWith("c ")){
					System.out.println("comment:" + str);
				}
				
				if (str.startsWith("p ")){
					String split[] = str.split(" ");
					vertexNumber =Integer.parseInt(split[2]);
					edgeNumber = Integer.parseInt(split[3]);
					System.out.println("vertexs:" + vertexNumber);
					System.out.println("edges:" + edgeNumber);
					
					graph = new int[edgeNumber][2];
					
				}
				
				if (str.startsWith("e ")){
					String split[] = str.split(" ");
					int i = Integer.parseInt(split[1]);
					int j = Integer.parseInt(split[2]);
					graph[t][0]=i;
					graph[t][1]=j;
					t++; 
				}
			}
			matrix = parseMatrix(graph, vertexNumber);
		} catch (IOException e) {
			System.out.println("File reading error");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong ");
		}
		
		
	}
	
	int[][] parseMatrix(int[][] parsedValues, int vertexNumber){
		int [][] sparseMatrix = new int[vertexNumber][vertexNumber]; 
		
		for (int i = 0; i < parsedValues.length; i++) {
            	int vertex1 = parsedValues[i][0];
            	int vertex2 = parsedValues[i][1];
            	sparseMatrix[vertex1-1][vertex2-1]= 1; 
            	sparseMatrix[vertex2-1][vertex1-1]= 1; 
            	
		}
		
		for (int k =0; k<vertexNumber; k ++){
			for (int j=0; j < vertexNumber; j ++){
				if (k==j){
					sparseMatrix[k][j]=999; 
				}
			}
		}
		
		return sparseMatrix;
	}
	
	public int[][] getMatrix(){
		return this.matrix; 
	}
	
	public void setMatrix(int[][]mat){
		this.matrix = mat; 
	}

}

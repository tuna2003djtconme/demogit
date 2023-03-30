package ltdt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Graph {
	protected int numVexs;
	protected int[][] matrix;
	protected String path;

	public Graph(int numVexs, int[][] matrix) {
		super();
		this.numVexs = numVexs;
		this.matrix = new int[numVexs][numVexs];
	}

	public Graph(String path) {
		super();
		this.path = path;
	}

	public void loadGraph(String pathFile) {
		File file = new File(pathFile);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			this.numVexs = Integer.valueOf(br.readLine());
			this.matrix = new int[numVexs][numVexs];
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(" ");
				for (int i = 0; i < temp.length; i++) {
					matrix[row][i] = Integer.valueOf(temp[i]);
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public abstract void addEdges(int matrix[][],int i, int j) ;
	public abstract void removeEdges(int matrix[][], int i, int j) ;
	public abstract int deg(int v);
	public boolean checkUnGraph(int[][] matrix) {
		boolean rs = true ; 
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
			
		if (matrix[i][j]!=matrix[j][i]) {
			return rs = false;
		}
			}
		}
		return rs;
		// implement code
		}



	public static void main(String[] args) {
		String pathFile = "C:\\Users\\Admin\\Desktop\\ltdt\\ltdt\\src\\graph.txt";
		Graph g1 = new Graph(pathFile) {

			@Override
			public void addEdges(int[][] matrix, int i, int j) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeEdges(int[][] matrix, int i, int j) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int deg(int v) {
				return 0;
				// TODO Auto-generated method stub
			}
		};
		g1.loadGraph(pathFile);
		g1.printMatrix();
	}

	
}

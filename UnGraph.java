package ltdt;

public class UnGraph extends Graph {
	

	public UnGraph(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addEdges(int[][] matrix, int i, int j) {
		// TODO Auto-generated method stub
		if (i<=numVexs&&j<=numVexs) {
		if (i==j) {
			matrix[i][j]+=1; 
		}else {
			matrix[i][j]+=1;
			matrix[j][i]+=1;
		}
		}
	}
	@Override
	public void removeEdges(int[][] matrix, int i, int j) {
		// TODO Auto-generated method stub
		if (i<=numVexs&&j<=numVexs) {
			if (i==j&&matrix[i][i]>=1) {
				matrix[i][j]-=1; 
			}else if (i!=j&&matrix[i][j]>=1){
				matrix[i][j]-=1;
				matrix[j][i]-=1;
			}
			}
		}
	@Override
	public int deg(int v) {
		// TODO Auto-generated method stub
		int rs = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (v==i) {
				rs += matrix[v][i]*2;
			}else {
			rs += matrix[v][i];
		}}
		return rs;
	}
		
	public static void main(String[] args) {
		String pathFile = "C:\\Users\\Admin\\Desktop\\ltdt\\ltdt\\src\\graph.txt";
		Graph u1 = new UnGraph(pathFile);
		u1.loadGraph(pathFile);
		u1.printMatrix();
		
		u1.addEdges(u1.matrix, 1, 1);
		System.out.println("----------add----------");
		u1.printMatrix();
		System.out.println("------degree------");
		for (int i = 0; i < u1.numVexs; i++) {
			System.out.println("bac cua dinh "+ (i+1)+ " la " + u1.deg(i));
		}
		System.out.println("----------remove----------");
		u1.removeEdges(u1.matrix, 1, 2);
		u1.printMatrix();
		}


		
	}



package assignment7;

public class MovieSeating {
	private Customer[][] seating;
	private int rows, cols;
	public MovieSeating(int rowNum, int colNum) {
		
		seating = new Customer[rowNum][colNum];
		rows = rowNum;
		cols = colNum;
		for (int i = 0;i<rowNum;i++) {
			for (int j=0;j<colNum;j++) {
				seating[i][j] = new Customer();
			}//for inner
		}//for outer
	}//constructor
	
	public Customer getCustomerAt(int row, int col) {
		return seating[row][col];
	}//getCustomer
	
	public boolean assignCustomerAt(int row, int col, Customer tempCustomer) {
		if (getCustomerAt(row, col).toString().equals("?.?.")) {
			seating[row][col]= tempCustomer;
			return true;
		}else {return false;}
	}//assign
	
	public boolean checkBoundaries(int row, int col) {
		
		if (row<0||col<0||row>rows||col>cols) {
			return false;
		}else {return true;}
		
	}
	
	
	public String toString() {
		String chart ="";
		chart = "The Current Seating"+
			  "\n-------------------"+
				"\n";
		for (int i=0;i<seating.length;i++) {
			for (int j=0;j<seating[0].length;j++) {
				chart+= seating[i][j]+" ";
			}
		chart +="\n";
		}
		return chart;
	}//toString
}

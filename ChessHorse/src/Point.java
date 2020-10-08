
public class Point {

	public int row;
	public int col;
	public boolean avialableMovesInPoint;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
		this.avialableMovesInPoint = true;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isAvialableMovesInPoint() {
		return avialableMovesInPoint;
	}

	public void setAvialableMovesInPoint(boolean avialableMovesInPoint) {
		this.avialableMovesInPoint = avialableMovesInPoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	

	@Override
	public String toString() {
		return "Point" + getCol() + " " + getRow();
	}

	public Point() {
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
	
	
}

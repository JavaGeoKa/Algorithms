
public class Move {
	public int startI;
	public int startJ;
	public int endI;
	public int endJ;
	public boolean alreadyWas = false;
	
	
	public Move(int startI, int startJ, int endI, int endJ) {
		super();
		this.startI = startI;
		this.startJ = startJ;
		this.endI = endI;
		this.endJ = endJ;
	}


	public int getStartI() {
		return startI;
	}


	public void setStartI(int startI) {
		this.startI = startI;
	}


	public int getStartJ() {
		return startJ;
	}


	public void setStartJ(int startJ) {
		this.startJ = startJ;
	}


	public int getEndI() {
		return endI;
	}


	public void setEndI(int endI) {
		this.endI = endI;
	}


	public int getEndJ() {
		return endJ;
	}


	public void setEndJ(int endJ) {
		this.endJ = endJ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endI;
		result = prime * result + endJ;
		result = prime * result + startI;
		result = prime * result + startJ;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (endI != other.endI)
			return false;
		if (endJ != other.endJ)
			return false;
		if (startI != other.startI)
			return false;
		if (startJ != other.startJ)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return   startI + "" +  startJ + " -> " + endI + endJ + "\n";
	}


	public boolean getAlreadyWas() {
		return alreadyWas;
	}


	public void setAlreadyWas(boolean alreadyWas) {
		this.alreadyWas = alreadyWas;
	}
	
	
	
	
	
	

}

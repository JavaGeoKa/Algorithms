package Utils;
import Controller.Controller;
import Model.Point;
import Repo.GameRepo;

public class KnightsMovesChecker {
	static int deskSize = 8;
	
	static int i;
    static int j;

    static int deskMov1[] = {-2, -1, 1, 2, 2, 1, -1, -2};		
    static int deskMov2[] = {1, 2, 2, 1, -1, -2, -2, -1};

	Point currentPoint;
	Point[] avialablePoints;
	static int moveQuantity = 0;
	
   	public static int checkAvialablePoints(Point p) {
		int a, b, e;
		int countAvialableMove = 0;
		
		Point[] avialablePoints = new Point[deskSize];
//		System.out.println(avialablePoints.length);

		for ( a = 0; a < 8; a++) {                     
	        /* Если все ходы сделаны, печатаем их */
	        if (moveQuantity >= deskSize*deskSize) {
	            printDesk();
	            System.exit(0);
	        }

	        /* Определяем колонку и строку для следующего хода */
	        b = i + deskMov1[a];
	        e = j + deskMov2[a];
//	        System.out.println("Move " + a + "   point " + b + e);

	        /* Проверяем, что после выполенения хода конь остается на шахматной доске */
	        if (b < 0 || b > deskSize - 1 || e < 0 || e > deskSize - 1) continue; 

	        /* Проверяем, были ли мы уже в этой клетке */
	        if (Controller.deskCell[b][e]) continue; 
	        
//	        System.out.println("BE = " + b + e);
//	        endPoint.setCol(b);
//	        endPoint.setRow(e);
//	        avialablePoints[a] = endPoint;
//	        System.out.println(endPoint);
	        System.out.println("Avialable Move " + a + "   point " + b + e);
//	        i = b; j = e;
	        countAvialableMove ++;
		}
        GameRepo.historyAvialableMoves.put(Controller.moveNum, avialablePoints);   

		return countAvialableMove;
	}

   	    	
   			static void printDesk( ) {
   	    	    int a;
   	    	    Point point = new Point();
   	    	    
   	    	    
   	    	    for (a = 0; a < deskSize*deskSize; a++) {
   	    	    	
   	    	        System.out.printf("%s%d ", deskCellColName[deskCol[a]], deskRow[a] + 1);

   	    	    }
	
	
   	    	 //initialisation block   
   	    	    
   	    	    
   	    		public KnightsMovesChecker(Point currentPoint, Point[] avialablePoints) {
   	    			this.currentPoint = currentPoint;
   	    			this.avialablePoints = avialablePoints;
   	    		}

   	    		public Point[] getAvialablePoints() {
   	    			return avialablePoints;
   	    		}

   	    		public void setAvialablePoints(Point[] avialablePoints) {
   	    			this.avialablePoints = avialablePoints;
   	    		}

   	    		public Point getCurrentPoint() {
   	    			return currentPoint;
   	    		}
   	    		
   	    		public KnightsMovesChecker() {
   	    		}
   	    	    
   	    	    
   	    	    
   	    	    
   	    	    
   	    	    

	
}

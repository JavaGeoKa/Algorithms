package Genuis;
public class TeleGenuisV4 implements Runnable{
    //параметры потока
	 int number;
	 int deskSize = 8;
	 Move nextMove;
	 boolean[][] deskCell = new boolean[deskSize][deskSize];
	 
	 

	String deskCellColName[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    int deskRow[] = new int[64];
    int deskCol[] = new int[64];
    int deskMov1[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    int deskMov2[] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    
    // Начальная позиция коня и общее количество ходов..
    int i, j;
    public int moveNum = 0;
    int c = 0;
	
    
    //
    
    TeleGenuisV4() {}
    
    
    
//    =================================================================
    		@Override
    		public void run() {
    		    
    			new TeleGenuisV4().theHamiltonCycle();
    					
    		}

    		
    		
//    		=================================================
    

    void theHamiltonCycle() {    	
        
    	deskCell[i][j] = true;
        deskRow[moveNum] = i;
        deskCol[moveNum] = j;
        moveNum++;
        c++;
        calculateAllAvialableMoves(i,j);
        
        for (Move m : Controller.avialableMoves) {
        	System.out.println(m);
		}
        
        
        nextMove = findNextMove();
        System.out.println("Next " + nextMove);
        i = nextMove.getEndI();
        j = nextMove.getEndJ();
//        
//        
        System.out.println(i + " " + j);
        theHamiltonCycle();

}
    
  
    
//    ==================================================================
    private void calculateAllAvialableMoves(int row, int col) {
    	
    	int a, b, e;
        deskRow[moveNum] = row;
        deskCol[moveNum] = col;       
        moveNum++;             
        c++;                          

       
  
        for ( a = 0; a < deskMov1.length; a++) {               
            
            if (moveNum >= deskSize*deskSize) { 
            	
                System.exit(0);                    
            }
            
            
            
            /* Определяем колонку и строку для следующего хода */
            b = i + deskMov1[a];
            e = j + deskMov2[a];
       
            

            /* Проверяем, что после выполенения хода конь остается на шахматной доске */
            if (b < 0 || b > deskSize - 1 || e < 0 || e > deskSize - 1) continue; 

            /* Проверяем, были ли мы уже в этой клетке */
            if (deskCell[b][e]) continue; 
              
            /* добавляем возможный ход в репозиторий*/
            Move move = new Move (i, j, b, e);
            
            if (Controller.avialableMoves.contains(move) && move.alreadyWas) {continue;}
        
            Point point = new Point(i, j);
            Controller.avialableMoves.add(move);
            continue;
            

        } 
        
 
		
	}


//=======================================================

	private Move findNextMove() {
    	for (Move m : Controller.avialableMoves) {
			if (!m.getAlreadyWas()) {
				m.alreadyWas = true;
				return m; }	
			}
    	System.out.println("no avialable moves");
		return null;
		}
		
	
    



	
	
	
//	private Move findAvialabletPoints() {     //здесь мы получаем точку старта для потока
//		for (Move m : StreamHorse.avialableMoves) {
//			if (m.getAlreadyWas()) {     //если хода не было
//				m.alreadyWas = true;     //устанавливаем что он был 
//				return m; }	
//			}
//		System.out.println("No avialable move");
//		return null;
//		}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//=======================================
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDeskSize() {
		return deskSize;
	}

	public void setDeskSize(int deskSize) {
		this.deskSize = deskSize;
	}



	public TeleGenuisV4(int number, int deskSize ) {
		this.deskCell = null;
		this.number = number;
		this.deskSize = deskSize;
		
	}
//==============================================



	public TeleGenuisV4(int deskSize) {
		this.deskCell = new boolean [deskSize][deskSize];;
		this.deskSize = deskSize;
	}
	
}
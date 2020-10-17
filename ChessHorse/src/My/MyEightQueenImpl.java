package My;

//Алгоритм решения задачи:
//1) встать на клетку (занять область,  запомнить ход)
//2) проверить если количество ферзей не окончательно -> проверить следующий доступный ход, выполнить его
//3) если доступного хода нет то вернуться назад и продолжить 

public class MyEightQueenImpl {
	
    
    // Параметры Шахматной доски и варианты разрешенных ходов из текущей позиции коня
    static final int deskSize = 8;
    static final int QueenQuantity = 8;
    boolean deskCell[][] = new boolean[deskSize][deskSize];
    String deskCellColName[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    
    static int deskRow[] = new int[deskSize];      //репозиторий
    static int deskCol[] = new int[deskSize];
    
    static int busyCellRow[] = new int[deskSize];    //helper
    static int busyCellCol[] = new int[deskSize];
    
    
//    int deskMov1[] = {1,1,1,-1,-1,-1,0,0,    0,1,2,   2,2,2,2,     1, 0,-1,-2,  -2,-2,-2,-2,   -1  };			//ходы 
//    int deskMov2[] = {0,1,-1,0,1,-1,1,-1,    2,2,2,   1,0,-1,-2,  -2,-2,-2,-2,  -1,0,1,2,        2 };
//    int innerCircle = 8;
//    int outerCircle = 24;
    
    static int input;
    
    
    // Начальная позиция коня и общее количество ходов..
    int x, y;
    static int i, j;    //текущая позиция 
//    int a;       //помогает при переборе хода
    static int h =0;   //помогает переору хелпера при удалении обороны
    int moveNum = 0;
    

    
    //то
    MyEightQueenImpl() {}
    

    
    void algorithmEightQueen() {
    	int n, m;
    	h = 0;

        deskCell[i][j] = true;     
        for (int a = 0 ; a < innerCircle ; a ++) {
        	
            n = i + deskMov1[a];
            m = j + deskMov2[a];

            if (n < 0 || n > deskSize - 1 || m < 0 || m > deskSize - 1) continue; 
            if (deskCell[n][m]) continue; 
            
            deskCell[n][m] = true;  
               
//            busyCellRow[h++] = n;
//            busyCellCol[h++] = m;
            
        }
        
        deskRow[moveNum] = i;     
        deskCol[moveNum] = j;
        moveNum ++;

    	
        
   //Ход следующим ферзем
      
        for (int a = 0; a < outerCircle; a++) {                      //ищем возможный ход
        	
    	  
    	  /* Если все ходы сделаны, печатаем их */
          if (moveNum >= QueenQuantity) {
        	  	printDesk();   
            	if (--input == 0) {
//          	    	System.exit(0);
//          	    	break;
            		continue;
                	}
            	
               }
          
          n = i + deskMov1[a];
          m = j + deskMov2[a];

          if (n < 0 || n > deskSize - 1 || m < 0 || m > deskSize - 1) continue; 
          if (deskCell[n][m]) continue;       
          i = n ; j = m;
            
          System.out.println("ij ->  " + i + j + "   a ->" +  a + "     moveNum ->" + moveNum);
          
          algorithmEightQueen();
             
      }  
        
    
    
//        	deskCell[deskRow[moveNum]][deskCol[moveNum]] = false;
//        	moveNum--;
        	  
  
        	clearDesk(); 
  
  
  /* Пробуем сделать следующий ход */
//        	moveNum--;
//        	i = deskRow[moveNum];
//        	j = deskCol[moveNum];
//        	moveNum++;
    
}
        
              

////--------------------------------------------------------------------------------------

private void clearDesk() {
		for (int i = 0; i < busyCellRow.length ; i ++) {
			deskCell[busyCellRow[i]][busyCellCol[i]] = false; 
			System.out.println(deskCell[busyCellRow[i]][busyCellCol[i]] + " ");
			}
			System.out.println("\n");	
	}



	

	



	////-------------------------------------------------------------------------------------
  
    void printDesk( ) {

            
            
            int a;
            for (a = 0; a < deskSize; a++) {
                System.out.printf("%s%d ", deskCellColName[deskCol[a]], deskRow[a] + 1);
            }
            System.out.println();    
            
            
        }
       
    
    

        
   
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
    	
//    	a1 c1 e1 g1 h3 h5 h7 f8 
    	
//    	Scanner sc = new Scanner(System.in);
//        //Вводим предложение в консоль
//        System.out.println("input quantity resultat: ");
//        input = Integer.parseInt(sc.nextLine());
      
    	
    	input = 5; 
    	    	
    	MyEightQueenImpl queen = new MyEightQueenImpl(); 	
    	
    	for (i = 0; i < deskSize; i ++) {
    		for (j = 0; j < deskSize; j++) {
    			System.out.println(i + "" + j);
    			queen.algorithmEightQueen();
    		}
    	}
    	
    		
    		
     
    }

}
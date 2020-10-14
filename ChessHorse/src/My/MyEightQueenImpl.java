package My;

import java.util.Scanner;

public class MyEightQueenImpl {
	
	static int numberOfAttempts = 3;
    
    // Параметры Шахматной доски и варианты разрешенных ходов из текущей позиции коня
    static final int deskSize = 8;
    static final int QueenQuantity = 8;
    boolean deskCell[][] = new boolean[deskSize][deskSize];
    
    static int deskRow[] = new int[deskSize];      //репозиторий
    static int deskCol[] = new int[deskSize];
    static int busyCellRow[] = new int[deskSize];
    static int busyCellCol[] = new int[deskSize];
    
    int deskMov1[] = {1,1,1,-1,-1,-1,0,0,    0,1,2, 2,2,2,2,     1, 0,-1,-2,  -2,-2,-2,-2, -1  };			//ходы 
    int deskMov2[] = {0,1,-1,0,1,-1,1,-1,    2,2,2, 1,0,-1,-2,  -2,-2,-2,-2,  -1,0,1,2, 2 };
    int innerCircle = 8;
    int outerCircle = 24;
    
    
    
    // Начальная позиция коня и общее количество ходов..
    int x, y;
    int i, j;
    int a;
    int moveNum = 0;
    
    static int input = 0;
    
    //то
    MyEightQueenImpl() {}
    

    
    void algorithmEightQueen() {
    	
  
// 1	
    	//здесь ферзь встает на клетку и начинает занимать все ходы вокруг себя 
    	int n, m;
        /* Пометить клетку как посещенную и запомнить координаты клетки */
        deskCell[i][j] = true;   
        
        
        
        for (a = 0 ; a < innerCircle ; a ++) {
        	
            n = i + deskMov1[a];
            m = j + deskMov2[a];

            /* Проверяем, что после выполенения хода конь остается на шахматной доске */
            if (n < 0 || n > deskSize - 1 || m < 0 || m > deskSize - 1) continue; 

            /* Проверяем, были ли мы уже в этой клетке */
            if (deskCell[n][m]) continue; 
            
            //занимаем оборону 
            deskCell[n][m] = true;  
            
            //запоминаем заняятые клетки
            busyCellRow[a] = n;
            busyCellCol[a] = m;
            
            
           //------------------------------------ 
        	
            
        }
        
        
        //запоминаем ход
        deskRow[moveNum] = i;     
        deskCol[moveNum] = j;
        moveNum ++;

    	
        
   //Ход следующим ферзем
      
      for (a = 0; a < outerCircle; a++) {                      //проходим по 
  
    	  
    	  /* Если все ходы сделаны, печатаем их */
          if (moveNum >= QueenQuantity) {
              
          	printDesk();
          	
          	if (--input == 0) {
              	System.exit(0);
          	}
          	continue;
          }
          
          
          
          
                 	
          n = i + deskMov1[a];
          m = j + deskMov2[a];

          /* Проверяем, что после выполенения хода конь остается на шахматной доске */
          if (n < 0 || n > deskSize - 1 || m < 0 || m > deskSize - 1) continue; 

          /* Проверяем, были ли мы уже в этой клетке */
          if (deskCell[n][m]) continue; 
      
          i = n ; j = m;
          
          algorithmEightQueen();
             
      }  
        
    
    
    /* Уменьшить счетчик ходов и попробовать сделать следующий ход */
  moveNum--;
  /* Освобождаем клетку, ранее занятую конем */
  deskCell[deskRow[moveNum]][deskCol[moveNum]] = false;
  
  //освобождение обороны
//  for (int a = 0; a < busyCellCol.length; a++) {
//	  
//	
//}
  
  /* Пробуем сделать следующий ход */
  moveNum--;
  i = deskRow[moveNum];
  j = deskCol[moveNum];
  moveNum++;
    
}
        
              

////--------------------------------------------------------------------------------------

////-------------------------------------------------------------------------------------
//            
//
//        
//        
//      
//      
//    
//    
//    
//    
//    ===========================}
//    
//    
//    
//    
//    
//    
    void printDesk( ) {
        int a;
        
                
        for (a = 0; a < deskSize*deskSize; a++) {
            System.out.printf("%d%d ",deskCol[a], deskRow[a]);
        }
       
    
    }
    
    
//    
//    
//    
//    
//    
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
    	
//    	Scanner sc = new Scanner(System.in);
//        //Вводим предложение в консоль
//        System.out.println("input quantity resultat: ");
//        input = Integer.parseInt(sc.nextLine());
      
    	MyEightQueenImpl queen = new MyEightQueenImpl();
    
    		input = 5;
    			
    		queen.algorithmEightQueen();
    		
    		
     
    }

}
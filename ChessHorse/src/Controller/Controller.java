package Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Point;
import Repo.GameRepo;
import Utils.KnightsMovesChecker;


public class Controller {
	
//===========================================
//Repository
	
	static KnightsMovesChecker k;     //подключаю утилиту для проверки доступных ходов
	
	
	static Point startPoint = new Point();
	static Point endPoint = new Point();

//===========================================	
//Configuration
	
	static int deskSize = 8;
	public static boolean deskCell[][] = new boolean[deskSize][deskSize];

    static String deskCellColName[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    
   
    public static int i;
    public static int j;
    
    
    public static int moveNum = 0;
		


//start recursion
static void theHamiltonCycle() {    
	
	
			deskCell[i][j] = true; 
    	    			
    	    startPoint.setCol(i);
    	    startPoint.setRow(j);
    	        	    
    	    GameRepo.deskRow[moveNum] = i;
    	    GameRepo.deskCol[moveNum] = j;
    	    moveNum++;
    	    
    	   //должен вернуть правильне число ходов
    	    int quantityAvialablePoints = KnightsMovesChecker.checkAvialablePoints(startPoint);
    	    
    	    System.out.println("Avialable moves int point " + startPoint.toString() + " = " + quantityAvialablePoints );
    	    
    	    
	    
//    	   endPoint = findNextMove();
//    	   i = endPoint.getCol();
//    	   j = endPoint.getRow();
//    	   System.out.println(i + " " + j);
    	    
    	
    	          
//    	    theHamiltonCycle();
    	    


    	    /* Уменьшить счетчик ходов и попробовать сделать следующий ход */
    	    moveNum--;
//    	    System.out.println("Quanity avialable moves: " + quantityAvialablePoints + " in Move " + moveNum );

    	    /* Освобождаем клетку, ранее занятую конем */
    	    deskCell[GameRepo.deskRow[moveNum]][GameRepo.deskCol[moveNum]] = false;
    	    /* Пробуем сделать следующий ход */
    	    moveNum--;
    	    i = GameRepo.deskRow[moveNum];
    	    j = GameRepo.deskCol[moveNum];
    	    moveNum++;
    	}


/*===========================================	
Cycle*/
    	private static Point findNextMove() {
			
    		Point[] avialableMoves = GameRepo.historyAvialableMoves.get(moveNum);
			
    		for (Point point : avialableMoves) {
				if(point != null) {
					GameRepo .historyAvialableMoves.remove(point);
					return point; };
			}
    		
			
			return null;			
		}



		//==============================================
 

    	    
//    	    System.out.println();
//    	    for (a = 0; a < deskSize*deskSize; a++) {
//    	    
//    	    		point.setRow(deskRow[a]);
//    	    		point.setCol(""+deskCol[a]);
//    	    		Controller.points.add(point);
//    	  
//    	    for (Point p : Controller.points) {
//    			System.out.println(p);
//    		}
    	    
    	



    		
    	

    	
    	
    	
    	
    	
    	//-----------------
    	
    	
    	
//    	
//    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
//    		System.out.println("How many Result?: "); 
//    		int calculators = 1; //Integer.parseInt(reader.readLine());	
//    		
//    		MainPathThread mainPathThread = new MainPathThread();
//    		Thread mainThread = new Thread(mainPathThread);
//    		mainThread.start();
//    		mainThread.join();
    		
    
    		
//    		TeleGenuisV4[] taskGenius = new TeleGenuisV4[calculators];  //создаем массив задач для потоков
//    		for (int i = 0 ; i < taskGenius.length; i ++) {	
//    			taskGenius[i] = new TeleGenuisV4(i, deskSize);  //создаем массив задач для жуков    			     
//    			}
//    		
//    		Thread[] genius = new Thread[calculators];               //в цикле делаем из массива задач массив потоков
//    		for (int i = 0; i < genius.length; i++) {
//    			genius[i] = new Thread(taskGenius[i]);
//    		}
//    			
//    		System.out.println("Start calculating");                 //запускаем потоки
//    		for (int i = 0; i < genius.length; i++) {                  //в цикле запускаем потоки из массива
//    			genius[i].start();
//    		}
//    		
//    		for (int i = 0; i < genius.length - 1; i++) {           //расстановка оиданий всех потоков в цикле
//    			genius[i].join();
//    		}
//    		
    		
    		
			
    		
//======================================================================================================
//Main
 
public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
  	
  startPoint.setCol(0);
  startPoint.setRow(0);
	
  theHamiltonCycle();
  	   
  }

//==========================================
//Cycle	
    		

} 	
    
    


    


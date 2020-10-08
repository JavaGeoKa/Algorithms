import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

	
//	public static List<Move> avialableMoves = Collections.synchronizedList(new ArrayList<Move>());   //список ходов
//	public static List<Point> points = Collections.synchronizedList(new ArrayList<Point>());   //список точек с доступными ходами

	//тут надо создать мепу с доступными на ходу точками
	Map <Integer, Point[]> startPoints = new HashMap<>();
	static Point startPoint = new Point();
	static Point endPoint = new Point();
	
	
	
	// Параметры Шахматной доски и варианты разрешенных ходов из текущей позиции коня
	static int deskSize = 8;
    static boolean deskCell[][] = new boolean[deskSize][deskSize];
    static String deskCellColName[] = {"a", "b", "c", "d", "e", "f", "g", "h"};
    static int deskRow[] = new int[deskSize*deskSize];      //репозиторий
    static int deskCol[] = new int[deskSize*deskSize];
    static int deskMov1[] = {-2, -1, 1, 2, 2, 1, -1, -2};			//ходы 
    static int deskMov2[] = {1, 2, 2, 1, -1, -2, -2, -1};
   
	   // Начальная позиция коня и общее количество ходов..
	   static int i;
	   static int j;
	   static int moveNum = 0;
		

	
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
    	
    	
    	theHamiltonCycle();
    	
    		
    	   
    }



    	static void theHamiltonCycle() {    	
    		int a, b, e;
    	    /* Пометить клетку как посещенную и запомнить координаты клетки */
    	    deskCell[i][j] = true; 
    	    
    	    startPoint.setCol(i);
    	    startPoint.setRow(j);
    	    
    	    deskRow[moveNum] = i;
    	    deskCol[moveNum] = j;
    	    moveNum++;
    	    
//    	    достать все возможные ходы
//     	   выбрать ход который выбираем
//          записать в мепу номер хода и доступные ходы, не совпадающие с выбраным

    	    /* Проверить 8 (Буква Г) возможных перемещений коня */
    	    for (a = 0; a < deskSize; a++) {                      //проходим по 
    	        /* Если все ходы сделаны, печатаем их */
    	        if (moveNum >= deskSize*deskSize) {
    	            printDesk();
    	            System.exit(0);
    	        }

    	        /* Определяем колонку и строку для следующего хода */
    	        b = i + deskMov1[a];
    	        e = j + deskMov2[a];

    	        /* Проверяем, что после выполенения хода конь остается на шахматной доске */
    	        if (b < 0 || b > deskSize - 1 || e < 0 || e > deskSize - 1) continue; 

    	        /* Проверяем, были ли мы уже в этой клетке */
    	        if (deskCell[b][e]) continue; 
    	          
    	        i = b; j = e;

    	          
    	        theHamiltonCycle();
    	    } 

    	    /* Уменьшить счетчик ходов и попробовать сделать следующий ход */
    	    moveNum--;
    	    /* Освобождаем клетку, ранее занятую конем */
    	    deskCell[deskRow[moveNum]][deskCol[moveNum]] = false;
    	    /* Пробуем сделать следующий ход */
    	    moveNum--;
    	    i = deskRow[moveNum];
    	    j = deskCol[moveNum];
    	    moveNum++;
    	}
    	   

    	static void printDesk( ) {
    	    int a;
    	    Point point = new Point();
    	    
    	    
    	    for (a = 0; a < deskSize*deskSize; a++) {
    	    	
    	        System.out.printf("%s%d ", deskCellColName[deskCol[a]], deskRow[a] + 1);

    	    }
    	    
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
    	    
    	}



    		
    	}

    	
    	
    	
    	
    	
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
    		
    		
			
    		
    		
    		

    	
    
    


    


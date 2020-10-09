package Genuis;
import java.util.HashMap;
import java.util.Map;

public class TeleGenuisV2 {
    
	
//	Map repository = new HashMap<>();
	
    // Параметры Шахматной доски и варианты разрешенных ходов из текущей позиции коня
    final int deskSize = 8;
    boolean deskCell[][] = new boolean[deskSize][deskSize];
    String deskCellColName[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    int deskRow[] = new int[deskSize*deskSize];
    int deskCol[] = new int[deskSize*deskSize];
    int deskMov1[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    int deskMov2[] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    int deskTempRow[] = new int[deskSize];
    int deskTempCol[] = new int[deskSize];
    
    
    // Начальная позиция коня и общее количество ходов..
    int i, j;
    int moveNum = 0;
    int c = 0;
    
    //
    TeleGenuisV2() {
        
    }
    
    //
    // Hamilton's Cycle Algorithm..
    //
    void theHamiltonCycle() {
        int a, b, e;
        /* Пометить клетку как посещенную и запомнить координаты клетки */
        deskCell[i][j] = true;
        deskRow[moveNum] = i;
        deskCol[moveNum] = j;
        moveNum++;
        c++;

        /* Проверить 8 (Буква Г) возможных перемещений коня */
        for (a = 0; a < deskMov1.length; a++) {
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
            
            // Вот в этом месте почему такие результаты в точке 0-0?
//            System.out.println("Avialable Move " + a + "   point " + b + e);
            i = b; j = e;
            
            
            //сохранить результат последний
            deskTempRow[a] = i;
            deskTempCol[a] = j;
            
//            System.out.println(deskTempCol.length);
              
//            
        } 
        
        
        //получить i и j
        for (int i = 0; i < deskTempCol.length; i++) {
        	if (deskTempCol[i]==) {
        		System.out.println(deskTempCol[i]);
        	}
			
		}
        
        
//        theHamiltonCycle();
        
        
//        /* Уменьшить счетчик ходов и попробовать сделать следующий ход */
//        moveNum--;
//        /* Освобождаем клетку, ранее занятую конем */
//        deskCell[deskRow[moveNum]][deskCol[moveNum]] = false;
//        /* Пробуем сделать следующий ход */
//        moveNum--;
//        i = deskRow[moveNum];
//        j = deskCol[moveNum];
//        moveNum++;
    }
    
    void printDesk( ) {
        int a;
        
        System.out.println(c);
                
        for (a = 0; a < deskSize*deskSize; a++) {
            System.out.printf("%s%d ", deskCellColName[deskCol[a]], deskRow[a] + 1);
        }
        
        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TeleGenuisV2().theHamiltonCycle();
    }
    
}
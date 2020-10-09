package Repo;

import java.util.HashMap;
import java.util.Map;

import Model.Point;

public class GameRepo {

	public static Map <Integer, Point[]> historyAvialableMoves = new HashMap<>();
	static Point startPoint = new Point();
	static Point endPoint = new Point();
	static int deskSize = 8;
	
	
	
	public static int deskRow[] = new int[deskSize *deskSize];      //репозиторий
    public static int deskCol[] = new int[deskSize*deskSize];
	
}

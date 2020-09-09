//Цель : вы указали уже напечатанный символ «А». Вам разрешено выполнять только 2 операции -
//
//Копировать все - эта операция скопирует все напечатанные символы.
//Вставить - эта операция вставит все символы, которые уже скопированы.
//Учитывая число N, напишите алгоритм для печати символа 'A' ровно N раз с минимальным количеством операций (либо скопировать все, либо вставить)




package algoritms.arrays.tasks;
public  class  CharCopyAndPasteMinIter {

	public  int  find ( int  number ) {
	    	 int res = 0;
	         for(int i=2;i<=number;i++){
	             while(number%i == 0){ //check if problem can be broken into smaller problem
	                 res+= i; //if yes then add no of smaller problems to result. If number = 25  i = 5 then 5*5 = 25 so add 5 to results
	                 number=number/i; // create smaller problem
	             }
	         }
	         return res;
	     }
	    
	    public  static  void  main ( String [] args ) {
	    	CharCopyAndPasteMinIter m = new CharCopyAndPasteMinIter();
	        int n =  50 ;
	        System.out.println("Minimum Operations: " + m.find(n));
	    }
	}
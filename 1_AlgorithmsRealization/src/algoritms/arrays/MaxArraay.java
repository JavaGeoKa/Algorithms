package algoritms.arrays;


	public class MaxArraay {
	    public static void main(String[] args) {
	        int [] mas = new int[12];
	        int maxNumber = -16;
	        int maxIndex = 0;
	 
	        for (int i = 0; i < mas.length; i++) {
	            mas[i] = (int)(Math.random()*31)-15;
	            if(maxNumber <= mas[i]){
	                maxNumber = mas[i];
	                maxIndex = i;
	            }
	        }
	        
	        System.out.println("Индекс максимального элемента: " + maxIndex);
	    }
	}
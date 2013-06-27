package assignment6;

import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * @author Dylan Noaker
 * this is a template that I will use for timing things.
 * I can't currently conceive a way to "extend" this class but it 
 * sure will be helpful to have all of this copied down somewhere. 
 *
 */
public abstract class TimingSuite {
	//private t Thing;
	/*1=best
	 * 2=avg
	 * 3=worst
	 */
	private static int typeOfTest = 2;
	
	private static final int start = 100000;
	private static final int end = 1000001;
	private static final int increment = 25000;
	private final static int timesToLoop = 100;
	
	private static Random rand;
	private static long t1,tmid,tfinal,tfull,tempty;
	private static double tactual1,tactual2;

	public TimingSuite() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//print samples for excel
		for(int i = start; i<end; i+=increment){
	    	   System.out.println(i);
	       }
		//TODO call timing functions
		

	}
	
	public static void timeFoo(){
		for(int index = start; index<end; index+=increment){
			t1 = System.nanoTime();
			while(System.nanoTime() - t1>1000000000){
				//warmup
			}
			t1 = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++){
				//TODO time things here
			}
			tmid = System.nanoTime();
			//time overhead
			for(int i = 0; i<timesToLoop; i++){
				//TODO time overhead
			}
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(tactual1/1000000);
		}
	}
	public static ArrayList<Integer> generateCase(int size)
	{
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		switch(typeOfTest){
			case 1:
				for(int i = 0; i<size; i++){
					arr1.add(i);
				}
				break;
			case 2:
				for (int i = size; i>=0; i--)
					arr1.add(i);
				break;
			case 3:
				for(int i = 0; i<size; i++)
					arr1.add(rand.nextInt());
				break;
		}
		return arr1;
	}
}




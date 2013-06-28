package assignment6;

import java.util.ArrayList;
import java.util.Random;

public class TimeBST {
	/*1=best
	 * 2=avg
	 * 3=worst
	 * 4=balanced
	 */
	private static int typeOfTest = 4;
	private static BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
	
	private static final int start = 100000;
	private static final int end = 1000001;
	private static final int increment = 25000;
	private final static int timesToLoop = 100;
	
	private static Random rand;
	private static long t1,tmid,tfinal,tfull,tempty;
	private static double tactual1,tactual2;


	public TimeBST() {
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = start; i<end; i+=increment){
	    	   System.out.println(i);
	       }
		tree1 = generateCase(25);
			
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
	public static BinarySearchTree<Integer> generateCase(int size)
	{
		BinarySearchTree<Integer> arr1 = new BinarySearchTree<Integer>();
		switch(typeOfTest){
		//right heavy
			case 1:
				for(int i = 0; i<size; i++){
					arr1.add(i);
				}
				break;
		// left heavy
			case 2:
				for (int i = size; i>0; i--)
					arr1.add(i);
				break;
				//average case unbalanced ish
			case 3:
				for(int i = 0; i<size; i++)
					arr1.add(rand.nextInt());
				break;
			//balanced
			case 4:
				balancedCaseGenerator(arr1, size);
		}
		return arr1;
	}
	
	private static void balancedCaseGenerator (BinarySearchTree<Integer> bst, int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=size; i++)
			list.add(i);
		
		balancedCaseGenerator(size-1, 0, bst, list);
	}
	
	private static void balancedCaseGenerator (int high, int low, BinarySearchTree<Integer> bst, ArrayList<Integer> list)
	{
		if (low > high)
			return;
		else
		{
			int mid = ((high + low) / 2);
			bst.add(list.get(mid));
			balancedCaseGenerator(high, mid+1, bst, list);
			balancedCaseGenerator(mid-1, low, bst, list);
			return;
		}
	}

}

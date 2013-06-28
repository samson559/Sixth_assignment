package assignment6;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class TimeBST {
	/*1=best
	 * 2=avg
	 * 3=worst
	 * 4=balanced
	 */
	private static int typeOfTest = 3;
	private static BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();

	private static final int start = 1000;
	private static final int end = 10001;
	private static final int increment = 100;
	private final static int timesToLoop = 500;
	
	private final static int expSize = 100;

	private static Random rand;
	private static long t1,tmid,tfinal,tfull,tempty;
	private static double tactual1,tactual2;


	public TimeBST() {


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		rand = new Random();
		tree1 = generateCase(25);
		
		t1 = System.nanoTime();
		while(System.nanoTime() - t1<1000000000){ } //warmup
		
		timeFoo();
	}
	
	/**Main timing experiment method. Contains several experiments. Things are commented in/out as needed for each experiment.
	 * 
	 */
	public static void timeFoo()
	{
		for(int index = start; index<end; index+=increment)
		{
			//BSTs for Experiment One (Question 3)
			//BinarySearchTree<Integer> tree = experimentOne(index, true); //Randomized
			//BinarySearchTree<Integer> tree = experimentOne(index, false); //Sorted
			
			//Collections for Experiment Two (Question 4)
			//BinarySearchTree<Integer> tree = experimentOne(index, true);
			TreeSet<Integer> tree = experimentTwo(index);
			
			t1 = System.nanoTime();
			while(System.nanoTime() - t1<100000000) { } //warmup
			
			//Start timing
			t1 = System.nanoTime();
			
			for(int i = 0; i<timesToLoop; i++)
			{
				//Contains method test
				for (int j = 1; j <= index; j++)
					tree.contains(j);
			}
			
			//Overhead timing
			tmid = System.nanoTime();
			for(int i = 0; i<timesToLoop; i++)
			{
				for (int j = 0; j < index; j++) {} //Capture cost of loop
			}
			
			//End timing
			
			// calculate and print average time
			tfinal = System.nanoTime();
			tfull = tmid-t1;
			tempty = tfinal-tmid;
			tactual1 = (tfull-tempty)/timesToLoop;
			System.out.println(index + " " + tactual1/1000000);
		}
	}
	
	/**Experiment One from the analysis document. Creates a sorted list of integers 1 - size,
	 * then adds them to a BinarySearchTree in sorted order or random order, as specified.
	 * 
	 * @param size of desired BST
	 * @param randomized - true for a randomly arranged BST, false for a sorted (ie right-heavy) BST.
	 * @return A randomized or sorted BinarySearchTree of the specified size containing values 1 - size
	 */
	public static BinarySearchTree<Integer> experimentOne (int size, boolean randomized)
	{
		//Create an ArrayList of items in sorted order.
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i<=size; i++)
			list.add(i);
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		for(int i = 0; i<list.size(); i++)
		{
			int r=0; //Adds the first element from the ArrayList to the BST.
			if (randomized)
				r = rand.nextInt(list.size()); //Adds a random element from the ArrayList to the BST.
			
			bst.add(list.get(r));
			list.remove(r); //Removes from the ArrayList to ensure it isn't added twice.
		}
		
		return bst;
	}
	
	/**Experiment Two from the analysis document. Creates a list of integers 1 - size, and adds them
	 * to a TreeSet in a random order, and returns that TreeSet.
	 * 
	 * @param size of desired TreeSet
	 * @return TreeSet
	 */
	public static TreeSet<Integer> experimentTwo (int size)
	{
		//Create an ArrayList of items in sorted order.
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i<=size; i++)
			list.add(i);
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		for(int i = 0; i<list.size(); i++)
		{
			int r = rand.nextInt(list.size()); //Adds a random element from the ArrayList to the TreeSet.
			
			tree.add(list.get(r));
			list.remove(r); //Removes from the ArrayList to ensure it isn't added twice.
		}
		
		return tree;
	}
	
	
	/**Case generation for BinarySearchTree.
	 * 
	 * @param size - Desired size of BST
	 * @return a BST of specified case in static variable.
	 */
	public static BinarySearchTree<Integer> generateCase(int size)
	{
		BinarySearchTree<Integer> arr1 = new BinarySearchTree<Integer>();
		switch(typeOfTest)
		{
		//right heavy
		case 1:
			for (int i = 0; i>size; i++)
				arr1.add(i);
			break;
			
		// left heavy
		case 2:
			for (int i = size; i>0; i--)
				arr1.add(i);
			break;
		
		//average case unbalanced ish
		case 3:
			for(int i = 0; i<size; i++)
				arr1.add(rand.nextInt(size));
			break;
			
		//balanced
		case 4:
			balancedCaseGenerator(arr1, size);
		}
		return arr1;
	}

	/**Creates a balanced BinarySearchTree for testing purposes. Driver method.
	 * This is the method referred to in Question 5 of the analysis document.
	 * 
	 * @param bst - BST to be created
	 * @param size - Size of BST desired.
	 */
	private static void balancedCaseGenerator (BinarySearchTree<Integer> bst, int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=size; i++)
			list.add(i);

		balancedCaseGenerator(size-1, 0, bst, list);
	}

	/**Recursive helper method for balancedCaseGenerator.
	 * Splits up array into halves and adds the mid point of the upper and lower bound specified.
	 * 
	 * @param high - upper bound
	 * @param low - lower bound
	 * @param bst - BinarySearchTree
	 * @param list - ArrayList
	 */
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

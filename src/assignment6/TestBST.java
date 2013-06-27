package assignment6;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class TestBST extends TestCase {
	private BinarySearchTree<Integer> ourtree;

	protected void setUp() throws Exception {
		super.setUp();
		ourtree = new BinarySearchTree<Integer>();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * test add
	 * corner case: when tree is empty
	 */
	public void testAdd2(){
		assertTrue(ourtree.add(1));
	}
	/**
	 * test add
	 * general cases: adding things to the left and right
	 */
	public void testAdd3(){
		assertTrue(ourtree.add(2));
		assertTrue(ourtree.add(1));
		assertTrue(ourtree.add(3));
	}
	/**
	 * test add
	 * fail case: duplicates
	 */
	public void testAdd4(){
		assertTrue(ourtree.add(1));
		assertFalse(ourtree.add(1));
	}
	/**
	 * test add
	 * corner case: out of order add to the left
	 */
	public void testAdd5(){
		assertTrue(ourtree.add(3));
		assertTrue(ourtree.add(1));
		assertTrue(ourtree.add(2));
		ArrayList<Integer> temp = ourtree.toArrayList();
		for(int i=1; i<=3;i++)
			assertEquals(i,(int)temp.get(i-1));
	}
	/**
	 * corner case: out of order add to the right
	 */
	public void testAdd6(){
		assertTrue(ourtree.add(3));
		assertTrue(ourtree.add(5));
		assertTrue(ourtree.add(4));
		ArrayList<Integer> temp = ourtree.toArrayList();
		ArrayList<Integer> result = new ArrayList<Integer>();
		//I trust java enough to call this the truth
		for(int i=3; i<=5;i++)
			result.add(i);
		for(int i = 0; i<3; i++)
			assertEquals(result.get(i), temp.get(i));
			
	}
	/**
	 * test addall
	 * empty case: add to a new tree
	 */
	public void testaddAll(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++)
			temp.add(i);
		assertTrue(ourtree.addAll(temp));
		for(int i = 1; i<=5; i++)
			assertTrue(ourtree.contains(i));
		
	}
	/**
	 * test addall
	 * gen case: some items in tree.
	 */
	public void testaddAll2(){
		ourtree.add(6);
		ourtree.add(8);
		ourtree.add(20);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++)
			temp.add(i);
		assertTrue(ourtree.addAll(temp));
		for(int i = 1; i<=5; i++)
			assertTrue(ourtree.contains(i));
		
	}
	/**
	 * test addall
	 *fail case: adding all duplicates
	 */
	public void testaddAll3(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++)
			temp.add(i);
		assertFalse(ourtree.addAll(temp));
		for(int i = 1; i<=5; i++)
			assertTrue(ourtree.contains(i));
		
	}
	/**
	 * test addall
	 *fail case: adding nullness
	 */
	public void testaddAll4(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++){
			if(i%2 ==0)
				temp.add(null);
			else
				temp.add(i);
		}
			
		try{
			ourtree.addAll(temp);
			assertTrue("failed to throw null pointer exception when adding list of nulls",false);
		}catch(NullPointerException n){
			assertTrue(true);
		}
		
	}
	/**
	 * test addall
	 *fail case ish: adding nothing 
	 */
	public void testaddAll5(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();		
		assertFalse(ourtree.addAll(temp));
	}
	/**
	 * test addall
	 *corner case: some dupes 
	 */
	public void testaddAll6(){
		for(int i = 1; i<=2; i++)
			ourtree.add(i);
		
		ArrayList<Integer> temp = new ArrayList<Integer>();	
		for(int i = 1; i<=5; i++)
			temp.add(i);
		assertTrue(ourtree.addAll(temp));
		assertEquals(temp,ourtree.toArrayList());
	}
	public void testClear(){
		for(int i = 1; i<=2; i++)
			ourtree.add(i);
		ourtree.clear();
		assertEquals(0,ourtree.size());
		for(int i = 1; i<=2; i++)
			assertFalse(ourtree.contains(i));
		
	}
	/**test contains
	 * true case
	 */
	public void testContains(){
		ourtree.add(1);
		assertTrue(ourtree.contains(1));
		assertTrue(ourtree.size()==1);
		assertTrue(ourtree.toArrayList().get(0) == 1);
		
	}
	/**test contains
	 * false case
	 */
	public void testContains2(){
		ourtree.add(1);
		assertFalse(ourtree.contains(2));
		assertTrue(ourtree.size()==1);
		assertTrue(ourtree.toArrayList().get(0) == 1);
		
	}
	/**test contains
	 * true case
	 */
	public void testContains3(){
		try{
			ourtree.contains(null);
			assertTrue(false);
		}
		catch(NullPointerException n){
			assertTrue(true);
		}
		
	}
	/**
	 * test containsall
	 * general true case
	 */
	public void testContainsall(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(4);
		result.add(3);
		result.add(5);
		
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertTrue(ourtree.containsAll(result));
	}
	/**
	 * test contains all 
	 * falseness
	 */
	public void testContainsAll3(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(9);
		result.add(8);
		
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertFalse(ourtree.containsAll(result));
	}
	/**
	 * test contains all 
	 * false corner case
	 */
	public void testContainsAll2(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(9);
		result.add(4);
		
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertFalse(ourtree.containsAll(result));
	}
	/** test first gen gase
	 * 
	 */
	public void testFirst(){
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertEquals(1, (int)ourtree.first());
	}
	/**
	 * test first right heavy
	 */
	public void testFirst2(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		assertEquals(1, (int)ourtree.first());
	}
	/**
	 * test first left heavy
	 */
	public void testFirst3(){
		for(int i = 5; i>=1; i--)
			ourtree.add(i);
		assertEquals(1, (int)ourtree.first());
	}
	/**
	 * test first
	 * fail case
	 */
	public void testFirst4(){
		
		try{
			ourtree.first();
			assertTrue(false);
		}
		catch (NoSuchElementException n){
			assertTrue(true);
		}
	}
	
	
	/**
	 * test Last
	 * gen case, semi balanced
	 */
	public void testLast(){
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertEquals(6,(int)ourtree.last());
		
	}
	/**
	 * test last right heavy
	 */
	public void testlast2(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		assertEquals(5, (int)ourtree.last());
	}
	/**
	 * test last left heavy
	 */
	public void testlast3(){
		for(int i = 5; i>=1; i--)
			ourtree.add(i);
		assertEquals(5, (int)ourtree.last());
	}
	/**
	 * test last
	 * fail case
	 */
	public void testlast4(){
		
		try{
			ourtree.last();
			assertTrue(false);
		}
		catch (NoSuchElementException n){
			assertTrue(true);
		}
	}
	/**
	 * test is empty
	 * gen case
	 */
	public void testIsEmpty(){
		ourtree.add(1);
		ourtree.remove(1);
		assertTrue(ourtree.isEmpty());
		assertTrue(ourtree.size()==0);
		
	}
	/**
	 * fail case
	 */
	public void testIsEmpty2(){
		ourtree.add(1);
		
		assertFalse(ourtree.isEmpty());
		assertFalse(ourtree.size()==0);
		
	}
	/**
	 * test remove
	 * case 1: remove a leaf
	 */
	public void testRemove(){
		for(int i = 1; i<=5; i++)
			ourtree.add(i);
		assertTrue(ourtree.doyleRemove(5));
		assertFalse(ourtree.contains(5));
		assertEquals(4,ourtree.size());
		
	}
	/**
	 * test remove
	 * case 1: remove a leaf
	 */
	public void testRemove2(){
		for(int i = 5; i>=1; i--)
			ourtree.add(i);
		assertTrue(ourtree.doyleRemove(1));
		assertFalse(ourtree.contains(1));
		assertEquals(4,ourtree.size());
		
	}
	/**
	 * test remove
	 * case 2: remove a subtree with one child
	 */
	public void testRemove3(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 1; i<=5; i++){
			ourtree.add(i);
			result.add(i);
		}
		assertTrue(ourtree.doyleRemove(2));
		assertFalse(ourtree.contains(2));
		assertEquals(4,ourtree.size());
		
	}
	/**
	 * test remove
	 * remove the root
	 */
	public void testRemove4(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i<=5; i++){
			ourtree.add(i);
			result.add(i);
		}
		assertTrue(ourtree.doyleRemove(1));
		assertFalse(ourtree.contains(1));
		assertEquals(5,ourtree.size());
		
	}
	/**test remove
	 * case 2: 2 children
	 */
	public void testremove5(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(4);
		result.add(3);
		result.add(5);
		result.add(2);
		result.add(1);
		result.add(6);
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		
		assertTrue(ourtree.doyleRemove(3));
		assertFalse(ourtree.contains(3));
		assertEquals(5,ourtree.size());

	}
	/**test remove
	 * case 3: successor
	 */
	public void testremove6(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(4);
		result.add(3);
		result.add(5);
		result.add(2);
		result.add(1);
		result.add(6);
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertTrue(ourtree.doyleRemove(4));
		assertFalse(ourtree.contains(4));
		assertEquals(5,ourtree.size());

	}

	/**
	 * test to arraylist
	 * general case: some items.
	 */
	public void testToArrayList(){
		Integer[] temp = new Integer[6];
		for(int i =1; i<=5; i++){
			ourtree.add(i);
			temp[i-1] = i;
		}
		ArrayList<Integer> temp2 = ourtree.toArrayList();
		for(int i =0; i<5; i++)
			assertEquals(temp[i],temp2.get(i));
	}
	/**
	 * test remove all gen case
	 */
	public void testremoveall(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(4);
		result.add(3);
		result.add(5);
		
		
		
		ourtree.add(4);
		ourtree.add(3);
		ourtree.add(5);
		ourtree.add(2);
		ourtree.add(1);
		ourtree.add(6);
		assertTrue(ourtree.removeAll(result));
		assertFalse(ourtree.containsAll(result));
		assertTrue(ourtree.size()==3);
		assertTrue(ourtree.contains(1));
		assertTrue(ourtree.contains(2));
		assertTrue(ourtree.contains(6));
		

			
	}
	/**
	 * test remove all fail case
	 */
	public void testremoveall2(){
		for(int i = 5; i>=0; i--)
			ourtree.add(i);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(20);
		result.add(69);
		result.add(55);
		assertFalse(ourtree.removeAll(result));
	}
	/**
	 * test remove all corner case
	 */
	public void testremoveall3(){
		for(int i = 5; i>=0; i--)
			ourtree.add(i);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(3);
		result.add(55);
		assertTrue(ourtree.removeAll(result));
	}
	/**
	 * test remove all error thing
	 */
	public void testremoveall4(){
		for(int i = 5; i>=0; i--)
			ourtree.add(i);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(3);
		result.add(null);
		try{
			ourtree.removeAll(result);
			assertTrue(false);
		}
		catch(NullPointerException n){
			assertTrue(true);
		}
	}
	

}

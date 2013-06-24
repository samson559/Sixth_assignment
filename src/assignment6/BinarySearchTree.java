package assignment6;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;




/**
 * 
 * @author Dylan Noaker
 * This is a binary search tree.
 *
 * @param <Type> whatever type you want to store
 */

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	private BinaryNode root;
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		root = new BinaryNode(null,null,null);
	}
	 /**
	   * Ensures that this set contains the specified item.
	   * 
	   * @param item
	   *          - the item whose presence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if the input item was actually inserted); otherwise, returns false
	   * @throws NullPointerException
	   *           if the item is null
	   */
	/*
	 * start at root
	 * when we get to the correct branch, make an assignment
	 * else, recursivley compare our way down the tree using this method.
	 * 
	 */
	  public boolean add(Type item){
		 return false;
		  
	  }

	  /**
	   * Ensures that this set contains all items in the specified collection.
	   * 
	   * @param items
	   *          - the collection of items whose presence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if any item in the input collection was actually inserted);
	   *         otherwise, returns false
	   * @throws NullPointerException
	   *           if any of the items is null
	   */
	  public boolean addAll(Collection<? extends Type> items){
		return false;
		  
	  }

	  /**
	   * Removes all items from this set. The set will be empty after this method
	   * call.
	   */
	  public void clear(){
		 this.root =null;
	  }

	  /**
	   * Determines if there is an item in this set that is equal to the specified
	   * item.
	   * 
	   * @param item
	   *          - the item sought in this set
	   * @return true if there is an item in this set that is equal to the input
	   *         item{ otherwise, returns false
	   * @throws NullPointerException
	   *           if the item is null
	   */
	    public boolean contains(Type item) throws NullPointerException
	  	  {
	  		  if (item == null)
	  			  throw new NullPointerException();
	  		  //starting at the root
	  		  BinaryNode temp = root;
	  		  //while we aren't at a leaf
	  		  while (temp != null)
	  		  {
	  			  switch (temp.data.compareTo(item)) 
	  			  {
	  			  case -1:
	  				  temp = temp.getRight();
	  				  break;
	  			  case 0:
	  				  return true; //Contains the item
	  			  case 1:
	  				  temp = temp.getLeft();
	 				  break;
	 			  } 
	 		  }
			  
			  //Will reach this point when temp is null.
 		  return false;
	   		  
	   	  }


	  /**
	   * Determines if for each item in the specified collection, there is an item
	   * in this set that is equal to it.
	   * 
	   * @param items
	   *          - the collection of items sought in this set
	   * @return true if for each item in the specified collection, there is an item
	   *         in this set that is equal to it{ otherwise, returns false
	   * @throws NullPointerException
	   *           if any of the items is null
	   */

	  public boolean containsAll(Collection<? extends Type> items){
		   
		  for(Type item: items){
			return(this.contains(item));
		}
		return false;
		  
	  }

	  /**
	   * Returns the first (i.e., smallest) item in this set.
	   * 
	   * @throws NoSuchElementException
	   *           if the set is empty
	   */
	  public Type first() throws NoSuchElementException{
		  if(root.data == null)
			  throw new NoSuchElementException();
		  if(root.left!=null)
			  return root.getLeftmostNode().data;
		  else
			  return root.data;
		  
	  }

	  /**
	   * Returns true if this set contains no items.
	   */
	  public boolean isEmpty(){
		return false;
		  
	  }

	  /**
	   * Returns the last (i.e., largest) item in this set.
	   * 
	   * @throws NoSuchElementException
	   *           if the set is empty
	   */
	  public Type last() throws NoSuchElementException{
		return null;
		  
	  }

	  /**
	   * Ensures that this set does not contain the specified item.
	   * 
	   * @param item
	   *          - the item whose absence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if the input item was actually removed){ otherwise, returns false
	   * @throws NullPointerException
	   *           if the item is null
	   */
	  public boolean remove(Type item){
		return false;
		  
	  }
		  

	  /**
	   * Ensures that this set does not contain any of the items in the specified
	   * collection.
	   * 
	   * @param items
	   *          - the collection of items whose absence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if any item in the input collection was actually removed){
	   *         otherwise, returns false
	   * @throws NullPointerException
	   *           if any of the items is null
	   */
	  public boolean removeAll(Collection<? extends Type> items){
		return false;
		  
	  }

	  /**
	   * Returns the number of items in this set.
	   */
	  public int size(){
		return 0;
		  
	  }

	  /**
	   * Returns an ArrayList containing all of the items in this set, in sorted
	   * order.
	   */
	  public ArrayList<Type> toArrayList(){
		return null;
		  
	  }
	  public void writeDot(String filename)
		{
			try {
				PrintWriter output = new PrintWriter(new FileWriter(filename));
				output.println("graph g {");
				if(root != null)
					output.println(root.hashCode() + "[label=\"" + root + "\"]");
				writeDotRecursive(root, output);
				output.println("}");
				output.close();
			}
			catch(Exception e){e.printStackTrace();}
		}

		// Recursively traverse the tree, outputting each node to the .dot file
		private void writeDotRecursive(BinaryNode n, PrintWriter output) throws Exception
		{
			if(n == null)
				return;
			if(n.left != null)
			{
				output.println(n.left.hashCode() + "[label=\"" + n.left + "\"]");
				output.println(n.hashCode() + " -- " + n.left.hashCode());
			}
			if(n.right != null)
			{
				output.println(n.right.hashCode() + "[label=\"" + n.right + "\"]");
				output.println(n.hashCode() + " -- " + n.right.hashCode());
			}

			writeDotRecursive(n.left, output);
			writeDotRecursive(n.right, output);
		}

		private class BinaryNode 
		{
			// Since the outer BST class declares <Type>, we can use it here without redeclaring it for BinaryNode
			Type data;
			BinaryNode left;
			BinaryNode right;
			/**
			 * Construct a new node with known children
			 * 
			 */
			public BinaryNode(Type _data, BinaryNode _left, BinaryNode _right) 
			{
				data = _data;
				left = _left;
				right = _right;
			}

			/**
			 * Construct a new node with no children
			 * 
			 */
			public BinaryNode(Type _data) 
			{
				this(_data, null, null);
			}


			/**
			 * Getter method.
			 * 
			 * @return the node data.
			 */
			public Type getData() 
			{
				return data;
			}

			/**
			 * Setter method.
			 * 
			 * @param _data
			 *          - the node data to be set.
			 */
			public void setData(Type _data) 
			{
				data = _data;
			}

			/**
			 * Getter method.
			 * 
			 * @return the left child node.
			 */
			public BinaryNode getLeft() 
			{
				return left;
			}

			/**
			 * Setter method.
			 * 
			 * @param _left
			 *          - the left child node to be set.
			 */
			public void setLeft(BinaryNode _left) 
			{
				left = _left;
			}

			/**
			 * Getter method.
			 * 
			 * @return the right child node.
			 */
			public BinaryNode getRight() 
			{
				return right;
			}

			/**
			 * Setter method.
			 * 
			 * @param _right
			 *          - the right child node to be set.
			 */
			public void setRight(BinaryNode _right) 
			{
				right = _right;
			}


			/**
			 * Number of children
			 * Use this to help figure out which BST deletion case to perform
			 * 
			 * @return The number of children of this node
			 */
			public int numChildren()
			{
				int numChildren = 0;
				
				if(getLeft() != null)
					numChildren++;
				if(getRight() != null)
					numChildren++;
				
				return numChildren;
			}

			/**
			 * @return The leftmost node in the binary tree rooted at this node.
			 */
			public BinaryNode getLeftmostNode() 
			{
				// Base case, done for you
				if(getLeft() == null)
					return this; // returns "this" node

				// FILL IN - do not return null
				return getLeft().getLeftmostNode();
			}

			/**
			 * this method finds the right most node
			 * @return The rightmost node in the binary tree rooted at this node.
			 */
			public BinaryNode getRightmostNode() 
			{
				// Base case, done for you
				if(getRight() == null)
					return this; // returns "this" node

				// FILL IN - do not return null
				return getRight().getRightmostNode();
			}		

			/** 
			 * This method applies to binary search trees only (not general binary trees).
			 * 
			 * @return The successor of this node.
			 *  
			 * The successor is a node which can replace this node in a case-3 BST deletion.
			 * It is either the smallest node in the right subtree,
			 * or the largest node in the left subtree.
			 */
			public BinaryNode getSuccessor() 
			{	
				BinaryNode temp = this;
				if(getRight() != null)
					return this.getRight().getLeftmostNode();
				
				else if(getLeft() != null)
					return this.getLeft().getRightmostNode();
				else 
					return null;
			}
			
			/**
			 * @return The height of the binary tree rooted at this node. The height of a
			 * tree is the length of the longest path to a leaf node. Consider a tree with
			 * a single node to have a height of zero.
			 *  
			 * The height of a tree with more than one node is the greater of its two subtrees'
			 * heights, plus 1
			 */
			public int height() 
			{			
				int leftheight= 0 , rightheight = 0;
				BinaryNode temp = this;
				if(temp.getRight()==null&&temp.getLeft()==null)
					return 0;
				if(temp.getLeft() != null){
					leftheight= temp.getLeft().height();
				}
				if(temp.getRight() != null){
					rightheight = temp.getRight().height();
				}
				return Math.max(leftheight, rightheight)+1;
			}
		}	


	}




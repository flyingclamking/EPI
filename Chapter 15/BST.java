package chapter_15;

class BinarySearchTree<T extends Comparable<T>> {
	T data;
	BinarySearchTree<T> left, right;
	
	public BinarySearchTree(T data) {
		this.data = data;
	}
}

public class BST {
	
//	Problem 15.1: Write a function that takes as input the root of a 
//	binary tree whose nodes have a key field, and returns true 
//	if and only if the tree satisfies the BST property
	
	public static boolean isValidBST(BinarySearchTree<Integer> root) {
		if (root == null) {
			throw new NullPointerException();
		}
		
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean helper(BinarySearchTree<Integer> root, int min, int max) {
		if (root.data <= min || root.data >= max) {
			return false;
		}
		
		return helper(root.left, min, root.data) && helper(root.right, root.data, max);
	}
	

	
//	Problem15.2: Write a function that takes a BST T 
//	and a key k , and returns the first entry larger than k 
//	that would appear in an inorder traversal. 
//	If k is absent or no key larger than k is present, return null. 
	
	public static int findFirstLarger(BinarySearchTree<Integer> root, int key) {
		if (root == null) {
			return -1;
		}
		
		if (root.data > key) {
			int temp = findFirstLarger(root.left, key);
			return  temp == -1 ? root.data : temp;
		}
		
		return findFirstLarger(root.right, key);
	}
	
	public static int findFirstLargerKWithKExist(BinarySearchTree<Integer> root, int key) {
		boolean findKey = false;
		
		BinarySearchTree<Integer> curr = root;
		BinarySearchTree<Integer> first = null;
		
		while (curr != null) {
			if (curr.data == key) {
				findKey = true;
				curr = curr.right;
			} else if (curr.data > key) {
				first = curr;
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		
		return findKey ? first.data : -1;
	}
	
	
	//How would you build a BST of minimum possible height from a sorted array A?
	
	public static BinarySearchTree<Integer> buildBST(int[] data) {
		if (data == null || data.length == 0) {
			throw new IllegalArgumentException();
		}
		
		return buildHelper(data, 0, data.length - 1);
	}
	
	private static BinarySearchTree<Integer> buildHelper(int[] data, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = start + (end - start) / 2;
		BinarySearchTree<Integer> root = new BinarySearchTree<Integer>(data[mid]);
		root.left = buildHelper(data, mid + 1, end);
		root.right = buildHelper(data, start, mid - 1);
		
		return root;
	}
	
}

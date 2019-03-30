package schultz.gsu.avltree;

import schultz.gsu.binarytree.BinaryTreeNode;

public class Test {
	
	/*
	 * All the tests use the trees in the textbook, pages 1000-1001.
	 */
	
	public static void testBalanceLL() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> twenty = new BinaryTreeNode<Integer>(20);
		
		root.setLeftChild(twenty);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		tree.insert(5, root);
		
		tree.inOrder(tree.getRoot());
	}
	
	public static void testBalanceLR() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> twenty = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> thirtyFour = new BinaryTreeNode<Integer>(34);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> thirty = new BinaryTreeNode<Integer>(30);
		BinaryTreeNode<Integer> fifty = new BinaryTreeNode<Integer>(50);
		
		root.setLeftChild(twenty);
		root.setRightChild(thirtyFour);
		
		twenty.setLeftChild(five);
		
		thirtyFour.setLeftChild(thirty);
		thirtyFour.setRightChild(fifty);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		tree.insert(10, root);
		
		tree.inOrder(tree.getRoot());
	}
	
	public static void testBalanceRR() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> twentyFive = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> thirtyFour = new BinaryTreeNode<Integer>(34);
		
		root.setLeftChild(five);
		root.setRightChild(twentyFive);
		
		twentyFive.setRightChild(thirtyFour);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		tree.insert(50, root);
		
		tree.inOrder(tree.getRoot());
	}
	
	public static void testBalanceRL() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> thirtyFour = new BinaryTreeNode<Integer>(34);
		BinaryTreeNode<Integer> twentyFive = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> fifty = new BinaryTreeNode<Integer>(50);
		
		root.setLeftChild(five);
		root.setRightChild(thirtyFour);
		
		thirtyFour.setLeftChild(twentyFive);
		thirtyFour.setRightChild(fifty);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		tree.insert(30, root);
		
		tree.inOrder(tree.getRoot());
	}
	
	public static void main(String[] args) {
		//testBalanceLL();
		//testBalanceLR();
		//testBalanceRR();
		testBalanceRL();
	}

}

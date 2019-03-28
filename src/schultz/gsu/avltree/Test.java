package schultz.gsu.avltree;

import schultz.gsu.binarytree.BinaryTreeNode;

public class Test {
	
	public static void testBalanceLL() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> eight = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		
		root.setLeftChild(four);
		root.setRightChild(eight);
		
		four.setLeftChild(three);
		four.setRightChild(five);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		tree.insert(2, root);
		
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
		
		tree.inOrder(root);
	}
	
	public static void testBalanceRR() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> twentyFive = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> thirtyFour = new BinaryTreeNode<Integer>(34);
		
		BinaryTreeNode<Integer> fifty = new BinaryTreeNode<Integer>(50);
		
		root.setLeftChild(five);
		root.setRightChild(twentyFive);
		
		twentyFive.setRightChild(thirtyFour);
		
		thirtyFour.setRightChild(fifty);
		
		AVLTree<Integer> tree = new AVLTree<Integer>(root);
		
		System.out.println(tree.balanceFactor(thirtyFour));
		
		//tree.insert(50, root);
		
		//tree.inOrder(root);
	}
	
	public static void main(String[] args) {
		//testBalanceLL();
		//testBalanceLR();
		testBalanceRR();
	}

}

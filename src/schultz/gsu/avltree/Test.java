package schultz.gsu.avltree;

import schultz.gsu.binarytree.BinaryTreeNode;

public class Test {

	public static void main(String[] args) {
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

}

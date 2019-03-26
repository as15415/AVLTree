package schultz.gsu.avltree;

import schultz.gsu.binarysearchtree.BinarySearchTree;
import schultz.gsu.binarytree.BinaryTreeNode;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	public AVLTree(BinaryTreeNode<T> root) {
		super(root);
	}

}

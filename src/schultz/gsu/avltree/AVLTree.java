package schultz.gsu.avltree;

import schultz.gsu.binarysearchtree.BinarySearchTree;
import schultz.gsu.binarytree.BinaryTreeNode;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	public AVLTree(BinaryTreeNode<T> root) {
		super(root);
	}
	
	@Override
	public BinaryTreeNode<T> insert(T key, BinaryTreeNode<T> node) {
		BinaryTreeNode<T> insertedNode = super.insert(key, node);
		
		balance(insertedNode);
		
		return insertedNode;
	}
	
	public void delete(T key, BinaryTreeNode<T> node) {
		super.delete(key, node);
	}
	
	private void balance(BinaryTreeNode<T> node) {
		if(balanceFactor(node) > 1 || balanceFactor(node) < -1) { // node not balanced
			switch(balanceFactor(node)) {
				case -2:
					if(balanceFactor(node.getLeftChild()) == -1 || balanceFactor(node.getLeftChild()) == 0)
						balanceLL(node);
					else
						balanceLR(node);
					
					break;
						
				case 2:
					if(balanceFactor(node.getRightChild()) == 1 || balanceFactor(node.getRightChild()) == 0)
						balanceRR(node);
					else
						balanceRL(node);
					
					break;
			}
		}
		
		else if(node.getParent() != null)
			balance(node.getParent());
	}
	
	private void balanceLL(BinaryTreeNode<T> A) {
		BinaryTreeNode<T> B = A.getLeftChild();
		
		A.setLeftChild(B.getRightChild());
		B.setRightChild(A);
		
		B.setParent(null);
		
		super.setRoot(B);
	}
	
	private void balanceLR(BinaryTreeNode<T> y) {
		
	}
	
	private void balanceRR(BinaryTreeNode<T> y) {
		
	}
	
	private void balanceRL(BinaryTreeNode<T> y) {
		
	}
	
	public int balanceFactor(BinaryTreeNode<T> node) {
		return super.height(node.getRightChild()) - super.height(node.getLeftChild());
	}
}

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
	
	@Override
	public void delete(T key, BinaryTreeNode<T> node) {
		BinaryTreeNode<T> toDelete = search(key, node);
		
		if(toDelete.getLeftChild() == null) { // Case 1
			// find out how to connect the parent: as its left subtree or right?
			if(toDelete.getParent().getLeftChild() == toDelete) {
				if(super.isExternal(toDelete))
					toDelete.getParent().setNullLeftChild();
				else
					toDelete.getParent().setLeftChild(toDelete.getRightChild());
			}
			
			else {
				if(super.isExternal(toDelete))
					toDelete.getParent().setNullRightChild();
				else
					toDelete.getParent().setRightChild(toDelete.getRightChild());
			}
			
			balance(toDelete.getParent());
		}
		
		else { // Case 2
			BinaryTreeNode<T> rightMost = super.getRightMost(toDelete.getLeftChild());
			
			if(rightMost == toDelete.getLeftChild()) {
				toDelete.setElement(rightMost.getElement());
				
				if(rightMost.getLeftChild() == null)
					toDelete.setNullLeftChild();
				
				else
					toDelete.setLeftChild(rightMost.getLeftChild());
			}
		
			else {
				toDelete.setElement(rightMost.getElement());
				rightMost.getParent().setRightChild(rightMost.getLeftChild());
			}
			
			balance(rightMost.getParent());
		}
		
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
		
		if(node.getParent() != null)
			balance(node.getParent());
	}
	
	private void balanceLL(BinaryTreeNode<T> A) {
		BinaryTreeNode<T> B = A.getLeftChild();
		
		if(super.isRoot(A))
			super.setRoot(B);
		
		else {
			if(A.getParent().getLeftChild() == A)
				A.getParent().setLeftChild(B);
			
			else
				A.getParent().setRightChild(B);
		}
		
		if(B.getRightChild() == null)
			A.setNullLeftChild();
		
		else
			A.setLeftChild(B.getRightChild());
	
		B.setRightChild(A);
	}
	
	private void balanceLR(BinaryTreeNode<T> A) {
		BinaryTreeNode<T> B = A.getLeftChild();
		BinaryTreeNode<T> C = B.getRightChild();
		
		if(super.isRoot(A))
			super.setRoot(C);
		
		else {
			if(A.getParent().getLeftChild() == A)
				A.getParent().setLeftChild(C);
			
			else
				A.getParent().setRightChild(C);
		}
		
		if(C.getLeftChild() == null)
			B.setNullRightChild();
		
		else
			B.setRightChild(C.getLeftChild());
		
		if(C.getRightChild() == null)
			A.setNullLeftChild();
		
		else
			A.setLeftChild(C.getRightChild());
		
		C.setLeftChild(B);
		C.setRightChild(A);
	}
	
	private void balanceRR(BinaryTreeNode<T> A) {
		BinaryTreeNode<T> B = A.getRightChild();
		
		if(super.isRoot(A))
			super.setRoot(B);
		
		else {
			if(A.getParent().getLeftChild() == A)
				A.getParent().setLeftChild(B);
			
			else
				A.getParent().setRightChild(B);
		}
		
		if(B.getLeftChild() == null)
			A.setNullRightChild();
		else
			A.setRightChild(B.getLeftChild());
		
		B.setLeftChild(A);
	}
	
	private void balanceRL(BinaryTreeNode<T> A) {
		BinaryTreeNode<T> B = A.getRightChild();
		BinaryTreeNode<T> C = B.getLeftChild();
		
		if(super.isRoot(A))
			super.setRoot(C);
		
		
		else {
			if(A.getParent().getLeftChild() == A)
				A.getParent().setLeftChild(C);
			
			else
				A.getParent().setRightChild(C);
		}
		
		if(C.getLeftChild() == null)
			A.setNullRightChild();
		
		else
			A.setRightChild(C.getLeftChild());
		
		if(C.getRightChild() == null)
			B.setNullLeftChild();
		
		else
			B.setLeftChild(C.getRightChild());
		
		C.setLeftChild(A);
		C.setRightChild(B);
	}
	
	public int balanceFactor(BinaryTreeNode<T> node) {
		return super.nodeHeight(node.getRightChild()) - super.nodeHeight(node.getLeftChild());
	}
}

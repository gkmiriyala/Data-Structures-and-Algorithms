package helperClasses;

public class BinaryTreeNode {
	int data;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}
	
	public void setLeftChild(BinaryTreeNode leftNode){
		this.leftChild = leftNode;
	}
	
	public void setRightChild(BinaryTreeNode rightNode){
		this.rightChild = rightNode;
	}
}

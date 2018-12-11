package commonInterviewQuestions;

import java.util.ArrayList;

import helperClasses.BinaryTreeNode;
import helperClasses.MyLinkedList;
import helperClasses.TreeNode;

public class TreeInterviewQuestions {
	public static void main(String[] args) {

	}

	/*
	 * Given a sorted (increasing order) array with unique integer elements,
	 * write an algorithm to create a binary search tree with minimal height
	 */
	public static BinaryTreeNode createBinaryTreeFromArray(int[] uniqueNumbers, int left, int right) {
		int mid = (left + right) / 2;
		BinaryTreeNode node = new BinaryTreeNode(uniqueNumbers[mid]);
		node.setLeftChild(createBinaryTreeFromArray(uniqueNumbers, left, mid - 1));
		node.setRightChild(createBinaryTreeFromArray(uniqueNumbers, mid + 1, right));
		return node;
	}

	/*
	 * Determine if a binary tree is balanced
	 */

	/*
	 * Check if a binary tree is a BST
	 */

	/*
	 * Given a binary tree, design an algorithm which creates a linked list of
	 * all the nodes at each depth
	 */
	public ArrayList<MyLinkedList<TreeNode>> CreateLinkedListsFromTree(TreeNode root) {
		ArrayList<MyLinkedList<TreeNode>> result = new ArrayList<MyLinkedList<TreeNode>>();
		MyLinkedList<TreeNode> current = new MyLinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
			while (current.size() > 0) {
				result.add(current);
				MyLinkedList<TreeNode> parent = current;
				current = new MyLinkedList<TreeNode>();
				for (TreeNode p : parent) {
					if (p.getLeftChild() != null)
						current.add(p.getLeftChild());
					if (p.getRightChild() != null)
						current.add(p.getRightChild());
				}
			}
		}
		return result;
	}
}

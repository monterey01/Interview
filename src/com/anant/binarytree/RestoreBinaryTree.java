package com.anant.binarytree;

import java.util.Stack;

public class RestoreBinaryTree {

	// Solution to
	// https://codefights.com/interview-practice/task/AaWaYxi8gjtbqgp2M/description

	static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int preOrder[] = { 4, 2, 1, 5, 3, 6};
		int inOrder[] = { 1, 2, 4, 3, 5, 6 };

		int intOrderRootPosition = 0;
		for (int i = intOrderRootPosition; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				intOrderRootPosition = i;
				break;
			}
		}
		// 5 10 15 23 21 12
		// 23 21 15 10 12 5
		Tree<Integer> root = new Tree<Integer>(preOrder[0]);
		buildTree( inOrder,preOrder,0,inOrder.length-1,0);

	}

	public static Tree<Integer> buildTree(int in[], int pre[], int inStrt, int inEnd, int preIndex) {

		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Preorder traversal using preIndex and increment
		 * preIndex
		 */
		Tree<Integer> tNode = new Tree<Integer>(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.value);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1, preIndex);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd, preIndex);

		return tNode;

	}

	static int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				return i;
		}
		return i;
	}
}

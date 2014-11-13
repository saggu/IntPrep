package edu.usc.preparation;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
	
	int value;
	Tree left = null;
	Tree right = null;
	
	public Tree(int d, Tree left, Tree right) //initialize 
	{
		this.value = d;
		this.left = left;
		this.right = right;
	}
	
	public void insertNode(Tree root, Tree newTree) //Binary Search tree Implementation
	{
		 if(newTree.value <= root.value)
	        {
	            if(root.left == null)
	            {
	                root.left = newTree;
	            }
	            else
	            {
	                insertNode(root.left, newTree);
	            }
	        }
	        else
	        {
	            if(root.right == null)
	            {
	                root.right = newTree;
	            }
	            else
	            {
	                insertNode(root.right, newTree);
	            }
	        }
	}
	
			public Tree createTreeFromArray(int[] A){
				
				Tree root = new Tree(A[0],null,null);
				
				for(int i=1;i<A.length;i++){
					root.insertNode(root, new Tree(A[i], null, null));
				}
				
				return root;
		
			}
		 
		 public void InOrder(Tree root) //Recursive Inorder Traversal
		    {
		        
		        if(root == null)
		        {
		            return;
		        }
		        else
		        {
		            InOrder(root.left);
		            System.out.print(root.value +" ");
		            InOrder(root.right);
		        }
		        
		    }
		 
		 public int maxDepth(Tree root) //Find the maximum depth of the tree recursively
		 {
			 if(root == null)
			 {
				 return 0;
			 }
			 
			 return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
		 }
		 
		 public int minDepth(Tree root) //Find the minimum depth of the tree recursively
		 {
			 if(root == null)
			 {
				 return 0;
			 }
			 
			 return 1 + Math.min(minDepth(root.left),minDepth(root.right));
		 }
		 
		 public boolean isParent(Tree root, Tree p) //returns true if root is ancestor of p
		 {
			 if(root == null) return false;
			 if(root == p) return true;
			 return (isParent(root.left,p) || isParent(root.right,p));
			 
		 }
		 
		 public Tree commonAncestor(Tree root, Tree p, Tree q) //returns the common ancestor of p and q, if exists
		 {
			 if(isParent(root.left,p) && isParent(root.left,q))
			 	 return commonAncestor(root.left, p, q);
			 
			 if(isParent(root.right,p) && isParent(root.right,q))
			 	 return commonAncestor(root.right, p, q);
			 
			 return root;
		 }
		 
		 public void printNodesAtDistanceK(Tree root, int[] path, boolean visited[],int pathLen, int k)
		 { 		//print all nodes at a distance of k from root
			 if(root == null) return;
			 
			 path[pathLen] = root.value;
			 visited[pathLen] = true;
			 pathLen++;
			 
			 if(root.left == null && root.right == null && pathLen-k-1 >=0 && visited[pathLen-k-1]==false)
			 {
				 System.out.print(root.value + " ");
				 visited[pathLen - k - 1] = true;
				 return;
			 }
			 
			 printNodesAtDistanceK(root.left, path, visited, pathLen, k);
			 printNodesAtDistanceK(root.right, path, visited, pathLen, k);
		 }
		 
		 public void distanceKNode(Tree root, int k)
		 {
			 int MAX_HEIGHT = root.maxDepth(root)-1;
			 int[] path = new int[MAX_HEIGHT];
			 boolean[] visited = new boolean[MAX_HEIGHT];
			 for(int i=0;i<MAX_HEIGHT;i++)
			 {
				 visited[i] = false;
			 }
			 printNodesAtDistanceK(root, path, visited, 0, k);
		 }
		 
		
		 
		 public boolean isLeaf(Tree node)  //returns true if node is  a leaf
		 {
			 return (node.left==null && node.right==null);
		 }
		 
		 public int distanceFromRoot(Tree root,Tree node, int distance) //returns the distance of node from root
		 {
			 
			 if(root == null) return -1;
			 
			 if(root.value == node.value) return distance;
			 
			 int l = distanceFromRoot(root.left,node, distance+1);
			 
			 return (l != -1) ? l : distanceFromRoot(root.right,node, distance+1);
				 
		 }
		 
		 public void distanceBetweenTwoNodes(Tree root,Tree node1, Tree node2) //prints distance between two nodes node1 and node2
		 {
			 Tree lca = commonAncestor(root, node1, node2);
			 
			 int distance = distanceFromRoot(root,node1, 0) + distanceFromRoot(root,node2, 0) - ( 2* distanceFromRoot(root,lca, 0));
			 
			 System.out.print("Distance between " + node1.value + " and " + node2.value + " is: " + distance);
		 }
		 
		 public void printNodesWithNoSiblings(Tree root) //prints all the nodes with no siblings
		 {
			 if(root == null) return;
			 
			 if(root.left != null && root.right != null) 
				 {
				 	printNodesWithNoSiblings(root.left);
				 	printNodesWithNoSiblings(root.right);
				 	
				 }
			 else if(root.left != null)
				 {
				 	System.out.print(root.left.value + " ");
				 	printNodesWithNoSiblings(root.left);
				 }
			 else if(root.right != null)
			 {
				 	System.out.print(root.right.value + " ");
				 	printNodesWithNoSiblings(root.right);
			 }
		 }
		 
		 public int checkHeight(Tree root){
			 
			 
			 if(root == null) return 0;
			 
			 int heightLeft = checkHeight(root.left);
			 
			 if (heightLeft == -1) return -1;
			 
			 int heightRight = checkHeight(root.right);
			 
			 if (heightRight == -1) return -1;
			 
			 int heightDiff =  heightLeft - heightRight;
			 
			 if(Math.abs(heightDiff) > 1){
				 return -1;
			 }else{
				 return Math.max(heightLeft, heightRight) + 1;
			 }
		 }
		 
		 public boolean isBalanced(Tree root){
			 
			 if(checkHeight(root) == -1)
				 return false;
			 else
				 return true;
		 }
		 
		 
		 public Tree createBSTFromArray(int[] array){
			 return createBSTFromArray(array,0,array.length-1);
		 }
		 
		 public Tree createBSTFromArray(int[] array, int start, int end){
			 
			 if(start > end) return null;
			 
			 int mid = (start+end)/2;
			 Tree root = new Tree(array[mid], null, null);
			 root.left = createBSTFromArray(array, start, mid-1);
			 root.left = createBSTFromArray(array, mid +1, end);
			 return root;
		 }
		 
		 
		 public ArrayList<LinkedList<Tree>> createLevelLinkedList(Tree root){
			 
			 ArrayList<LinkedList<Tree>> result = new ArrayList<LinkedList<Tree>>();
			 
			 LinkedList<Tree> current = new LinkedList<Tree>();
			 
			 if(root!=null) 
				 current.add(root);
			 
			 while(current.size() > 0){
				 
				 result.add(current);
				 
				 LinkedList<Tree> parents = current;
				 current = new LinkedList<Tree>();
				 for(Tree parent : parents){
					 
					 if(parent.left != null)
						 current.add(parent.left);
					 if(parent.right != null) 
						 current.add(parent.right);
				 }
			 }
			 
			 return result;
		 }
		 
		 public boolean checkBST(Tree root){
			 return checkBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
		 }
		 
		 public boolean checkBST(Tree root, int min, int max){
			 
			 if(root==null) return true;
			 
			 if(root.value <= min||root.value > max) return false;
			 
			 if (!checkBST(root.left,min,root.value) || !checkBST(root.right,root.value,max)){
				 return false;
			 }
			 
			 return true;
		 }
		 
//		 public Tree inOrderSuccessor(Tree root) {//assume it has a pointer to parent
//		
//			 if(root==null) return null;
//			 
//			 if(root.right!=null){
//				 return leftMostChild(root.right);
//			 }else{
//				 Tree q = root;
//				 Tree x = root.parent;
//				 
//				 while(x!=null &&	 x.left!=q){
//					 q=x;
//					 x=x.parent;
//				 }
//					 return x;
//			 }
//			 
//		 }
		 
		 public Tree leftMostChild(Tree root){
			 if(root==null) return null;
			 
			 while(root.left!=null){
				 root = root.left;
						
			 }
			 
			 return root;
		 }
		 
		 
		 public boolean containsTree(Tree t1,Tree t2){ //check it t2 is a subtree of t1)
			 
			 if(t2==null) return true;
			 
			 return subTree(t2,t1);
		 }
		 
		 
		 public boolean subTree(Tree t1, Tree t2){
			 
			 if(t1==null) return false;
			 
			 if(t1.value==t2.value){
				 if(matchTree(t1,t2))
					 return true;
			 }
			 
			 return (subTree(t1.left,t2) || subTree(t1.right,t2));
		 }
		 
		 public boolean matchTree(Tree t1, Tree t2){
			 
			 if(t1==null && t2==null) return true;
			 
			 if(t1==null || t2==null) return false;
			 
			 if(t1.value!=t2.value)return false;
			 
			 return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
		 }
		 
		 public void findSum(Tree node, int sum){//print all paths which sums to 'sum'
			 
			 int depth = maxDepth(node);
			 int[] path = new int[depth];
			 
			 findSum(node, sum, path,0);
			 
		 }
		 
		 public void findSum(Tree node, int sum, int[] path, int level){
			 
			 if(node==null) return;
			 
			 path[level] = node.value;
			 
			 int t=0;
			 for(int i=level;i>=0;i--){
				 t+=path[i];
				 
				 if(t==sum){
					 printPath(path,i,level);
				 }
			 }
			 
			 findSum(node.left,sum,path,level+1);
			 findSum(node.right,sum,path,level+1);
			 
			 path[level] = Integer.MIN_VALUE;
		 }
		 
		 public void printPath(int[] path ,int start, int end){
			 
			 for(int i =start;i<=end;i++){
				 System.out.print(path[i] + " ");
			 }
		 }
	}
	
	



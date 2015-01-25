package edu.usc.preparation;

public class TerTree {
    
    private int value;
    private TerTree left;
    private TerTree middle;
    private TerTree right;
    
    
    public TerTree(int value, TerTree left, TerTree middle, TerTree right) {
    
        this.value = value;
        this.left = left;
        this.middle = middle;
        this.right = right;
    }
    
    public void insertNode(TerTree root, int value){
        
        if(root == null){
            
            root = new TerTree(value,null,null,null);
        }
        else if(value < root.value){
            
            if(root.left == null){
                
                root.left = new TerTree(value,null,null,null);
            }
            else{
                
                insertNode(root.left,value);
            }
        }
        else if(value == root.value){
            
            if(root.middle == null){
                
                root.middle = new TerTree(value,null,null,null);
            }
            else{
                
                insertNode(root.middle,value);
            }
        }
        else if(value > root.value){
    
            if(root.right == null){
                
                root.right = new TerTree(value,null,null,null);
            }
            else{
                
                insertNode(root.right,value);
            }
        }
    }
    
    public void deleteNode(TerTree root, int value){
        root = delete(root,value);
    }
    
    public TerTree delete(TerTree root,int value){
        
        if(root==null)
            return null;
        
        if(value < root.value)
        {
            root.left = delete(root.left,value);
        }
        else if(value > root.value)
        {
            root.right = delete(root.right, value);
        }
        else
        {
            if(root.right == null)
            {
                return root.left;
            }
            if(root.left == null)
            {
                return root.right;
            }
            
            if(root.middle != null)
            {
                TerTree temp = root;
                while(temp.middle.middle != null)
                    temp = temp.middle;
                temp.middle = null;
            }
            else
            {
                TerTree temp = root;
                root.value = findMin(temp.right).value;
                root.right = deleteMin(temp.right);
                root.left = temp.left;
            }
            
        }
        
        return root;
    }
    
    public TerTree deleteMin(TerTree node){
        
        if(node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
    
    private TerTree findMin(TerTree node) { 
        if (node.left == null) 
            return node; 
        else
            return findMin(node.left); 
    } 
    
    public void inOrder(TerTree root){
        if(root==null)
            return;
        inOrder(root.left);
        inOrder(root.middle);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    
    public void preOrder(TerTree root){
        if(root==null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        preOrder(root.middle);
        System.out.print(root.value + " ");
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public TerTree getLeft() {
        return left;
    }
    public void setLeft(TerTree left) {
        this.left = left;
    }
    public TerTree getMiddle() {
        return middle;
    }
    public void setMiddle(TerTree middle) {
        this.middle = middle;
    }
    public TerTree getRight() {
        return right;
    }
    public void setRight(TerTree right) {
        this.right = right;
    }

}
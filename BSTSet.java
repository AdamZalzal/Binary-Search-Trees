/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstset;

/**
 *
 * @author adamzalzal
 */
public class BSTSet {
    private TNode root;
    public BSTSet() //empty constructor
    {
        root = null;
    }
    public BSTSet( int[] input ) //constructor from input list
    {   TNode k;
 
        this.root = new TNode(input[0],null,null); //make first item in list the root
        for(int i = 1; i<input.length;i++) //for each item in the input list
        {   k = this.root; //set counter to root
            
             while(true){ //run while loop to find proper position
            if(input[i]>k.element) //if input element is greater than this element interate right
            {
                if(k.right == null) //if counter is at last node of tree make a new node
                {
                    k.right = new TNode(input[i],null,null);
                    break;
                }
                k = k.right;
            }
            if(input[i]<k.element) // if input element is less thant this element iterate left
            {
                if(k.left == null) //if counter is at last node of tree make a new node
                {
                    k.left = new TNode(input[i],null,null); 
                    break;
                }
                k=k.left;
            }
             if(input[i] == k.element) //if input element equals this element break while loop
            {
                break;
            }
        }
            
        }
    }
    public boolean isIn(int v) 
    {
        if(this.root==null) //if tree is empty return false
        {
            return false;
        }
        TNode k = this.root;
         while(true){ //same while loop as constructor
            if(v>k.element)
            {
                if(k.right == null) //if counter is at end of tree return false
                {
                    return false;
                }
                k = k.right;
            }
            if(v<k.element)
            {
                if(k.left == null) //if counter is at end of tree return false
                {
                    return false;
                }
                k=k.left;
            }
            if(v == k.element) //if input equals counter
            {
                return true; //return true
            }
        }
    }
    ////the worst case runtime for the add function would be O(m) where m is the height of the tree
    public void add(int v){
        if(this.root == null) //if tree is empty make new node for root
        {
            this.root = new TNode(v,null,null);
            return;
        }
        TNode k = this.root;
        while(true){ //same while loop as constructor
            if(v>k.element)
            {
                if(k.right == null) //if at end of a branch add a new node
                {
                    k.right = new TNode(v,null,null);
                    break;
                }
                k = k.right;
            }
            if(v<k.element)
            {
                if(k.left == null)
                {
                    k.left = new TNode(v,null,null); //if at end of a branch add a new node
                    break;
                }
                k=k.left;
            }
            if(v == k.element) //if input equals counter element break while loop and finish method
            {
                break;
            }
        }
            
    }
    //the worst case runtime for the remove function would be O(m) where m is the height of the tree
    public boolean remove(int v){
        TNode k,target = null;
        int temp;
        int flag;
        k = this.root;
        if(this.root == null) //if empty return false
        {
            return false;
        }
        
        while(true){ //same loop as constructor
            
            if(v>k.element)
            {
                if(k.right == null) //if at end of tree
                {
                   return false; //return false
                    
                }
                if(k.right.element==v) //if the next element is equal to the input
                {
                    target = k.right; // store that element and set flag that it is on the right
                    flag = 0;
                    break;
                }
                k = k.right;
            }
            if(v<k.element) // if at end of tree
            {
                if(k.left == null) // return false
                {
                   return false;
                }
                if(k.left.element==v)//if the next element is equal to the input
                {
                    target = k.left; // store that element and set flag that it is on the left
                    flag = 1;
                    break;
                }
                k=k.left;
            }
           if (k.element ==v) // if k is equal to the input that means that it is the root
           {
               target = k;
               flag =2; // set flag accordingly
               break;
           }
           
            }
        if(flag ==0) // if element is on the right of k
        {
         if(target.right == null && target.left == null) //no children
            {
               k.right =null; //make it null
               
                return true;
            }
            else if(target.right!=null && target.left == null) //one child on right
            {
                  
                k.right = target.right; // replace with right
                return true;
            }
            else if(target.left!=null && target.right == null) // one child on left
            {
                 
                k.right = target.left; //replace with child on left
                return true;
            }
            else{ // two children
                
                target = target.right; //move right one
                while(target.left!=null) //move all the way to bottem left of tree
                {
                    target= target.left;
                }
                temp = target.element; //store element at bottom left in temp
                this.remove(temp); //remove that emelent
                k.right.element = temp; //place it where the input was
                return true;
        }
        }
        else if (flag ==1){ //same procedure as above but reversed
            if(target.right == null && target.left == null)
            {
               k.left =null;
                
                return true;
            }
            else if(target.right!=null&& target.left==null)
            {
                k.left = target.right;
                return true;
            }
            else if(target.left!=null && target.right==null)
            {
                k.left = target.left;
                return true;
            }
            else{
                
                target = target.left;
                while(target.right!=null)
                {
                    target= target.right;
                }
                temp = target.element;
                this.remove(temp);
                k.left.element = temp;
               
                return true;
        }
       
        }
        else //same proedure as above
        {
             if(target.right == null && target.left == null)
            {
               
                this.root=null;
                return true;
            }
            else if(target.right!=null&& target.left==null)
            {
                this.root = target.right;
                return true;
            }
            else if(target.left!=null && target.right==null)
            {
               this.root= target.left;
                
                return true;
            }
            else{
                
                target = target.left;
                
                while(target.right!=null)
                {
                    target= target.right;
                }
                
                temp = target.element;
                this.remove(temp);
                k.element = temp;
              this.root = k; //set counter as the root this time as the root has bee removed
                
                return true; 
            }
        }
        
    }
    //the runtime for copy is O(n*m) where m is the size of the input tree and n is the size of "this" tree
    public void Copy(TNode k) //recursive function to coppy contents of list into another list
    {
        if(k.right!=null) //if right node is not null
        {
            this.Copy(k.right); //move recursively right
        }
        if(k.left!=null) //if left is not null
        {
            this.Copy(k.left); //move recursively left
        }
        this.add(k.element); //once at tend of branch add that element to "this" list
    }
    ////the runtime for cut is O(n*m) where m is the size of the input list and n is the size of "this" list
    public void Cut(TNode k) // recusrive funciton to remove common items between to lists
    { boolean test; 
        if(k==null) // if this counter is null skip
    {
        
    }
    else{
         test = this.remove(k.element); // remove this element form list
         
          if(k.left!=null) // if left is not null
        {
            
            test = remove(k.left.element);  //remove left element and move recurisvely left
             
            this.Cut(k.left);
            
        }
        if(k.right!=null) // if right is not null
        {    
            test = remove(k.right.element);  // remove right element
            
            this.Cut(k.right); //move recursively right
            
        }
      
        
       this.remove(k.element); // remove this element
        
    }
    }
    //the runtime for union is the same as copy which is O(m*n) where m is the size of the input tree and n is the size of "this" tree
    public BSTSet union(BSTSet s)
    {
       BSTSet Uset = new BSTSet(); //empty tree
       Uset.Copy(this.root); //copy this tree to empty tree
       Uset.Copy(s.root); //add contents to new tree
        return Uset;
    }
    //the runtime for intersection is the same as copy and cut which is O(m*n) where m is the size of the input tree and n is the size of "this" tree
    public BSTSet intersection(BSTSet s)
    {
       BSTSet Iset1 = new BSTSet(); //make two empty trees
       BSTSet Iset2 = new BSTSet();
       Iset1.Copy(this.root); //copy this tree to both new trees
       Iset2.Copy(this.root);
       Iset1.Cut(s.root); //remove items that are common between this tree and s
       Iset2.Cut(Iset1.root); //remove common items from second copy of "this" tree
       return (Iset2);
    }
    //the runtime for count is O(n) as it loops through every item in this tree
    public int count(TNode k) // recusrively counts size
    {int x =1;
    if(k!=null)
    {
         if(k.right!=null) // if right is not null
        {
            x = x + this.count(k.right); //add one move recursively right
        }
        if(k.left!=null) //if left is not null
        {
           x = x + this.count(k.left); //add one and move recursively left
        }
    }
        return (x); //return x
    }
    // the runtime for size is the same as count which is O(n) as it moves through every item in the list
    public int size()
    {
        if(this.root == null) //if root is null return 0
        {
            return 0;
        }
       return this.count(this.root); //return count of this tree
    }
    // the runtime for hcount is O(n) as it moves through every item in the list
    public int hcount(TNode k)
    {
        int x =1,y=1;
        if(k!=null) //if this node is not null
        {
         if(k.right!=null) //if right is not null
        {
            x = this.hcount(k.right); //move recursively right
            
        }
        if(k.left!=null) //if left is not null
        {
            
           y= this.hcount(k.left); //move recursively left
           
        }
        }
        if(k.left==null) // if left is null return x +1
        {
            return x+1;
        }
        if(k.right==null) //if right is null return y+1
        {
            return y+1;
        }
        if (x>y) //if two children of current node return larger count
        {
            return x+1;
        }
        else{
            return y+1;
        }
    }
    // the runtime for height is the same as hcount which is O(n) as it moves through every item in the list
    public int height()
    {
        if (this.root ==null) //if root is null return 0
        {
            return 0;
        }
        return this.hcount(this.root)-1; //return hcount - 1 because of extra addition at the end
    }
    public void printBSTSet(){
         if(root==null)
             System.out.println("The set is empty");
         else{
             System.out.print("The set elements are: ");
             printBSTSet(root);
             System.out.print("\n");
         } 
        }
         private void printBSTSet(TNode t){
          if(t!=null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
                    } 
         }
         //the runtime for printNonRec is O(n) as it prints every item in the list
     public void printNonRec()
     {  
         MyStack stk = new MyStack(); //creat empty array stack
       TNode k = this.root; //set counter to root
       while(k!=null) //while counter is not null
       {
           
           stk.push(new SNode(k,null)); //push counter node as stack node
           k=k.left; //move left
       }
       while(stk.size>0) //while stack is not empty
       {
           k = stk.pop(); //pop top item
           System.out.print(k.element+", "); //print its element
           if(k.right!=null) //if there are children on right of this element
           {
               k=k.right; //move right
               while(k!=null) //loop left til end of this branch
               {
                 
                   stk.push(new SNode(k,null)); //push each tree node as stack node
                   k=k.left; //move left
               }
           }
       }
     }
}

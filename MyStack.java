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
public class MyStack {
    public int size;
    private SNode[] array;
    private int top;
    public MyStack()
    {
        array  = new SNode[1000000];
        top=-1;
        size=0;
    }
    public void push(SNode n)
    {
        array[++top] = n;
        size+=1;
    }
    public TNode pop()
    {
        size-=1;
        return array[top--].store;
        
    }
}

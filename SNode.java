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
public class SNode {
   public TNode store;
   public SNode next;
           public SNode(TNode t, SNode n)
           {
               store = t;
               next = n;
           }
}

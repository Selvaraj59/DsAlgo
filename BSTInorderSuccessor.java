/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is 

public. */
class Ideone {
    static class Node {
        int data;
        Node left, right;

        public Node(int val) {


            this.data = val;
        }
    }

    public static Node finSucc(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    public static Node findInorderSucc(Node root, Node imParent, Node parent, int key) {
        if (root == null)
            return null;
        if (key == root.data) {
            if (root.right == null) {
                if (key > imParent.data)
                    return parent;
                return imParent;
            } 
            else
                return finSucc(root.right);
        } 
        else if (key < root.data) {
            parent = root;
            return findInorderSucc(root.left, root, parent, key);
        } 
        else {
            return findInorderSucc(root.right, root, parent, key);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Node result = findInorderSucc(root, root, root, 1);
        if (result != null)
            System.out.println("Successor Node value: " + result.data);

    }
}
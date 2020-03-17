/*
 *  Assignment II - Algorithms
 *  Problem: 3
 *  Student Name: Mariam Ahmed Amin
 *  Student ID : 20170279
 */
package tree;

import java.util.ArrayList;

/**
 *
 * @author Mariam
 */
class Node<T> {

    Node(T x) {
        value = x;
    }

    T value;
    Node<T> left;
    Node<T> right;
}

public class Tree {

    Node<Integer> root;
    ArrayList<Integer> sumPaths = new ArrayList<>();

    void assignSumPath(int path[], int len) {
        String sum="";
        for (int i = 0; i < len; i++) {
            sum+= path[i];
        }
        //System.out.println(sum);
        sumPaths.add(Integer.parseInt(sum));

    }

    void setPaths(Node<Integer> node, int path[], int len) {

        if (node == null) {
            return;
        }
        
        path[len] = node.value;
        len++;

        if (node.left == null && node.right == null) {

            assignSumPath(path, len);
            
        } else {

            if (node.left != null) {

                setPaths(node.left, path, len);
            }

            if (node.right != null) {

                setPaths(node.right, path, len);
            }

        }
    }
    long digitSum(Node<Integer> t)
    {
        long sum =0;
        int path [] = new int [2000] ;
        this.setPaths(t, path, 0);
        for (int i=0 ; i<sumPaths.size(); i++)
            sum+=sumPaths.get(i);
        
        return sum;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(0);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(1);

        //System.out.println(tree.sumPaths);
        System.out.println(tree.digitSum(tree.root));
    }

}

package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=eD3tmO66aBA
 */
public class TreeHeight {

    //Approach1
    static int treeHeight(Node curr) {
        if (curr == null) {
            return 0;
        }

        int leftHeight = treeHeight(curr.left);
        int rightHeight = treeHeight(curr.right);

        return 1+ Math.max(leftHeight,rightHeight);
    }



    public static void main(String args[]) {

        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

        //OUTPUT: 4 2 8 5 1 6 3 9 7 10

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        System.out.println("Height of tree is : " + treeHeight(root));
    }
}

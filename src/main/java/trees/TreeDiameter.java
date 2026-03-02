package trees;
//TC-> O(N)
//https://www.youtube.com/watch?v=Rezetez59Nk

//Longest path between two nodes is tree diameter
public class TreeDiameter {

    static int diam;
    static int treeDiameter(Node curr) {
//        int[] diameter = new int[1];
        height(curr);
        return diam;
    }

    //Approach1
    static int height(Node curr) {
        if (curr == null) {
            return 0;
        }

        int leftHeight = height(curr.left);
        int rightHeight = height(curr.right);

        diam = Math.max(diam, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
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

        System.out.println("Height of tree is : " + treeDiameter(root));
    }
}

package trees;

class LCA {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        //result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else { //both left and right are not null, we found our result
            return root;
        }
    }

    public static void main(String args[]) {
        //        1
        //    2       3
        // 4    5   6    7
        //     8       9   10

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

//        System.out.println("The LCA is : " + lowestCommonAncestor(root, root.left.right.left, root.left.left));
        System.out.println("The LCA is : " + lowestCommonAncestor(root, root.right.right.right, root.right.left));

    }
}
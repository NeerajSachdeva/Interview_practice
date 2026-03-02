package trees;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{").append(data).append('}');
        return sb.toString();
    }
}

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    // TODO: generic constructor
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    // TODO: constructor
    public BinarySearchTree(E val) {
        Node<E> head = new Node<>();
        head.info = val;
        this.root = head;
    }

    // TODO: returns true if BST has val else false.
    public boolean contains (E val) {
        return true;
    }

    public Node insertHelper(E val, Node tempRoot) {
        if (val.compareTo((E) tempRoot.info) < 0)
            tempRoot.left = insertHelper(val, tempRoot.left);
        else if (val.compareTo((E) tempRoot.info) > 0)
            root.right = insertHelper(val, tempRoot.right);
        return tempRoot;
    }

    // TODO: inserts val at the right place satisfying search tree properties,
    //  should handle if the tree is empty, if value is there don't insert again
    public void insert(E val) {
        if (this.root == null) {
            Node<E> head = new Node<>();
            head.info = val;
            this.root = head;
        } else {
            this.root = insertHelper(val, this.root);
        }
    }

    // TODO: returns the minimum value stored in the tree
    public E findMin() {
        return root.info;
    }

    // TODO: returns the maximum value stored in the tree
    public E findMax() {
        return root.info;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
        bt.postOrder(bt.root);
    }


}

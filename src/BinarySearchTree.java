public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public BinarySearchTree(E val) {
        Node<E> head = new Node<>(val);
        this.root = head;
    }

    // returns true if BST has val else false.
    public boolean contains (E val) {
        Node<E> current = this.root;

        while (current != null && !current.getInfo().equals(val)) {
            if (val.compareTo(current.getInfo()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return (current != null);
    }

    public void insertHelper(Node<E> newNode, Node<E> current) {
        if (!this.contains(newNode.getInfo())) {
            if (this.root == null) {
                this.root = newNode;
            } else {
                if (newNode.getInfo().compareTo(current.getInfo()) < 0) {
                    if (current.getLeft() == null)
                        current.left = newNode;
                    else {
                        insertHelper(newNode, current.getLeft());
                    }
                }
                if (newNode.getInfo().compareTo(current.getInfo()) > 0) {
                    if (current.getRight() == null)
                        current.right = newNode;
                    else {
                        insertHelper(newNode, current.getRight());
                    }
                }
            }
        }
    }

    //  inserts val at the right place satisfying search tree properties,
    //  should handle if the tree is empty, if value is there don't insert again
    public void insert(E val) {
        Node<E> n = new Node<>(val);
        insertHelper(n, this.root);
    }

    //  returns the minimum value stored in the tree
    public E findMin() {
        if (this.root == null)
            return null;
        else {
            Node<E> current = this.root;
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return current.getInfo();
        }
    }

    //  returns the maximum value stored in the tree
    public E findMax() {
        if (this.root == null)
            return null;
        else {
            Node<E> current = this.root;
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current.getInfo();
        }
    }

    // testing purposes
    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
        System.out.println(bt.contains(5));
        System.out.println(bt.contains(10));
        System.out.println(bt.contains(3));
        System.out.println(bt.contains(20));
        System.out.println(bt.contains(8));
        System.out.println(bt.contains(4));
        System.out.println(bt.contains(9));
        System.out.println(bt.findMin());
        System.out.println(bt.findMax());
    }


}

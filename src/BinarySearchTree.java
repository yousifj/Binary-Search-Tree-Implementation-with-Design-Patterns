public class BinarySearchTree {

    private Node root;
    private SortStrategy sortStrategy;
    // default constructor
    BinarySearchTree(SortStrategy sortStrategy){
        root = new NullNode();
        this.sortStrategy = sortStrategy;
    }
    // Internal iterator
    public interface InternalIterator {
        void process(Student student);
    }

    /**
     * Goes over all elements in the tree
     * @param processor lambda function
     */
    public void forEach(InternalIterator processor) {

        // Using the null object pattern
        // moved the responsibility of the iterator to each node to avoid the null check
        root.inOrderTraversal(processor);
    }

    /**
     * default insert function if no strategy is used.
     * @param node location to be inserted
     * @param student object to be inserted into the node
     * @return node containing the inserted object.
     */
    Node insert(Student student){
        root = sortStrategy.insert(root,student);
        return root;
    }

    /**
     * root getter
     * @return the root node of the tree
     */
    public Node getRoot() {
        return root;
    }

}


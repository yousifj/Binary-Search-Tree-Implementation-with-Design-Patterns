public class RealNode implements Node {
    private final Student student;
    private Node left;
    private Node right;

    RealNode(Student student) {
        this.student = student;
        left = new NullNode();
        right = new NullNode();
    }
    //setters and getters for the left and right nodes
    public Student getStudent() {
        return student;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * visits the tree nodes in order smallest to biggest
     * @param processor lambda function
     */
    public void inOrderTraversal(BinarySearchTree.InternalIterator processor) {

        // Recursively traverse the left subtree
        this.getLeft().inOrderTraversal(processor);

        // Apply the custom Iterator logic to the current node's student
        processor.process(this.getStudent());

        // Recursively traverse the right subtree
        this.getRight().inOrderTraversal(processor);

    }

    /**
     * accept for the visitor pattern
     * @param visitor concrete visitor
     */
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}



public class NullNode implements Node {

    // Return null for the student in the NullNode
    @Override
    public Student getStudent() {
        return null;
    }
    // Return the NullNode itself for left and right in the NullNode
    @Override
    public Node getLeft() {
        return this;
    }
    @Override
    public Node getRight() {
        return this;
    }
    //setters do not need to do anything for null nodes.
    @Override
    public void setRight(Node right) {
    }
    @Override
    public void setLeft(Node left) {
    }

    /**
     * null object pattern does not need to do anything to travers the tree
     * @param processor lambda
     */
    @Override
    public void inOrderTraversal(BinarySearchTree.InternalIterator processor) {
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

public interface Node {
    //setter and getter for the node data
    Student getStudent();
    Node getLeft();
    Node getRight();
    void setLeft(Node left);
    void setRight(Node right);
    /**
     * visits the tree nodes in order smallest to biggest
     * @param processor lambda function
     */
    void inOrderTraversal(BinarySearchTree.InternalIterator processor);
    /**
     * accept for the visitor pattern
     * @param visitor concrete visitor
     */
    void accept(NodeVisitor visitor);

}

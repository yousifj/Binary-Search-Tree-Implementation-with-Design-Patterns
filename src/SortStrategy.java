public interface SortStrategy {
    /**
     * function to be overridden by the classes which implement this interface
     * @param node current node starts at root
     * @param student student object to be inserted into the tree
     * @return Node the node where we added the new student to
     */
    Node insert(Node node, Student student);
}

public class NullNodesVisitor implements NodeVisitor{
    private int count = 0;

    @Override
    public void visit(RealNode node) {
        // Visit left subtree
        node.getLeft().accept(this);
        // Visit right subtree
        node.getRight().accept(this);
    }

    /**
     * counts the number of null nodes visited in the BST
     * @param node default for visitor pattern
     */
    public void visit(NullNode node) {
        count++;
    }

    /**
     * returns the count of null nodes
     *
     * @return the count of the number of null nodes in the tree
     */
    @Override
    @SuppressWarnings (value="unchecked")
    public <T> T getResults() {
        return (T) Integer.valueOf(count);
    }
}

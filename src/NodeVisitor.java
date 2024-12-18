public interface NodeVisitor {
    //visit logic to be implemented in the concrete classes
    void visit(RealNode node);
    void visit(NullNode node);

    /**
     * generic method to be implemented by each visitor
     *
     * @return type depends on the visitor
     */
    <T> T getResults();

}

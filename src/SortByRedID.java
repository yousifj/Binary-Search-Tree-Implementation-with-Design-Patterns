public class SortByRedID implements SortStrategy {
    /**
     * function to insert students according to their REDID
     * @param node current node starts at root
     * @param student student object to be inserted into the tree
     * @return Node the node where we added the new student to
     */
    @Override
    public Node insert(Node node, Student student) {
        if (node instanceof NullNode){
            node = new RealNode(student);
            return node;
        }
        //insert the smallest on the left, the biggest on the right
        if(student.getRedID() < node.getStudent().getRedID()){
            node.setLeft(insert(node.getLeft(),student));
        }else {
            node.setRight(insert(node.getRight(),student));
        }
        return node;
    }
}


public class SortByGPA implements SortStrategy {

    /**
     * function to insert students according to their rounded GPA
     * it will use REDID when rounded GPA is equal
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

        //smallest GPA on the left, biggest GPA on the right
        if(Math.round(student.getGPA()) < Math.round(node.getStudent().getGPA())){
            node.setLeft(insert(node.getLeft(),student));
        }
        //when GPA is the same use REDID
        else if (Math.round(student.getGPA()) == Math.round(node.getStudent().getGPA())){
            if(student.getRedID() < node.getStudent().getRedID()){
                node.setLeft(insert(node.getLeft(),student));
            }else {
                node.setRight(insert(node.getRight(),student));
            }
        }
        else{
            node.setRight(insert(node.getRight(),student));
        }
        return node;
    }
}

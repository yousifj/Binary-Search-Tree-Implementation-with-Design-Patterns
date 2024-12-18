public class SortByLastName implements SortStrategy {

    /**
     * function to insert students according to their last name
     * or first name is last name is equal
     * @param node current node starts at root
     * @param student student object to be inserted into the tree
     * @return Node the node where we added the new student to
     */
    @Override
    public Node insert(Node node, Student student) {
        if (node instanceof NullNode) {
            node = new RealNode(student);
            return node;
        }
        // Compare last names
        int lastNameComparison = student.getLastName().compareTo(node.getStudent().getLastName());
        if (lastNameComparison < 0) {
            // The student's last name is lexicographically smaller, insert to the left
            node.setLeft(insert(node.getLeft(), student));
        } else if (lastNameComparison > 0) {
            // The student's last name is lexicographically larger, insert to the right
            node.setRight(insert(node.getRight(), student));
        } else {
            // if last names are equal use first names
            int firstNameComparison = student.getFirstName().compareTo(node.getStudent().getFirstName());
            if (firstNameComparison < 0) {
                // The student's first name is lexicographically smaller, insert to the left
                node.setLeft(insert(node.getLeft(), student));
            } else if (firstNameComparison > 0) {
                // The student's first name is lexicographically larger, insert to the right
                node.setRight(insert(node.getRight(), student));
            }
        }
        return node;
    }
}

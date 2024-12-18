import java.util.ArrayList;

public class NodeLongestPathVisitor implements NodeVisitor{

    private int longestPath = 0;
    private int currentPath = 0;
    private final ArrayList<Integer> allPaths  = new ArrayList<>();;
    private final ArrayList<Node> currentPaths  = new ArrayList<>();;
    private ArrayList<Node> previousPaths  = new ArrayList<>();;
    private final ArrayList<Node> longestPathNodes  = new ArrayList<>();;

    /**
     * Deal with real node visitor logic
     * compute all paths in the tree
     * keeping track of size and path
     * @param node node being visited
     */
    @Override
    public void visit(RealNode node) {
        // Increment the current path depth
        currentPath++;
        // Add the current node to the path
        currentPaths.add(node);
        // Visit left subtree
        node.getLeft().accept(this);
        // Visit right subtree
        node.getRight().accept(this);
        // Decrement on backtrack and remove the node from the path
        currentPaths.remove(node);
        currentPath--;
    }

    /**
     * End of a path when visiting a NullNode
     * @param node node being visited
     */
    @Override
    public void visit(NullNode node) {
        // add it to list of paths when we reach a nullNode
        // make sure that the same path is not counted twice if it has 2 null nodes
        if(!previousPaths.equals(currentPaths)){
            previousPaths = new ArrayList<>();
            previousPaths.addAll(currentPaths);
            allPaths.add(currentPath);
        }
        //update the path to the longest
        if (currentPath > longestPath) {
            longestPath = currentPath;
            longestPathNodes.addAll(currentPaths);
        }
    }

    /**
     * getter for the array of nodes that has the longest path
     * @return Array<nodes> of nodes
     */
    @Override
    @SuppressWarnings (value="unchecked")
    public <T> T getResults() {
        return (T) longestPathNodes;
    }

}
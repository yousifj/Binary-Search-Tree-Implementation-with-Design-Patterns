import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Class for unit testing
 */
public class MainTest {
    //PRINTING MODE
    // set this to False if you don't want to see expected vs results for the correct answers.
    boolean printMode = true;
    //student list to use for testing
    Student student1 = new Student("Carrol","Holland",87895,3.0);
    Student student2 = new Student("Yousif","Jabbo",128574,4.0);
    Student student3 = new Student("Jack","Madison",317541,1.9);
    Student student4 = new Student("Mark","Jason",31298,3.10);
    Student student5 = new Student("Sarah","Madison",10230,3.6);
    Student student6 = new Student("Maria","Roch",9230,2.45);


    /**
     * Test to see if the students object are created correctly
     * Basic test
     */
    @Test
    void unitTestForStudent(){

        Student student = new Student("Maria","Roch",9230,2.45);
        //check the results
        Assertions.assertEquals(student.getFirstName(),"Maria");
        Assertions.assertEquals(student.getLastName(),"Roch");
        Assertions.assertEquals(student.getRedID(),9230);
        Assertions.assertEquals(student.getGPA(),2.45);

    }

    /**
     * Test to see if the node object is created correctly
     * Basic test
     */
    @Test
    void unitTestForNode(){

        Student student = new Student("Maria","Roch",9230,2.45);
        Node node = new RealNode(student);
        //check the results
        Assertions.assertEquals(node.getStudent(),student);
        //make sure that the left and right nodes are null
        Assertions.assertNull(node.getRight().getStudent());
        Assertions.assertNull(node.getLeft().getStudent());

    }

    /**
     * Test to see if the list of student we get from tree
     * is the same as the expected one, according to their REDID
     */
    @Test
    void unitTestForRedID(){
        //choose strategy
        SortStrategy strategy = new SortByRedID();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);
        //list to be filled from testing results
        ArrayList<Integer> testList = new ArrayList<>();
        //list of correct answer build by hand
        ArrayList<Integer> correctAnswer = new ArrayList<>(){{
            add(student6.getRedID());
            add(student5.getRedID());
            add(student4.getRedID());
            add(student1.getRedID());
            add(student2.getRedID());
            add(student3.getRedID());
        }
        };

        //use iterator to add all the sorted students to list
        binarySearchTree.forEach(student -> testList.add(student.getRedID()));
        //check the results
        Assertions.assertIterableEquals(correctAnswer,testList);
        //print the expected vs results
        printResults(correctAnswer,testList);
    }

    /**
     * Test to see if the list of student we get from tree
     * is the same as the expected one, according to their GPA
     */
    @Test
    void unitTestForGPA(){
        //choose strategy
        SortStrategy strategy = new SortByGPA();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);
        //list to be filled from testing results
        ArrayList<String> testList = new ArrayList<>();
        //list of correct answer build by hand
        ArrayList<String> correctAnswer = new ArrayList<>(){{
            //this student is here because the rounded gpa is equal, so
            //we use REDID
            add(student6.getGPA() +" REDID: "+ student6.getRedID());
            add(student3.getGPA() +" REDID: "+ student3.getRedID());
            //same for this student because the rounded gpa is equal, so
            //we use REDID
            add(student4.getGPA() +" REDID: "+ student4.getRedID());
            add(student1.getGPA() +" REDID: "+ student1.getRedID());
            add(student5.getGPA() +" REDID: "+ student5.getRedID());
            add(student2.getGPA() +" REDID: "+ student2.getRedID());
        }
        };
        //use iterator to add all the sorted students to list
        binarySearchTree.forEach(student -> testList.add(student.getGPA() +" REDID: "+ student.getRedID()));
        //check the results
        Assertions.assertIterableEquals(correctAnswer,testList);
        printResults(correctAnswer,testList);
    }
    /**
     * Test to see if the list of student we get from tree
     * is the same as the expected one, according to their last name
     * or first name if the last name is the same
     */
    @Test
    void unitTestForLastName(){
        //choose strategy
        SortStrategy strategy = new SortByLastName();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);
        //list to be filled from testing results
        ArrayList<String> testList = new ArrayList<>();
        //list of correct answer build by hand
        ArrayList<String> correctAnswer = new ArrayList<>(){{
            add(student1.getLastName() + " " + student1.getFirstName());
            add(student2.getLastName() + " " + student2.getFirstName());
            add(student4.getLastName() + " " + student4.getFirstName());
            add(student3.getLastName() + " " + student3.getFirstName());
            add(student5.getLastName() + " " + student5.getFirstName());
            add(student6.getLastName() + " " + student6.getFirstName());

        }
        };
        //use iterator to add all the sorted students to list
        binarySearchTree.forEach(student -> testList.add(student.getLastName() + " " + student.getFirstName()));
        //check the results
        Assertions.assertIterableEquals(correctAnswer,testList);
        printResults(correctAnswer,testList);
    }


    /**
     * Test to see if the null node count of the tree is the same as
     * the expected one, tree is build according to their REDID
     */
    @Test
    void unitTestForNullCount(){
        //choose strategy
        SortStrategy strategy = new SortByRedID();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);

        //find number of null nodes
        NodeVisitor visitor = new NullNodesVisitor();
        binarySearchTree.getRoot().accept(visitor);

        // the expected null count is 6 (explanation is in the readme file)
        Assertions.assertEquals(Integer.valueOf(7),visitor.getResults());
        if(printMode){
            System.out.println("Expected: 7 Results: "+visitor.getResults());
        }

    }
    /**
     * Test to see if the longest path in tree is the same as
     * the expected one. The path start from the root and goes to the deepest element
     * tree is build according to their REDID
     */
    @Test
    void unitTestForLongestPath(){
        //choose strategy
        SortStrategy strategy = new SortByRedID();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);
        //list to be filled from testing results
        ArrayList<Integer> testList = new ArrayList<>();

        // the longest path is from student 1 to 4 to 5 to 6
        ArrayList<Integer> correctAnswer = new ArrayList<>(){{
            add(student1.getRedID());
            add(student4.getRedID());
            add(student5.getRedID());
            add(student6.getRedID());
        }
        };
        //find the longest path
        NodeVisitor pathVisitor = new NodeLongestPathVisitor();
        binarySearchTree.getRoot().accept(pathVisitor);

        //use iterator to add all the sorted students to list
        ArrayList<Node> LongestPath = new ArrayList<>();
        LongestPath = pathVisitor.getResults();


        //list to of nodes that is the longest path
        //used the red Id to compare the expected vs the results
        for(Node node: LongestPath){
            testList.add(node.getStudent().getRedID());
        }
        // check if the path is correct
        Assertions.assertIterableEquals(correctAnswer,testList);
        printResults(correctAnswer,testList);
        // the longest path length is 4 (explanation is in the readme file)
        Assertions.assertEquals(4,LongestPath.size());
        //print the results of the longest path
        if(printMode){
            for (int i = 0; i < correctAnswer.size()-1; i++) {
                System.out.print(correctAnswer.get(i) + " ----> ");
            }
            System.out.println(correctAnswer.get(correctAnswer.size()-1) );
            System.out.println("Expected: 4 Results: "+LongestPath.size());
        }

    }
    /**
     * Test to see if the average length of the tree is the same as
     * the expected one, tree is build according to their REDID
     */
    @Test
    void unitTestForAveragePath(){
        //choose strategy
        SortStrategy strategy = new SortByRedID();
        // build the tree with the strategy
        BinarySearchTree binarySearchTree = buildTree(strategy);


        //find the average path
        NodeVisitor pathVisitor = new NodeAveragePathVisitor();
        binarySearchTree.getRoot().accept(pathVisitor);

        // the expected average path is 2.8 (explanation is in the readme file)
        Assertions.assertEquals(2.8,pathVisitor.getResults());

        if(printMode){
            System.out.println("Expected: 2.8 Results: "+pathVisitor.getResults());
        }

    }

    /**
     *  function to print the expected vs the results we get from the code
     * @param list1 expected list
     * @param list2 results from the tree
     * @param <E> used to create a generic function that can accept ArrayLists of any type.
     */
    public <E> void printResults(ArrayList<E> list1, ArrayList<E> list2){
        //if print mode is set to false return
        if (!printMode){
            return;
        }
        for (int i = 0; i < list1.size(); i++) {
            E elementList1 = list1.get(i);
            E elementList2 = list2.get(i);
            System.out.println("Expected: "+elementList1 + " Results: " + elementList2);
        }
        System.out.println();
    }

    /**
     * function that builds the tree based on SortStrategy
     * @param strategy object of type SortStrategy
     * @return a new BinarySearchTree based on SortStrategy
     */
    private BinarySearchTree buildTree(SortStrategy strategy) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(strategy);
        binarySearchTree.insert(student1);
        binarySearchTree.insert(student2);
        binarySearchTree.insert(student3);
        binarySearchTree.insert(student4);
        binarySearchTree.insert(student5);
        binarySearchTree.insert(student6);
        return binarySearchTree;
    }
}
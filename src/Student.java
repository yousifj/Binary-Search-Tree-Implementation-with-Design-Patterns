public class Student {
    private String firstName;
    private String lastName;
    private int redID;
    private double gpa;
    //default constructor
    Student(){

    }

    /**
     * constructor for the student class
     * @param firstName
     * @param lastName
     * @param redID
     * @param GPA
     */
    Student(String firstName, String lastName, int redID, double GPA){
        this.firstName = firstName;
        this.lastName = lastName;
        this.redID = redID;
        this.gpa = GPA;
    }
    //setters for variables of the class to change the variables if needed
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRedID(int redID) {
        this.redID = redID;
    }
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    // getters for all variables of the class
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getRedID() {
        return redID;
    }
    public double getGPA() {
        return gpa;
    }

}

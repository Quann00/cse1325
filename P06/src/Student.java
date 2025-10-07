import java.util.ArrayList;

public class Student extends Person {

    private static int nextStudentID = 0; // 0 inline
    private int studentID;
    private ArrayList<Course> courses = new ArrayList<>();


    public Student(String name, String email){

        super(name, email);
        this.studentID = nextStudentID;
        nextStudentID++;
    }
    
}
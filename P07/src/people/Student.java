package people;
import session.Course;

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
    public void addCourse(Course course){
    courses.add(course);
    }
    public Course[] getCourses(){
    return courses.toArray(new Course[0]);
    }

@Override
public String toString(){
    return super.toString().replace(")", ", #" + studentID + ")");
}
}
package people;
import session.Course;

import java.util.ArrayList;

import java.io.PrintStream;
import java.util.Scanner;

public class Student extends Person {

    private static int nextStudentID = 0; // 0 inline
    private int studentID;
    private ArrayList<Course> courses = new ArrayList<>();


    public Student(String name, String email){

        super(name, email);
        this.studentID = nextStudentID;
        nextStudentID++;
    }

    public Student(Scanner in){
        super(in);
        nextStudentID = in.nextInt();
        in.nextLine();
        this.studentID = in.nextInt();
        in.nextLine();
        
        int size = in.nextInt();
        in.nextLine();

        this.courses = new ArrayList<>();

        for (int i = 0; i < size; i++){
            courses.add(new Course(in));
        }
    }

    public void save(PrintStream out){
        super.save(out);
        out.println(nextStudentID);
        out.println(studentID);

        out.println(courses.size());
        for (int i = 0; i < courses.size(); i++){
            courses.get(i).save(out);
        }
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
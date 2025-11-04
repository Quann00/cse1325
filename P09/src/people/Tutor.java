package people;
import session.Course; 
import java.io.PrintStream;
import java.util.Scanner;

public class Tutor extends Person{
    private String bio;
    private int ssn;
    private Course course;

    public Tutor (String name, String email, int ssn, String bio, Course course){
        super(name, email);
        if (ssn < 001_01_0001 || ssn > 999_99_9999){
            throw new IllegalArgumentException("Must be between 001_01_0001 and 999_99_9999");
        }
    
        this.ssn = ssn;
        this.bio = bio;
        this.course = course;
    }

    public Tutor(Scanner in){
        super(in);
        this.bio = in.nextLine();
        this.ssn = in.nextInt();
        in.nextLine();
        this.course = new Course(in);

    }

    public void save(PrintStream out){
        super.save(out);
        out.println(bio);
        out.println(ssn);
        course.save(out);
    }
    public int getSSN(){
    return ssn;
    }
    public String getBio(){
    return bio;

    }

    public Course getCourse(){
    return course;

    }
}
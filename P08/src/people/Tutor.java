package people;
import session.Course; 

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
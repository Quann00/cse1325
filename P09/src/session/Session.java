package session;
import people.Student;
import people.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;
/**
* Models a Session.
*
* @author Quan Nguyen
* @version 1.0
* @since 1.0
* @license.agreement CC BY-SA International 4.0
*/

public class Session{
    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List<Student> students;

    /**
     * Constructs a new Session
     * 
     * @param course    The Course that this session is for
     * @param tutor     The Tutor leading the session
     * @since           1.0
     */

    public Session(Course course, Tutor tutor){
        this.course = course;
        this.tutor = tutor;
        this.students = new ArrayList<>();
    }

    public Session(Scanner in){
        this.course = new Course(in);
        this.dates = new DateRange(in);
        this.tutor = new Tutor(in);

        int size = in.nextInt();
        in.nextLine();

        this.students = new ArrayList<>();

        for (int i = 0; i < size; i++){
            students.add(new Student(in));
        }

    }

    public void save(PrintStream out){
        course.save(out);
        dates.save(out);
        tutor.save(out);

        out.println(students.size());
        for (int i = 0; i < students.size(); i++){
            students.get(i).save(out);
        }


    }

    /**
     * 
     * 
     * @param date    The date of the session
     * @param startTime     The starting time of the session.
     * @param duration     The duration of the session in minutes.
     * @since           1.0
     */

    public void setSchedule(String date, String startTime, long duration){
        this.dates = new DateRange(date, startTime, duration);
    }

    /**
     * Adds a student to the list of enrolled students
     * 
     * @param student   The Student to add to the session
     * @since           1.0
     */


    public void addStudent(Student student){
        this.students.add(student);
    }

    /**
     * Returns a detailed, multi-line string representation of the Session
     * @return      Formatted string describing the session
     * @since       1.0
     */

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Session on ").append(course).append(" at ").append(dates.toString());
        sb.append("\n Tutor: ").append(tutor.getName());
        sb.append("\n Students: ");
        for(int i = 0; i < students.size(); ++i)
        {
            sb.append(students.get(i).getName());
            if(i < students.size() - 1)
            {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
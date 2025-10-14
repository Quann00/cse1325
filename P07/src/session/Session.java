package session;
import people.Student;
import people.Tutor;
import java.util.ArrayList;
import java.util.List;



public class Session{
    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List<Student> students;

    

    public Session(Course course, Tutor tutor){
        this.course = course;
        this.tutor = tutor;
        this.students = new ArrayList<>();
    }

    

    public void setSchedule(String date, String startTime, long duration){
        this.dates = new DateRange(date, startTime, duration);
    }

   


    public void addStudent(Student student){
        this.students.add(student);
    }

    

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
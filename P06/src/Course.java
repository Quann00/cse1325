import java.util.Objects;

public class Course {
    private String dept;
    private int number;

    public Course(String dept, int number){
        if (dept.length() != 3 && dept.length() != 4){
        throw new InvalidCourseException(dept);
    }
        if (number < 1000 || number > 9999){
        throw new InvalidCourseException(dept, number);

    }
        this.dept = dept;
        this.number = number;
    }
    public String toString(){
    return dept + number;
    }


@Override
public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())return false;
    Course course = (Course) o;
    // if both are equal
    return number == course.number && Objects.equals(dept, course.dept);
}

@Override
public int hashCode(){
    return Objects.hash(dept, number);
}
}
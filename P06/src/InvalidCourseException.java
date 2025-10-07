public class InvalidCourseException extends IllegalArgumentException {
    public InvalidCourseException(String dept){
        super("Invalid dept in new Course: " + dept);

    }

    public InvalidCourseException(String dept, int number){
        super("Invalid dept in new Course: " + dept + number);

    }
}
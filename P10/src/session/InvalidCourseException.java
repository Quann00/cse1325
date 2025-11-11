package session;
/**
* Models a InvalidCourseException.
*
* @author Quan Nguyen
* @version 1.0
* @since 1.0
* @license.agreement CC BY-SA International 4.0
*/

 
public class InvalidCourseException extends IllegalArgumentException {
    public InvalidCourseException(String dept){
        super("Invalid dept in new Course: " + dept);

    }

    /**
     * Constructs a new InvalidCourseException with a message
     * 
     * @param dept     The department code
     * @param number     The invalid course number that caused the error
     * @since           1.0
     */

    public InvalidCourseException(String dept, int number){
        super("Invalid course number in new Course " + dept + number);

    }
}
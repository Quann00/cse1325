package session;

import java.util.Objects;

import java.io.PrintStream;
import java.util.Scanner;

/**
* Models a Course.
*
* @author Quan Nguyen
* @version 1.0
* @since 1.0
* @license.agreement CC BY-SA International 4.0
*/

public class Course {
    private String dept;
    private int number;

    /**
    
     * @param dept     The department code CSE
     * @param number       The course number 1325
     * @throws IllegalArgumentException     if the department is invalid or the number is out of range
     * @since               1.0
     */


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
    
    public Course(Scanner in){
        this.dept = in.nextLine();
        this.number = in.nextInt();
        in.nextLine();

    }

    public void save(PrintStream out){
        out.println(dept);
        out.println(number);
    }
    /**
    
    
     * @return formatted string with the department and course number.
     * @since               1.0
     */
    public String toString(){
    return dept + number;
    }

/**
     * Compares this Course to another object for equality.
     *
     * @param o The object to compare against this Course.
     * @return true if the objects are equal,  false otherwise.
     * @since                   1.0
     */

@Override
public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())return false;
    Course course = (Course) o;
    // if both are equal
    return number == course.number && Objects.equals(dept, course.dept);
}
/**
     * The hash code is based on the department and number fields
     * @return integer hash code for this object
     * @since                   1.0
     */

@Override
public int hashCode(){
    return Objects.hash(dept, number);
}
}
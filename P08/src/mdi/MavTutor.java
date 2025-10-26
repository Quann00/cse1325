package mdi;

import menu.Menu;
import session.Course;
import people.Student;
import people.Tutor;
import session.Session;
import menu.MenuItem;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class MavTutor{
    private Menu menu;
    private List view;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Tutor> tutors = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    public MavTutor(){
        this.menu = new Menu(
            
            new Object [] {
                "\n Selection \n"
            },
            this.view = view,

                //menu items

            new MenuItem("Create New Course", this::newCourse),
            new MenuItem("Create New Tutor", this::newTutor),
            new MenuItem("Create New Student", this::newStudent),
            new MenuItem("Create New Session", this::newSession),

            new MenuItem("View Courses",     () -> selectView(this.courses)),
            new MenuItem("View Tutors",     () -> selectView(this.tutors)),
            new MenuItem("View Students",     () -> selectView(this.students)),
            new MenuItem("View Sessions",     () -> selectView(this.sessions)),


            new MenuItem("Quit", this::quit)


        );
        // start appli run
        this.menu.run();


    }

    public static void main(String[] args){
        new MavTutor();

    }

    @Override
    public String toString(){
        return "MavTutor";
    }

    private void quit(){
       menu.result = null;

    }

    private void selectView(List list){
        String head;
        if (list == null){
            menu.result.append("Invalid selection\n");
            return;
        }
        if (list.isEmpty()){
            menu.result.append("Invalid Items");
            return;
        }
        if(list == courses) {
            head = "Courses";
        } 
        else if(list == students) {
            head = "Students";
        } 
        else if(list == tutors) {
            head = "Tutors";
        } 
        else if(list == sessions) {
            head = "Sessions";
        } 
        else {
            menu.result.append("Invalid view selection\n");
            return;
        }
        menu.result.append(Menu.listToString(head, list, null));
    }

    private void newCourse(){
        String dept = Menu.getString("Enter Department: ");
        int number = Menu.getInt("Enter Number of the Course: ");

        Course newCourse = new Course(dept, number);//create course

        //check for course existence
        if(courses.indexOf(newCourse) == -1){
            courses.add(newCourse);
            menu.result.append("Course added");
        }

        else {
            menu.result.append("Course already there");

        }

    }

    private void newTutor(){

        String name = Menu.getString("Enter Tutor Name: ");
        String email = Menu.getString("Enter Tutor Email: ");
        String bio = Menu.getString("Enter Tutor BIO: ");
        int ssn = Menu.getInt("Enter Tutor SSN: ");

        Integer index = Menu.selectItemFromList("Select the course: ", courses);

        if (index != null){
            Course course = courses.get(index);
            Tutor newTutor = new Tutor(name, email, ssn, bio, course);
            tutors.add(newTutor);
            menu.result.append("Tutor added: " + newTutor + '\n');
        }
        else {
            menu.result.append("No course, no Tutor");
        }


    }

    private void newStudent(){
        if (courses.isEmpty()){
            menu.result.append("No course please add it first");
            return;
        }

        String name = Menu.getString("Enter Student Name: ");
        String email = Menu.getString("Enter Student Email: ");

        Student newStudent = new Student(name, email);

        while (true){
            Integer index = Menu.selectItemFromList("Select a course: ", courses);

            if (index == null){
                break;
            }

            Course course = courses.get(index);
            newStudent.addCourse(course);
            menu.result.append("Course added: " + course +'\n');

        }

        students.add(newStudent);
        menu.result.append("Student added " + newStudent + '\n');



    }

    private void newSession(){
        if (courses.isEmpty()){
            menu.result.append("No course please add it first");
            return;
        }
        if (tutors.isEmpty()){
            menu.result.append("No tutor");
            return;
        }
        // select courses and tutors
        Integer coursesIndex = Menu.selectItemFromList("Select a course: ", courses);
        //check if theres no course
        if (coursesIndex == null || coursesIndex < 0){
        menu.result.append("No course ");
        return;
        }
        
        Course course = courses.get(coursesIndex);
        

        // select courses and tutors
        Integer tutorsIndex = Menu.selectItemFromList("Select a tutor: ", tutors);
        //check if theres no course
        if (tutorsIndex == null || tutorsIndex < 0){
        menu.result.append("No tutors ");
        return;
        }
        
        Tutor tutor = tutors.get(tutorsIndex);
        

        //make session

        Session newSession = new Session(course, tutor);

        String date = Menu.getString("Enter Date: ");
        String time = Menu.getString("Enter Time: ");
        int duration = Menu.getInt("Enter Duration: ");

        newSession.setSchedule(date, time, duration);

        //loop
        while (true){
            Integer studentsIndex = Menu.selectItemFromList("Add a student: ", students);
        if (studentsIndex == null || studentsIndex < 0){
            menu.result.append("No student ");
            break;
            }
        else {
            Student student = students.get(studentsIndex);
            newSession.addStudent(student);
            menu.result.append("Added student: " + student + '\n');

            }  

        }

        sessions.add(newSession);
        menu.result.append("Added Session: " + "\n");






    }

}
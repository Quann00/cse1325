package mdi;

import menu.Menu;
import session.Course;
import people.Student;
import people.Tutor;
import session.Session;
import menu.MenuItem;
import rating.Rating;
import rating.Comment;
import rating.Rateable;
import people.Person;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class MavTutor{
    private Menu menu;
    private List view;
    private File file;
    private boolean dirty;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Tutor> tutors = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    public MavTutor(){
        this.dirty = false;
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

            new MenuItem("newz", this::newz),
            new MenuItem("save", this::save),
            new MenuItem("saveAs", this::saveAs),
            new MenuItem("open", this::open),

            new MenuItem("Review a Tutor", () -> review(this.tutors)),
            new MenuItem("Review a Student", () -> review(this.students)),
            new MenuItem("Review a Session", () -> review(this.sessions)),






            new MenuItem("Quit", this::quit)


        );
        // start appli run
        this.menu.run();


    }

    public static void main(String[] args){
        SplashScreen.show();
        new MavTutor();

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(Menu.listToString("Courses", courses, null));
        sb.append(Menu.listToString("Tutors", tutors, null));
        sb.append(Menu.listToString("Students", students, null));
        sb.append(Menu.listToString("Sessions", sessions, null));


        
        return sb.toString();
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
            dirty = true;
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
            dirty = true;

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
            dirty = true;

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
        dirty = true;

        menu.result.append("Added Session: " + "\n");

    }

    private boolean safeToDiscardData(){
        if (dirty == false){
            return true;
        }
        
        String response = Menu.getString("Unsaved data what to do (S)ave, (D)iscard, or (A)bort: ");
        if (response.equals("S")){
            save();
            return !dirty;
        }    
        else if(response.equals("D")){
            dirty = false;
            return true;
        }

        else if(response.equals("A")){
            dirty = true;
            return false;
        }

        else {
            menu.result.append("Invalid response\n");
            return safeToDiscardData();//ask again
        }
        
    }

    private void newz(){
        if (!safeToDiscardData()){
            return;
        }
        courses.clear();
        students.clear();
        tutors.clear();
        sessions.clear();
        file = null;
        dirty = false;

    }

    private void save(){
        file = Menu.selectFile("Select / create .simple file (-1 to abort): ", file, null);
        if(file == null) return;
        try (PrintStream out = new PrintStream(file)) {
            
            out.println(courses.size());
            for (int i = 0; i < courses.size(); i++){
                courses.get(i).save(out);
            }

            out.println(students.size());
            for (int i = 0; i < students.size(); i++){
                students.get(i).save(out);
            }

            out.println(tutors.size());
            for (int i = 0; i < tutors.size(); i++){
                tutors.get(i).save(out);
            }

            out.println(sessions.size());
            for (int i = 0; i < sessions.size(); i++){
                sessions.get(i).save(out);
            }

            menu.result.append("\n Saved to " + file.getName());
        } 
        catch (Exception e) {
            menu.result.append("\nFailed  " + e);
}

    }

    private void saveAs(){
        file = null;
        save();
    }

    private void open(){
        if (!safeToDiscardData()){
            return;
        }

        file = Menu.selectFile("Select .MavTutor file to load (-1 to abort): ", null, null);
        if(file == null) return;
        try (Scanner in = new Scanner(file)) {
            
            int sizeC = in.nextInt();
            in.nextLine();

            this.courses = new ArrayList<>();

            for (int i = 0; i < sizeC; i++){
            courses.add(new Course(in));
            }
            
            int sizeSt = in.nextInt();
            in.nextLine();

            this.students = new ArrayList<>();

            for (int i = 0; i < sizeSt; i++){
            students.add(new Student(in));
            }

            int sizeT = in.nextInt();
            in.nextLine();

            this.tutors = new ArrayList<>();

            for (int i = 0; i < sizeT; i++){
            tutors.add(new Tutor(in));
            }

            int sizeS = in.nextInt();
            in.nextLine();

            this.sessions = new ArrayList<>();

            for (int i = 0; i < sizeS; i++){
            sessions.add(new Session(in));
            }
            dirty = false;

            menu.result.append("\nRecreated MavTutor from " + file.getName());
        } 
        catch (IOException e) {
            menu.result.append("\nFailed to read: " + e);
            newz();

        }
        catch(Exception e)
            {
                menu.result.append(" Error: " + e);
                newz();
            }
    }
    
    public void review(List<? extends Rateable> list){
        if (list.isEmpty()){
        menu.result.append("No items\n");
        return;
        }
        Integer reviewIndex = Menu.selectItemFromList("Select one to review (-1 to abort): ", list, "-1");
        if (reviewIndex < 0){
        menu.result.append("No item to choose\n");
        return;
        }
    }

    private Person login(){
        Person Logged = null;
        String[] items = new String[] {"Tutor", "Student", "Delete"};
        Integer index = Menu.selectItemFromArray("Login : ", items);
        
        if (index == null || index == 2)// one of the 2
        {
            menu.result.append("No students or tutors available\n");
            return Logged;
        }

        if (index == 0){  // Tutor 
        if (!tutors.isEmpty()){
            Integer tIndex = Menu.selectItemFromList("Choose tutor: ", tutors);
            if (tIndex != null && tIndex >= 0){
                Logged = tutors.get(tIndex);
            }
        } 
        else {
            menu.result.append("No tutors \n");
        }
    }
        else if (index == 1){  // Student 
        if (!students.isEmpty()){
            Integer sIndex = Menu.selectItemFromList("Choose student: ", students);
            if (sIndex != null && sIndex >= 0){
                Logged = students.get(sIndex);
            }
        } 
        else {
            menu.result.append("No students \n");
        }
    }
    
    return Logged; 



    }
    

    private void printExpandedComments(Comment  c, int level){

    }

    private void printIndented(String  multiline, int level){

    }



}
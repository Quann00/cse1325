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
            head = "nothing";
        }
        
        System.out.println(Menu.listToString(head, list, '-'));

    }

    private void newCourse(){

    }

    private void newTutor(){

    }

    private void newStudent(){

    }

    private void newSession(){

    }



}
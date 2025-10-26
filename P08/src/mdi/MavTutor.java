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
        this.view = view;
        this.courses = courses;
        this.menu = new Menu(
            
            new Object [] {
                "\n Selection \n"
            },
                //menu items
            new MenuItem("Create New Course", this::newCourse),
            new MenuItem("Create New Tutor", this::newTutor),
            new MenuItem("Create New Student", this::newStudent),
            new MenuItem("Create New Session", this::newSession),

            new MenuItem("View Courses",     () -> selectView(this.courses))

        );
        // start appli run
        this.menu.run();


    }

    public static void main(String[] args){

    }

    @Override
    public String toString(){
        return "MavTutor";
    }

    private void quit(){

    }

    private void selectView(List list){

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
import java.util.Objects;

public class Person {
    private String name;
    private String email;
    public Person(String name, String email){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid Name");
        }
        if (email == null){
            throw new IllegalArgumentException("Invalid Email");

        }
        // initi fields
        this.name = name;
        this.email = email;
    }

public String getName(){
    return name;
    }




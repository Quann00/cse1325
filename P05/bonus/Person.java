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

@Override
public boolean equals(Object o){
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())return false;
    Person person = (Person) o;
    // if both are equal
    return Objects.equals(name, person.name) && Objects.equals(email, person.email);
}

@Override
public int hashCode(){
    return Objects.hash(name, email);
}
@Override
public String toString(){
    return name + "(" + email + ")";
    }
}

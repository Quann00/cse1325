import java.util.Objects;
import java.util.ArrayList;


public class Person implements Rateable{
    protected String name;
    protected String email;
    //new stuff
    private ArrayList<Rating> ratings = new ArrayList<>();


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

 // new stuff
 @Override
public void addRating(Rating rating){
    ratings.add(rating);
}
@Override
public double getAverageRating(){
    double sum = 0;
    // for stars
    for (int i = 0; i < ratings.size(); i++){
        sum += ratings.get(i).getStars();
    }
    return sum / ratings.size();
}
@Override
public Rating[] getRatings(){
    return ratings.toArray(new Rating[0]);
}
}

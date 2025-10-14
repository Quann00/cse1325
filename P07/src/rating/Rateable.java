package rating;
import people.Person;
public interface Rateable{
    void addRating(Rating rating);
    double getAverageRating();
    Rating[] getRatings();
}
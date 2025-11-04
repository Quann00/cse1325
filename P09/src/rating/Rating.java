package rating;

public class Rating{
    private int stars;
    private Comment review;

public Rating(int stars, Comment review){
    if (stars < 1 || stars > 5){
        throw new IllegalArgumentException("Stars must be between 1 - 5");
    }
    this.stars = stars;
    this.review = review;
    }


public int getStars(){
    return stars;
}

public Comment getReview(){
    return review;
}

@Override
public String toString(){
    //initi unicode
    char filledStars = '\u2605';
    char unfilledStars = '\u2606';

    String total = "";
    // add filled stars
    for (int i = 0; i < stars; i++){
        total += filledStars;
    }
    //add unfilled starts
    for (int i = 0; i < 5 - stars ; i++){
        total += unfilledStars;
    }

    return total;
    }   

}

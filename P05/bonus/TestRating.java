public class TestRating {
    public static void main(String[] args){
        System.out.println("Test Class Rating\n");
        //Test 1-5 stars
        Rating rating1 = new Rating (1,null); 
        // get star and toString
        System.out.println(" star 1  getstar" + rating1.getStars());
        System.out.println(" star 1  toString" + rating1.toString());

        Rating rating2 = new Rating (2,null); 
        // get star and toString
        System.out.println(" star 2  getstar" + rating2.getStars());
        System.out.println(" star 2  toString" + rating2.toString());

        Rating rating3 = new Rating (3,null); 
        // get star and toString
        System.out.println(" star 3  getstar" + rating3.getStars());
        System.out.println(" star 3  toString" + rating3.toString());

        Rating rating4 = new Rating (4,null); 
        // get star and toString
        System.out.println(" star 4  getstar" + rating4.getStars());
        System.out.println(" star 4  toString" + rating4.toString());

        Rating rating5 = new Rating (5,null); 
        // get star and toString
        System.out.println(" star 5  getstar" + rating5.getStars());
        System.out.println(" star 5  toString" + rating5.toString());

        
    }
}
public class Card {
    private String term;
    private String definition;
    //Constructor
    public Card (String term, String definition) {
        this.term = term;
        this.definition = definition;

        if(term == null || definition == null) throw new IllegalArgumentException("Either parameter is empty"); 
    }
    //override
    @Override
    public String toString() {
        return definition;
    }
    //Boolean true or false
    public boolean attempt (String response){
        if (response.toUpperCase().equals(term.toUpperCase())) {
            return true;
        }
        else {
            return false;
        }

    }
    // getTerm
    public String getTerm() {
        return term;

    }
}

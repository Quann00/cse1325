import java.util.ArrayList;

public class Comment{
    private String text;
    private Person author;
    private Comment inReplyTo;
    private ArrayList<Comment> replies;



public Comment(String text, Person author, Comment inReplyTo){
    if (text == null || text.isEmpty()){
        throw new IllegalArgumentException("Text cannot be empty");
    }
    if (author == null){
        throw new IllegalArgumentException("Author cannot be empty");
    }
    //initi fields
    this.text = text;
    this.author = author;
    this.inReplyTo = inReplyTo;
    this.replies = new ArrayList<>();
}

public void addReply(String text, Person author){
    if (text == null || text.isEmpty()){
        throw new IllegalArgumentException("Text cannot be empty");
    }
    if (author == null){
        throw new IllegalArgumentException("Author cannot be empty");
    }
    Comment inReplyTo = new Comment(text, author, this);
    this.replies.add(inReplyTo);

}
public int numReplies(){
    return replies.size();
}

public Comment getReply(int index){
    return replies.get(index);
}

public Comment getInReplyTo(){
    return inReplyTo;
}


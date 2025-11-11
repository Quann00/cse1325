package rating;
import people.Person;
import java.io.PrintStream;
import java.util.Scanner;

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

public Comment(Scanner in){
        this.text = in.nextLine();
        this.author = new Person(in);  
        int numReplies = in.nextInt();
        in.nextLine(); 

        this.replies = new ArrayList<>();
        for (int i = 0; i < numReplies; i++) {
            this.replies.add(new Comment(in)); 
        }

    }

public void save(PrintStream out){
        out.println(text);
        author.save(out);


        out.println(replies.size());
        for (int i = 0; i < replies.size(); i++){
            replies.get(i).save(out);
        }
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

@Override
public String toString(){
    String total = "Comment by " + author.toString();
    if (inReplyTo != null){
        StringBuilder sb = new StringBuilder(total);
        sb.append(" in reply to ").append(inReplyTo.author.toString());
        total = sb.toString();  
    }
    total += "\nReplies: ";
    if(!replies.isEmpty()){
        for (int i = 0; i < replies.size(); i++){
            Comment reply = replies.get(i);
            total += " (" + i + ") " + reply.author.toString() + "\n";
        }
        total += "\n";

    }
    total += text + "\n";

    return total;
    }
}

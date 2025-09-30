public class TestPerson{
    public static void main(String[] args){
        //test 1 verify name and email
        Person charlie1 = new Person("Charlie Brown", "cb@aol.com");
        System.out.println("toString: " + charlie1.getName());
        // email
        System.out.println("toString: " + charlie1.toString());
        
        //test 2 verify getName return name field
        if (charlie1.getName().equals("Charlie Brown")){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");

        }

        

    }

}
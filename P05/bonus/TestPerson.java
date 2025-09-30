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

        //test 3 verify equal methods
        //object
        if (charlie1.equals(charlie1)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");

        }
        // false null and string
        if (!charlie1.equals(null)){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");

        }
        if(!charlie1.equals("Charlie Brown")){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // same name and email
        Person charlie2 = new Person("Charlie Brown", "cb@aol.com");
        if (charlie1.equals(charlie2)){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }


    }

}
import java.util.Scanner;

class Arithmetic {
    public int add(int x, int y) {
        return x + y;
    }
}

class Adder extends Arithmetic{

}

abstract class Book{
    String title;

    abstract void setTitle(String s);

    String getTitle(){
        return title;
    }
}

class MyBook extends Book{

    @Override
    void setTitle(String s) {
        this.title = s;
    }
}



public class Solution {
    public static void main(String[] args) {
// Create a new Adder object
        Adder a = new Adder();

        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        MyBook newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("The title is: " + newNovel.getTitle());
        scanner.close();
    }
}



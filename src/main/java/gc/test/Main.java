package gc.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    private User user = new User();

    public static void main(String[] args) {
        new Main();
        System.out.println("hello");
    }

}

class User{
    public User(){
        System.out.println("userclass init...");
    }
}

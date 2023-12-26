package ucu.edu.ua.apps.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student user = Student.builder() .name("Artyer")
                                   .age(12)
                                   .gender("Male")
                                   .mark(54) 
                                   .grades(Arrays.asList(1, 2, 3)).build();
        System.out.println(user.toString());
    }
}
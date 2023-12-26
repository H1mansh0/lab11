package ucu.edu.ua.apps.one;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
public class User {
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
}
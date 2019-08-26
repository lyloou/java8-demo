package com.example.lombok;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("a");
        person1.printSelf();
        person1.printSelf();

        Person person2 = Person.builder().id("id1").identity("identity1").name("name1").build();
        person2.printSelf();
        person2.printSelf();
    }
}

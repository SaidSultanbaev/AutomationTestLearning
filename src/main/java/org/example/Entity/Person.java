package org.example.Entity;

public class Person {
    private String name;
    private int age;
    private String jobTitle;

    public Person(String name, int age, String jobTitle) {
        this.age = age;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public void introduce() {
        System.out.println("My name is " + name + " im " + age + " years old, " + "im " + jobTitle);
    }

    public void celebrateBirthday() {
        this.age++;
        System.out.println("Happy Birthday, " + name + "!" + " Now you are " + age + " years old");
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

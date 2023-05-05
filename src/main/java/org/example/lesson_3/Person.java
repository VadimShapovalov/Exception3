package org.example.lesson_3;

public class Person {
    protected String name;
    protected String lastName;
    protected String middleName;
    protected String birthday;
    protected String male;
    protected String phoneNumber;

    public Person() {

    }
    public Person(String lastName, String name, String middlelName, String birthday, String phoneNumber, String male) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middlelName;
        this.birthday = birthday;
        this.male = male;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMale() {
        return male;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", male='" + male + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

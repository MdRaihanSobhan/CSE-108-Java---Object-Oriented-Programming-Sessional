package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class NewPlayer {
    private final SimpleStringProperty name;
    private final SimpleStringProperty country;
    private SimpleIntegerProperty age;
    private SimpleDoubleProperty height;
    private SimpleStringProperty club;
    private final SimpleStringProperty position;
    private SimpleIntegerProperty number;
    private SimpleDoubleProperty salary;

    public NewPlayer(Player player) {
        name = new SimpleStringProperty(player.getName());
        country = new SimpleStringProperty(player.getCountry());
        club = new SimpleStringProperty(player.getClub());
        position = new SimpleStringProperty(player.getPosition());
        age = new SimpleIntegerProperty(player.getAge());
        number = new SimpleIntegerProperty(player.getNumber());
        height = new SimpleDoubleProperty(player.getHeight());
        salary = new SimpleDoubleProperty(player.getSalary());
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getClub() {
        return club.get();
    }

    public SimpleStringProperty clubProperty() {
        return club;
    }

    public double getHeight() {
        return height.get();
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public String getName() {
        return name.get();
    }

    public double getSalary() {
        return salary.get();
    }

    public SimpleDoubleProperty salaryProperty() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public int getNumber() {
        return number.get();
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setClub(String club) {
        this.club.set(club);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void displayPlayerinfo()
    {
        System.out.println();
        System.out.println("Player Name : "+ this.getName());
        System.out.println("Country: "+ this.getCountry());
        System.out.println("Age: "+ this.getAge());
        System.out.println("Height: "+ this.getHeight()+ "Meter");
        System.out.println("Club: " + this.getClub());
        System.out.println("Position: "+ this.getPosition());
        System.out.println("Number: "+ this.getNumber());
        System.out.println("Weekly Salary: "+ this.getSalary());

    }
}

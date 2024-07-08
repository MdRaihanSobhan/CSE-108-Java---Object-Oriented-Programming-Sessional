package sample;

import java.io.Serializable;
import java.util.Scanner;

public class Player implements Serializable {
     String name;
     String country;
     int age;
     double height;
     String club;
     String position;
     int number;
     double salary;

    public Player(Player player, String clientClub) {

        this.name = player.getName();
        this.country =player.getCountry();
        this.club =clientClub;
        this.position =player.getPosition();
        this.number =player.getNumber();
        this.salary =player.getSalary();
        this.age =player.getAge();
        this.height =player.getHeight();

    }

    public Player(){}

    public void setName(String name){ this.name= name; }
    public void setAge(int age){
        this.age= age;
    }
    public void setCountry(String country) {
        this.country= country;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public void setClub(String club){
        this.club=club;
    }
    public void setPosition(String position){
        this.position= position;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public String getClub(){
        return club;
    }
    public String getPosition(){
        return position;
    }
    public int getAge(){
        return age;
    }
    public int getNumber(){
        return number;
    }
    public double getHeight(){
        return height;
    }
    public double getSalary(){
        return salary;
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

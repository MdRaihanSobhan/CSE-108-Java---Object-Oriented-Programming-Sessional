public class Player {
    private int number;
    private String name;
    private double salary;
    public void setSalary (int salary) {
        this.salary = salary;
    }
    public void setSalary (double salary) {
        this.salary = salary;
    }
    public double getSalary () {
        return salary;
    }
    public void setNumber (int number) {
        this.number = number;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }

    // add your code here
}
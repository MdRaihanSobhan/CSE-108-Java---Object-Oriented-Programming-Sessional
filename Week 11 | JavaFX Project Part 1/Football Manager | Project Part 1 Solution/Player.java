import java.util.Scanner;

public class Player {
   private String name;
   private String country;
   private int age;
   private double height;
   private String club;
   private String position;
   private int number;
   private double salary;

   public Player() { }

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

    public void takeName(Scanner cin) throws Exception {
        System.out.println("Enter Name of the Player : ");
        this.setName(cin.nextLine());
        for (Player player : Server.readFromFile()) {
            if (player.getName().equalsIgnoreCase(this.getName())) {
                System.out.println("Player already in Database!");
                cin.nextLine();
                Server.mainMenu();
            }
        }
    }

    public void takeClub(Scanner cin) throws Exception {
        System.out.println("Enter Name of the Club : ");
        this.setClub(cin.nextLine());
        for (Club club : Server.clubList){
            if(club.getName().equalsIgnoreCase(this.getClub())){
                if(club.playerList.size()<7){
                    this.takeOtherInfo(cin);
                }
                else {
                    System.out.println("You cannot add more player to this club");
                    cin.nextLine();
                    Server.mainMenu();
                }
            }
        }
    }

    public boolean CheckNumber() throws Exception{
        boolean Ok= true;
        for (Club club : Server.clubList){
            if(club.getName().equalsIgnoreCase(this.getClub())){
                for (Player player: club.playerList) {
                    if(this.number==player.number){
                        Ok=false;
                        break;
                    }
                }
            }
        }
        return Ok;
    }
    public boolean CheckPosition() throws Exception{
        boolean Ok= false;
        if (this.position.equalsIgnoreCase("Forward") || this.position.equalsIgnoreCase("Midfielder") ||
                this.position.equalsIgnoreCase("Defender") || this.position.equalsIgnoreCase("Goalkeeper"))
            Ok=true;
        return Ok;
    }

    public void takeOtherInfo(Scanner cin) throws Exception {
        System.out.println("Enter Country of the Player : ");
        this.setCountry(cin.nextLine());
        System.out.println("Enter Age of the Player : ");
        this.setAge(Integer.parseInt(cin.nextLine()));
        System.out.println("Enter Height of the Player : ");
        this.setHeight(Double.parseDouble(cin.nextLine()));
        System.out.println("Enter Position of the Player ");
        this.setPosition(cin.nextLine());
        if(!this.CheckPosition()){
            System.out.println("Invalid Position!");
            cin.nextLine();
            Server.mainMenu();
        }
        System.out.println("Enter Number of the Player: ");
        this.setNumber(Integer.parseInt(cin.nextLine()));
        if(!this.CheckNumber()){
            System.out.println("There is already a player with this number in this club");
            cin.nextLine();
            Server.mainMenu();
        }
        System.out.println("Enter Weekly Salary of the Player ");
        this.setSalary(Double.parseDouble(cin.nextLine()));

        Server.playerList.add(this);
        Server.writeToFile(Server.playerList);
        Server.clubList=Club.setClubList(Server.playerList);
        Server.countryList=Country.setCountryList((Server.playerList));
        System.out.println("Player has been added!");

        cin.nextLine();
        Server.mainMenu();
    }

    public void takePlayer(Scanner cin) throws Exception{
        this.takeName(cin);
        this.takeClub(cin);
        this.takeOtherInfo(cin);
    }


    @Override
    public String toString(){
        return (name+ "," +country+ "," +age+ "," +height+ "," +club+ "," +position+ "," +number+ "," +salary);
    }



}

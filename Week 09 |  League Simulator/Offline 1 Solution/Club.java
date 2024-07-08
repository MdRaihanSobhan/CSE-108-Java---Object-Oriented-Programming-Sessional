public class Club {
    private int id;

    private String name= new String();

    private int points;

    public void setId(int temp){
        id= temp;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String temp){
        this.name=temp;
    }

    public String getName() {
        return this.name;
    }

    public void setPoints(int temp){
        this.points+=temp;
    }

    public int getPoints(){
        return this.points;
    }

    public void resetpoint(){ this.points=0;}
}

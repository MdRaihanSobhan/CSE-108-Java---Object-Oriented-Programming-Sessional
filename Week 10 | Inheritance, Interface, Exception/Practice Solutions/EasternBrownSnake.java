public class EasternBrownSnake extends Reptile implements Venomous{
    EasternBrownSnake(String name,int age){
        setName(name);
        setAge(age);
    }
    public boolean isLethalToAdultHumans(){
        return true;
    }
}

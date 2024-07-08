public class RedBackSpider extends Arachnid implements Venomous{
    RedBackSpider(String name,int age){
        setName(name);
        setAge(age);
    }
    public boolean isLethalToAdultHumans(){
        return false;
    }
}

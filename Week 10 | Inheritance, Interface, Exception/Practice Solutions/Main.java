// you are not allowed to change the main method
public class Main {
    public static void main(String[] args) {
        Bird alex = new Albatross("Alex", 39);
        Mammal spot = new Dog("Spot", 7);
        Mammal fred = new FruitBat("Fred", 10);
        Reptile steph = new EasternBrownSnake("Steph", 12);
        Fish bruce = new GreatWhiteShark("Bruce", 40);
        Arachnid charlotte = new RedBackSpider("Charlotte", 1);
        Mammal perry = new Platypus("Perry", 5);
        Mammal bob = new Human("Bob", 20);

        Animal [] animals = {alex, spot, fred, steph, bruce, charlotte, perry, bob};
        for (Animal a: animals) {
            System.out.print(a);
            if (a instanceof Mammal) {
                ((Mammal) a).printBloodType();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("The following animals are venomous: ");
        for (Animal a: animals) {
            if (a instanceof Venomous) {
                boolean deadly = ((Venomous) a).isLethalToAdultHumans();
                System.out.println(a + (deadly? ", and it's lethal!" : ", and fortunately non-lethal"));
            }
        }
    }
}


/* main output
Alex is a Albatross, aged 39
Spot is a Dog, aged 7, Warm-Blooded!
Fred is a FruitBat, aged 10, Warm-Blooded!
Steph is a EasternBrownSnake, aged 12
Bruce is a GreatWhiteShark, aged 40
Charlotte is a RedBackSpider, aged 1
Perry is a Platypus, aged 5, Warm-Blooded!
Bob is a Human, aged 20, Warm-Blooded!

The following animals are venomous: 
Steph is a EasternBrownSnake, aged 12, and it's lethal!
Charlotte is a RedBackSpider, aged 1, and fortunately non-lethal
Perry is a Platypus, aged 5, and fortunately non-lethal
*/

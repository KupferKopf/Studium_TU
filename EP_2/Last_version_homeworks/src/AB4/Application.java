package AB4;

import AB4.Interfaces.AbstractTreeNode;
import AB4.Interfaces.Dinosaur;

public class Application {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("| Personal Test started |");
        System.out.println();

        Dinosaur dino1 = new TyrannosaurusRex(123,"Rexw");
        Dinosaur dino2 = new TyrannosaurusRex(231,"Rexy");
        Dinosaur dino3 = new TyrannosaurusRex(321,"Rexz");

        NonEmptyTreeNode roote = new NonEmptyTreeNode(dino1);
        roote.store(dino2);
        roote.store(dino3);

        roote.remove(123);
        roote.remove(231);
        roote.remove(321);


        System.out.println("| Personal Test over |");

        // build the corporation with an empty dino population
        AbstractTreeNode animals = new EmptyTreeNode();
        DinoCorp corp = new DinoCorp(animals);

        // setup of two factories, one for Tyrannosaurus rex, one for Edmontosaurus
        corp.registerFactory(new TRexFactory(), "TREX");
        corp.registerFactory(new EdSFactory(), "EDMONTOSAURUS");

        // create the production "script"
        String[] executiveOrders = {
                "#TREX",
                "Mom!200",
                "Tick!456",
                "Trick!123",
                "Track!7",
                "#EDMONTOSAURUS",
                "Donald!1",
                "Daisy!8"
        };
        corp.setOrders(executiveOrders);

        // start production by executing the production script
        // noooooooooo why would we execute the dinos :(
        int oid = 0;
        while (corp.processNextOrder()) {
            System.out.println("order " + executiveOrders[oid++] + " executed.");
        }
        System.out.println();

        // feeding time
        System.out.println("All new and hungry dinos...");
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));

        System.out.println("Feed some meat...");
        corp.feed(Dinosaur.Food.MEAT);
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));

        System.out.println("Feed some plants...");
        corp.feed(Dinosaur.Food.PLANTS);
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));
        System.out.println();

        System.out.println("Today's cast:");
        // dump dinos to console utilizing the flatten() method
        Dinosaur[] flattened = animals.flatten();
        for (Dinosaur dino : flattened) {
            System.out.println(dino);
        }
        System.out.println("After flatten");

        // some additional test code for the tree implementation

        AbstractTreeNode root = new EmptyTreeNode();    // create an empty tree to start with

        root = root.store(new TyrannosaurusRex(200, "Mom"));     // add some dinos
        root = root.store(new TyrannosaurusRex(123, "Jim"));     // add some dinos
        root = root.store(new TyrannosaurusRex(456, "Jack"));   // add some dinos
        root = root.store(new Edmontosaurus(7, "Joe"));          // add some dinos
        root = root.store(new Edmontosaurus(127, "Elvis"));      // add some dinos

        // dump dinos to console utilizing the flatten() method
        Dinosaur[] population = root.flatten();
        for (Dinosaur dino : population) {
            System.out.println(dino);
        }

        System.out.println();
        // find dino via DNA
        Dinosaur target = null;
        target = root.find(200);    // should be found
        System.out.println(target != null ? target : "200 not found");
        target = root.find(123);    // should be found
        System.out.println(target != null ? target : "123 not found");
        target = root.find(456);    // should be found
        System.out.println(target != null ? target : "456 not found");
        target = root.find(7);      // should be found
        System.out.println(target != null ? target : "7 not found");
        target = root.find(127);    // should be found
        System.out.println(target != null ? target : "127 not found");

        target = root.find(100);    // should not be found
        System.out.println(target != null ? target : "100 not found");

        // find dino by name
        target = root.findByName("Mom");
        System.out.println(target != null ? target : "not found");

        target = root.findByName("Joe");
        System.out.println(target != null ? target : "not found");

        target = root.findByName("Bob");
        System.out.println(target != null ? target : "not found");


        // remove mom and joe
        root = root.remove(200);
        target = root.find(200);
        System.out.println(target != null ? target : "not found");

        // remove non existing dino
        root = root.remove(6);
        target = root.find(7);
        System.out.println(target != null ? target : "not found");

        root = root.remove(7);
        target = root.find(7);
        System.out.println(target != null ? target : "not found");

        // flatten tree
        flattened = root.flatten();
        for (Dinosaur dino : flattened) {
            System.out.println(dino);
        }

        // TODO: implementation of any developer specific tests (optional)

    }
}

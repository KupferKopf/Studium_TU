package AB6;

import AB6.Provided.DinosaurCollection;
import AB6.Provided.DinosaurDNA;

public class Application {
    public static void main(String[] args) {

//        int test = 500;
//
//        DinosaurDNA dna = new DinosaurDNA(test);
//
//        ArenaFightingBehavior testBehaviour = new ArenaFightingBehavior(dna);
//
//        System.out.println(testBehaviour.getPlannedAction(0));
//        System.out.println(testBehaviour.getPlannedAction(1));
//        System.out.println(testBehaviour.getPlannedAction(2));
//




        // create some meaningful dino dna
        int geneticCodeAllrounder = (0b0001 << 20) | (0b1110010011100100 << 4) | 0b0001; // uniqueID, battlePlan, male
        int geneticCodeGandhi = (0b0010 << 20) | (0b0000000000000000 << 4) | 0b0001; // uniqueID, battlePlan, male
        int geneticCodeCyclone = (0b0011 << 20) | (0b1010011010100110 << 4) | 0b0001; // uniqueID, battlePlan, male
        int geneticCodeMuncher = (0b0100 << 20) | (0b0011111100111111 << 4) | 0b0001; // uniqueID, battlePlan, male
        int geneticCodeBrainiac = (0b0101 << 20) | (0b1110110111111001 << 4) | 0b0000; // uniqueID, battlePlan, female
        int geneticCodeLunatic = (0b0111 << 20) | (0b1101110111011101 << 4) | 0b0000; // uniqueID, battlePlan, female

        DinosaurCollection population = new DinosaurCollection(); // list of all participants

        population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeLunatic), "Ms. Luna"));
        population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeCyclone), "Typhoon D."));
        population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeAllrounder), "Mr. Big"));
        population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeGandhi), "Gandhi"));
        population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeMuncher), "Morris the Muncher"));
        population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeBrainiac), "Mrs. Brainiac"));

        System.out.println("Setting up the 2025 International Dino Games with " + population.size() + " participants...");

        System.out.println("Female participants:");
        DinosaurFilteringIterator femaleDinoIterator = population.filteringIterator(new FemaleSelector());
        while (femaleDinoIterator.hasNext()) {
            System.out.println("   " + femaleDinoIterator.next().getName());
        }

        System.out.println("Male participants:");
        DinosaurFilteringIterator maleDinoIterator = population.filteringIterator(new MaleSelector());
        while (maleDinoIterator.hasNext()) {
            System.out.println("   " + maleDinoIterator.next().getName());
        }
        System.out.println();

        // setting up the arena
        Arena arena = new Arena(new ArenaBattleSimulation(), population);

        // run the tournament
        System.out.println("Let's get ready to rumble...");
        arena.runTournament();

        // print the results
        TournamentResultIterator resultIterator = arena.getResultIterator();
        System.out.println("Results:");
        int position = 1;
        while (resultIterator.hasNext()) {
            System.out.println("Rank " + position++ + ": " + resultIterator.next().getName());
        }

        // TODO: implementation of any developer specific tests (optional)

    }
}

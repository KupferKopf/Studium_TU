package AB6;

import AB6.Interfaces.BattleSimulation;
import AB6.Interfaces.Dinosaur;
import AB6.Provided.DinosaurCollection;
import AB6.Provided.DinosaurIterator;

/**
 * The Arena class models a tournament between a roster of dinosaurs, each competing
 * against the others in a series of fights. In a fight each dinosaur is evaluated based on its
 * predefined fighting behavior and that of its opponent.
 */
public class Arena {
    private Dinosaur[] roster;
    private int[] scoreSheet;
    private BattleSimulation sim = null;

    // TODO: variable declarations (optional)

    /**
     * Constructs an {@code Arena} object and initializes its roster and scoresheet using the provided collection
     * of dinosaur fighters.
     *
     * <p>The roster is built from the provided collection of dinosaur fighters in a first-come-first-serve manner.
     * So participants that are returned early by the collection's iterator will also be located "early" within the
     * roster (low index).</p>
     *
     * <p>The scoresheet holds the overall score for each participant (sum of scores of all fights the participant
     * was engaged in).</p>
     *
     * @param sim      an implementation of the {@code BattleSimulation} interface that represents the rules of engagement
     *                 for the fights performed in this arena.
     * @param fighters a collection of {@code Dinosaur} objects that will participate in the tournament.
     *                 This collection is used to build the roster and determine the size of the scoresheet.
     *                 It must not be {@code null}.
     */
    public Arena(BattleSimulation sim, DinosaurCollection fighters) {

        roster = new Dinosaur[fighters.size()];
        scoreSheet = new int[fighters.size()];
        this.sim = sim;
        DinosaurIterator iterator = fighters.iterator();


        int pos = 0;
        while (iterator.hasNext()){
            roster[pos++] = iterator.next();
        }

    }

    /**
     * Builds a roster of Dinosaur objects from the provided collection of fighters.
     *
     * <p>This method serializes the given collection of dinosaurs into an array of participants, the roster.</p>
     *
     * @param fighters a collection of {@code Dinosaur} objects that participate in the tournament and will be used
     *                 to build the roster. This collection must not be null.
     * @return an array of Dinosaur objects extracted from the provided collection.
     */
    private Dinosaur[] buildRoster(DinosaurCollection fighters) {
        Dinosaur[] ret = new Dinosaur[fighters.size()];
        DinosaurIterator iterator = fighters.iterator();

        int pos = 0;
        while (iterator.hasNext()){
            ret[pos++] = iterator.next();
        }
        return ret;
    }


    /**
     * Simulates a tournament where all dinosaurs in the roster face off against each other and updates their scores
     * based on their performance in the matches.
     *
     * <p>Each dinosaur competes against every other dinosaur exactly once ("A vs. B" is the same as "B vs. A" and hence
     * is only executed once). The results of each match affect the scoresheet:
     * - If a dinosaur wins a match, its corresponding score in the scoresheet is incremented by 1.
     * - If a match results in a draw, no updates are made to the scoresheet.</p>
     *
     * <p>The tournament is conducted by iterating through the roster and invoking the `executeFight` method of the arena's
     * {@code BattleSimulation} for each pair of dinosaurs. The winner of each fight is determined by the simulation.</p>
     * <p>
     * The method assumes the roster and scoresheet have been initialized properly. The roster should contain all
     * participating dinosaurs, while the scoresheet corresponds to and matches the roster.
     */
    public void runTournament() {

        scoreSheet = new int[roster.length];

        for (int i = 0; i < roster.length; i++) {
            for (int j = i+1; j < roster.length; j++) {
                Dinosaur winner = sim.executeFight(roster[i], roster[j]);

                if(winner != null){
                    //System.out.println(winner.getName());
                    if(winner == roster[i]) scoreSheet[i]++;
                    else scoreSheet[j]++;

                }
            }
        }
        //System.out.println("after tournament");

    }

    /**
     * Provides an iterator for accessing the results of a tournament.
     * The iterator allows traversal over the tournament results, where each result
     * corresponds to a participant dinosaur from the roster based on their performance in the tournament.
     *
     * @return a {@code TournamentResultIterator} that iterates over the dinosaurs in the roster,
     * ordered by their scores in the tournament from highest (winner) to lowest (last). If multiple participants
     * with the same score exist (same number of wins), these are ordered according to their position in the roster
     * (first come, first serve).
     */
    public TournamentResultIterator getResultIterator() {
        return new TournamentResultIterator(roster, scoreSheet);
    }
}

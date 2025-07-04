package AB6;

import AB6.Interfaces.BattleSimulation;
import AB6.Interfaces.Dinosaur;
import AB6.Interfaces.FightingBehavior;
import AB6.Interfaces.FightingBehavior.Action;

public class ArenaBattleSimulation implements BattleSimulation {
    // TODO: variable declarations (optional)

    /**
     * Executes a fight between two dinosaurs based on their respective fighting behaviors.
     *
     * <p>The method determines the winner by simulating a series of combat rounds
     * according to the predefined battle plans of the dinosaurs. The number of rounds is equivalent to
     * the size of these plans. Each dinosaur's individual battle plan is provided by its {@code getFightingBehavior()}
     * method, and is an instance of {@code FightingBehavior}.</p>
     *
     * <p>If one of the participants is {@code null}, the other is declared winner by forfeit. If both are null, this method
     * will simply return null. If the fight ends in a draw, the method also returns null.</p>
     *
     * <p>The method also logs information on each fight (name of participants), each round, and the final result to the
     * console using the provided methods {@code logFight()}, {@code logRound()}, and {@code logResult()}</p>
     *
     * @param dinoA the first dinosaur participating in the fight
     * @param dinoB the second dinosaur participating in the fight
     * @return the winning dinosaur, or {@code null} if the fight results in a draw or if both participants are null
     */
    @Override
    public Dinosaur executeFight(Dinosaur dinoA, Dinosaur dinoB) {

        if(dinoA == null && dinoB == null)return null;
        if(dinoA == null){
            System.out.println("Only " + dinoB.getName() + " appeared and wins by default!");
            return dinoB;
        }
        if(dinoB == null){
            System.out.println("Only " + dinoA.getName() + " appeared and wins by default!");
            return dinoA;
        }

        logFight(dinoA, dinoB);

        FightingBehavior behaviorA = dinoA.getFightingBehavior();
        FightingBehavior behaviorB = dinoB.getFightingBehavior();

        int round = 0;
        int score = 0;
        int result = 0;
        // falls beide keinen move mehr haben ists halt aus
        while (round < ArenaFightingBehavior.BATTLEPLAN_SIZE) {


            Action currAAction = behaviorA.getPlannedAction(round);
            Action currBAction = behaviorB.getPlannedAction(round);

            result = executeAction(currAAction, currBAction);

            logRound(round + 1, currAAction, currBAction, result);

            score += result;
            round++;
        }

        logResult(score, dinoA, dinoB);

        if(score == 0) return null;
        return score < 0 ? dinoA : dinoB;
    }

    /**
     * Executes a single round of a fight between two participants, each performing one action.
     * <p>The result of the round is based on predefined rules of how different actions interact with each other.
     * The rules are as follows:<br>
     * - If both participants perform the same action, it is a draw.<br>
     * - NONE always looses against DODGE, BITE, and TAIL_WHIP<br>
     * - DODGE beats BITE<br>
     * - BITE beats TAIL_WHIP<br>
     * - TAIL_WHIP beats DODGE<br>
     * </p>
     *
     * @param actionA the action performed by participant A
     * @param actionB the action performed by participant B
     * @return an integer value indicating the outcome of the round:
     * -1 if participant A wins,
     * 0 if the round is a draw,
     * 1 if participant B wins
     */
    @Override
    public int executeAction(Action actionA, Action actionB) {

        if(actionA == actionB) return 0; // beide gleich somit draw
        if(actionA == Action.NONE) return 1; // A None somit B win
        if(actionB == Action.NONE) return -1; // B None somit A win

        if(actionA == Action.BITE){
            if(actionB == Action.DODGE) return 1;
            else return -1;
        }

        if(actionA == Action.TAIL_WHIP){
            if(actionB == Action.BITE) return 1;
            else return -1;
        }

        if(actionA == Action.DODGE){
            if(actionB == Action.TAIL_WHIP) return 1;
            else return -1;
        }

        return 0;
    }

    /**
     * Logs the details of a fight between two dinosaurs by printing their names to the console.
     *
     * @param dinoA the first dinosaur participating in the fight
     * @param dinoB the second dinosaur participating in the fight
     */
    private void logFight(Dinosaur dinoA, Dinosaur dinoB) {
        /* If this method is changed, provided output examples may become invalid. */
        System.out.println("# " + dinoA.getName() + " vs. " + dinoB.getName());
    }

    /**
     * Logs the result of a battle between two dinosaurs, specifying the winner or indicating a draw.
     *
     * @param score the result of the battle; zero indicates a draw, a negative value indicates the first dinosaur wins,
     *              and a positive value indicates the second dinosaur wins
     * @param dinoA the first dinosaur participating in the battle
     * @param dinoB the second dinosaur participating in the battle
     */
    private void logResult(int score, Dinosaur dinoA, Dinosaur dinoB) {
        /* If this method is changed, provided output examples may become invalid. */
        if (score == 0){
            System.out.println("Draw..");
        }
        else{
            System.out.println("Winner: " + ((score < 0) ? dinoA.getName() : dinoB.getName()) );
        }
        System.out.println();
    }

    /**
     * Logs the details of a single round in a battle, including the round number, actions
     * performed by both participants, and the result of the round.
     *
     * @param round   the number of the current round being logged
     * @param actionA the action performed by participant A during the round
     * @param actionB the action performed by participant B during the round
     * @param result  the outcome of the round:
     *                0 for a draw,
     *                a negative value if participant A wins,
     *                a positive value if participant B wins
     */
    private void logRound(int round, Action actionA, Action actionB, int result) {
        /* If this method is changed, provided output examples may become invalid. */
        System.out.println(
                "  Round " + round + ": " +
                        actionA + " vs. " + actionB + " => " +
                        ((result == 0) ? "draw" : ((result < 0) ? actionA : actionB) + " wins.")
        );
    }
}

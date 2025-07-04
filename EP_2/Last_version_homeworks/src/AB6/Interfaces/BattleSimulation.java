/* DO NOT EDIT */
package AB6.Interfaces;

import AB6.Interfaces.FightingBehavior.Action;

/**
 * The BattleSimulation interface provides methods to simulate battles between dinosaurs.
 * It defines rules and mechanisms for executing full fights as much as single turns (aka rounds).
 */
public interface BattleSimulation {
    /**
     * Executes a fight between two dinosaurs based on their respective fighting behaviors.
     *
     * <p>The method determines the winner by simulating a series of combat rounds
     * according to the predefined battle plans of the dinosaurs. The number of rounds is predefined by the size of
     * the battle plans.</p>
     *
     * @param dinoA the first dinosaur participating in the fight
     * @param dinoB the second dinosaur participating in the fight
     * @return the winning dinosaur, or {@code null} if the fight results in a draw or if both participants are null
     */
    Dinosaur executeFight(Dinosaur dinoA, Dinosaur dinoB);

    /**
     * Executes a single round of a fight between two participants, each performing one action.
     * <p>The result of the round is based on rules of how different actions interact with each other.</p>
     *
     * @param actionA the action performed by participant A
     * @param actionB the action performed by participant B
     * @return an integer value indicating the outcome of the round:
     * -1 if participant A wins,
     * 0 if the round is a draw,
     * 1 if participant B wins
     */
    int executeAction(Action actionA, Action actionB);
}

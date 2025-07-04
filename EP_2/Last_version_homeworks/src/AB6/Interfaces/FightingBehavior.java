/* DO NOT EDIT */
package AB6.Interfaces;

/**
 * Represents an animal's behavior at a fight.
 *
 * <p> The behavior is a plan-like ordered sequence of actions that are performed one by one in ascending order during
 * a battle scenario. The interface provides functionality for decoding genetic data into a sequence of basic actions
 * and retrieving planned actions based on their position in the battle plan.</p>
 */
public interface FightingBehavior {
    /**
     * Represents an enumeration of possible actions in a fighting behavior context.
     *
     * <p>Each action indicates a specific type of activity that can be performed
     * during a battle scenario. The possible actions include:<br>
     * - DODGE: represents a defensive move to avoid a bite.<br>
     * - TAIL_WHIP: represents an offensive move involving whipping with the tail.<br>
     * - BITE: represents an aggressive biting action.<br>
     * - NONE: represents no action being performed.</p>
     */
    public enum Action {
        DODGE,
        TAIL_WHIP,
        BITE,
        NONE
    }

    /**
     * Decodes a binary sequence of 2-bit genes to construct a battle plan (an array of actions).
     *
     * <p>Each 2-bit-sized gene in the sequence is processed by {@code decodeActionGene()} to determine the corresponding
     * {@code Action} value, which then is stored inside the battle plan in ascending order.</p>
     * <p>The genes are also stored in ascending order within the binary sequence, so the genes of action 0 are stored in
     * bits [0,1], those of action 1 in bits [2,3] a.s.o.</p>
     *
     * @param geneSequence an integer representing the encoded sequence of genes,
     *                     where each pair of bits (2 bits per gene) corresponds to an action
     */
    void decodeBehavior(int geneSequence);

    /**
     * Decodes the given gene value into its corresponding Action.
     * Each gene value represents a specific action, or none if the value is not recognized ore zero.
     *
     * @param gene an integer representing a gene value (part of the genome) for an action
     * @return the {@code Action} corresponding to the provided gene value:
     * <p>DODGE for gene {@code 0b01}, TAIL_WHIP for gene {@code 0b10}, BITE for gene {@code 0b11},
     * and NONE for any other gene value resp. {@code 0b00}</p>
     */
    Action decodeActionGene(byte gene);

    /**
     * Retrieves action at the specified index in the battle plan.
     * If the index is out of bounds, it returns {@code Action.NONE}.
     *
     * @param index the position in the battle plan to fetch the action from.
     *              Valid indices are between 0 (inclusive) and {@code BATTLEPLAN_SIZE} (exclusive).
     * @return the {@code Action} at the specified index, or {@code Action.NONE} if the index is invalid
     */
    Action getPlannedAction(int index);

}

package AB6;

import AB6.Interfaces.FightingBehavior;
import AB6.Provided.DinosaurDNA;

/**
 * Implements the {@code FightingBehavior} interface to define specific behavior
 * for a dinosaur in an arena fighting context. The behavior is determined
 * by decoding genetic information into a predefined sequence of actions,
 * referred to as a battle plan.
 */
public class ArenaFightingBehavior implements FightingBehavior {
    public static final int BATTLEPLAN_SIZE = 8;
    private Action[] battlePlan = new Action[BATTLEPLAN_SIZE];

    // TODO: variable declarations (optional)

    /**
     * Constructs an {@code ArenaFightingBehavior} object by decoding a dinosaur's DNA
     * into a battle plan consisting of individual actions.
     *
     * <p>The genes defining the battle plan (an animal's fighting behavior) require {@code 2 * BATTLEPLAN_SIZE} bit
     * and are located from the 5th bit (bits 0-3 are reserved for other purposes) upwards. These bits are decoded into
     * a plan by calling the method {@code decodeBehavior()}.</p>
     *
     * @param dna the {@code DinosaurDNA} object containing the genetic information to be decoded
     *            into a battle plan
     */
    public ArenaFightingBehavior(DinosaurDNA dna) {
        //System.out.println(dna.getGeneticCode());
        //System.out.println(Integer.toBinaryString(dna.getGeneticCode()));
        battlePlan = new Action[BATTLEPLAN_SIZE];
        decodeBehavior(dna.getGeneticCode() >> 4);
    }

    /**
     * Decodes a binary sequence of 2-bit genes to construct a battle plan (an array of actions).
     *
     * <p>Each 2-bit-sized gene in the sequence is processed by {@code decodeActionGene()} to determine the corresponding
     * {@code Action} value, which then is stored inside the battle plan in ascending order.</p>
     * <p>The genes are also stored in ascending order within the binary sequence, so the genes of action 0 are stored in
     * bits [1,0], those of action 1 in bits [3,2] a.s.o. with the higher indexed bit being the MSB</p>
     *
     * @param geneSequence an integer representing the encoded sequence of genes,
     *                     where each pair of bits (2 bits per gene) corresponds to an action
     */
    @Override
    public void decodeBehavior(int geneSequence) {
        //System.out.println("after first shift: " + geneSequence);
        //System.out.println("after first shift: " + Integer.toBinaryString(geneSequence));
        int pos = 0;
        while(geneSequence != 0 && pos < battlePlan.length){

            int currentBits = geneSequence & 0b11; // letzten 2 bits bekommen als int also: 0, 1, 2 oder 3
            Action curAction = decodeActionGene((byte)currentBits);

            battlePlan[pos++] = curAction;

            geneSequence >>= 2;

        }
        //System.out.println(pos);
    }

    /**
     * Decodes the given gene value into its corresponding Action.
     *
     * <p>Each gene value represents a specific action, or none if the value is not recognized or zero.</p>
     *
     * @param gene an integer representing a gene value (part of the genome) of an action
     * @return the Action corresponding to the provided gene value;
     * <p>DODGE for gene {@code 0b01}, TAIL_WHIP for gene {@code 0b10}, BITE for gene {@code 0b11},
     * and NONE for any other gene value resp. {@code 0b00}</p>
     */
    @Override
    public Action decodeActionGene(byte gene) {
        return switch (gene) {
            case 1 -> Action.DODGE;
            case 2 -> Action.TAIL_WHIP;
            case 3 -> Action.BITE;
            default -> Action.NONE;
        };
    }

    /**
     * Retrieves the action at the specified index in the battle plan.
     * If the index is out of bounds, it returns {@code Action.NONE}.
     *
     * @param index the position in the battle plan to fetch action from.
     *              Valid indices are between 0 (inclusive) and {@code BATTLEPLAN_SIZE} (exclusive).
     * @return the {@code Action} at the specified index, or {@code Action.NONE} if the index is invalid
     */
    @Override
    public Action getPlannedAction(int index) {
        if(index >= battlePlan.length || index < 0) return Action.NONE;
        return battlePlan[index];

    }
}

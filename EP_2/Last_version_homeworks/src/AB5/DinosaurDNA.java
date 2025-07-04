package AB5;

/**
 * The DinosaurDNA class represents the genetic information of a dinosaur
 * encoded as an integer. This class provides methods to retrieve the
 * genetic code, compare equality, compute the hash code, and generate a string
 * representation of the DNA characteristics.
 */
public class DinosaurDNA {
    private int geneticCode;

    // TODO: variable declarations (optional)

    /**
     * Constructs a DinosaurDNA object with the given genetic code.
     *
     * @param geneticCode an integer representing the genetic information of a dinosaur
     */
    public DinosaurDNA(int geneticCode) {
        this.geneticCode = geneticCode;
    }

    /**
     * Retrieves the genetic code of the dinosaur.
     *
     * @return an integer representing the genetic code of the dinosaur
     */
    public int getGeneticCode() {
        return geneticCode;
    }

    /**
     * Compares this DinosaurDNA instance with another object for equality.
     * Two DinosaurDNA instances are considered equal if they have the same genetic code,
     * and they belong to the DinosaurDNA class.
     *
     * @param obj the object to be compared for equality with this DinosaurDNA instance
     * @return true if the specified object is equal to this DinosaurDNA instance, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == DinosaurDNA.class){
            if(geneticCode == ((DinosaurDNA) obj).geneticCode){
                return true;
            }
        }
        return false;
    }

    /**
     * Computes the hash code for this DinosaurDNA instance based on its genetic code.
     *
     * @return the hash code computed from the genetic code of this DinosaurDNA instance
     */
    @Override
    public int hashCode() {
        return geneticCode;
    }

    /**
     * Returns a string representation of the DinosaurDNA object.
     * The string includes the binary string representation of the genetic code as well as
     * the integer value of the genetic code.
     * <p>The precise format is defined as: "DNA:" followed by a white space, followed by the binary string
     * representation of the genetic code, followed by a white space, followed by the integer value of the genetic code
     * within parentheses, e.g. "DNA: 101 (5)".
     *
     * @return a string representation of the DinosaurDNA object, in the format specified above.
     */
    @Override
    public String toString() {
        String ret = "DNA: ";

        int[] binary = intToBinary(geneticCode);

        if(binary[0] == 1) ret += "-";

        for (int i = 1; i < 33; i++) {
            if(binary[i] == -1) break;
            ret += binary[i];
        }

        return ret + " (" + geneticCode + ")";
    }


    private int[] intToBinary(int input){
        int[] binary = new int[33];

        if(input < 0){
            binary[0] = 1;
            input *= -1;
        }

        int cursor = 1;
        while(input > 0){
            binary[cursor++] = input%2;
            input /= 2;
        }
        if(cursor < 33) binary[cursor] = -1;
        return binary;
    }

}

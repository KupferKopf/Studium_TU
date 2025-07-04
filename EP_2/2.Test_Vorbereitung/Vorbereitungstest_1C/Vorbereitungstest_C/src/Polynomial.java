/**
 * This polynomial is an expression of one variable in the form a⋅x⁰+b⋅x¹+c⋅x²+d⋅x³+e⋅x⁴ ... .
 * More generally, it is a sum of multiple monomials of the form c⋅xᵈ where 'c' is the constant
 * coefficient, 'x' is the variable and 'd' the constant degree of the monomial. 'c' and 'd'
 * can take on any value (also a negative value or 0).
 */
//
// TODO: Complete the methods in 'Polynomial'.
//       You can define further classes and methods if needed.
//       Do NOT use the Java-Collection framework in 'Polynomial' or any other class.
//
public class Polynomial {

    ConstConstTreeMap polyMap;


    /**
     * Initializes this polynomial using the specified map in which in each key-value pair
     * represents one monomial. The degree of a monomial (key of 'IntConst') is associated with
     * the coefficient of the monomial (value of 'IntConst'). Later changes of 'map' will
     * not affect 'this'.
     *
     * @param map, the map from which this polynomial is constructed, map != null,
     *             'map' is not empty.
     */
    public Polynomial(ConstConstTreeMap map) {

       polyMap = new ConstConstTreeMap(map);

    }

    /**
     * Returns a new polynomial representing the sum of 'this' and 'p'.
     *
     * @param p the second summand, p != null.
     * @return a new polynomial representing the sum of 'this' and 'p'.
     */
    public Polynomial plus(Polynomial p) {

        NodeIterator iter_local = p.polyMap.getIterator();
        NodeIterator iter_other = this.polyMap.getIterator();

        ConstConstTreeMap ret  = new ConstConstTreeMap();

        Node local = null;
        Node other = null;

        while(iter_local.hasNext() || iter_other.hasNext()){
            if(iter_local.hasNext() && local == null) local = iter_local.next();
            if(iter_other.hasNext() && other == null) other = iter_other.next();

            if(local != null && other == null){
                ret.put(local.getKey(), local.getValue());
                local = null;
            }else if(local == null && other != null) {
                ret.put(other.getKey(), other.getValue());
                other = null;
            }else if(local.getKey().isEqual(other.getKey())){
                //System.out.println("local: " + local.getKey() + " " + local.getValue() + " | other: " + other.getKey() + " " + other.getValue());
                IntConst temp = local.getValue();
                //System.out.println("bevor plus " + temp);
                //System.out.println("other value " + other.getValue());
                temp = temp.plus(other.getValue());
                //System.out.println("after plus " + temp);
                ret.put(local.getKey(), temp);
                other = null;
                local = null;
            }else {
                if (local.getKey().lessThan(other.getKey())) {
                    ret.put(local.getKey(), local.getValue());
                    local = null;
                } else {
                    ret.put(other.getKey(), other.getValue());
                    other = null;
                }
            }

        }

        return new Polynomial(ret);
    }

    /**
     * Returns a string representation of this polynomial in which the terms appear ordered
     * according to their degree and there is at most one term with a specific degree (terms of
     * the same degree are represented by their sum). The terms are separated by " + ".
     * Monomials with coefficient of 0 do not appear in the string representation
     * (if all monomials are 0 an empty string is returned).
     * Example: "-2x^3 + 1x^4 + -3x^5"
     *
     * @return the string representation of this polynomial.
     */
    public String toString() {

        String ret = "";

        IntConstQueue queue = new IntConstQueue();
        polyMap.addAllKeysTo(queue);

        IntConst cursor = queue.poll();

        while(cursor != null){
            if(!polyMap.get(cursor).isZero()) {
                ret += polyMap.get(cursor) + "x^" + cursor;
            }
            cursor = queue.poll();
            if(cursor != null){
                ret += " + ";
            }
        }

        return ret;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
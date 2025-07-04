package AB5;

import AB5.Interfaces.BucketList;
import AB5.Interfaces.Dinosaur;

/**
 * The {@code DinosaurHashMapIterator} class provides an iterator for traversing over all
 * {@code Dinosaur} objects within a {@code DinosaurHashMap}.
 *
 * <p>This iterator ensures that all non-empty buckets are processed sequentially. The iteration process
 * skips over any empty buckets and processes all non-empty buckets using the list iterator provided by each bucket.
 * If a bucket is completely processed, the {@code DinosaurHashMapIterator} continues to iterate seamlessly over the next
 * non-empty bucket. If all non-empty buckets have been processed {@code hasNext() returns false} and any subsequent call
 * to {@code next()} returns {@code null}</p>
 */
public class DinosaurHashMapIterator {
    private BucketList[] buckets;         // the hashmap's buckets
    private int bucketIndex;              // the currently processed bucket
    private DinosaurListIterator currentBucketIterator; // the list iterator of the currently processed bucket

    // TODO: variable declarations (optional)

    /**
     * Constructs a {@code DinosaurHashMapIterator}.
     *
     * <p>This constructor initializes the iterator at the first bucket in the array.
     * If the first bucket is empty, subsequent calls to {@code hasNext()} or {@code next()}
     * will automatically skip over empty buckets and find the next non-empty bucket.</p>
     *
     * @param buckets the hashmap's array of {@code BucketList} objects that store {@code Dinosaur} objects.
     *                Each bucket may contain zero or more {@code Dinosaur} objects, and empty buckets
     *                are skipped during iteration.
     */
    public DinosaurHashMapIterator(BucketList[] buckets){
        this.buckets = buckets;
        bucketIndex = 0;
        currentBucketIterator = buckets[0].iterator();

    }

    /**
     * Advances the bucket index to the next non-empty bucket in the array of buckets and updates
     * the current bucket iterator to iterate over the elements in that bucket.
     *
     * <p>If the current bucket and all subsequent buckets are empty or if the end of the bucket array
     * is reached, this method returns {@code false}.</p>
     *
     * @return {@code true} if a non-empty bucket was found and the iterator was successfully updated;
     *         {@code false} otherwise, indicating that there are no more non-empty buckets.
     */
    private boolean setNextNonEmptyBucket(){
        bucketIndex++;

        while(true){
            if(bucketIndex >= buckets.length){
                //System.out.println("auserhalb vom bucket");
                return false;}
            if(!buckets[bucketIndex].isEmpty()){
                //System.out.println("nicht leerer bucket gefuhnden bei index: " + bucketIndex);
                break;
            }
            bucketIndex++;
        }

        return true;
    }

    /**
     * Determines whether there are more elements to iterate over in the hashmap.
     * This method checks if the current bucket has more elements or if subsequent
     * buckets contain elements by advancing to the next non-empty bucket if necessary.
     *
     * @return true if there are more elements to iterate over, false otherwise.
     */
    public boolean hasNext(){
        if(currentBucketIterator.hasNext()) return true;

        int posCur = bucketIndex;
        boolean ret = setNextNonEmptyBucket();
        bucketIndex = posCur;
        return ret;
    }

    /**
     * Retrieves the next {@code Dinosaur} object in the hashmap iteration sequence.
     *
     * <p>This method iterates through the current bucket using the {@code currentBucketIterator}.
     * If the current bucket is depleted, it attempts to find the next non-empty bucket by
     * advancing the bucket index. If no non-empty buckets remain, the method returns {@code null}.</p>
     *
     * @return the next {@code Dinosaur} object if available; {@code null} if there are no more elements.
     */
    public Dinosaur next(){
        if(currentBucketIterator.hasNext()){
            return currentBucketIterator.next();
        }

        if(setNextNonEmptyBucket()){
            currentBucketIterator = buckets[bucketIndex].iterator();
            return currentBucketIterator.next();
        }


        return null;
    }
}

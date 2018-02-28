package csc143.data_structures;
/**
 * 
 * Exception for when the Queues/Stacks become overfilled
 * 
 * @author Samson Haile
 * 
 * 
 */
public class Overfill extends DataStructureException {
    public Overfill(String msg) {
        super(msg);
    }
}

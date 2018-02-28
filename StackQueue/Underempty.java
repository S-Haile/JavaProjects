package csc143.data_structures;
/**
 * 
 * Exception for when someone tries to remove something from a queue/stack
 * when it is empty
 * 
 * @author Samson Haile
 * 
 * 
 */
public class Underempty extends DataStructureException {
    public Underempty(String msg) {
        super(msg);
    }
}
package e2011;


public interface Listener {
    
    /*
     * Listener interface listens changes from MatchResult, the implemented
     * class will deal with the changed information.
     */
    public void changed(MatchResult matchResult);
}

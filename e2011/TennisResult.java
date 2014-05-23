package e2011;


public class TennisResult extends MatchResult {
    
    public TennisResult(String homeTeam, String awayTeam) {
        super(homeTeam, awayTeam);
    }
    
    /**
     * change class MatchResult to abstract class,
     * change methods to abstract which are needed to be
     * specified by sub class.
     * 
     * Example: boolean isWinner is a abstract method and needed to be specified
     * here
     */
    @Override
    public boolean isWinner(String participant) {
        if (!isParticipant(participant)) {
            throw new IllegalArgumentException(participant
                    + " is not participant.");
        }
        return participant == winnerIs();
    }
}

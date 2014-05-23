package e2011;


public abstract class MatchResult {
    
    private String homeTeam, awayTeam;
    private int    homeGoals, awayGoals;
    public MatchResult(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public String getHomeTeam() {
        return homeTeam;
    }
    
    public String getAwayTeam() {
        return awayTeam;
    }
    public boolean isParticipant(String participant) {
        if (participant == homeTeam || participant == awayTeam) {
            return true;
        }
        return false;
    }
    
    public void setResult(int homeGoals, int awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }
    public boolean isDraw() {
        if (homeGoals == awayGoals) {
            return true;
        }
        return false;
    }
    
    public abstract boolean isWinner(String participant);
    
    protected String winnerIs() {
        if (homeGoals > awayGoals) {
            return this.homeTeam;
        }
        if (awayGoals > homeGoals) {
            return this.awayTeam;
        }
        return null;
    }
    
    public int getGoals(String participant) {
        if (isParticipant(participant)) {
            return participant == homeTeam ? homeGoals : awayGoals;
        }
        return 0;
    }
}

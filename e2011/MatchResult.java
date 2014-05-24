package e2011;

import java.util.ArrayList;

public abstract class MatchResult {
    
    private String homeTeam, awayTeam;
    private int    homeGoals, awayGoals;
    private ArrayList<Listener> listener;
    public MatchResult(String homeTeam, String awayTeam) {
        listener = new ArrayList<Listener>();
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
    
    /**
     * 
     * @param homeGoals
     * @param awayGoals
     *            edit result: set in new goals for each team
     * 
     */
    public void editResult(int homeGoals, int awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        boardcast();
    }
    
    public void addListener(Listener listener) {
        this.listener.add(listener);
    }
    
    public void boardcast() {
        for (Listener listener : this.listener) {
            listener.changed(this);
        }
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
    
    public String toString() {
        return "Home team: " + homeTeam + ", Goals: " + homeGoals + "\n"
                + "Away team: " + awayTeam + ", Goals: " + awayGoals + "\n"
                + "Winner is: " + winnerIs();
    }
}

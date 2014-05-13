package e2011;

import java.util.ArrayList;
import java.util.List;

public class LeagueTable {
    
    private List<MatchResult> matchtable;
    private List<String>      teamtable;
    
    /**
     * 
     * @param teamName
     *            Variable-Length Argument Lists (String... teamName)
     */
    public LeagueTable(String... teamName) {
        matchtable = new ArrayList<MatchResult>();
        teamtable = new ArrayList<String>();
        for (String s : teamName) {
            teamtable.add(s);
        }
    }
    
    public void addMatch(String homeTeam, String awayTeam) {
        if (!teamtable.contains(homeTeam) || !teamtable.contains(awayTeam)) {
            throw new IllegalArgumentException("Illegal teams!");
        }
        matchtable.add(new MatchResult(homeTeam, awayTeam));
    }
    
    public int getParticipantPoints(MatchResult matchResult, String participant) {
        return matchResult.getGoals(participant);
    }
    
    /**
     * sort matchtable with teams with more goals on the top
     */
    private void sortMatchtable() {

        for (int i = 0; i < matchtable.size(); i++) {
            
        }
    }
}

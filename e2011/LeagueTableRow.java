package e2011;


public class LeagueTableRow {
    
    //3 points for a victory and 1 for a draw
    private int points, victories, draws;
    private String participant;
    
    public LeagueTableRow(LeagueTable leagueTable, String participant) {
        this.points = 0;
        this.victories = 0;
        this.draws = 0;
        this.participant = participant;
        for (MatchResult mr : leagueTable.getMatchtable()) {
            if (mr.isParticipant(participant)) {
                if (mr.isWinner(participant)) {
                    victories++;
                    points += 3;
                } else if (mr.isDraw()) {
                    draws++;
                    points++;
                }
            }
        }
        
    }
    
    public int getPoints() {
        return points;
    }
    
    public int getVictories() {
        return victories;
    }
    
    public int getDraws() {
        return draws;
    }
    
    public String getTeamName() {
        return participant;
    }
}

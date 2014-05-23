package e2011;


public class TennisTournamentTable extends LeagueTable implements
        LeagueTableRow {
    
    public int    points, victories, draws;
    public String participant;
    
    public TennisTournamentTable(LeagueTable leagueTable, String participant) {
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

package e2011;


public class LFLeagueTableRow implements Comparable<LFLeagueTableRow> {
    
    private String participant;
    
    public LFLeagueTableRow(String participant) {
        this.participant = participant;
    }
    
    public String getParticipant() {
        return participant;
    }
    
    private int points = 0;
    
    public int getPoints() {
        return points;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int compareTo(LFLeagueTableRow other) {
        return other.getPoints() - points;
    }
}

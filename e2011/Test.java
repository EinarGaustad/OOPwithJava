package e2011;


public class Test implements Listener {
    
    private MatchResult mr;
    private LeagueTable lt;
    private Person      p;
    public Test() {
        mr = new TennisResult("NTNUI", "HiT");
        mr.addListener(this);
        
        lt = new LeagueTable("NTNUI", "HiT", "UiO", "HiST", "HiOA", "UiT",
                "UiS", "UiB");
    }
    
    public void testExceptions() {
        p = new Person("Male", new Date(14, 05, 93));
        System.out.println(p.toString());

        Person ole = new Person("Male");
        try {
            ole.setDateOfBirth(new Date(1, 3, 1));
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println(ole.toString());
        ole.generatePnr();
        System.out.println(ole.toString());
        try {
            ole.setDateOfBirth(new Date(2, 3, 1));
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public void testperson() throws Exception {
        Person kari = new Person("female");
        kari.setDateOfBirth(new Date(1, 1, 1));
        System.out.println("\n" + kari.toString());
        kari.generatePnr();
        System.out.println(kari.toString());
        kari.setDateOfBirth(new Date(2, 2, 2));
        System.out.println(kari.toString());
    }
    public void testLeagueTable() {
        lt.addMatch(lt.getTeamtable().get(0), lt.getTeamtable().get(1));
        System.out.println(lt.toString());
        //add result to ntnui & hit, will return true;
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(0), lt
                .getTeamtable().get(1), 6, 4));
        // return false, because hist, hioa are not yet on match list;
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(3), lt
                .getTeamtable().get(4), 6, 4));
        //add match
        lt.addMatch(lt.getTeamtable().get(2), lt.getTeamtable().get(3));
        //return true
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(2), lt
                .getTeamtable().get(3), 5, 5));
        System.out.println(lt.toString());

        //add match
        lt.addMatch(lt.getTeamtable().get(4), lt.getTeamtable().get(5));
        lt.addMatch(lt.getTeamtable().get(6), lt.getTeamtable().get(7));
        //return true
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(4), lt
                .getTeamtable().get(5), 7, 5));
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(6), lt
                .getTeamtable().get(7), 5, 5));
        System.out.println(lt.toString());
        
        //add match
        lt.addMatch(lt.getTeamtable().get(0), lt.getTeamtable().get(2));
        lt.addMatch(lt.getTeamtable().get(1), lt.getTeamtable().get(5));
        //return true
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(0), lt
                .getTeamtable().get(2), 7, 7));
        System.out.println(lt.addMatchResult(lt.getTeamtable().get(1), lt
                .getTeamtable().get(5), 2, 1));
        System.out.println(lt.toString());
    }
    
    public void run() {
        System.out.println(mr.toString() + "\n");
        mr.setResult(5, 4);
        System.out.println(mr.toString() + '\n');
        mr.editResult(9, 9);
    }
    
    @Override
    public void changed(MatchResult matchResult) {
        System.out.println("Listener report... ... " + "\n"
                + matchResult.toString());
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
        System.out.println("\n " + "test 2b: LeagueTable: --- --- ---");
        test.testLeagueTable();
        System.out.println("\n " + "test 1d: exceptions: --- --- ---");
        test.testExceptions();
        try {
            test.testperson();
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
    }
}

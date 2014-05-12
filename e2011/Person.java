package e2011;

public class Person {
    
    private Date   birth;
    private String gender;
    private String personnumber;
    private int[]  tabelpnr;
    
    public Person(String gender) {
        this.gender = gender;
    }
    
    public Person(String gender, Date birth) {
        this.gender = gender;
        this.birth = birth;
        
        //
        generatePnr();
    }
    
    public String getGender() {
        return gender;
    }
    
    public Date getBirth() {
        return birth;
    }
    
    private void generatePnr() {
        personnumber = "";
        //DDMMYY
        int day = getBirth().getDay();
        int month=getBirth().getMonth();
        int year=getBirth().getYear();
        if (day < 10) {
            personnumber += "0";
        }
        personnumber += day;
        if (month < 10) {
            personnumber += "0";
        }
        personnumber += month;
        if (year < 10) {
            personnumber += "0";
        }
        personnumber += month;
        //NNN
        personnumber += ((int) (Math.random() * 10));//N1
        personnumber += ((int) (Math.random() * 10));//N2
        if (getGender() == "female") {//N3
            personnumber += ((int) (Math.random() * 5) * 2);
        } else {
            personnumber += (((int) (Math.random() * 5) * 2) + 1);
        }
        //KK
        personnumber += generateK1();
        personnumber += generateK2();
        generatetabelpnr();
    }
    
    private void generatetabelpnr() {
        tabelpnr = new int[personnumber.length()];
        for (int i = 0; i < personnumber.length(); i++) {
            tabelpnr[i] = Integer.parseInt(personnumber.charAt(i) + "");
        }
    }
    
    private int generateK1(){
        generatetabelpnr();
        int vs =0;
        vs += tabelpnr[0] * 3;
        vs += tabelpnr[1] * 7;
        vs += tabelpnr[2] * 6;
        vs += tabelpnr[3] * 1;
        vs += tabelpnr[4] * 8;
        vs += tabelpnr[5] * 9;
        vs += tabelpnr[6] * 4;
        vs += tabelpnr[7] * 5;
        vs += tabelpnr[8] * 2;
        return 11-(vs%11);
    }
    
    private int generateK2() {
        generatetabelpnr();
        int vs = 0;
        vs += tabelpnr[0] * 5;
        vs += tabelpnr[1] * 4;
        vs += tabelpnr[2] * 3;
        vs += tabelpnr[3] * 2;
        vs += tabelpnr[4] * 7;
        vs += tabelpnr[5] * 6;
        vs += tabelpnr[6] * 5;
        vs += tabelpnr[7] * 4;
        vs += tabelpnr[8] * 3;
        vs += tabelpnr[9] * 2;
        return 11 - (vs % 11);
    }
    
    /**
     * En checked exception er en subklasse av Exception som ikke samtidig er en
     * subklasse av RuntimeException. En slik Exception må deklareres vha.
     * throws og den kallende metoden må enten håndtere unntaket med try/catch
     * eller deklarere det med throws.
     **/
    public void setDateOfBirth(Date dateOfBirth) throws Exception { 
        if (personnumber != null) {
            throw new Exception(
                    "Cannot change date of birth after PID has been set");
        }
        this.birth = dateOfBirth; }
}

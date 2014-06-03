package test;


public class Car {
    
    private int carid, caryear, telephone;
    private String ownername, carbrand, predefinedWork, additionWork,
            additionPart, workDone, notes;
    
    /**
     * @param carid
     * @param caryear
     * @param telephone
     * @param ownername
     * @param carbrand
     * @param predefinedWork
     * @param additionWork
     * @param additionPart
     * @param workDone
     * @param notes
     */
    public Car(int carid, int caryear, int telephone, String ownername,
            String carbrand, String predefinedWork, String additionWork,
            String additionPart, String workDone, String notes) {
        this.carid = carid;
        this.caryear = caryear;
        this.telephone = telephone;
        this.ownername = ownername;
        this.carbrand = carbrand;
        this.predefinedWork = predefinedWork;
        this.additionWork = additionWork;
        this.additionPart = additionPart;
        this.workDone = workDone;
        this.notes = notes;
    }
    
    /**
     * @param carid
     * @param caryear
     * @param telephone
     * @param ownername
     * @param carbrand
     * @param predefinedWork
     */
    public Car(int carid, int caryear, int telephone, String ownername,
            String carbrand, String predefinedWork) {
        this.carid = carid;
        this.caryear = caryear;
        this.telephone = telephone;
        this.ownername = ownername;
        this.carbrand = carbrand;
        this.predefinedWork = predefinedWork;
    }

    public Car(){
        
    }

    @Override
    public String toString() {
        return "[carid=" + carid + ", caryear=" + caryear + ", telephone="
                + telephone + ", ownername=" + ownername + ", carbrand="
                + carbrand + ", predefinedWork=" + predefinedWork
                + ", additionWork=" + additionWork + ", additionPart="
                + additionPart + ", workDone=" + workDone + ", notes=" + notes
                + "]";
    }

    public int getCarid() {
        return carid;
    }
    
    public void setCarid(int carid) {
        this.carid = carid;
    }
    
    public int getCaryear() {
        return caryear;
    }
    
    public void setCaryear(int caryear) {
        this.caryear = caryear;
    }
    
    public int getTelephone() {
        return telephone;
    }
    
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    public String getOwnername() {
        return ownername;
    }
    
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
    
    public String getCarbrand() {
        return carbrand;
    }
    
    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }
    
    public String getPredefinedWork() {
        return predefinedWork;
    }
    
    public void setPredefinedWork(String predefinedWork) {
        this.predefinedWork = predefinedWork;
    }
    
    public String getAdditionWork() {
        return additionWork;
    }
    
    public void setAdditionWork(String additionWork) {
        this.additionWork = additionWork;
    }
    
    public String getAdditionPart() {
        return additionPart;
    }
    
    public void setAdditionPart(String additionPart) {
        this.additionPart = additionPart;
    }
    
    public String getWorkDone() {
        return workDone;
    }
    
    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
        
}

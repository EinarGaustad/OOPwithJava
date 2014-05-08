package no.posten;


public interface IAdress {
    
    public String getAdresse(String idnr);
    
    public String getKommune(String adr);
    
    public String getFylke(String adr);
}

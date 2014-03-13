package oving6.named;

public interface Named {
	
	void setGivenName(String fornavn);
	String getGivenName();

	void setFamilyName(String etternavn);
	String getFamilyName();
	
	void setFullName(String fullname);//Argumentet til set-metoden skal være fornavn og etternavn skilt med mellomrom
	String getFullName();//Tilsvarende skal get-metoden returnere fornavn og etternavn skilt med mellomrom.
}

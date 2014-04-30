import java.util.*;

class Employer1
{
	private String nom;
	private String prenom;
	private int cin;
	private int tel;
	
	public Employer1(String nomEmployer, String prenomEmployer, int cinEmployer, int telEmployer)
	{
		nom = nomEmployer;
		prenom = prenomEmployer;
		cin = cinEmployer;
		tel = telEmployer;
	
	}
	
	public String getnom()
	{
		return(nom);
	}
	
	public String getprenom()
	{
		return(prenom);	
	}
	
	public int getcin()
	{
		return(cin);
	}
	
	public int gettel()
	{
		return(tel);
	}
	
}
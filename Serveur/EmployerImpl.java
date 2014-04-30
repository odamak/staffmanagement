import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.nio.*;
import java.util.*;


public class EmployerImpl extends UnicastRemoteObject  implements InterfaceEmployer
{ 
	Employer[] tabEmployers ;
	int nbEmp=0;  
	int empCourant; 
	String nomInstitut;
	String ligne; //chaine pour la lecture des lignes du fichier
	BufferedReader fread; //buffer pour la lecture des fichier
	PrintWriter fwrite; //pour ecrire dans le fichier
	
      

	public EmployerImpl() throws java.rmi.RemoteException
	{
		super();
		tabEmployers = new Employer[100];
		nbEmp = 0;
		empCourant = 0;
		fread = null;
		fwrite = null;	
   	}
        
	//Ajouter un Employer
	public void ajouterEmployer (String[] tab) throws java.rmi.RemoteException
	{
		Employer emp = new Employer();
		for (int i = 0; i<4; i++)
		{
			emp.tabChamps[i] = tab[i];
		}
		tabEmployers [nbEmp] = emp;
		nbEmp++;

	}

	//Retourne le nombre d'Employers
	public int  lireFichier ( String institut) throws java.rmi.RemoteException 
	{		
		try 		
		{
            		nomInstitut = institut;  
			nbEmp=0;
			// ouverture en entrée du fichier 
			fread = new BufferedReader (new FileReader (institut));
			System.out.println("Fichier ouvert" + institut);
			
			// Lire le fichier et mémoriser les informations dans tabEmployers
				
			while ((ligne = fread.readLine())!=null) 
			{
				Employer emp = new Employer(); //creation d'un nouveau objet pour sotcker les nouvelles coordonnées
				StringTokenizer empToken = new StringTokenizer (ligne, ";");//pour séparer les champs de chaque ligne
				for (int i=0; i < 4; i++) 
				{ //remplire les données de chaque ligne
					emp.tabChamps[i] = empToken.nextToken();
					System.out.println(emp.tabChamps[i]);
				}
			
			//sauvegarder la ligne dans le tableau
			
			tabEmployers [nbEmp] = emp;
			nbEmp ++;
			}

			fread.close();
						
			return (nbEmp);
			
		}

			 catch (IOException e) 
			 {
				return 0;
			
			}
	}
		
	//Chercher un Employer
	public int chercherEmployer (String nomEmployer) throws java.rmi.RemoteException 
	{
		boolean trouve = false;
		int	i = 0;
		while (!trouve && i < nbEmp) 
		{
			if ( nomEmployer.equals(tabEmployers[i].tabChamps[0]) ) 
			{
				trouve = true;
			} 
			else 
			{
				i++;
			}
		}
		
	return trouve ? i : -1;
		
	}

	//Modifier un Employer
	public  void modifierEmployer (int position, String[] tabEmployer) throws java.rmi.RemoteException
	{   
		System.out.println("En train de modifier");
		for(int i=0;i<4;i++)
		{
			System.out.println(tabEmployer[i]);
			tabEmployers[position].tabChamps[i] =tabEmployer[i];
		}            	
			
			
	}


	//Supprimer un Employer
	public void  supprimerEmployer (int position) throws java.rmi.RemoteException
	{
		if (position!= nbEmp-1) 
		tabEmployers [position] = tabEmployers [nbEmp-1];
		nbEmp--;
	} 





	//Enregistrer les modifications
	public int sauvegarder() throws java.rmi.RemoteException
	{
		try 
		{
			System.out.println("Opération de sauvegarde en cours...");
			
			File f = new File (nomInstitut);
			f.delete();// détruire le fichier actuel
			fwrite = new PrintWriter (new FileWriter (nomInstitut));// regénérer le fichier nomInstitut
									
            for (int i=0; i < nbEmp; i++) 
			{
				System.out.println("Employer "+i+":");
				for (int j=0; j < 3; j++) 
				{
					System.out.print(tabEmployers[i].tabChamps[j]+";");
					fwrite.print (tabEmployers[i].tabChamps[j] + ";");					
				}
				fwrite.println (tabEmployers[i].tabChamps[3]);
			}
			fwrite.close();
			System.out.println("Fin opération sauvegarde");
			return 1;
						
		} 
		catch (IOException err) 
		{
		return 0;
		}
		
	}


	

	//afficher les information d'un Employer
	public  String afficherChamps(int position, int champs) throws java.rmi.RemoteException
	{System.out.println(tabEmployers[position].tabChamps[champs]);
		return (tabEmployers[position].tabChamps[champs]);
	}
	
}

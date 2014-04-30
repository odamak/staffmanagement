import java.rmi.*;
import java.util.*;


public interface InterfaceEmployer extends java.rmi.Remote
{
	int lireFichier(String institut) throws java.rmi.RemoteException;
	void ajouterEmployer (String[] tabEmployer) throws java.rmi.RemoteException;
	void  supprimerEmployer (int position) throws java.rmi.RemoteException;
	void modifierEmployer (int position, String[] tabEmployer) throws java.rmi.RemoteException;
	int chercherEmployer (String nomEmployer) throws java.rmi.RemoteException;
	int sauvegarder() throws java.rmi.RemoteException;
	String afficherChamps(int position,int champs) throws java.rmi.RemoteException;
}

import java.rmi.*;
import java.rmi.server.*;
public class Serveur 
{
public static void main(String args[])
	{
		try {
			System.out.println("Serveur : contruction de l'implementation ");
			EmployerImpl traitementEmp= new EmployerImpl();
			System.out.println("Objet traitementEmp enregistré dans RMI registry");
			Naming.rebind ("traitementEmp" , traitementEmp);
			System.out.println ("attente des invocations des clients");
			}
		catch (Exception e)
		{ 
			System.out.println ("erreur de liaison de l'objet au compte");
		}
		
	}
}

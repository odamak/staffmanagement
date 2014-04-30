import java.rmi.*;
import java.io.*;
import java.util.*;
import javax.swing.*;//JFrame
import java.awt.*;
import java.awt.event.*;//ActionListener


		
public class Client extends JFrame 
{

	//fenetre graphique

	JLabel l1 = new JLabel ("Nom");
	JLabel l2 = new JLabel ("Prénom");
	JLabel l3 = new JLabel ("C.I.N");
	JLabel l4 = new JLabel ("Téléphone");


	JTextField tf1 = new JTextField (15);
	JTextField tf2 = new JTextField (15);
	JTextField tf3 = new JTextField (15);
	JTextField tf4 = new JTextField (15);


	JTextField[] tabTF = {tf1, tf2, tf3, tf4};
	
	
	JButton b0  = new JButton ("ENIT");
	JButton b1  = new JButton ("ENSI");
	JButton b2  = new JButton ("ENSIT");
	JButton b3  = new JButton ("FST");
	JButton b4  = new JButton ("INSAT");
	JButton b41  = new JButton ("ISI");
	JButton b5  = new JButton ("Quitter");

	JButton b6  = new JButton ("Suivant");
	JButton b7  = new JButton ("Précédent");
	JButton b8  = new JButton ("Rechercher");
	JButton b9  = new JButton ("Lancer la recherche");
	JButton b10 = new JButton ("Ajouter");
	JButton b11 = new JButton ("Valider Ajout");
	JButton b12 = new JButton ("Modifier");
	JButton b13 = new JButton ("Valider modification");
	JButton b14 = new JButton ("Supprimer");
	JButton b15 = new JButton ("Enregistrer");
	JButton b16 = new JButton ("Retour");
	JButton b17 = new JButton ("Quitter");

	JButton[] boutons ={ b0, b1, b2, b3, b4, b41, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17};

	JPanel p1 = new JPanel(new GridLayout(0,2)); // Nom, prénom, cin, tel et texfield associés dans p1
	JPanel p2 = new JPanel(new GridLayout(0,2));// les boutons des institutions dans p2
	JPanel p3 = new JPanel(new GridLayout(1,0));// les consignes dans p3
	JPanel p4 = new JPanel(new GridLayout(0,2));// les boutons de traitement dans p4
	//JTextArea ta = new JTextArea("", 3, 20);
	JEditorPane ta = new JEditorPane ("text/html", "");

	//fin fenetre graphique
	 
	ActionListener ecouteur = new ActionBouton();


	//les variables à utiliser
	int empCourant=0;//numero du personnel actuel affiché
	int  nbEmp=0;//nombre total des personnels totale dans le fichier
	String[] tabChamps = new String[4];
	public static InterfaceEmployer interfaceEmp;

			
	//le constructeur de la classe
			
	 public  Client() throws Exception {

		//creation de la fenetre

		Container f = this.getContentPane();
		setTitle ("Carnet d’adresses");
		setBackground (Color.white);
		setBounds (600, 200, 400, 500);
		BoxLayout bo= new BoxLayout (f, BoxLayout.Y_AXIS);
		f.setLayout (bo);
		ActionBouton ecouteur = new ActionBouton();

		//creation du panneau p1
		p1.setBorder(BorderFactory.createTitledBorder("Coordonnées"));
		p1.setBackground (Color.lightGray);
		f.add (p1);
		p1.add (l1); p1.add (tf1);
		p1.add (l2); p1.add (tf2);
		p1.add (l3); p1.add (tf3);
		p1.add (l4); p1.add (tf4);
		p1.setVisible(false);

		//creation du panneau p2 pour les institutions
		p2.setBorder(BorderFactory.createTitledBorder("Instituts"));
		p2.setBackground (Color.orange);
		f.add (p2);

		//associer les boutons au panneau p2
		for (int i=0; i <7 ; i++) {
		p2.add(boutons[i]);
		boutons[i].addActionListener(ecouteur);
		}

		p2.setVisible(true);


		//creation du panneau p3 pour les Consignes

		f.add(p3);
		p3.setBorder(BorderFactory.createTitledBorder("Consignes"));
		p3.setBackground (Color.gray);
		p3.add(ta);


		//creation du panneau p4 pour les traitements

		p4.setBorder(BorderFactory.createTitledBorder("Traitement"));
		p4.setBackground (Color.pink);
		f.add (p4);
		p4.setVisible(false);

		//associer les boutons au panneau p4
		for (int i=7; i <boutons.length ; i++) {
		p4.add(boutons[i]);
		boutons[i].addActionListener(ecouteur);
		}

		// fin creation fenetre

		setVisible (true);
		ta.setText("<h2> Selectionner l'institution à gérer </h2>");

	}


	int rechercherbouton (JButton b) 
	{
		boolean trouve = false;
			int
			i = 0;
			while (!trouve && i < boutons.length) 
			{
				if ( b == boutons[i]) 
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
			
				
	//remplir les champs dans la fenêtre avec les information issues du fichier
	void setTF (int position) throws Exception //set text field
	{	
		System.out.println("debut setTF"+position);
		if (nbEmp == 0) 
		{ 
			// aucun élément
			System.out.println("cas nbEmp==0");
			resetTF ();
			ta.setText ("Le carnet d’adresses est vide");
			b6.setEnabled (false);
			b7.setEnabled (false);
			b8.setEnabled (false);
			b12.setEnabled (false);
			b14.setEnabled (false);
		} 
		else 
		{
			System.out.println("cas nbEmp!=0");
			for (int champs=0; champs < 4; champs++)
			{
				tabTF[champs].setText(interfaceEmp.afficherChamps(position,champs));
				System.out.println("champs "+champs+" : "+tabTF[champs].getText());
			}
		}
	}
		
	//Initialiser la zone du texte	
	void resetTF () 
	{
		for (int champs=0; champs < tabTF.length; champs++) 
		{
			tabTF[champs].setText("");
		}
	}
			
	//Afficher les traitements possibles pour les employers
	void afficherOptions (String nomFichier)
	{ 
		try
		{
			System.out.println("En train de lire "+nomFichier);
			nbEmp=0;
			//int j=pers.lireFichier(inst);
			nbEmp = interfaceEmp.lireFichier(nomFichier);
			System.out.print(nbEmp+" ");

			if(nbEmp!=0)
			{
				System.out.println("Fichier lu");
				//nbEmp=pers.calcule();
				setTF(0);
				
				ta.setText("<h1> choisir un traitement</h1>");
				p1.setVisible(true);
				p2.setVisible(false);
				p4.setVisible(true);
				b6.setEnabled(true);
				b7.setEnabled(false);
				b9.setEnabled (false);
				b11.setEnabled (false);
				b13.setEnabled (false);
				b15.setEnabled (false);
			}

			else
				ta.setText("Impossible d'ouvrir le fichier "+ nomFichier);
		}
		catch (Exception e)
		{
			ta.setText("Problème de connexion au serveur, veuillez réessayer");
		}
	}
	
	
	
	// Actions des boutons de 0 à 17
			
	class ActionBouton implements ActionListener 
	{
		public void actionPerformed (ActionEvent evt) 
		{
			JButton bouton = (JButton) evt.getSource();
			
			
			b9.setEnabled (false);
			b11.setEnabled (false);
			b13.setEnabled (false);
			b15.setEnabled (false);
                           
			
			
			for(int i=0;i<4;i++)
				tabTF[i].setVisible(true);

			switch (rechercherbouton(bouton)) 
			{
				
				//Istitut ENIT selectionnée
				case 0:
				afficherOptions("ENIT.txt");
				break;

				
				//Istitut ENSI selectionnée
				case 1:
				afficherOptions("ENSI.txt");
				break; 

				
				//Istitut ENSIT selectionnée
				case 2:
				afficherOptions("ENSIT.txt");
				break;

				//Istitut FST selectionnée
				case 3:
				afficherOptions("FST.txt");
				break;

				//Istitut INSAT selectionnée
				case 4:
				afficherOptions("INSAT.txt");
				break;
				case 5:	
				afficherOptions("ISI.txt");
				break;
				
				//Quitter l'application
				case 6:
				System.exit(0);
				break;

				
				
				//afficher l'employer qui suit
				//bouton suivant
				case 7 :
				
					try
					{
						
					//tabChamps=interfaceEmp.suivant(empCourant);
					    b7.setEnabled(true);
					    b11.setEnabled(false);
					    b9.setEnabled(false);
					    b13.setEnabled(false);
						System.out.println("la valeur de l'emp courant est "+empCourant);
						empCourant++;
						System.out.println("la valeur de l'emp courant apres inc est "+empCourant);
						setTF (empCourant);
						ta.setText("<h1> Choisir un traitement</h1>");
						if (empCourant == nbEmp-1)
							b6.setEnabled(false);
					}
					catch (Exception e)
					{
						ta.setText("Problème de connexion au serveur, réessayer");
					}
				
				
				break;
				
				/*
				if (empCourant == nbEmp-1) empCourant = 0;
				try
				{
					//tabChamps=interfaceEmp.suivant(empCourant);
					empCourant++;
					setTF (empCourant);
					ta.setText("<h1> Choisir un traitement</h1>");
				}
				catch (Exception e)
				{
					ta.setText("Problème de connexion au serveur, réessayer");
				}
				break;
				*/
				
				
				
				//afficher le information précédentes
				//bouton précédent
				
				case 8 :				
				
					try
					{
						b6.setEnabled(true);
						b11.setEnabled(false);
					        b9.setEnabled(false);
					        b13.setEnabled(false);
						empCourant--;						
						ta.setText("<h1> choisir un traitement</h1>");
						setTF(empCourant);
						if (empCourant==0)	
							b7.setEnabled(false);
					}
					catch (Exception e)
					{
						ta.setText("Probleme de connexion au serveur, réessayer");
					}
						
				
				break;
				
				
				
				
				//if (empCourant< 0) empCourant = nbEmp-1;
				
				/*
				try
				{
					
					empCourant--; 
					ta.setText("<h1> choisir un traitement</h1>");
					setTF(empCourant);
				}
				catch (Exception e)
				{
					ta.setText("Probleme de connection au serveur. réessayer");
				}
				break;
				*/


				//remplir le formulaire pour rechercher (bouton chercher)
				case 9 :
					resetTF();
					for(int i=1;i<4;i++)
					tabTF[i].setVisible(false);
					ta.setText ("Indiquer le  nom  puis cliquer sur  le bouton <b> Lancer la recherche </b> ");
					tabTF[0].requestFocus();
					b9.setEnabled (true);
					b11.setEnabled(false);
					
					b13.setEnabled(false);
				break;

				
				
				//lancer la recherche
				case 10 :
					try
					{
						//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						System.out.println("chakk");
						int pos = interfaceEmp.chercherEmployer(tabTF[0].getText());
						if (pos != -1) 
						{
							empCourant = pos;
							ta.setText (tabTF[0].getText() + " trouvé");														
						}
						else 
						{
							ta.setText (tabTF[0].getText() + " <b > inconnu </b > ");
						}

						setTF(empCourant);
						
						for(int i=0;i<4;i++)
						{
							tabTF[i].setVisible(true);
						}

					}
					catch(Exception e)
					{
						ta.setText("Problém de recherche.\nTaper le bouton <b>lancer recherche</b> encore une fois");
						b9.setEnabled (true);
					}
				break;

				
				//remplire le formulaire pour l'ajout d'une nouvelle entrée dans le fichier
				case 11 :
					if(nbEmp<=100)
					{
						resetTF();
						ta.setText ("Compléter  les différents champs de l'employer à ajouter puis cliquer sur  le bouton <b> Valider Ajout </b> ");					
						b9.setEnabled(false);
						b13.setEnabled(false);
						b11.setEnabled (true);
						tabTF[0].requestFocus();
					}
					else 
						ta.setText("<h1>Impossible d'ajouter plus de personnel</h1>");
				break;

				
				//Valider l'ajout d'un nouveau personnel
				case 12 :
				
					if (tabTF[0].getText().equals ("") || tabTF[1].getText().equals ("") || tabTF[1].getText().equals ("") || tabTF[3].getText().equals ("")) 
						ta.setText ("Veuillez remplir tous les champs");

					else 
					{

						try
						{
							for(int i=0;i<4;i++)
								tabChamps[i]=tabTF[i].getText();
							interfaceEmp.ajouterEmployer(tabChamps);
							nbEmp++;
							ta.setText("<h1>Employé ajouté avec succès</h1>)");
							b15.setEnabled(true);
							b16.setEnabled(false);
							b17.setEnabled(false);
							b11.setEnabled(false);
						}
						
						catch( Exception e)
						{
							ta.setText("Problème d'ajout.\nCliquez sur le bouton <b>Valider ajout</b> encore une fois");
							b11.setEnabled (true);
						}
					}

				break;
				
				
				//modifier un employer
				case 13:
					try{
					setTF(empCourant);
					b11.setEnabled(false);
					b9.setEnabled(false);
					b13.setEnabled(true);
					System.out.println("à modi"+empCourant);
					ta.setText("Valider en cliquant sur<h1>Valider modification</h1>");
					tabTF[0].requestFocus();}
							catch(Exception e)
					{
						ta.setText("Problème de Validation. Cliquez sur le bouton <b>modifier</b> encore une fois");
					}
				break;
				
				
				//valider la modification
				case 14:
					try
					{
						for(int i=0;i<4;i++)
						{
							tabChamps[i]=tabTF[i].getText();
							System.out.println(tabChamps[i]);
						}
						interfaceEmp.modifierEmployer(empCourant,tabChamps);
						System.out.println("modifi");
						ta.setText("Employer modifié. Choisir une opération ou cliquez sur <b>Enregistrer</b> pour finir)");
						b15.setEnabled(true);
						b16.setEnabled(false);
						b17.setEnabled(false);

					}
					catch(Exception e)
					{
						ta.setText("Problème de Validation. Cliquez sur le bouton <b>Valider modification</b> encore une fois");
					}
				break;
				
				
				//supression d'un employer
				case 15 :
					try
					{
						if (nbEmp >= 0 )
						{
							interfaceEmp.supprimerEmployer(empCourant);
							nbEmp--;
							if (empCourant!=0)empCourant--;
							ta.setText("Employer supprimé. Cliquez sur </b> Enregistrer</b> pour Finir");
							setTF (empCourant);
							 b15.setEnabled(true);
						}
						else setTF(0);
					} 
					catch(Exception e)
					{
						ta.setText("Probléme de suppression.\nTaper le bouton <b>supprimer</b> encore une fois");
					}


				break;

				
				//comfirmer tous les changements
				case 16 :
					try
					{
						if(interfaceEmp.sauvegarder()!=0)
						{
							 ta.setText("<b>Modifications sauvegardées. Choisir une opération</b>");
							b16.setEnabled(true);
							 b17.setEnabled(true);
							 b11.setEnabled(false);
					   		 b9.setEnabled(false);
					                 b13.setEnabled(false);
						}
						else
							ta.setText("Problème d'enregistrement.\nTaper le bouton <b>Enregistrer</b> encore une fois");
					 
					}
					
					catch(Exception e)
					{
						ta.setText("Problème d'enregistrement.\nTaper le bouton <b>Enregistrer</b> encore une fois");
					}
				break;
				
				
				//Retour a la page d'acceuil
				case 17:
					resetTF ();
					nbEmp=0;
					empCourant=0;
					System.out.println("nbEmp est "+nbEmp);
					ta.setText("<h1> Choisir un traitement</h1>");
					p1.setVisible(false);
					p2.setVisible(true);
					p4.setVisible(false);
				break;
				
				
				//quitter totalement l'application
				case 18:
					System.exit(0);
				break;


				}
				} // actionPerformed
				} // class ActionBouton

		
	public static void main (String []args) throws Exception
	{

		try
		{  
			interfaceEmp = (InterfaceEmployer) Naming.lookup ("traitementEmp");
			System.out.println("object trouvé");
			Client c =new Client();}

		catch(Exception e)
		{
			System.out.println("problem"+e.toString());
		}
	}
}


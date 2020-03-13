package fac;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;


public class MaFrame extends JFrame implements ActionListener
{

	private JPanel pnl1;
	private JPanel pnl2;
	
	private JMenuBar monMenu;
	
	private JMenu fichier;
	private JMenu donnee;
	
	private JMenuItem quitter;
	private JMenuItem redessiner;
	private JMenuItem ajouterCol;
	private JMenuItem suppCol;
	private JMenuItem effacer;
	
	private JTable tab;
	private JButton bn;
	private MonPanelDessin pnlDessin;

	MaFrame()
	{
		this.setLayout(new GridLayout(2,1));
		 
		bn = new JButton("Redessiner");
		
		   SpinnerModel value = new SpinnerNumberModel(5, 0,10,1);  
		   JSpinner spinner = new JSpinner(value); 
		   
		//Partie 1/2
		pnl1 = new JPanel();
		pnl2 = new MonPanel(2,1);
		
		//colonne
		Vector<String> colonnes = new Vector<String>();
		colonnes.add("donnees"); 
		colonnes.add("serie 1");
		
		//ligne
		Vector<Vector<String>> donnees = new Vector<Vector<String>>();
		
		Vector<String> donnee1 = new Vector<String>();
		donnee1.add("janvier"); 
		donnee1.add("1");
		Vector<String> donnee2 = new Vector<String>();
		donnee2.add("fevrier");
		donnee2.add("5");
		Vector<String> donnee3 = new Vector<String>();
		donnee3.add("mars"); 
		donnee3.add("3");
		Vector<String> donnee4 = new Vector<String>();
		donnee4.add("avril");
		donnee4.add("5");
		Vector<String> donnee5 = new Vector<String>();
		donnee5.add("mai"); 
		donnee5.add("1");
		Vector<String> donnee6 = new Vector<String>();
		donnee6.add("juin");
		donnee6.add("5");
		Vector<String> donnee7 = new Vector<String>();
		donnee7.add(" "); 
		donnee7.add("  ");
		Vector<String> donnee8 = new Vector<String>();
		donnee8.add("  ");
		donnee8.add("");
		
		donnees.add(donnee1);
		donnees.add(donnee2);
		donnees.add(donnee3);
		donnees.add(donnee4);
		donnees.add(donnee5);
		donnees.add(donnee6);
		donnees.add(donnee7);
		donnees.add(donnee8);
		
		// Tab
		tab = new JTable(donnees,colonnes);
		
		//Bar de menu
		monMenu = new JMenuBar();
		fichier = new JMenu("Fichier");
		donnee  = new JMenu("Donnees");
		
		quitter = new JMenuItem("Quitter");
		redessiner = new JMenuItem("Redessiner");
		ajouterCol = new JMenuItem("Ajouter colonne");
		suppCol = new JMenuItem("Supprimer Colonne");
		effacer = new JMenuItem("Effacer donnees");

		quitter.addActionListener(this);
		redessiner.addActionListener(this);
		bn.addActionListener(this);
		
		
		//ajout
		donnee.add(redessiner);
		donnee.add(ajouterCol);
		donnee.add(suppCol);
		donnee.add(effacer);
		fichier.add(quitter);
		monMenu.add(fichier);
		monMenu.add(donnee);
		this.add(monMenu);
		
		tab.setFillsViewportHeight(true);
		pnl1.add(tab);
		JScrollPane panneau; 
		panneau = new JScrollPane(tab);
		add(panneau);
		
		pnl2.add(bn);

		this.add(pnl1);
		pnl1.add(pnl2);

		
		this.setTitle("Courbes");
		//pack();
		setSize(200,200);
		setLocationRelativeTo(null);
		setJMenuBar(monMenu);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new MaFrame();
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.print(e.getActionCommand());
		
		if(e.getActionCommand().contentEquals("Quitter"))
		{
			System.exit(0);
		}
		if(e.getActionCommand().contentEquals("Redessiner"))
		{
			System.out.print(e.getActionCommand());
			String[][] val = new String[tab.getRowCount()][tab.getColumnCount()];
			
			//Lecture données
		 	for(int i=0; i<tab.getRowCount();i++)
			{
				for(int j=0; i<tab.getColumnCount();i++)
				{
					val[i][j] = tab.getValueAt(i,j).toString();
					
				}
				
			}
		 	
			pnlDessin = new MonPanelDessin(val,tab.getColumnCount(),tab.getRowCount());
			pnl2.add(pnlDessin);
			pnlDessin.repaint();

		}
		
	}


}

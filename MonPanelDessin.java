package fac;


import java.awt.*;
import javax.swing.*;

public class MonPanelDessin extends JPanel
{
	
	private int nbCol;
	private int nbLig;
	
	private String[][] val;

	public MonPanelDessin(String[][] val,int c,int l)
	{
		this.val = new String[nbLig][nbCol];
		nbCol = c;
		nbLig = l;
	}
	
	public void majVal(String[][] tab)
	{
		this.val = tab;
	}
	
	public void setNbCol(int i)
	{
		this.nbCol = i;
	}
	
	public void setNbLig(int i)
	{
		this.nbLig = i;
	}
	public void paint(Graphics g)
	{
		super.paint(g);

		g.setColor(Color.RED);
	
		int avcmt = 50;

		for(int i=1; i<nbLig;i++)
		{
			int y1 = Integer.parseInt(val[i-1][1]);
			int y2 = Integer.parseInt(val[i][1]);
			g.drawString(val[i-1][0],avcmt,y1);
			g.drawLine(y1,avcmt,y2,avcmt+50);
			avcmt += 50;

			if(i== (nbLig-1))
				g.drawString(val[i][0],avcmt,y2);
		}
	}
}

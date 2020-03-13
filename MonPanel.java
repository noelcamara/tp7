package fac;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MonPanel extends JPanel{
	public MonPanel(int i, int j)
	{
		this.setLayout(new GridLayout(i,j));
	}
}

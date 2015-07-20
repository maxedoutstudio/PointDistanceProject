package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JFrame  {
	
	//Constants
		
	public static final String VERSION = "0.1.0";
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	public static final int INTERVAL = 1000;
	
	
	//Variables
	private static JPanel topPanel;
	private static JPanel botPanel;
	private static Timer timer;
	private static JProgressBar progressBar;
	
	private File pointsFile;
	private File limitsFile;
	private File outputFile;
	
	public static void main(String[] args)
	{
		Window window = new Window();
		window.setVisible(true);
	}
	
	public Window()
	{
		super("PointD GUI V." + VERSION );// Set title of JFrameusing constructor
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Panel for browsing for the points file
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JLabel pointsLabel = new JLabel("Points: ");
		JButton pointsBrowse = new JButton("Browse");
		pointsBrowse.addActionListener(new BrowsePoints());
		JLabel limitsLabel = new JLabel("Limits: ");
		JButton limitsBrowse = new JButton("Browse");
		limitsBrowse.addActionListener(new BrowseLimits());

		topPanel.add(pointsLabel);
		topPanel.add(pointsBrowse);
		topPanel.add(limitsLabel);
		topPanel.add(limitsBrowse);
		add(topPanel,BorderLayout.NORTH);
		
		
		//Progress Bar and run button panel

		botPanel = new JPanel();
		botPanel.setLayout(new FlowLayout());
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new Run());
		/* @TODO: functional progress bar
		progressBar = new JProgressBar(0,20);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		*/
		botPanel.add(runButton);
		//botPanel.add(progressBar);
		add(botPanel,BorderLayout.SOUTH);
		
	}

	class BrowsePoints implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(Window.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				pointsFile = (c.getSelectedFile().getAbsoluteFile());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
			}
		}
	}
	
	class BrowseLimits implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(Window.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				limitsFile = (c.getSelectedFile().getAbsoluteFile());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
			}
		}
	}

	class Run implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(pointsFile == null || limitsFile == null ){
				//@TODO Print error message here
			}
			
			ArrayList<double[]> results;
			
			try{
				results = pointDist.Main.Run(pointsFile,limitsFile);

				JFileChooser c = new JFileChooser();
				int rVal = c.showSaveDialog(Window.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					outputFile = (c.getSelectedFile().getAbsoluteFile());
					try{
						fileIO.Export.exportPoints(outputFile, results);
					} catch (IOException e2) {
						System.out.println("E2");
						//@TODO error message incase incorrect path
					}
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
					//@TODO put a cancel message
				}
				
			} catch(IOException e1) {
				System.out.println("E1");
				//@TODO Put error message, depending on what file is missing/errorenous 
			}
			

		
			
			
			
		}
	}

	
	
}

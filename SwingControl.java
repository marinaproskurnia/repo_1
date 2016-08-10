package mypackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Write a Java program that will use Listener and Command design patterns in a way that make sense;
 * In the current implementation Swing listener waits until it receives an event from a user (pressing a button);
 * Once the event is received, the listener processes the event (prints out an appropriate message) an then returns.
 */

public class SwingControl {
	 private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	   public SwingControl(){
	      prepareGUI();
	   }
 
	   private void prepareGUI(){
		  JFrame.setDefaultLookAndFeelDecorated(true);
	      mainFrame = new JFrame("Control panel");
	      mainFrame.setSize(500,400);
	      mainFrame.setLayout(new GridLayout(3, 1));	      
	      mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        System.exit(0);
		         }        
		      }); 
	      
	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        

	      statusLabel.setSize(350,100);
	         
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }

	   private void showEventAction(){
	      headerLabel.setText("Press a button to proceed with the product"); 
	      // actions available to the user to do with a product with these buttons in Control panel; 
	      JButton saveButton = new JButton("Save");
	      JButton amendButton = new JButton("Amend");
	      JButton submitButton = new JButton("Submit");
	      JButton cancelButton = new JButton("Cancel");
	          
	      saveButton.setActionCommand("Save");
	      amendButton.setActionCommand("Amend");
	      submitButton.setActionCommand("Submit");
	      cancelButton.setActionCommand("Cancel");

	      saveButton.addActionListener(new ButtonClickListener()); 
	      amendButton.addActionListener(new ButtonClickListener()); 
	      submitButton.addActionListener(new ButtonClickListener()); 
	      cancelButton.addActionListener(new ButtonClickListener()); 

	      controlPanel.add(saveButton);
	      controlPanel.add(amendButton);
	      controlPanel.add(submitButton);
	      controlPanel.add(cancelButton);       

	      mainFrame.setVisible(true);  
	   }

	   private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         // the listener gets some commands here from the user
	    	  String command = e.getActionCommand();  
	    	 // and the listener reacts in response
	         if( command.equals( "Save" ))  {
	            statusLabel.setText("The product is saved");
	         } else if( command.equals( "Amend" ) )  {
		            statusLabel.setText("The product is amended");
	         } else if( command.equals( "Submit" ) )  {
	            statusLabel.setText("The product is submitted"); 
	         } else  {
	            statusLabel.setText("The product is cancelled");
	         }  	
	      }		
	   }
	   
	   public static void main(String[] args) {
		      SwingControl swingControlAction = new SwingControl();  
		      swingControlAction.showEventAction();       
		   }
}

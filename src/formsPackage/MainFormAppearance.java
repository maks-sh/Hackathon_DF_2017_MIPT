package formsPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import testActions.*;
import appearanceCustomisation.FrameObjectsBuilder;

public class MainFormAppearance {
	public JPanel createContentPane() {
		//creating custom objects constructor
		FrameObjectsBuilder builder = new FrameObjectsBuilder();
		
		
		//First, creating panel, 
		//where other components should be placed
		JPanel totalGUI = new JPanel(); // creating panel
		totalGUI.setLayout(null);
		
		
		
		//creating blue label
		JLabel mainLabel = builder.createLabel("Label 1", 10, 10, 300, 100, Color.blue);
		totalGUI.add(mainLabel); //adding textlabel to the panel
		
		
		
		//creating button 1
		JButton redButton = builder.createButton("Button lol", 120, 200, 200, 50);
		//creating action listener
		ActionListener actionListener = new TestActionListener();
		//adding action listener to button
		redButton.addActionListener(actionListener);//link action to the button
		totalGUI.add(redButton);//adding button to the panel
		
		
		//creating button 2
		JButton parceButton = builder.createButton("Second button", 200, 100, 100, 30);
		ActionListener parceListener = new ParceListener();
		parceButton.addActionListener(parceListener);
		totalGUI.add(parceButton);
		
		
		//creating button 3
		JButton button3 = builder.createButton("Nu lol zhe, a", 200, 150, 150, 30);
		ActionListener csvListener = new CsvListener();
		button3.addActionListener(csvListener);
		totalGUI.add(button3);
		
		return totalGUI;
	
	
	
	
	}

}

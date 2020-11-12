import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel counterLabel;

  JTextField outputCount;

  JButton countButton;
  JButton resetButton;

  int count = 10;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main panel 
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    counterLabel = new JLabel("Counter:");
    counterLabel.setBounds(150,200,100,30);
    outputCount = new JTextField("10");
    outputCount.setBounds(220,200,150,30);
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");
    countButton.setBounds(150,150,100,30);
    resetButton.setBounds(270,150,100,30);
    countButton.addActionListener(this);
    resetButton.addActionListener(this);
    countButton.setActionCommand("count");
    resetButton.setActionCommand("reset");
    mainPanel.add(counterLabel);
    mainPanel.add(outputCount);
    mainPanel.add(countButton);
    mainPanel.add(resetButton);
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //if the count button is pressed the program will count down by 1
    if(command.equals("count")){

      if(count > 1){
      count = count - 1;
      outputCount.setText("" + count);
      }
    }

    //When the reset button is pressed it will set the count back to 10
    if(command.equals("reset")){
      count = 10;
      outputCount.setText("10");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

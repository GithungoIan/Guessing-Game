import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.JTextComponent;


public class GuessingGame  extends JFrame {
    JTextField guessInput, guessDisplay;
    JLabel messageDisplay;
    ButtonListener bl1;
    ButtonListner2 bl2;

    //Setting random number between 0 and 9
    int targetNumber = (int)(Math.random()*10);
    int count = 0;

    public GuessingGame(){

        // Get the container
         Container c = getContentPane();
        
        //set absolute layout
        c.setLayout(null);

        //set Background Color
        c.setBackground(Color.WHITE);

        //Create Label Guess my Number text
        JLabel guessGameLabel = new JLabel("Guess my number game");
        guessGameLabel.setForeground(Color.BLUE);
        guessGameLabel.setFont(new Font("Italic",Font.PLAIN,17));
        guessGameLabel.setSize(270, 20);
        guessGameLabel.setLocation(100, 35);

        //Creating label Enter a number
        JLabel guessInputLabel = new JLabel("Enter a number between 0-9");
        guessInputLabel.setFont(new Font("tunga",Font.PLAIN,17));
        guessInputLabel.setSize(270, 20);
        guessInputLabel.setLocation(100, 60);

        //Creating TextField for input guess
        guessInput = new JTextField(10);
        guessInput.setSize(50,30);
        guessInput.setLocation(10,60);

        //creating  Label for Display message
        messageDisplay = new JLabel("Try and guess my number");
        messageDisplay.setFont(new Font("tunga",Font.PLAIN,17));
        messageDisplay.setSize(270,20);
        messageDisplay.setLocation(150, 130);

        //Creating guess text field
        guessDisplay = new JTextField(10);
        guessDisplay.setSize(40, 20);
        guessDisplay.setLocation(10, 120);

        //Creating guess label text field
        JLabel guessDisplayLabel = new JLabel("Guesses");
        guessDisplayLabel.setFont(new Font("tunga",Font.PLAIN,17));
        guessDisplayLabel.setSize(270, 20);
        guessDisplayLabel.setLocation(70, 120);

        //Creating guess button
        JButton guessBtn = new JButton("Guess");
        guessBtn.setSize(120,40);
        guessBtn.setLocation(100,200);
        bl1 = new ButtonListener();        
        guessBtn.addActionListener(bl1);

        //Creating the Play Again button
         JButton playAgainBtn = new JButton("Play Again");    
         playAgainBtn.setSize(120,40);
         playAgainBtn.setLocation(330,200);    
         bl2 = new ButtonListner2 ();        
         playAgainBtn.addActionListener(bl2);


        //Place the components in the Pane
        c.add(messageDisplay);
        c.add(guessGameLabel);
        c.add(guessInputLabel);
        c.add(guessDisplayLabel);
        c.add(guessInput);
        c.add(guessDisplay);
        c.add(guessBtn);
        c.add(playAgainBtn);
        
        
        //Changing TextFileds to UnEditable
        guessDisplay.setEditable(false);

        //set the Title of the window
        setTitle("Guessing Game ");

        //Set the size of the window and display it
        setSize(550, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(final ActionEvent e){
             int a = Integer.parseInt(guessInput.getText());
            count = count + 1;
    
            if (a == targetNumber){
            	messageDisplay.setText("CORRECT, YOU WIN!!!");
                targetNumber = (int)(Math.random()*10);
                guessInput.setText("");
                guessDisplay.setText("");
                messageDisplay.setText("Try and Guess my Number");
                guessDisplay.setText("");
                count = 0;
                guessInput.setEditable(true);
                guessInput.requestFocus();
            }
            if(count >= 3 ) {
            	messageDisplay.setText("Correct Answer is " + targetNumber);
            }
            if( count > 3){    
            	messageDisplay.setText("Correct Answer is " + targetNumber);
                targetNumber = (int)(Math.random()*10);
                guessInput.setText("");
                guessDisplay.setText("");
                messageDisplay.setText("Try and Guess my Number");
                guessDisplay.setText("");
                count = 0;
                guessInput.setEditable(true);
                guessInput.requestFocus();
                
              
            }
            //Setting focus to input guess text Field
            guessInput.requestFocus();
            guessInput.selectAll();
            guessDisplay.setText(count + " ");
            
        }
    }

    private class ButtonListner2 implements ActionListener{
        public void actionPerformed(final ActionEvent e){

           
            targetNumber = (int)(Math.random()*10);
            guessInput.setText("");
            guessDisplay.setText("");
            messageDisplay.setText("Try and Guess my Number");
            guessDisplay.setText("");
            count = 0;
            guessInput.setEditable(true);
            guessInput.requestFocus();
        }
    }

    public static void main(final String[] args){
        new GuessingGame();
    }


}
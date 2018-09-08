package com.game.src.main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class Quiz extends JPanel {

/**
 * 
 */
	Singelton Quiz = Singelton.getInstance();
private static final long serialVersionUID = 1L;
public JPanel contentPane;

/**
 * Launch the application.
 */


	String s = null;
	int level=0;
	int qn=0;//question number
	int ch1=0;
	int ch2=1;
	int ch3=2;
	int ch4=3;
	int points=0;
	int flag=0;
	int trials=3;
	
	String[][] ans = new String [3][10];
	{
	   ans[0][0]="smallest";
       ans[0][1]="rocky";
       ans[0][2]="craters";
       ans[0][3]="59 days";
       ans[0][4]="Messenger of the Roman gods.";
       ans[0][5]="Mariner 10";
       ans[0][6]="0";
       ans[0][7]="166.8 C";
       ans[0][8]="0.284";
       ans[0][9]="Transit";
       ans[1][0]="goddess of Virginity";
       ans[1][1]="Much slower";
       ans[1][2]="Most similar";
       ans[1][3]="Third rock from the sun";
        ans[1][4]="Oxygen";
       ans[1][5]="900 degrees or more";
      ans[1][6]="Earth";
       ans[1][7]="Volcanoes";
      ans[1][8]="117";
      ans[1][9]="Hydrogen";
    
	}
	
	 String pq4=null,pq1=null,pq2=null,pq3=null;
	 String cho1 = null,choice2=null,choice3=null,choice4=null;

	private JFrame frmRoadToHome;
	private InputStream test;

	/**
	 * Launch the application.
	 */
	
	
/**	public static enum STATE{
		MENU,
		GAME,
		ABOUT,
	};
	//private MyAwesomeMenu menu;
	private STATE State=STATE.MENU;*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("i entered");
					Quiz window = new Quiz();
					window.frmRoadToHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Quiz() throws IOException  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		//MyAwesomeMenu menu=new MyAwesomeMenu();
		frmRoadToHome = new JFrame();
		frmRoadToHome.setTitle("Road to Home");
		test = new FileInputStream("C:\\Users\\user\\Documents\\Java projects\\Sace game\\space.wav");
		//if(State==STATE.GAME){
		frmRoadToHome.getContentPane().setForeground(new Color(51, 204, 255));
		frmRoadToHome.getContentPane().setBackground(new Color(51, 204, 204));
		frmRoadToHome.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmRoadToHome.setFont(new Font("Arial", Font.PLAIN, 15));
		frmRoadToHome.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Documents\\Java projects\\Sace game\\rocket.png"));
		frmRoadToHome.setBackground(new Color(51, 204, 255));
		frmRoadToHome.setAlwaysOnTop(true);
		frmRoadToHome.setBounds(100, 100, 483, 346);
		frmRoadToHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmRoadToHome.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		//Correct or not label
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblNewLabel.setBounds(23, 222, 165, 32);
		panel.add(lblNewLabel);
		//Next QUESTION BUTTOn
		JButton Next = new JButton("Next Question");
		Next.setForeground(new Color(0, 0, 205));
		JLabel points1 = new JLabel("points");
		points1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//while(trials>0){
		JLabel Questions = new JLabel("Qusetion");
		Questions.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		Questions.setForeground(new Color(0, 0, 128));
		Questions.setBounds(23, 35, 397, 47);
		Questions.setText(s);
		panel.add(Questions);
		Next.addActionListener(new ActionListener() {
			
			private Scanner in;

			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Safely");
				//if(Next.getText().equals("Next")){
					System.out.println("Safely222");
                    if((qn<10)&&(trials>0)){
                    	lblNewLabel.setText("_________");
                    	System.out.println("i will go & select");
                               getSelection();
                               System.out.println("yay method done");
                               
                                qn++;
                                if(qn>0){
                                	//System.out.println("ch1 1 =" + ch1);
                                	//System.out.println("ch1 2 =" + ch2);
                                	ch1+=4;
                                	//System.out.println("ch1 1 after addition =" + ch1);
                              
                                	ch2+=4;
                                	//System.out.println("ch1 2 after addition =" + ch2);
                                	ch3+=4;
                                	ch4+=4;
                                }
                                
                                System.out.println("done");
                               
                                }
                    //else {
                    	//System.out.println("Bloody HELL");
                    	//System.out.println("qn= " +qn+"trials" + trials);
                                //map.put(qaid,getSelection());
                                //btnext.setText("Show answers");
                    	if((trials<=0)&&(points<7)){
                    		new GameOver().setVisible(true);
        		        	//System.out.println("visible");
        		        	frmRoadToHome.dispose();
                    		//JOptionPane.showMessageDialog(null, "GAME OVER", null, JOptionPane. INFORMATION_MESSAGE);
                    		//new MainMenu().setVisible()
                    		//back to Main Menu
                    	}if((points>=7)&&(qn>=10)&&(level==0)){
                    		
                    		JOptionPane.showMessageDialog(null, "Level up !,Well Done", null, JOptionPane. INFORMATION_MESSAGE);
                    		level++;
                    	if(points>8){
                    		trials=4;}
                    	else{trials=3;}
                    		points=0;
                    		ch1=0;
                    		ch2=1;
                    		ch3=2;
                    		ch4=3;
                    		qn=0;
                    		getSelection();
                    		ch1=0+4;
                    		ch2=1+4;
                    		ch3=2+4;
                    		ch4=3+4;
                    		qn=0+1;
                    	}if((points>=7)&&(qn>=10)&&(level==1)){
                    		new Win().setVisible(true);
                    		System.out.println("u r a LEGEND");
                    		//JOptionPane.showMessageDialog(null, "Level up !,Well Done", null, JOptionPane. INFORMATION_MESSAGE);
                    	/**	level++;
                    	if(points>8){
                    		trials=4;}
                    	else{trials=3;}
                    		points=0;
                    		ch1=0;
                    		ch2=1;
                    		ch3=2;
                    		ch4=3;
                    		qn=0;
                    		getSelection();*/
                    		}
                               
                             //}
                    
				
			}

			private void getSelection() {
				Next.setEnabled(false);
				// TODO Auto-generated method stub
				
	    		//Questions q = new Questions();
	    		//s=q.readfile(level,qn);
				System.out.println("I entered the method ");
	    		Scanner  in = null;
	    	      //FileOutputStream out = null;
	    	      //String question;
	    		if(level ==0){
	    	      try {
	    	          in = new Scanner(new File("Mercury.txt"));
	    	          String s1 = Files.readAllLines(Paths.get("Mercury.txt")).get(qn);
	    	      	Questions.setText(s1);
	    	          }
	    	       
	    	      catch(Exception e){
	    	    	  //String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }}
	    	      else if(level ==1){
		    	      try {
		    	    	  System.out.println("a new life");
		    	          in = new Scanner(new File("venus.txt"));
		    	          String s1 = Files.readAllLines(Paths.get("venus.txt")).get(qn);
		    	      	Questions.setText(s1);
		    	          }
		    	       
		    	      catch(Exception e){
		    	    	  //String question1 = null;
		    	    	  System.out.println("couldn't find the file ");
		    	    		
		    	      }
	    	      }
	    	
	    		
	    		//button choice 1
	    		
	    		JButton btnNewButton = new JButton("New button");
	    		//btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\Java projects\\Space game\\gal.png"));
	    		//btnNewButton.setForeground(new Color(0, 0, 0));
	    		btnNewButton.setBounds(12, 84, 187, 52);
	    		panel.add(btnNewButton);
	    		 try {
	    			 System.out.println("hello");
	    	          in = new Scanner(new File("choice1.txt"));
	    	          System.out.println("hello2222");
	    	          if(level==0){
	    	          cho1 = Files.readAllLines(Paths.get("choice1.txt")).get(ch1);}
	    	          if(level==1){
		    	          cho1 = Files.readAllLines(Paths.get("choice2.txt")).get(ch1);}
	    	          System.out.println("what i read :" +cho1);
	    	          System.out.println("ch1 1 =" + ch1);
	    	          System.out.println("lol ");
	    	      btnNewButton.setText(cho1);
	    	      System.out.println("oops");
	    	    //  choice1=null;
	    	      revalidate();
	    	      repaint();
	    	          }
	    	       
	    	      catch(Exception e){
	    	    	 // String choice1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		// String pq =btnNewButton.getText();//picked answer
	    		 try {
	    			 System.out.println("serching answ");
	    	         // in = new Scanner(new File("mansewer.txt"));
	    	         // System.out.println("i found the file ^_^");
	    			pq1 = ans[level][qn];
	    	          
	    	          System.out.println("i got the answer");
	    	      //btnNewButton.setText(choice1);
	    	      System.out.println(pq1);
	    	          }
	    	       
	    	      catch(Exception e){
	    	    	  //String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		btnNewButton.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				
	    				System.out.println("I will try and compare");
	    				System.out.println("pq1 =" +pq1 +" choice1 "+cho1);
	    				if(pq1.equals(cho1)){
	    					System.out.println("comparingggggggggggg");
	    					 flag=1;
	    					 lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    						lblNewLabel.setText("Correct Answer");
	    						
	    						
	    					 System.out.println("flag");
	    					 points++;
	    					 points1.setText(String.valueOf(points));
	    					 if(points>8){
	    						 trials++;
	    					 }
	    				 }
	    				else{
	    					System.out.println("no comparison");
	    					flag=-1;
	    					lblNewLabel.setText("Wrong Answer");
	    					trials--;
	    				}
	    			flag=0;
	    			Next.setEnabled(true);}
	    		});
	    	
	    		//button choice 2
	    		JButton btnNewButton_1 = new JButton("New button");
	    		//btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\Java projects\\Sace game\\gal.png"));
	    		btnNewButton_1.setBounds(235, 81, 185, 55);
	    		panel.add(btnNewButton_1);
	    		 try {
	    			 System.out.println("hello");
	    	          in = new Scanner(new File("choice1.txt"));
	    	          System.out.println("hello2222");
	    	          if(level==0){
		    	          choice2= Files.readAllLines(Paths.get("choice1.txt")).get(ch2);}
		    	          if(level==1){
			    	          choice2 = Files.readAllLines(Paths.get("choice2.txt")).get(ch2);}
	    	          System.out.println("hello333");
	    	      btnNewButton_1.setText(choice2);
	    	      System.out.println("hello444");
	    	      revalidate();
	    	      repaint();   }
	    	       
	    	      catch(Exception e){
	    	    	//  String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		 try {
	    			 System.out.println("serching answ");
	    	          in = new Scanner(new File("mansewer.txt"));
	    	          System.out.println("i found the file ^_^");
	    	          pq1 = ans[level][qn];
	    	          System.out.println("i got the nsw");
	    	      //btnNewButton.setText(choice1);
	    	      System.out.println("thanks :D ");
	    	          }
	    	       
	    	      catch(Exception e){
	    	    	  //String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		btnNewButton_1.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				
	    				System.out.println("I will try and compare");
	    				System.out.println("pq1 =" +pq1 +" choice2 "+choice2);
	    				if(pq1.equals(choice2)){
	    					System.out.println("comparingggggggggggg");
	    					 flag=1;
	    						lblNewLabel.setText("Correct Answer");
	    						
	    						
	    					 System.out.println("flag");
	    					 points++;
	    					 points1.setText(String.valueOf(points));
	    					 if(points>8){
	    						 trials++;
	    					 }
	    				 }
	    				else{
	    					System.out.println("no comparison");
	    					flag=-1;
	    					lblNewLabel.setText("Wrong Answer");
	    					trials--;
	    				}
	    			flag=0;Next.setEnabled(true);}
	    		});
	    	
	    		//button choice 3
	    		JButton btnNewButton_2 = new JButton("New button");
	    		//btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\Java projects\\Sace game\\gal.png"));
	    		btnNewButton_2.setBounds(12, 140, 187, 55);
	    		panel.add(btnNewButton_2);
	    		 try {
	    			 System.out.println("hello");
	    	          in = new Scanner(new File("choice1.txt"));
	    	          System.out.println("hello2222");
	    	          if(level==0){
		    	          choice3= Files.readAllLines(Paths.get("choice1.txt")).get(ch3);}
		    	          if(level==1){
			    	          choice3 = Files.readAllLines(Paths.get("choice2.txt")).get(ch3);}
	    	          System.out.println("hello333");
	    	      btnNewButton_2.setText(choice3);
	    	      System.out.println("hello444");
	    	      revalidate();
	    	      repaint();  }
	    	       
	    	      catch(Exception e){
	    	    	  //String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }try {
	    				 System.out.println("serching answ");
	    		          in = new Scanner(new File("mansewer.txt"));
	    		          System.out.println("i found the file ^_^");
	    		          pq1 = ans[level][qn];
	    		          System.out.println("i got the nsw");
	    		      //btnNewButton.setText(choice1);
	    		      System.out.println("shokran");
	    		          }
	    		       
	    		      catch(Exception e){
	    		    	  //String question1 = null;
	    		    	  System.out.println("couldn't find the file ");
	    		    		
	    		      }
	    			btnNewButton_2.addActionListener(new ActionListener() {
	    				public void actionPerformed(ActionEvent arg0) {
	    					
	    					System.out.println("I will try and compare");
	    					System.out.println("pq1 =" +pq1 +" choice3 "+choice3);
	    					if(pq1.equals(choice3)){
	    						System.out.println("comparingggggggggggg");
	    						 flag=1;
	    							lblNewLabel.setText("Correct Answer");
	    							
	    							
	    						 System.out.println("flag");
	    						 points++;
	    						 points1.setText(String.valueOf(points));
	    						 if(points>8){
	    							 trials++;
	    						 }
	    					 }
	    					else{
	    						System.out.println("no comparison");
	    						flag=-1;
	    						lblNewLabel.setText("Wrong Answer");
	    						trials--;
	    					}
	    				flag=0; Next.setEnabled(true);}
	    			});
	    		
	    		//button choice 4 
	    		JButton btnNewButton_3 = new JButton("New button");
	    		//btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\Java projects\\Sace game\\gal.png"));
	    		btnNewButton_3.setBounds(235, 140, 185, 55);
	    		panel.add(btnNewButton_3);
	    		try {
	    			 System.out.println("hello");
	    	          in = new Scanner(new File("choice1.txt"));
	    	          System.out.println("hello2222");
	    	          if(level==0){
		    	          choice4= Files.readAllLines(Paths.get("choice1.txt")).get(ch4);}
		    	          if(level==1){
			    	          choice4 = Files.readAllLines(Paths.get("choice2.txt")).get(ch4);}
	    	          System.out.println("hello333");
	    	      btnNewButton_3.setText(choice4);
	    	      System.out.println("hello444");
	    	      revalidate();
	    	      repaint(); }
	    	       
	    	      catch(Exception e){
	    	    	  //String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		try {
	    			 System.out.println("serching answ");
	    	         // in = new Scanner(new File("mansewer.txt"));
	    	         // System.out.println("i found the file ^_^");
	    	          pq1 = ans[level][qn];
	    	          System.out.println("i got the nsw");
	    	      //btnNewButton.setText(choice1);
	    	      System.out.println("shokran");
	    	          }
	    	       
	    	      catch(Exception e){
	    	    	 // String question1 = null;
	    	    	  System.out.println("couldn't find the file ");
	    	    		
	    	      }
	    		btnNewButton_3.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				
	    				System.out.println("I will try and compare");
	    				System.out.println("pq1 =" +pq1 +" choice4 "+choice4);
	    				if(pq1.equals(choice4)){
	    					System.out.println("comparingggggggggggg");
	    					 flag=1;
	    						lblNewLabel.setText("Correct Answer");
	    						
	    						
	    					 System.out.println("flag");
	    					 points++;
	    					 points1.setText(String.valueOf(points));
	    					 if(points>8){
	    						 trials++;
	    					 }
	    				 }
	    				else{
	    					System.out.println("no comparison");
	    					flag=-1;
	    					lblNewLabel.setText("Wrong Answer");
	    					trials--;
	    				}
	    			flag=0;Next.setEnabled(true);
	    			}
	    	});
	    	}
	            //return(selectedChoice);
	
			});
		//public void getSelection(){
			//int i=4;
            //String selectedChoice=null;
            //Enumeration<AbstractButton> buttons=bg.getElements(); 
            //while(i>0) 
           // { 
           //JButton temp=(JButton)ButtonUI.nextElement(); 
          //  if(temp.isSelected()) 
                       /** { 
                                    selectedChoice=temp.getText();
                        } 
             }  */
            
	
		points1.setBounds(379, 13, 56, 26);
		panel.add(points1);
		points1.setText(String.valueOf(points));
		JLabel Chances = new JLabel("Chances");
		Chances.setForeground(new Color(0, 0, 255));
		Chances.setFont(new Font("Arial", Font.BOLD, 16));
		Chances.setBounds(28, 13, 69, 26);
		panel.add(Chances);
		//panel.add(trials);
		
		
		
		JLabel Score = new JLabel("Score");
		Score.setForeground(new Color(0, 0, 255));
		Score.setFont(new Font("Arial", Font.BOLD, 16));
		Score.setBounds(302, 13, 50, 26);
		panel.add(Score);
		
		Next.setFont(new Font("Arial", Font.BOLD, 17));
		Next.setBounds(279, 239, 174, 47);
		panel.add(Next);
		
		JLabel die = new JLabel("");
		die.setBounds(129, 23, 56, 16);
		panel.add(die);
		//}
		
		
		
		
		
		/**
}
}*/}}




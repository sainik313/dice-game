import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*; 
import java.awt.BorderLayout; 
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

class Dice extends JFrame implements ActionListener{ 

JFrame f;
JButton b,b1,b2,b3,b4,b5,b6,b31,b32,b33,b34,b35,b36,b37,b38,b39,b310,b311,b312;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p11,p21,p31;
JLabel l11,l21,l22,l23,l31,l41,l42,l43,l44,l45,l51,l52,l53,l54,l55,l61;
Icon ic1,ic2,ic3,ic4,ic5,ic6;

Random randomGenerator = new Random();
	int rand1, rand2,select=0;
	int dice,flag=0; 
	int given=100; int current=100;
	 
	
	JLabel pic1=new JLabel();
	JLabel pic2=new JLabel();
	JLabel pic3=new JLabel();
	
	JPanel p22=new JPanel();
	JPanel p40=new JPanel();
	JPanel p41=new JPanel();
	JPanel p42=new JPanel();
	JPanel p43=new JPanel();
         
	
	
Dice(){
	f=new JFrame("Dice Game");
	
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p6=new JPanel();
	p7=new JPanel();
	p8=new JPanel();
	
	  
	try {
          
         URL url = this.getClass().getClassLoader().getResource("audio.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
         Clip clip = AudioSystem.getClip();
         
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e1) {
         e1.printStackTrace();
      } catch (IOException e1) {
         e1.printStackTrace();
      } catch (LineUnavailableException e1) {
         e1.printStackTrace();
      }
	  
	//p1 
	 
	l11=new JLabel("<html><h2 style='color:red; font-family: Tw Cen MT; font-size:25px;'>Dice Game</h2><html>");
	p1.add(l11);
	 
	p1.setBackground(new Color (0,250,154));
	p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	//p2
	l21=new JLabel("Here Your Dices:-");
	l21.setBorder(new EmptyBorder(5, 170, 1, 170));
	p2.add(l21);
	
	p21= new JPanel();
	
	ic1=new ImageIcon("0.gif");
	ic2=new ImageIcon("0.gif");
	 
	pic1.setIcon(ic1);  
    pic2.setIcon(ic2);
	
    p21.add(pic1);
    p21.add(pic2);
	
		
	
	p21.setBackground(new Color (60,179,113));
	p21.setLayout(new GridLayout(1,2,250,30));
	p21.setBorder(new EmptyBorder(20, 330, 20, 330));
	
	l22=new JLabel("Selcted Value: NULL ");
	l23=new JLabel("Dices Value: NULL ");
	p22.setBorder(new EmptyBorder(10, 30, 10, 30));
	
	p22.add(l22);
	p22.add(l23);
	
	p22.setLayout(new GridLayout(1,2,100,0));
	p22.setBackground(new Color (60,179,113));
	
	p2.add(p21);
	p2.add(p22);
	p2.setBackground(new Color (0,250,154));
	p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	l31=new JLabel("Select Any Number");
	l31.setBorder(new EmptyBorder(0, 200, 0, 200));
		//p3

	p31= new JPanel();
 
	
	b31=new JButton("1");
	b32=new JButton("2");
	b33=new JButton("3");
	b34=new JButton("4");
	b35=new JButton("5");
	b36=new JButton("6");
	b37=new JButton("7");
	b38=new JButton("8");
	b39=new JButton("9");
	b310=new JButton("10");
	b311=new JButton("11");
	b312=new JButton("12");
	
	b31.addActionListener(this);
	b32.addActionListener(this);
	b33.addActionListener(this);
	b34.addActionListener(this);
	b35.addActionListener(this);
	b36.addActionListener(this);
	b37.addActionListener(this);
	b38.addActionListener(this);
	b39.addActionListener(this);
	b310.addActionListener(this);
	b312.addActionListener(this);
	b312.addActionListener(this);
	 
	
	b3=new JButton("Roll Dice");
    b3.setBorder(new EmptyBorder(5, 170, 5, 170));
	 
	
	b3.addActionListener(this);
	b31.setBounds(10,10,100,100); 
	
	p3.add(l31);
	p31.add(b31);
	p31.add(b32);
	p31.add(b33);
	p31.add(b34);
	p31.add(b35);
	p31.add(b36);
	p31.add(b37);
	p31.add(b38);
	p31.add(b39);
	p31.add(b310);
	p31.add(b311);
	p31.add(b312);
	
	p31.setBackground(new Color (60,179,113));
	
	p31.setBorder(new EmptyBorder(20, 20, 20, 20));

	p31.setLayout(new GridLayout(2,6,130,30));
	
	
	
	p3.add(p31);
	p3.add(b3);
	
	p3.setBackground(new Color (0,250,154));
	p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	//p4
	l41=new JLabel("Score Board");
	l42=new JLabel("Given Points= "+given);
	l43=new JLabel("Current Points= "+current);
	l44=new JLabel("Last Status= NULL");
	b4=new JButton("<html><h2 style='position:absolute; top: 100px; left:200px; color:red; font-family: Tw Cen MT; font-size:12px;'>Restart Game</h2><html>");
	
	b4.addActionListener(this);
	
	l41.setBorder(new EmptyBorder(10, 230, 5, 10));
	l41.setBackground(Color.gray);
	
	p41.setLayout(new GridLayout(3,1,10,10));
	
	l42.setBorder(new EmptyBorder(0, 20, 0, 0));
	l43.setBorder(new EmptyBorder(0, 20, 0, 0));
	l44.setBorder(new EmptyBorder(0, 20, 0, 0));
	
	p42.add(b4);
	p42.setBackground(new Color (0,250,154));
	
    p41.add(l42);	
    p41.add(l43);	
    p41.add(l44);

	p41.setBackground(new Color (0,250,154));	
    
	p43.setLayout(new GridLayout(1,2,10,10));
	p43.add(p41);
	p43.add(p42);
	
	p4.setLayout(new GridLayout(2,1,10,10));
	p4.add(l41);
	p4.add(p43);
	
	p4.setBackground(new Color (0,250,154));
	p4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	//p5
	l51=new JLabel("Game Rules");
	l52=new JLabel("We gives you 100 points in Starting");
	l53=new JLabel("If you Won, you got 50 Points");
	l54=new JLabel("If you Lose, You lose 10 Points");
	l55=new JLabel("You need 500 Points for Win the Game");
	
	l51.setBorder(new EmptyBorder(10, 230, 5, 10)); 
	l52.setBorder(new EmptyBorder(0, 20, 0, 0));
	l53.setBorder(new EmptyBorder(0, 20, 0, 0));
	l54.setBorder(new EmptyBorder(0, 20, 0, 0));
	l55.setBorder(new EmptyBorder(0, 20, 0, 0));
	
	p5.setLayout(new GridLayout(5,1,5,5));
	
	p5.add(l51);
	p5.add(l52);	
    p5.add(l53);	
    p5.add(l54);	
    p5.add(l55);
	
	p5.setBackground(new Color (0,250,154));
	p5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	//p6
	l61=new JLabel("<html><p style='color:red; font-family: Tw Cen MT; font-size:10px;'>&copy; All Rights Reserved by Kapil Saini</p><html>");
	p6.add(l61);
	
	p6.setBackground(new Color (0,250,154));
	p6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	//p7
	
	p7.add(p4);
	p7.add(p5);
	
	p7.setLayout(new GridLayout(1,2));
	
	//p8
	p8.add(p2);
	p8.add(p3);
	p8.add(p7);
	
	p8.setLayout(new GridLayout(3,1));
	
	//frame
	
	f.add(p1);
	f.add(p6);
	 
	f.add(p8);
	
	f.add(p1,BorderLayout.NORTH);	
       
    f.add(p8,BorderLayout.CENTER);  
       
    f.add(p6,BorderLayout.SOUTH);
	
	f.pack();
	f.setVisible(true);
	f.setSize(1100,700);
	f.setIconImage(new ImageIcon("00.png").getImage());
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void rand()
{
	rand1 = randomGenerator.nextInt((6 - 1) + 1) + 1;
		rand2 = randomGenerator.nextInt((6 - 1) + 1) + 1;
		 
}

public void diceadd()
{
	dice=rand1+rand2;
}

public void showdice()
{
	ic1=new ImageIcon(rand1+".gif");  
	ic2=new ImageIcon(rand2+".gif");  
	ic3=new ImageIcon("0.gif");  
	ic4=new ImageIcon("0.gif");  
	
	pic1.setIcon(ic3);  
    pic2.setIcon(ic3);
    
    p21.add(pic1);
    p21.add(pic2);

	
	
	Timer timer = new Timer(5000, new ActionListener() {

             
            public void actionPerformed(ActionEvent e) {
                // Clear text or whatever you want
				pic1.setIcon(ic1);  
				pic2.setIcon(ic2);
               p21.add(pic1);
               p21.add(pic2);
			   
			   l22.setText("Selected Value: "+select);
			   l23.setText("Dices Value: "+dice);
	
				p22.add(l22);
			    p22.add(l23);
            }
        });
        // start Tick-Tack
        timer.start();
		
}

public void result(int f)
{
				
	if(f==1)
	{
		current=current+50;
		 
		l43.setText("Current Points= "+current);
		l44.setText("Last Status= You Won");
		p41.add(l43);
	    p41.add(l44);
		
	}
	else
	{
		current=current-10;
		 
		l43.setText("Current Points= "+current);
		l44.setText("Last Status= You Lose");
		p41.add(l43);
	    p41.add(l44);
	}
	if(current<=0)
	{
		JOptionPane.showMessageDialog(p3, "You Lose the Game");
	}
	if(current>=500)
	{
		JOptionPane.showMessageDialog(p3, "You Win the Game");
	}
}

public void actionPerformed(ActionEvent e)
{
	 
	if(e.getSource()==b31)
	{
		select=1;
		 
	}
	if(e.getSource()==b32)
	{
		select=2;
		 
	}
	if(e.getSource()==b33)
	{
		select=3;
	 
	}
	if(e.getSource()==b34)
	{
		select=4;
		 
	}
	if(e.getSource()==b35)
	{
		select=5;
		 
	}
	if(e.getSource()==b36)
	{
		select=6;
		 
	}
	if(e.getSource()==b37)
	{
		select=7;
		 
	}
	if(e.getSource()==b38)
	{
		select=8;
		 
	}
	if(e.getSource()==b39)
	{
		select=9;
		 
	}
	if(e.getSource()==b310)
	{
		select=10;
		 
	}
	if(e.getSource()==b311)
	{
		select=11;
		 
	}
	if(e.getSource()==b312)
	{
		select=12;
		 
	}
	
	if(e.getSource()==b4)
	{
		current=100;
		ic1=new ImageIcon("0.gif");
	ic2=new ImageIcon("0.gif");
	 
	pic1.setIcon(ic1);  
    pic2.setIcon(ic2);
	
    p21.add(pic1);
    p21.add(pic2);
		l43.setText("Current Points= "+current);
		l44.setText("Last Status= NULL");
		p41.add(l43);
	    p41.add(l44);
	}
	
	
	 if(e.getSource()==b3)
	 {
		 
		 if(select==0){
			 JOptionPane.showMessageDialog(p3, "Please Select Your Number");
		 }
		 else
		 {
			 
		 try {
          
         URL url = this.getClass().getClassLoader().getResource("dice.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
         Clip clip = AudioSystem.getClip();
         
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e1) {
         e1.printStackTrace();
      } catch (IOException e1) {
         e1.printStackTrace();
      } catch (LineUnavailableException e1) {
         e1.printStackTrace();
      }
	  
		 
		rand();
		diceadd();
		showdice();
		 
		if(dice==select)
		{
			flag=1;
		}
		result(flag);
		flag=0;
		 }
	 }

}

public static void main(String s[])
{
	new Dice();
}
}
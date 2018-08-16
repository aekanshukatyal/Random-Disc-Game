import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Game extends Frame implements ActionListener,MouseListener
	{
	Button b,b1,b2,b3,b4;
	Thread t;
	Random r;
	Label l,l1;
	Color gg,ggg;
	int counter=0;
	Color c[]={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
	int x,y;
	Game()
	{
		b=new Button("Red");
		b1=new Button("Green");
		b2=new Button("Blue");
		b3=new Button("Yellow");
		b4=new Button("Exit");
		l=new Label();
		l1=new Label("Choose Your Colour");
		l1.setFont(new Font("Courier",Font.BOLD,18));
		r=new Random();
		t=new Thread(new Runnable()
		{
			public void run()
			{
				while(true)
					{
					repaint();
					x=r.nextInt(500);
					y=r.nextInt(400);
					try{Thread.sleep(600);}catch(InterruptedException e){}
					}
			}
		});
		setLayout(null );
		b.setBounds(50,30,50,30);
		b1.setBounds(110,30,50,30);
		b2.setBounds(170,30,50,30);
		b3.setBounds(230,30,50,30);
		b4.setBounds(630,550,50,30);
		l.setBounds(290,500,150,30);
		l1.setBounds(50,60,250,30);
		setBackground(Color.CYAN);
		add(b);add(b1);add(b2);add(b3);add(b4);add(l);add(l1);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent  e)
			{
				dispose();
			}
		});
		addMouseListener(this);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(700,600);
		setResizable(false);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.setFont(new Font("Times New Roman",Font.BOLD,20));
		g.drawString("Score : "+counter,550,50 );
		g.setColor(c[r.nextInt(4)]);
		gg=g.getColor();
		g.fillOval(x,y,40,40);
		g.fillOval(x+40,y+40,40,40);
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		t.start();
		if(e.getSource()==b)
		{
			ggg=Color.RED;
		}
		if(e.getSource()==b1)
		{
			ggg=Color.GREEN;
		}
		if(e.getSource()==b2)
		{
			ggg=Color.BLUE;
		}
		if(e.getSource()==b3)
		{
			ggg=Color.YELLOW;
		}
		if(e.getSource()==b4)
		{
			System.exit(0);
		}
	}	

	public void mouseClicked(MouseEvent e)
	{
			if(gg==ggg)
			{
				counter++;
				repaint();			}
			else
			{
			l.setFont(new Font("Courier",Font.BOLD,20));	
			l.setText("GAME OVER");
			t.stop();
			}
	}
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}


	public static void main(String[] args) 
	{
	new Game();
	}
	
}

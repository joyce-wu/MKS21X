import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window2 extends JFrame implements ActionListener {
    private Container pane;

    private JButton b, b2;
    private JLabel l, l2;
    private JTextField f, c;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window2() {
	this.setTitle("Temperature Conversion");
	this.setSize(200,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); 
	b = new JButton("FtoC");
	b.addActionListener(this);
	b.setActionCommand("FtoC");
	b2 = new JButton("CtoF");
	b2.addActionListener(this);
	b2.setActionCommand("CtoF");
	l = new JLabel("Fahrenheit");
	l2 = new JLabel("Celsius");
	f = new JTextField(1);
	c = new JTextField(1);
	pane.add(l);
	pane.add(f);
	pane.add(b);
	pane.add(l2);
	pane.add(c);
	pane.add(b2);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("FtoC")){
	    String s = f.getText();
	    try{
	    	int num = Integer.parseInt(s);
	    	f.setText(""+num);
	    	c.setText(Temperatures.FtoC(num)+"");
	    }catch(NumberFormatException a){
	    	c.setText("ERROR");
	    	f.setText("ERROR");
	    }
	}
	else if(event.equals("CtoF")){
	    String s = c.getText();
	    try{
	    	int num = Integer.parseInt(s);
	    	f.setText(Temperatures.CtoF(num)+"");
	    }catch(NumberFormatException a){
	    	c.setText("ERROR");
	    	f.setText("ERROR");
	    }
	}
    }
	

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}

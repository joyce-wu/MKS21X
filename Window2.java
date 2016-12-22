import javax.swing.*;
import java.awt.*;
public class Window2 extends JFrame {
    private Container pane;

    private JButton b, a;
    private JLabel l, f;
    private JTextField t, r;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window2() {
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS)); 
    
	b = new JButton("FtoC");
	a = new JButton("CtoF");
	l = new JLabel("Fahrenheit",null,JLabel.CENTER);
	f = new JLabel("Celsius", null, JLabel.CENTER);
	t = new JTextField(12);
	r = new JTextField(12);
	pane.add(l);
	pane.add(f);
	pane.add(t);
	pane.add(r);
	pane.add(b);
	pane.add(a);
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}

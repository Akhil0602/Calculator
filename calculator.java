import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;
public class calculator extends JFrame implements ActionListener
{
    JTextField tx;
    JButton b[]=new JButton[20];
    public calculator()
    {
        setVisible(true);
        setSize(440,650);
        setLocation(200,0);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] s={"B","C","1/X","sqrt","7","8","9","/","4","5","6","*"
        ,"1","2","3","-","0",".","=","+"};
        int x=10,y=110,w=100,h=100,i,j,k=0;
        Font f=new Font("Algeria",Font.BOLD,20);
        Font f1=new Font("Algeria",Font.BOLD,30);
        tx=new JTextField("");
        tx.setSize(400,100);
        tx.setLocation(10,10);
        tx.setFont(f);
        tx.setHorizontalAlignment(JTextField.RIGHT);
        add(tx);
        for(i=0;i<5;i++)
        {
            for(j=0;j<4;j++)
            {
             b[k]=new JButton(s[k]);
             b[k].setSize(w,h);
             b[k].setLocation(x,y);
             b[k].setFont(f1);
             b[k].addActionListener(this);
             x+=w;
             add(b[k]);
             k++;
            }
            x=10;
            y+=h;
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton a=(JButton)e.getSource();
        String s=a.getLabel();
        if(!(s.equals("C")||s.equals("B")||s.equals("sqrt")||s.equals("1/X")||s.equals("=")))
        {
            String x=tx.getText()+s;
            tx.setText(x);
        }
        else if(s.equals("C"))
        {
            tx.setText("");
        }
        else if(s.equals("B"))
        {
            tx.setText((tx.getText()).substring(0,(tx.getText()).length()-1));
        }
        else if(s.equals("sqrt"))
        {
            Double d=Double.parseDouble(tx.getText());
            tx.setText(""+Math.sqrt(d));
        }
        else if(s.equals("1/X"))
        {
            Double d=Double.parseDouble(tx.getText());
            tx.setText(""+1/d);
        }
        else if(s.equals("="))
        {
            ScriptEngineManager em=new ScriptEngineManager();
            ScriptEngine em1=em.getEngineByName("js");
            try
            {
                tx.setText(""+em1.eval(tx.getText()));
            }
            catch(Exception ex){}
        }
    }
    public static void main(String args[])
    {
        calculator c=new calculator();
    }
}

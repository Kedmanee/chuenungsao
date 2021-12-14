import java.awt.*;
import javax.swing.*;

public class Login {
    private JFrame fr;
    public JLabel user, pass,log;
    private JPanel mainp, userp, passp, nop;
    private JButton login;
    private JTextField usert, passt;
    
    public Login(){
        fr = new JFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(3,1));
        mainp = new JPanel();
        
        userp = new JPanel();
        user = new JLabel("Username");
        usert = new JTextField();
        userp.setLayout(new GridLayout(1,2));
        userp.add(user);
        userp.add(usert);
        
        passp = new JPanel();
        pass = new JLabel("Password");
        passt = new JTextField();
        passp.setLayout(new GridLayout(1,2));
        passp.add(pass);
        passp.add(passt);
        
        login = new JButton("Login");
        
        nop = new JPanel();
        log = new JLabel("Login");
        nop.add(log);
        
        mainp.setLayout(new GridLayout(3,1));
        mainp.add(userp);
        mainp.add(passp);
        mainp.add(login);
        mainp.setSize(600,300);
        
        fr.add(nop);
        fr.add(mainp);
        fr.setSize(1000,1000);

        
        
        
    }
}

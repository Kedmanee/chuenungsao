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

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JLabel getUser() {
        return user;
    }

    public void setUser(JLabel user) {
        this.user = user;
    }

    public JLabel getPass() {
        return pass;
    }

    public void setPass(JLabel pass) {
        this.pass = pass;
    }

    public JLabel getLog() {
        return log;
    }

    public void setLog(JLabel log) {
        this.log = log;
    }

    public JPanel getMainp() {
        return mainp;
    }

    public void setMainp(JPanel mainp) {
        this.mainp = mainp;
    }

    public JPanel getUserp() {
        return userp;
    }

    public void setUserp(JPanel userp) {
        this.userp = userp;
    }

    public JPanel getPassp() {
        return passp;
    }

    public void setPassp(JPanel passp) {
        this.passp = passp;
    }

    public JPanel getNop() {
        return nop;
    }

    public void setNop(JPanel nop) {
        this.nop = nop;
    }

    public JButton getLogin() {
        return login;
    }

    public void setLogin(JButton login) {
        this.login = login;
    }

    public JTextField getUsert() {
        return usert;
    }

    public void setUsert(JTextField usert) {
        this.usert = usert;
    }

    public JTextField getPasst() {
        return passt;
    }

    public void setPasst(JTextField passt) {
        this.passt = passt;
    }
    
}

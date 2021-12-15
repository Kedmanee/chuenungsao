
import java.awt.*;
import javax.swing.*;

public class mainPage {

    private JFrame fr;
    public JLabel icon;
    private JPanel photop, mainp, bntp, mainbnt, bnthire;
    private JButton reg, hire, manage;
    private ImageIcon chns;

    public mainPage() {
        fr = new JFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(3,1));
        photop = new JPanel();
        chns = new ImageIcon(getClass().getResource("1.png"));
        icon = new JLabel(chns);
        photop.setLayout(new FlowLayout());
        photop.add(icon);
        photop.setSize(100, 109);

        bntp = new JPanel();
        mainbnt = new JPanel();
        reg = new JButton("สมัครใช้งาน");
        manage = new JButton("จัดการหนังสือ");
        mainbnt.add(bntp, BorderLayout.CENTER);
        bntp.setLayout(new FlowLayout());
        bntp.add(reg);
        bntp.add(manage);
        mainbnt.add(bntp);

        bnthire = new JPanel();
        hire = new JButton("เช่า");
        bnthire.setLayout(new FlowLayout());
        bnthire.add(hire);
        
        fr.add(photop);
        fr.add(mainbnt);
        fr.add(bnthire);
        fr.setSize(1000, 1000);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JLabel getIcon() {
        return icon;
    }

    public void setIcon(JLabel icon) {
        this.icon = icon;
    }

    public JPanel getPhotop() {
        return photop;
    }

    public void setPhotop(JPanel photop) {
        this.photop = photop;
    }

    public JPanel getMainp() {
        return mainp;
    }

    public void setMainp(JPanel mainp) {
        this.mainp = mainp;
    }

    public JPanel getBntp() {
        return bntp;
    }

    public void setBntp(JPanel bntp) {
        this.bntp = bntp;
    }

    public JPanel getMainbnt() {
        return mainbnt;
    }

    public void setMainbnt(JPanel mainbnt) {
        this.mainbnt = mainbnt;
    }

    public JPanel getBnthire() {
        return bnthire;
    }

    public void setBnthire(JPanel bnthire) {
        this.bnthire = bnthire;
    }

    public JButton getReg() {
        return reg;
    }

    public void setReg(JButton reg) {
        this.reg = reg;
    }

    public JButton getHire() {
        return hire;
    }

    public void setHire(JButton hire) {
        this.hire = hire;
    }

    public JButton getManage() {
        return manage;
    }

    public void setManage(JButton manage) {
        this.manage = manage;
    }

    public ImageIcon getChns() {
        return chns;
    }

    public void setChns(ImageIcon chns) {
        this.chns = chns;
    }
    
}


import model.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginController implements ActionListener {
    private Login view;
    private Admin model;
    private MDI test;

    public LoginController(){
        test = new MDI();
        view = new Login();
        model = new Admin();
        view.getUsert().addActionListener(this);
        view.getPasst().addActionListener(this);
        view.getLogin().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(view.getLogin())) {
            System.out.printf("test");
            if (model.isLogin(view.getUsert().getText(), view.getPasst().getText())){
                test.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "ผิดไอ้กาก.", "Insert Command", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}

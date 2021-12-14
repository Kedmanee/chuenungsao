/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MDI extends JFrame {

    private JDesktopPane desktopPane;
    private ManageBooks manageBooks;
    public Font headFont = new Font("Angsana new", Font.BOLD, 56);
    public Font titleFont = new Font("Angsana new", Font.BOLD, 30);
    public MDI() {
        desktopPane = new JDesktopPane();
        desktopPane.setLayout(new BorderLayout());
        //สร้างหน้าการจัดการหนังสือ
        manageBooks = new ManageBooks(false, false, false, false, this);

        //เพิ่มหน้าหนังสือ
        desktopPane.add(manageBooks);
        
        this.add(desktopPane);
        this.setMinimumSize(new Dimension(1200, 600));
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ให้ย่อแล้วอยู่ตรงกลาง
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    public ManageBooks getManageBooks() {
        return manageBooks;
    }

    public void setManageBooks(ManageBooks manageBooks) {
        this.manageBooks = manageBooks;
    }

}

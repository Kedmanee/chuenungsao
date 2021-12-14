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

public class InsertBook {

    private JFrame frame;
    private JPanel pHeading,pAdd, pNameLB, pCategoryLB, pAuthorLB, pPricePerDayLB,pNameG,pCategoryG,pAuthorG,pPricePerDayG ,p1,p2,p3,p4,pForm;
    private JLabel name, category, author, pricePerDay, heading;
    private JTextField nameTF, authorTF, pricePerDayTF;
    private JComboBox categoryCB;
    private JButton add;

    public InsertBook() {
        frame = new JFrame("Adding Book");

        //หัวข้อ
        pHeading = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        heading = new JLabel("การเพิ่มหนังสือ");
        heading.setFont(new Font("Angsana new", Font.BOLD, 56));
        pHeading.add(heading);

        //สร้าง form
        name = new JLabel("ชื่อหนังสือ");
        nameTF = new JTextField(15);
        name.setFont(new Font("Angsana new", Font.BOLD, 30));
        nameTF.setFont(new Font("Angsana new", Font.BOLD, 30));
        pNameLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pNameLB.add(name);
        pNameG = new JPanel(new GridLayout(1, 2));
        pNameG.add(pNameLB);
        pNameG.add(nameTF);
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p1.add(pNameG);

        category = new JLabel("หมวดหมู่");
        categoryCB = new JComboBox();
        categoryCB.addItem("เบ็ดเตล็ด");
        categoryCB.addItem("การ์ตูน");
        categoryCB.addItem("นิยาย");
        categoryCB.addItem("การลงทุน");
        categoryCB.addItem("เทคโนโลยี");
        categoryCB.addItem("ประวัติศาสตร์ การเมือง");
        category.setFont(new Font("Angsana new", Font.BOLD, 30));
        categoryCB.setFont(new Font("Angsana new", Font.BOLD, 30));
        pCategoryLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pCategoryLB.add(category);
        pCategoryG = new JPanel(new GridLayout(1, 2));
        pCategoryG.add(pCategoryLB);
        pCategoryG.add(categoryCB);
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p2.add(pCategoryG);
        ((JLabel)categoryCB.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        author = new JLabel("ผู้แต่ง");
        authorTF = new JTextField(15);
        author.setFont(new Font("Angsana new", Font.BOLD, 30));
        authorTF.setFont(new Font("Angsana new", Font.BOLD, 30));
        pAuthorLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pAuthorLB.add(author);
        pAuthorG = new JPanel(new GridLayout(1, 2));
        pAuthorG.add(pAuthorLB);
        pAuthorG.add(authorTF);
        p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
        p3.add(pAuthorG);

        pricePerDay = new JLabel("ราคา/วัน");
        pricePerDayTF = new JTextField(14);
        pricePerDay.setFont(new Font("Angsana new", Font.BOLD, 30));
        pricePerDayTF.setFont(new Font("Angsana new", Font.BOLD, 30));
        pPricePerDayLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 5));
        pPricePerDayLB.add(pricePerDay);
        pPricePerDayG = new JPanel(new GridLayout(1, 2));
        pPricePerDayG.add(pPricePerDayLB);
        pPricePerDayG.add(pricePerDayTF);
        p4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        p4.add(pPricePerDayG);
        
        pForm = new JPanel(new GridLayout(2, 2));
        pForm.add(p1);
        pForm.add(p2);
        pForm.add(p3);
        pForm.add(p4);

        //สร้างปุ่มเพิ่มหนังสือ
        add = new JButton("เพิ่มหนังสือ");
        add.setFont(new Font("Angsana new", Font.BOLD, 30));
        pAdd = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pAdd.add(add);

        
        frame.add(pHeading, BorderLayout.NORTH);
        frame.add(pForm);
        frame.add(pAdd,BorderLayout.SOUTH);
        
        frame.setSize(1300,450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(false);
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(JTextField nameTF) {
        this.nameTF = nameTF;
    }

    public JTextField getAuthorTF() {
        return authorTF;
    }

    public void setAuthorTF(JTextField authorTF) {
        this.authorTF = authorTF;
    }

    public JTextField getPricePerDayTF() {
        return pricePerDayTF;
    }

    public void setPricePerDayTF(JTextField pricePerDayTF) {
        this.pricePerDayTF = pricePerDayTF;
    }

    public JComboBox getCategoryCB() {
        return categoryCB;
    }

    public void setCategoryCB(JComboBox categoryCB) {
        this.categoryCB = categoryCB;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }
    
}

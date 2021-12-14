/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class controller implements ActionListener{
    private int test = 1;
    private MDI main;
    private InsertBook addingBook;
    private Book books;
    //ปุ่มในตาราง
    private ButtonRenderer btn;
    private JButton button;
    public controller() {
        main = new MDI();
        addingBook = new InsertBook();
        
        btn = new ButtonRenderer();
        button = new JButton();
        btn.setFont(main.titleFont);
        main.getManageBooks().getAddBooks().addActionListener(this);
        addingBook.getAdd().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(main.getManageBooks().getAddBooks())){
            addingBook.getFrame().setVisible(true);
        }
        else if(ae.getSource().equals(addingBook.getAdd())){
            Object[] row = {test++,addingBook.getCategoryCB().getSelectedItem(),addingBook.getNameTF().getText()};
            main.getManageBooks().getModel().addRow(row);
           main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellRenderer(btn);
            main.getManageBooks().getTableOfInfoBooks().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
            
            addingBook.getNameTF().setText("");
            addingBook.getAuthorTF().setText("");
            addingBook.getPricePerDayTF().setText("");
            addingBook.getCategoryCB().setSelectedItem("Other");
            
        }

    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            //ปรับสีปุ่มในตาราง
            setOpaque(true);
            setBackground(new Color(69,69,69));
            setForeground(Color.white);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "More Details..." : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "More Details..." : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }
}

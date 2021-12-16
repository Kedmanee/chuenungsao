package Controller;
import View.MDI;
import model.Book;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import View.InfoBook;

public class Rent_Controller implements ActionListener {

    private MDI main;
    private Book bookDB;
    private InfoBook infoBook;
    private List<Integer> idcheck = new LinkedList();
    private List<Integer> daycheck = new LinkedList();
    //ปุ่มในตาราง
    private ButtonRenderer btn;
    private JButton button;
    private int keepRow;


    public Rent_Controller() {
        main = new MDI();
        bookDB = new Book();
        infoBook = new InfoBook();
        btn = new ButtonRenderer();
        btn.setFont(main.titleFont);
        button = new JButton();
        button.setFont(main.titleFont);
        button.setBackground(new Color(69, 69, 69));
        button.setForeground(Color.white);
        button.addActionListener(this);
        main.getRentview().getBtn_add().addActionListener(this);
        main.getRentview().getBtn_submit().addActionListener(this);
        main.getRentview().getBtn_delete().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(main.getRentview().getBtn_add())) { //ถ้ากดปุ่มAdd
            int search = Integer.parseInt(main.getRentview().getBookCodeTF().getText());//รับIDที่จะเพิ่มมาจากผู้ใช้
            int days = Integer.parseInt(main.getRentview().getTextDayrentTF().getText());//รับวันที่จะเพิ่มมาจากผู้ใช้
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            if (idcheck.indexOf(search) == -1) {
                for (int i = 0; i < booklist.getBookList().size(); i++) { //ลูปตามจำนวนหนังสือที่มี
                    int id = booklist.getBookList().get(i).getBookID();// ให้รับIDของหนังสือจากdbทุกตัวมาเช็ค
                    if (id == search) {//เช็คว่ามีหนังสือที่จะยืมไหม
                        book = booklist.getBookList().get(i);
                        break;
                    }
                }
            } else {
                main.getRentview().getBookCodeTF().setText("");
                main.getRentview().getTextDayrentTF().setText("");
            }
            //เริ่มลูป

            //จบลูป
            if (!Objects.equals(book.getTitle(), "")) {
                Object[] row = {main.getRentview().getBookCodeTF().getText(), book.getTitle(), main.getRentview().getTextDayrentTF().getText()}; //รับข้อมูลมาใส่ในobject
                main.getRentview().getModel().addRow(row); //นำrowที่รับข้อมูลต่างๆไปใส่ในตาราง
                main.getRentview().getTableOfRentals().getColumn("").setCellRenderer(btn);
                main.getRentview().getTableOfRentals().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
                idcheck.add(search); //เพิ่มไอดีในลิสต์
                daycheck.add(days); //เพิ่มวันในลิสต์
            }
            System.out.println("The id are " + idcheck); //เอาไว้เช็คลิสต์ที่เก็บไอดี
            System.out.println("The day are " + daycheck); //เอาไว้เช็คลิสต์ที่เก็บวัน
        }

        else if (ae.getSource().equals(main.getRentview().getBtn_submit())) {
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม

            for (int j = 0; j < idcheck.size(); j++) {
                for (int i = 0; i < booklist.getBookList().size(); i++) {
                    int id = booklist.getBookList().get(i).getBookID();
                    List<Book> bookList = new LinkedList<>();//เอาไว้เพิ่มลิสต์หนังสือที่จะยืมทั้งหมด
                    if (idcheck.get(j) == id) {
                        book = booklist.getBookList().get(i);
                        book.setDay(daycheck.get(j));
                        book.setStatus(false);
                        bookList.add(book);//เพิ่มหนังสือนั้นเข้าไปในลิสต์
                        book.rentBooks(bookList);
                        break;
                    }
                }
            }
        }

        else if (ae.getSource().equals(button)) {
            int row;
            if (main.getRentview().getTableOfRentals().getSelectedRow() == -1) {
                row = keepRow;
            } else {
                row = main.getRentview().getTableOfRentals().getSelectedRow();
                keepRow = row;
            }
            System.out.println();
            for (Book checkBook : bookDB.getBookList()) {
                System.out.println(main.getRentview().getTableOfRentals().getModel().getValueAt(row, 0));
                if (Integer.parseInt((String) main.getRentview().getTableOfRentals().getModel().getValueAt(row, 0)) == (checkBook.getBookID())) {
                    infoBook.getBookId2().setText(String.valueOf(checkBook.getBookID()));
                    infoBook.getBookNameTF().setText(checkBook.getTitle());
                    infoBook.getCategoryCB().setSelectedItem(checkBook.getCategories());
                    infoBook.getAuthorTF().setText(checkBook.getWriter());
                    infoBook.getPricePerDayTF().setText(String.valueOf(checkBook.getPrice()));
                }
            }
            infoBook.getFrame().setVisible(true);
        }

        else if (ae.getSource().equals(main.getRentview().getBtn_delete())) {
            int index = (main.getRentview().getTableOfRentals().getSelectedRow());
            idcheck.remove(index);
            daycheck.remove(index);
            /*for (int i : idcheck){
                System.out.println(i);
            }*/
            main.getRentview().getModel().setRowCount(0);
            for (int i = 0; i < idcheck.size(); i++) {
                for (Book checkbook : bookDB.getBookList()) {
                    if (idcheck.get(i) == checkbook.getBookID()) {
                        Object[] row = {idcheck.get(i), checkbook.getTitle(), daycheck.get(i)}; //รับข้อมูลมาใส่ในobject
                        main.getRentview().getModel().addRow(row); //นำrowที่รับข้อมูลต่างๆไปใส่ในตาราง
                        main.getRentview().getTableOfRentals().getColumn("").setCellRenderer(btn);
                        main.getRentview().getTableOfRentals().getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
                    }
                }
            }
        }

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            //ปรับสีปุ่มในตาราง
            setOpaque(true);
            setBackground(new Color(69, 69, 69));
            setForeground(Color.white);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "More Detail.." : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
            label = (value == null) ? "More Detail.." : value.toString();
            button.setText(label);
            return button;
        }
        public Object getCellEditorValue() {
            return new String(label);
        }
    }
}



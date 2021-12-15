import model.Book;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;


public class RentController implements ActionListener{
    private int test = 1;
    private MDI main;
    private Book books;
    public static LinkedList bookList;
    List<Integer> idcheck = new LinkedList();
    List<Integer> daycheck = new LinkedList();
    //ปุ่มในตาราง
    private ButtonRenderer btn;
    private JButton button;
    public RentController() {
        main = new MDI();
        btn = new ButtonRenderer();
        button = new JButton();
        btn.setFont(main.titleFont);
        main.getRentview().getBtn_add().addActionListener(this);
        main.getRentview().getBtn_submit().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(main.getRentview().getBtn_add())){ //ถ้ากดปุ่มAdd
            int search = Integer.parseInt(main.getRentview().getBookCodeTF().getText());//รับIDที่จะเพิ่มมาจากผู้ใช้
            int days = Integer.parseInt(main.getRentview().getTextDayrentTF().getText());//รับวันที่จะเพิ่มมาจากผู้ใช้
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            //เริ่มลูป
            for (int i = 0 ; i< booklist.getBookList().size() ; i++){
                int id = booklist.getBookList().get(i).getBookID();//เปลี่ยน0เป็นiให้รับIDของหนังสือจากdbทุกตัวมาเช็ค
                if(id == search){//เช็คว่ามีหนังสือที่จะยืมไหม
                    book = booklist.getBookList().get(i);
                    break;
                }
            }
            //จบลูป
            if(!Objects.equals(book.getTitle(),"")){
                Object[] row = {main.getRentview().getBookCodeTF().getText(),book.getTitle(),main.getRentview().getTextDayrentTF().getText()};
                main.getRentview().getModel().addRow(row);
                idcheck.add(search);
                daycheck.add(days);
            }
                System.out.println("The id are " + idcheck);
                System.out.println("The day are " + daycheck);
            }


        else if(ae.getSource().equals(main.getRentview().getBtn_submit())){ //ถ้ากดปุ่มSubmit
            Book booklist = new Book();//รับลิสต์หนังสือมาจากdb
            Book book = new Book();//เอาไว้สำหรับรับหนังสือจะยืม
            for(int j = 0 ; j < idcheck.size(); j++) {
                for (int i = 0; i < booklist.getBookList().size(); i++) {
                    int id = booklist.getBookList().get(i).getBookID();
                    List<Book> bookList = new LinkedList<>();
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
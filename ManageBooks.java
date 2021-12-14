
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ManageBooks extends JInternalFrame {

    //ประกาศ Table แสดงข้อมูล
    private DefaultTableModel model;
    private JTable tableOfInfoBooks;
    private JScrollPane scroll;
    private JButton addBooks, button, returnBook, search;
    private JPanel pHeading, pAddBook, pReturnBook, pAddBookAndReturnBook, pSearch, pHeadingAndSearch;
    private JLabel heading, bookCode;
    private JTextField bookCodeTF, searchTF;
    private JComboBox searchCB;

    //main Desktop
    private MDI frame;

    public ManageBooks(boolean resizable, boolean closable, boolean maximizable, boolean iconificable, MDI frame) {
        super("Manage Books", resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }

    public void init() {
        //หัวข้อการจัดการหนังสือ
        heading = new JLabel("การจัดการหนังสือ");
        heading.setFont(new Font("Angsana new", Font.BOLD, 56));
        pHeading = new JPanel();
        pHeading.add(heading);

        //ตารางแสดงข้อมูลหนังสือ
        model = new DefaultTableModel();
        tableOfInfoBooks = new JTable();
        scroll = new JScrollPane(tableOfInfoBooks);
        model.addColumn("รหัสหนังสือ");
        model.addColumn("หมวดหมู่");
        model.addColumn("ชื่อหนังสือ");
        model.addColumn("");
        tableOfInfoBooks.setModel(model);
        //ปุ่มในตาราง
        button = new JButton();
        //set ความสูง
        tableOfInfoBooks.setRowHeight(100);
        //set font
        tableOfInfoBooks.getTableHeader().setFont(frame.headFont.deriveFont(30f));
        tableOfInfoBooks.getTableHeader().setOpaque(false);
        tableOfInfoBooks.setFont(frame.titleFont);
        //text อยู่ตรงกลาง ในตาราง
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableOfInfoBooks.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableOfInfoBooks.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableOfInfoBooks.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        //คืนหนังสือ
        pReturnBook = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        bookCode = new JLabel("รหัสหนังสือ");
        bookCode.setFont(frame.titleFont);
        bookCodeTF = new JTextField(15);
        bookCodeTF.setFont(frame.titleFont);
        returnBook = new JButton("คืนหนังสือ");
        returnBook.setFont(frame.titleFont);
        pReturnBook.add(bookCode);
        pReturnBook.add(bookCodeTF);
        pReturnBook.add(returnBook);

        //เพิ่มหนังสือ
        pAddBook = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        addBooks = new JButton("เพิ่มหนังสือ");
        pAddBook.add(addBooks);
        addBooks.setFont(frame.titleFont);

        //นำเพิ่มกับคืนรวมกัน
        pAddBookAndReturnBook = new JPanel(new GridLayout(1, 2));
        pAddBookAndReturnBook.add(pReturnBook);
        pAddBookAndReturnBook.add(pAddBook);

        //ค้นหาหนังสือ
        pSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchCB = new JComboBox();
        searchCB.addItem("รหัสหนังสือ");
        searchCB.addItem("ชื่อหนังสือ");
        searchCB.setFont(frame.titleFont);
        searchTF = new JTextField(15);
        searchTF.setFont(frame.titleFont);
        ImageIcon searchIcon = new ImageIcon(this.getClass().getResource("/search.png"));
        Image img = searchIcon.getImage();
        Image newimg = img.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        searchIcon = new ImageIcon(newimg);

        search = new JButton(searchIcon);
        pSearch.add(searchCB);
        pSearch.add(searchTF);
        pSearch.add(search);

        //หัวข้อกับค้นหารวมกัน
        pHeadingAndSearch = new JPanel(new GridLayout(2, 1));
        pHeadingAndSearch.add(pHeading);
        pHeadingAndSearch.add(pSearch);

        //ลบ Title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        frame.setTitle("Manage Books");
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pHeadingAndSearch, BorderLayout.NORTH);
        this.getContentPane().add(scroll);
        this.getContentPane().add(pAddBookAndReturnBook, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);

    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getTableOfInfoBooks() {
        return tableOfInfoBooks;
    }

    public void setTableOfInfoBooks(JTable tableOfInfoBooks) {
        this.tableOfInfoBooks = tableOfInfoBooks;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getAddBooks() {
        return addBooks;
    }

    public void setAddBooks(JButton addBooks) {
        this.addBooks = addBooks;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JButton getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(JButton returnBook) {
        this.returnBook = returnBook;
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public JPanel getpHeading() {
        return pHeading;
    }

    public void setpHeading(JPanel pHeading) {
        this.pHeading = pHeading;
    }

    public JPanel getpAddBook() {
        return pAddBook;
    }

    public void setpAddBook(JPanel pAddBook) {
        this.pAddBook = pAddBook;
    }

    public JPanel getpReturnBook() {
        return pReturnBook;
    }

    public void setpReturnBook(JPanel pReturnBook) {
        this.pReturnBook = pReturnBook;
    }

    public JPanel getpAddBookAndReturnBook() {
        return pAddBookAndReturnBook;
    }

    public void setpAddBookAndReturnBook(JPanel pAddBookAndReturnBook) {
        this.pAddBookAndReturnBook = pAddBookAndReturnBook;
    }

    public JPanel getpSearch() {
        return pSearch;
    }

    public void setpSearch(JPanel pSearch) {
        this.pSearch = pSearch;
    }

    public JPanel getpHeadingAndSearch() {
        return pHeadingAndSearch;
    }

    public void setpHeadingAndSearch(JPanel pHeadingAndSearch) {
        this.pHeadingAndSearch = pHeadingAndSearch;
    }

    public JLabel getHeading() {
        return heading;
    }

    public void setHeading(JLabel heading) {
        this.heading = heading;
    }

    public JLabel getBookCode() {
        return bookCode;
    }

    public void setBookCode(JLabel bookCode) {
        this.bookCode = bookCode;
    }

    public JTextField getBookCodeTF() {
        return bookCodeTF;
    }

    public void setBookCodeTF(JTextField bookCodeTF) {
        this.bookCodeTF = bookCodeTF;
    }

    public JTextField getSearchTF() {
        return searchTF;
    }

    public void setSearchTF(JTextField searchTF) {
        this.searchTF = searchTF;
    }

    public JComboBox getSearchCB() {
        return searchCB;
    }

    public void setSearchCB(JComboBox searchCB) {
        this.searchCB = searchCB;
    }

    public MDI getFrame() {
        return frame;
    }

    public void setFrame(MDI frame) {
        this.frame = frame;
    }

    private static class HeaderRenderer implements TableCellRenderer {

        DefaultTableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }
}

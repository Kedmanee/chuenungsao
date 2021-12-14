import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RentView extends JInternalFrame {
    //ประกาศตัวแปรหน้าหลัก เอาไว้เก็บหน้าหลักเพื่อเรียกใช้ getter setter
    private MDI frame;
    private JTable table;
    DefaultTableModel model;
    private JPanel panel, pn_input, pn_ctrl, pn_submit;
    private JLabel lb1, lb2;
    private JTextField textId, textDayrent;
    private JButton btnAdd, btnDelete, btnDetail, btnSubmit;

    
    //สร้าง contructor ที่รับหน้าหลักมาด้วยเพื่อเก็บไว้ในตัวแปรด้านบน
    public RentView(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconificable, MDIExample frame) {
        super(title, resizable, closable, maximizable, iconificable);
        this.frame = frame;
        //เรียกฟังก์ชัน init
        this.init();
    }

    
    public void init() {
        table = new JTable();
        model = (DefaultTableModel) table.getModel();
        model.addColumn("รหัสหนังสือ");
        model.addColumn("ชื่อหนังสือ");
        panel = new JPanel();
        pn_input = new JPanel();
        pn_ctrl = new JPanel();
        pn_submit = new JPanel();
        lb1 = new JLabel("รหัสหนังสือ");
        lb2 = new JLabel("จำนวนวัน");
        textId = new JTextField(5);
        textDayrent = new JTextField(5);
        btnAdd = new JButton("เพิ่ม");
        btnDelete = new JButton("ลบ");
        btnDetail = new JButton("รายละเอียดหนังสือ");
        btnSubmit = new JButton("ยืนยัน");

        
        table.setModel(model);
        table.setRowHeight(30);
        table.setFont(new Font("Angsana new", Font.BOLD, 20));
        table.getTableHeader().setFont(new Font("Angsana new", Font.BOLD, 20));
        lb1.setFont(new Font("Angsana new", Font.BOLD, 20));
        lb2.setFont(new Font("Angsana new", Font.BOLD, 20));
        btnAdd.setFont(new Font("Angsana new", Font.BOLD, 20));
        btnDelete.setFont(new Font("Angsana new", Font.BOLD, 20));
        btnDetail.setFont(new Font("Angsana new", Font.BOLD, 20));
        btnSubmit.setFont(new Font("Angsana new", Font.BOLD, 20));

        
        pn_input.setLayout(new FlowLayout());
        pn_input.add(lb1);
        pn_input.add(textId);
        pn_input.add(lb2);
        pn_input.add(textDayrent);
        pn_input.add(btnAdd);
        pn_ctrl.setLayout(new FlowLayout());
        pn_ctrl.add(btnDelete);
        pn_ctrl.add(btnDetail);
        pn_submit.setLayout(new FlowLayout());
        pn_submit.add(btnSubmit);
        panel.setLayout(new GridLayout(3, 1));
        panel.add(pn_input);
        panel.add(pn_ctrl);
        panel.add(pn_submit);

        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);
        JScrollPane pane = new JScrollPane(table);
        this.add(pane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.setVisible(true);
    }
    
    
    public MDI getFrame() {
        return frame;
    }

    public void setFrame(MDI frame) {
        this.frame = frame;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPn_input() {
        return pn_input;
    }

    public void setPn_input(JPanel pn_input) {
        this.pn_input = pn_input;
    }

    public JPanel getPn_ctrl() {
        return pn_ctrl;
    }

    public void setPn_ctrl(JPanel pn_ctrl) {
        this.pn_ctrl = pn_ctrl;
    }

    public JPanel getPn_submit() {
        return pn_submit;
    }

    public void setPn_submit(JPanel pn_submit) {
        this.pn_submit = pn_submit;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }

    public JTextField getTextId() {
        return textId;
    }

    public void setTextId(JTextField textId) {
        this.textId = textId;
    }

    public JTextField getTextDayrent() {
        return textDayrent;
    }

    public void setTextDayrent(JTextField textDayrent) {
        this.textDayrent = textDayrent;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnDetail() {
        return btnDetail;
    }

    public void setBtnDetail(JButton btnDetail) {
        this.btnDetail = btnDetail;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }
}

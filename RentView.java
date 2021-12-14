import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RentView extends JInternalFrame {
    //ประกาศตัวแปรหน้าหลัก เอาไว้เก็บหน้าหลักเพื่อเรียกใช้ getter setter
    private MDIExample frame;
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
}

//SecondWindow ทำแบบเดียวกับ FirstWindow

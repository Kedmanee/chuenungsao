import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Book;
import model.Member;

public class NonMem extends JInternalFrame implements ActionListener{
    private JPanel p_header, p_fname,p_lname, p_address, p_contract, p_buttons, p_cardid;
    private JLabel header, fname_header, lname_header, address_header, contract_header, cardid_header;
    private JTextField fname,lname, cardid;
    private JScrollPane sp_address, sp_contract;
    private JTextArea address, contract;
    private JButton back, next;
    private Pay_MDI frame;
    private Font f1 = new Font("Arial Rounded MT Bold", Font.BOLD, 15);
    Book book = new Book();
    Member member = new Member();
    
    public NonMem(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconificable, Pay_MDI frame){
        super(title, resizable, closable, maximizable, iconificable);
        this.frame = frame;
        this.init();
    }
    public void init(){
        this.setLayout(new GridLayout(7,1));
        
        p_header = new JPanel();
        p_fname = new JPanel();
        p_lname = new JPanel();
        p_address = new JPanel();
        p_contract = new JPanel();
        p_buttons = new JPanel();
        p_cardid = new JPanel();
        
        p_fname.setLayout(new FlowLayout());
        p_lname.setLayout(new FlowLayout());
        p_address.setLayout(new FlowLayout());
        p_contract.setLayout(new FlowLayout());
        p_buttons.setLayout(new FlowLayout());
        
        //header
        header = new JLabel("Insert Your Name/Address/Contract");
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));

        p_header.add(header);
        p_header.setBackground(new Color(69,68,68));
        header.setForeground(Color.WHITE);
        
        //ชื่อ/นามสกุล
        fname_header = new JLabel("First Name: "); fname = new JTextField(15); lname_header = new JLabel("Last Name: "); lname = new JTextField(15);
        p_fname.add(fname_header); p_fname.add(fname); p_lname.add(lname_header); p_lname.add(lname);
        fname_header.setFont(f1); fname.setFont(f1); lname_header.setFont(f1); lname.setFont(f1);

        fname_header.setForeground(Color.WHITE);
        lname_header.setForeground(Color.WHITE);
        p_fname.setBackground(new Color(69,68,68));
        p_lname.setBackground(new Color(69,68,68));
        
        //บัตรประชาชน
        cardid_header = new JLabel("National ID: "); cardid = new JTextField(15);
        p_cardid.add(cardid_header); p_cardid.add(cardid);
        cardid_header.setFont(f1); cardid.setFont(f1);

        cardid_header.setForeground(Color.WHITE);
        p_cardid.setBackground(new Color(69,68,68));
        
        //ที่อยู่
        address_header = new JLabel("Address: "); address = new JTextArea(2,10);
        sp_address = new JScrollPane(address, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p_address.add(address_header); p_address.add(sp_address);
        address_header.setFont(f1); sp_address.setFont(f1);

        address_header.setForeground(Color.WHITE);
        p_address.setBackground(new Color(69,68,68));

        //ติดต่อ
        contract_header = new JLabel("Contract: "); contract = new JTextArea(2,10);
        sp_contract = new JScrollPane(contract, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p_contract.add(contract_header); p_contract.add(sp_contract);
        contract_header.setFont(f1); sp_contract.setFont(f1);

        contract_header.setForeground(Color.WHITE);
        p_contract.setBackground(new Color(69,68,68));

        //ปุ่ม
        back = new JButton("Back"); next = new JButton("Next");
        p_buttons.add(back); p_buttons.add(next);
        back.setFont(f1); next.setFont(f1);
        back.addActionListener(this);
        next.addActionListener(this);

        p_buttons.setBackground(new Color(69,68,68));
        back.setBackground(new Color(250,0,100));
        back.setForeground(Color.WHITE);
        next.setBackground(new Color(250,0,100));
        next.setForeground(Color.WHITE);
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        this.add(p_header);
        this.add(p_fname);
        this.add(p_lname);
        this.add(p_cardid);
        this.add(p_address);
        this.add(p_contract);
        this.add(p_buttons);
        this.setSize(400,350);
        this.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        int index = 0;
        double totalprice = book.getBookList().get(index).getPrice() * book.getBookList().get(index).getDay();
        if(ae.getSource().equals(next)){
           //เช็ค ข้อมูล ถ้าถูกต้อง Alert ขึ้น แล้วกลับหน้าเช่าหนังสือ
           if(fname.getText().equals("") || lname.getText().equals("") || address.getText().equals("") || contract.getText().equals("")){
                JOptionPane.showMessageDialog(frame, "Please Insert Name or Address or Contract.");
           }
           
           else{
                JOptionPane.showMessageDialog(frame, book.getBookList().get(index).getTitle()+ " Rented\nTotal Price: "+ totalprice);
                //member.getMemberList().add(); เพิ่ม Member เข้าไปใน Collection
           }
        }
        if(ae.getSource().equals(back)){
            this.frame.getPrice_pre().setVisible(true);
            this.frame.getNonmem().setVisible(false);
        }
    }
}

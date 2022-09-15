import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.it.DAO.studentDAO;
public class Main extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public Main() {
        setResizable(false);
        setTitle("学生管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 814, 448);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("学生管理");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
        lblNewLabel.setBounds(296, 10, 214, 50);
        contentPane.add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("学生姓名：");
        lblNewLabel_1.setBounds(10, 65, 76, 15);
        contentPane.add(lblNewLabel_1);
        textField = new JTextField();
        textField.setBounds(73, 62, 231, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        JButton btnNewButton = new JButton("查询");
        btnNewButton.setBounds(335, 61, 93, 23);
        contentPane.add(btnNewButton);
        JButton btnNewButton_1 = new JButton("添加学生");
        btnNewButton_1.setBounds(437, 61, 93, 23);
        contentPane.add(btnNewButton_1);
        JButton btnNewButton_1_1 = new JButton("修改学生");
        btnNewButton_1_1.setBounds(540, 61, 93, 23);
        contentPane.add(btnNewButton_1_1);
        JButton btnNewButton_1_1_1 = new JButton("删除学生");
        btnNewButton_1_1_1.setBounds(639, 61, 93, 23);
        contentPane.add(btnNewButton_1_1_1);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 106, 778, 293);
        contentPane.add(scrollPane);
        //表格
        //1、获取数据回来
        studentDAO s = new studentDAO();
        Vector<Vector<String>> list = s.getAll(null);
        //2、设置表头
        Vector<String> head = new Vector<String>();
        head.add("序号");
        head.add("姓名");
        head.add("年龄");
        head.add("性别");
        head.add("身高");
        head.add("班级ID");
        head.add("创建时间");
        //3、设置值
        table = new JTable(list,head);
        scrollPane.setViewportView(table);
    }
}
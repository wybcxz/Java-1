package xiugai1;

import com.it.DAO.studentDAO;
import com.it.model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Sun Sep 04 23:29:51 CST 2022
 */


/**
 * @author 1
 */
public class UpdatePage extends JFrame {
    public UpdatePage(String val) {

    }
    public UpdatePage(int id){
        initComponents(id);
    }

    public static void main(String[] args) {
//        new xiugai().setVisible(true);
        UpdatePage xiugai = new UpdatePage(5);
        xiugai.setVisible(true);
    }


    private void initComponents(int id) {
        studentDAO s = new studentDAO();
        Student stu = s.query(id);


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("nn");
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        btn_ok = new JButton();
        btn_no = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField_name = new JTextField(stu.getName());

        textField_age = new JTextField(String.valueOf(stu.getAge()));
        textField_sex = new JTextField(String.valueOf(stu.getGender()));
        textField_genal = new JTextField(String.valueOf(stu.getHeight()));
        textField_id = new JTextField(String.valueOf(stu.getClassID()));

        //======== this ========
        setTitle("修改学生");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(null);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(null);

                //---- btn_ok ----
                btn_ok.setText("修改学生");
                btn_ok.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //组装对象
                        Student stu = new Student();


                        //判断输入是否为null
                        if (textField_name.getText().toString().trim().equals("") ||
                                textField_age.getText().toString().trim().equals("") ||
                                textField_id.getText().toString().trim().equals("") ||
                                textField_genal.getText().toString().trim().equals("") ||
                                textField_sex.getText().toString().trim().equals("") ){
                            JOptionPane.showMessageDialog(null,"请输入信息！");
                            return;
                        }else


//                        System.out.println(textField_name.getText());


                        //获取修改人id
                        stu.setStuid(id);
                        stu.setName(textField_name.getText());
                        stu.setAge(Integer.parseInt(textField_age.getText()));
                        stu.setGender(textField_sex.getText());
                        stu.setHeight(Double.parseDouble(textField_genal.getText()));
                        stu.setClassID(Integer.parseInt(textField_id.getText()));
                        studentDAO s = new studentDAO();

                        if (s.update(stu)){
                            JOptionPane.showMessageDialog(null,"修改成功！");
                            dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"修改失败！");
                        }



                    }
                });
                buttonBar.add(btn_ok);
                btn_ok.setBounds(60, 10, 105, btn_ok.getPreferredSize().height);

                //---- btn_no ----
                btn_no.setText("关闭");
                btn_no.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //关闭界面
                        dispose();
                    }
                });
                buttonBar.add(btn_no);
                btn_no.setBounds(270, 10, 100, btn_no.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < buttonBar.getComponentCount(); i++) {
                        Rectangle bounds = buttonBar.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = buttonBar.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    buttonBar.setMinimumSize(preferredSize);
                    buttonBar.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(buttonBar);
            buttonBar.setBounds(12, 265, 434, 49);

            //---- label1 ----
            label1.setText("修改学生");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            dialogPane.add(label1);
            label1.setBounds(185, 20, 95, 35);

            //---- label2 ----
            label2.setText("学生姓名：");
            dialogPane.add(label2);
            label2.setBounds(145, 85, 75, label2.getPreferredSize().height);

            //---- label3 ----
            label3.setText("学生年龄：");
            dialogPane.add(label3);
            label3.setBounds(145, 115, 75, 15);

            //---- label4 ----
            label4.setText("学生性别：");
            dialogPane.add(label4);
            label4.setBounds(145, 145, 75, 15);

            //---- label5 ----
            label5.setText("学生身高：");
            dialogPane.add(label5);
            label5.setBounds(145, 175, 75, 15);

            //---- label6 ----
            label6.setText("班级 ID：");
            dialogPane.add(label6);
            label6.setBounds(155, 205, 75, 15);
            dialogPane.add(textField_name);
            textField_name.setBounds(220, 85, 105, textField_name.getPreferredSize().height);
            dialogPane.add(textField_age);
            textField_age.setBounds(220, 115, 105, 21);
            dialogPane.add(textField_sex);
            textField_sex.setBounds(220, 145, 105, 21);
            dialogPane.add(textField_genal);
            textField_genal.setBounds(220, 175, 105, 21);
            dialogPane.add(textField_id);
            textField_id.setBounds(220, 205, 105, 21);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane);
        dialogPane.setBounds(0, 0, 458, 348);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton btn_ok;
    private JButton btn_no;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField_name;
    private JTextField textField_age;
    private JTextField textField_sex;
    private JTextField textField_genal;
    private JTextField textField_id;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

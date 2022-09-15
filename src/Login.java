import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.it.DAO.loginDAO;
import com.it.model.Account;
/*
 * Created by JFormDesigner on Sat Sep 14 23:23:35 CST 2022
 */



/**
 * @author thorn
 * 用户登录界面
 * 验证查询
 *
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    //登录按钮的实现
    private void dengluActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("nn");
        dialogPane = new JPanel();
        panel1 = new JPanel();
        label_1 = new JLabel();
        label_2 = new JLabel();
        label_3 = new JLabel();
        textField_username = new JTextField();
        pwd = new JPasswordField();
        buttonBar = new JPanel();
        JButton_login = new JButton();
        JButton_rges = new JButton();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //---- label_1 ----
                label_1.setText("用户登录");
                label_1.setHorizontalAlignment(SwingConstants.CENTER);
                label_1.setFont(label_1.getFont().deriveFont(label_1.getFont().getStyle() | Font.BOLD, label_1.getFont().getSize() + 7f));
                panel1.add(label_1);
                label_1.setBounds(new Rectangle(new Point(155, 25), label_1.getPreferredSize()));

                //---- label_2 ----
                label_2.setText("用户名：");
                panel1.add(label_2);
                label_2.setBounds(new Rectangle(new Point(115, 85), label_2.getPreferredSize()));

                //---- label_3 ----
                label_3.setText("密码：");
                panel1.add(label_3);
                label_3.setBounds(125, 120, 48, 15);
                panel1.add(textField_username);
                textField_username.setBounds(175, 85, 105, textField_username.getPreferredSize().height);
                panel1.add(pwd);
                pwd.setBounds(175, 115, 105, pwd.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(panel1);
            panel1.setBounds(0, 0, 396, 173);

            //======== buttonBar ========
            {
                buttonBar.setLayout(null);

                //---- JButton_login ----
                JButton_login.setText("登录");
                JButton_login.addActionListener(e -> dengluActionPerformed(e));
                buttonBar.add(JButton_login);
                JButton_login.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        loginDAO loginDAO = new loginDAO();
                        String admin = textField_username.getText();
                        String password = pwd.getText();
                        Account account = new Account();
                        account.setAdmin(admin);
                        account.setPwd(password);
                        //第二种方法
                        if (loginDAO.account(account)){
                        //if (loginDAO.account(admin,password)){
                            dispose();
                            JOptionPane.showMessageDialog(null,"登陆成攻！");
                            new MainPage().setVisible(true);
                        }else {
                            JOptionPane.showMessageDialog(null,"登陆失败!请重新输入！");
                        }

                    }



                });
                JButton_login.setBounds(new Rectangle(new Point(90, 5), JButton_login.getPreferredSize()));

                //---- JButton_rges ----
                JButton_rges.setText("重置");
                buttonBar.add(JButton_rges);
                JButton_rges.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        textField_username.setText("");
                        pwd.setText("");
                    }
                });
                JButton_rges.setBounds(new Rectangle(new Point(250, 5), JButton_rges.getPreferredSize()));

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
            buttonBar.setBounds(0, 173, 396, 52);

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
        dialogPane.setBounds(0, 0, 397, 207);
        contentPane.add(label5);
        label5.setBounds(105, 235, 215, label5.getPreferredSize().height);

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

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel panel1;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextField textField_username;
    private JPasswordField pwd;
    private JPanel buttonBar;
    private JButton JButton_login;
    private JButton JButton_rges;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

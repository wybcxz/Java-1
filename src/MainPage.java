import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.it.DAO.studentDAO;
import xiugai1.UpdatePage;
/*
 * Created by JFormDesigner on Sat Sep 03 22:15:15 CST 2022
 */



/**
 * @author 1
 */
public class MainPage extends JFrame {
    public MainPage() {
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        System.out.println("hhh");
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("nn");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table_biao = new JTable();
        label1 = new JLabel();
        sousuo = new JTextField();
        btn_select = new JButton();
        btn_insert = new JButton();
        btn_update = new JButton();
        btn_delte = new JButton();

        //======== this ========
        setTitle("\u5b66\u6821\u767b\u9646\u7cfb\u7edf");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //======== panel1 ========
                {
                    panel1.setLayout(null);

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
                contentPanel.add(panel1);
                panel1.setBounds(0, 0, 567, panel1.getPreferredSize().height);

                //======== scrollPane1 ========
                {

                    //---- table_biao ----
                    studentDAO s = new studentDAO();
                    Vector<Vector<String>> list = s.getAll(null);
                    //2???????????????
                    updateall(null);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(15, 70, 665, 250);

                //---- label1 ----
                label1.setText(bundle.getString("MainPage.label1.text"));
                contentPanel.add(label1);
                label1.setBounds(30, 25, label1.getPreferredSize().width, 20);
                contentPanel.add(sousuo);
                sousuo.setBounds(100, 25, 120, sousuo.getPreferredSize().height);



                //---- btn_select ----
                //?????? -- ????????????
                btn_select.setText("??????");
                btn_select.setFont(btn_select.getFont().deriveFont(btn_select.getFont().getSize() - 2f));
                btn_select.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //??????????????????
                            String keyword = sousuo.getText();
                            updateall(keyword);


                    }
                });
                contentPanel.add(btn_select);
                btn_select.setBounds(290, 20, 85, 25);

                //---- btn_insert ----
                btn_insert.setText("????????????");
                btn_insert.setFont(btn_insert.getFont().deriveFont(btn_insert.getFont().getSize() - 2f));
                btn_insert.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new InsertPage().setVisible(true);
                    }
                });

                contentPanel.add(btn_insert);
                btn_insert.setBounds(385, 20, 85, 25);

                //---- btn_update ----
                btn_update.setText("????????????");
                btn_update.setFont(btn_update.getFont().deriveFont(btn_update.getFont().getSize() - 2f));
                btn_update.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rows = table_biao.getSelectedRow();
                        if (rows == -1){
                            JOptionPane.showMessageDialog(null,"???????????????");
                            return;
                        }
                        //?????????????????????????????????
                        int val = Integer.valueOf((String) table_biao.getValueAt(rows, 0));
                        System.out.println(val);
                        new UpdatePage(val).setVisible(true);
                    }
                });

                contentPanel.add(btn_update);
                btn_update.setBounds(480, 20, 85, 25);

                //---- btn_delte ----
                //?????? -- ??????????????????
                btn_delte.setText("????????????");
                btn_delte.setFont(btn_delte.getFont().deriveFont(btn_delte.getFont().getSize() - 2f));
                btn_delte.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rows = table_biao.getSelectedRow();
                        if (rows == -1){
                            JOptionPane.showMessageDialog(null,"???????????????");
                            return;
                        }
                        //?????????????????????????????????
                        String val = (String)table_biao.getValueAt(rows, 0);

                        studentDAO s = new studentDAO();
                        boolean result = s.delete(val);
                        if (result){
                            JOptionPane.showMessageDialog(null,"???????????????");
                            updateall(null);
                        }else {
                            JOptionPane.showMessageDialog(null,"???????????????");
                        }
                    }
                });
                contentPanel.add(btn_delte);
                btn_delte.setBounds(575, 20, 85, 25);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel);
            contentPanel.setBounds(5, 10, 725, 320);

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
        dialogPane.setBounds(0, 0, 710, 395);

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

    //????????????
    private void updateall(String keyword) {
        studentDAO s = new studentDAO();
        Vector<Vector<String>> list = s.getAll(keyword);
        Vector<String> head = new Vector<String>();
        head.add("??????");
        head.add("??????");
        head.add("??????");
        head.add("??????");
        head.add("??????");
        head.add("??????ID");
        head.add("????????????");
        //3????????????
        table_biao = new JTable(list,head);
        scrollPane1.setViewportView(table_biao);






    }

    public static void main(String[] args) {
        new MainPage().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table_biao;
    private JLabel label1;
    private JTextField sousuo;
    private JButton btn_select;
    private JButton btn_insert;
    private JButton btn_update;
    private JButton btn_delte;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

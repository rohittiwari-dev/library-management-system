

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Return_book extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String edition,course;
    int quan,fine;
    DefaultTableModel model;

    /**
     * Creates new form Return_book
     */
    public Return_book() {
        initComponents();
        conn=connectiondb.db();
        fetch_issue();
        jTable1.getTableHeader().setFont(new Font("Verdana",Font.PLAIN,15));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(255,207,191));
        jTable1.getTableHeader().setForeground(new Color(220,88,22));
        super.setTitle("Library Management System-Return Book");
        ImageIcon im =new ImageIcon("Assets//icon.png");
        super.setIconImage(im.getImage());
    }

    public void fetch_issue()
    {
        try {
            String ur="Select bookid,bookname,edition,studntid,sname,course,issuedate,returndate from issue_book ";
            ps=conn.prepareStatement(ur);
            rs=ps.executeQuery();
            model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
            }
        } catch (Exception e) {
        }
        finally
        {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void searchdet(String ref,String re1)
    {
        try {
            String s="Select edition,quantity from add_book where bookid=?";
            ps=conn.prepareStatement(s);
            ps.setString(1, ref);
            rs=ps.executeQuery();
            rs.next();
            edition=rs.getString(1);
            quan=Integer.parseInt(rs.getString(2))+1;
        } catch (Exception e) {
        }
        finally
        {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        try {
            String s="Select course from add_student where studentid=?";
            ps=conn.prepareStatement(s);
            ps.setString(1, re1);
            rs=ps.executeQuery();
            rs.next();
            course=rs.getString(1);
        } catch (Exception e) {
        }
        finally
        {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
    }
    public void return_book(String ref)
    {
        try {
            String s="UPDATE add_book SET quantity="+quan+" where bookid=?";
            ps=conn.prepareStatement(s);
            ps.setString(1, ref);
            ps.executeUpdate();
            quan=0;
        } catch (Exception e) {
        }
        finally
        {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
    }
    public void Remmoveissue(String ref,String reg)
    {
        try {
            String s="delete from issue_book where bookid=? and studntid=?";
            ps=conn.prepareStatement(s);
            ps.setString(1, ref);
            ps.setString(2, reg);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        finally
        {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
    }
    public void comparedate(String d1,String d2) 
    {
        SimpleDateFormat ds=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1,dt2;
        try {
            dt1 = ds.parse(d1);
            dt2=ds.parse(d2);
            if(dt1.compareTo(dt2)<0)
            {
                int i=JOptionPane.showConfirmDialog(rootPane, "The Student is Late to Submit the Book on Time,\nDo you want to fine Him","Fine Confirmation",JOptionPane.YES_NO_OPTION);
                if(i==0)
                {
                    String jp= JOptionPane.showInputDialog(rootPane, "Enter Fine Charged on bieng late to Submit this Book","Fine The Student",JOptionPane.OK_OPTION);
                    if(jp!=null)
                        fine=Integer.parseInt(jp);
                    else
                        fine=0;
                }
            }
            else 
                fine=0;
        } catch (ParseException ex) {
        }   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 0, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Search Type", "Book Id", "Student Id" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 133, 260, 35));

        jDateChooser2.setDate(new Date());
        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.setEnabled(false);
        jDateChooser2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jDateChooser2.setOpaque(false);
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 525, 300, 35));

        jRadioButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(102, 0, 102));
        jRadioButton1.setText("Enable Date Field");
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 102, 102));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setAutoscrolls(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 370, 305, 30));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 102, 102));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setAutoscrolls(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 418, 305, 30));

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 102, 102));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setAutoscrolls(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jTextField6.setSelectionColor(new java.awt.Color(200, 96, 253));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 468, 305, 30));

        jTextField7.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 102, 102));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setAutoscrolls(false);
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 134, 398, 32));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 102, 102));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 300, 32));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 102, 102));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 418, 300, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 102, 102));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setAutoscrolls(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 465, 300, 30));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/SEO-icon-1.png"))); // NOI18N
        jButton3.setText("Search Book");
        jButton3.setFocusPainted(false);
        jButton3.setIconTextGap(5);
        jButton3.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 133, 150, 35));

        jTable1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Edition", "Student Id", "Student Name", "Course", "Issue Date", "Return Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(25);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 180, 1080, 160));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/return-book.png"))); // NOI18N
        jButton1.setText("Return Book");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 210, 40));

        jButton7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/grid_update.png"))); // NOI18N
        jButton7.setText("Refresh Table");
        jButton7.setFocusPainted(false);
        jButton7.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, 180, 40));

        jButton6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-trash-48.png"))); // NOI18N
        jButton6.setText("Clear");
        jButton6.setFocusPainted(false);
        jButton6.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/return_book.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected())
        {
            jDateChooser2.setEnabled(true);
        }
        else jDateChooser2.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jComboBox1.getSelectedItem()=="Select Search Type")
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Search Type");
        }
        else if(jTextField7.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Search Field");
        }
        else
        {   
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            String select;
            if(jComboBox1.getSelectedItem()=="Book Id")
                select="bookid";
            else
                select="studntid";
            String url="Select bookid,bookname,edition,studntid,sname,course,issuedate,returndate from issue_book where "+select+"=?";
            int flag=0;
            try {
                ps=conn.prepareStatement(url);
                ps.setString(1, jTextField7.getText());
                rs=ps.executeQuery();
                model=(DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                while(rs.next())
                {
                    flag=1;
                    model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
                }
                if(flag!=1)
                {
                    JOptionPane.showMessageDialog(rootPane, "No Book Issued to This Id");
                }
            } catch (Exception e) {
            }
            finally
            {
                try {
                    rs.close();
                    ps.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText().equals("")||jTextField2.getText().equals("")||jTextField3.getText().equals("")||jTextField4.getText().equals("")||jTextField5.getText().equals("")||jTextField6.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Fill The Empty Fields");
        }
        else
        {
            try {
                String url="insert into return_book (bookid,bookname,edition,studntid,sname,course,issuedate,returndate,returnon,fine) values(?,?,?,?,?,?,?,?,?,?)";
                searchdet(jTextField4.getText(), jTextField1.getText());
                ps=conn.prepareStatement(url);
                ps.setString(1, jTextField4.getText());
                ps.setString(2, jTextField5.getText());
                ps.setString(3, edition);
                ps.setString(4, jTextField1.getText());
                ps.setString(5, jTextField2.getText());
                ps.setString(6, course);
                ps.setString(7, jTextField3.getText());
                ps.setString(8, jTextField6.getText());
                Date d=jDateChooser2.getDate();
                ps.setString(9, new SimpleDateFormat("dd/MM/yyyy").format(d));
                comparedate(jTextField6.getText(), new SimpleDateFormat("dd/MM/yyyy").format(d));
                ps.setInt(10, fine);
                ps.execute();
                return_book(jTextField4.getText());
                Remmoveissue(jTextField4.getText(), jTextField1.getText());
                JOptionPane.showMessageDialog(rootPane, "Book Name "+jTextField5.getText()+" Returned By "+jTextField2.getText());
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jComboBox1.setSelectedIndex(0);
                fetch_issue();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int selectedindx=jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedindx, 3).toString());
        jTextField2.setText(model.getValueAt(selectedindx, 4).toString());
        jTextField3.setText(model.getValueAt(selectedindx, 6).toString());
        jTextField4.setText(model.getValueAt(selectedindx, 0).toString());
        jTextField5.setText(model.getValueAt(selectedindx, 1).toString());
        jTextField6.setText(model.getValueAt(selectedindx, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        if(jTextField7.getText().equals(""))
            fetch_issue();
        
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField7.requestFocus();
        jDateChooser2.setEnabled(false);
        jRadioButton1.setSelected(false);
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        fetch_issue();
        jTextField7.setText("");
        jTextField7.requestFocus();
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return_book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

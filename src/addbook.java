
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class addbook extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form addbook
     */
    public addbook() {
        initComponents();
        super.setTitle("Library Management System-Add Book");
        ImageIcon im =new ImageIcon("Assets//icon.png");
        super.setIconImage(im.getImage());
        conn=connectiondb.db();
        showdate();
        
    }
    
    
    public void showdate()
    {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d=new Date();
                SimpleDateFormat s= new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat s1= new SimpleDateFormat("hh:mm:ss");
                jLabel18.setText("Date : "+s.format(d)+"    Time: " +s1.format(d));
            }
        }).start();
    }
    
public int verify()
{
    int i=0;
    String url="Select bookname from add_book where bookid=?";
        try {
            ps=conn.prepareStatement(url);
            ps.setString(1, jTextField1.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {
                
                jLabel3.setIcon(null);
                JOptionPane.showMessageDialog(rootPane, "Book Id Already Registerd With Book Name: "+rs.getString(1));
                i=1;
            }
            else
            {
                ImageIcon icon=new ImageIcon("Assets\\verify.png");
                jLabel3.setIcon(icon);
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
    return i;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/generate.png"))); // NOI18N
        jButton2.setText("Generate Book Id");
        jButton2.setFocusPainted(false);
        jButton2.setIconTextGap(5);
        jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 180, 30));

        jTextField6.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 102, 102));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setAutoscrolls(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 310, 30));

        jTextField5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 102, 102));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setAutoscrolls(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 392, 310, 30));

        jTextField4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 102, 102));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setAutoscrolls(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 342, 310, 30));

        jTextField3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 102, 102));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setAutoscrolls(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 292, 310, 30));

        jTextField2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 102, 102));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 242, 310, 30));

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 102, 102));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 192, 310, 30));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/addbook12.png"))); // NOI18N
        jButton1.setText("Add Book");
        jButton1.setFocusPainted(false);
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 150, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 140, 30));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 153));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 420, 40));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-trash-48.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.setFocusPainted(false);
        jButton3.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add_book.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel3.setIcon(null);
        Date d= new Date();
        SimpleDateFormat s= new SimpleDateFormat("yyssddMMhhmmss");
        jTextField1.setText(s.format(d));
        if(verify()==1)
        {
            d=new Date();
            s= new SimpleDateFormat("yyssddMMhhmmss");
            jTextField1.setText(s.format(d));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            if(jTextField1.getText().equals(""))
            {
                jButton2.doClick();
                jTextField2.requestFocus();
            }
            else
            {
                if(verify()==1)
                {
                    jTextField1.requestFocus();
                }
                else
                    jTextField2.requestFocus();
            }
        }
        if(c==KeyEvent.VK_DOWN)
        {
            if(jTextField1.getText().equals(""))
            {
                jButton2.doClick();
                jTextField2.requestFocus();
            }
            else
            {
                if(verify()==1)
                {
                    jTextField1.requestFocus();
                }
                else
                    jTextField2.requestFocus();
            }
        }
        if(c==KeyEvent.VK_UP)
        {
           jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            jTextField3.requestFocus();
        }
        if(c==KeyEvent.VK_DOWN)
        {
            jTextField3.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            jTextField4.requestFocus();
        }
        if(c==KeyEvent.VK_DOWN)
        {
            jTextField4.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            jTextField5.requestFocus();
        }
        if(c==KeyEvent.VK_DOWN)
        {
            jTextField5.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            jTextField6.requestFocus();
        }
        if(c==KeyEvent.VK_DOWN)
        {
            jTextField6.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_DOWN)
        {
            jTextField1.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jButton1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText().equals("")||jTextField2.getText().equals("")||jTextField3.getText().equals("")||jTextField4.getText().equals("")||jTextField5.getText().equals("")||jTextField6.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Please Fill The Empty Fields");
        }
        else
        {
            try {
                String purl="Insert into add_book (bookid,bookname,publication,edition,page,quantity) Values(?,?,?,?,?,?) ";
                ps=conn.prepareStatement(purl);
                ps.setString(1, jTextField1.getText());
                ps.setString(2, jTextField2.getText());
                ps.setString(3, jTextField3.getText());
                ps.setString(4, jTextField4.getText());
                ps.setString(5, jTextField5.getText());
                ps.setString(6, jTextField6.getText());
                ps.execute();
                JOptionPane.showMessageDialog(rootPane, "Book Regidtered with Id: "+jTextField1.getText());
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jButton2.doClick();
            } catch (Exception e) 
            {
                String em=e.getMessage();
          
                if(em.equals("[SQLITE_CONSTRAINT_PRIMARYKEY]  A PRIMARY KEY constraint failed (UNIQUE constraint failed: add_book.bookid)")) {
                    JOptionPane.showMessageDialog(rootPane, "Book Already Registered with this Book Id Please Generate or Enter Other one");
                } else JOptionPane.showMessageDialog(rootPane, e);
            }
            finally
            {
                try {
                    ps.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        int c= evt.getKeyCode();
        if(c==KeyEvent.VK_ENTER)
        {
            jButton1.requestFocus();
        }
        if(c==KeyEvent.VK_DOWN)
        {
            jButton1.requestFocus();
        }
        if(c==KeyEvent.VK_UP)
        {
           jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField1.requestFocus();
        jLabel3.setIcon(null);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}

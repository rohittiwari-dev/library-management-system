
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class issue_detail extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel model;
    /**
     * Creates new form issue_detail
     */
    public issue_detail() {
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
    
    public void returnexport(String path)
    {
        DefaultTableModel model1=(DefaultTableModel)jTable1.getModel();
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet ws =wb.createSheet();
        XSSFCellStyle style = wb.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 15);
        font.setColor(XSSFFont.COLOR_RED); 
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        TreeMap<String,Object[]> map= new TreeMap<>();
        
        map.put("0", new Object[]{model1.getColumnName(0),model1.getColumnName(1),model1.getColumnName(2),
            model1.getColumnName(3),model1.getColumnName(4),model1.getColumnName(5),model1.getColumnName(6),
            model1.getColumnName(7)});
        for (int i = 0; i < model.getRowCount(); i++) {
            map.put(Integer.toString(i+1), new Object[]{model1.getValueAt(i,0),model1.getValueAt(i,1),model1.getValueAt(i,2),
            model1.getValueAt(i,3),model1.getValueAt(i,4),model1.getValueAt(i,5),model1.getValueAt(i,6),
            model1.getValueAt(i,7)});
        }
        Set<String> id=map.keySet();
        XSSFRow fRow;
        
        int rowId=0;
        for(String key: id)
        {
            fRow=ws.createRow(rowId++);
            fRow.setHeight((short)400);
            Object[] value=map.get(key);
            int cellid=0;
            for(Object object:value)
            {
                XSSFCell cell=fRow.createCell(cellid++);
                cell.setCellValue(object.toString());
                for(int a=0;a<object.toString().length();a++)
                    ws.autoSizeColumn(a);
                
                XSSFCellStyle style1 = wb.createCellStyle();
                style1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
                cell.setCellStyle(style1);
            }
        }
        XSSFRow rs= ws.getRow(0);
        rs.setHeight((short)400);
        Cell cell0=rs.getCell(0);
        cell0.setCellStyle(style);
        Cell cell1=rs.getCell(1);
        cell1.setCellStyle(style);
        Cell cell2=rs.getCell(2);
        cell2.setCellStyle(style);
        Cell cell3=rs.getCell(3);
        cell3.setCellStyle(style);
        Cell cell4=rs.getCell(4);
        cell4.setCellStyle(style);
        Cell cell5=rs.getCell(5);
        cell5.setCellStyle(style);
        Cell cell6=rs.getCell(6);
        cell6.setCellStyle(style);
        Cell cell7=rs.getCell(7);
        cell7.setCellStyle(style);
        for(int a=0;a<cell7.toString().length();a++)
            ws.autoSizeColumn(a);
        
        try {
            FileOutputStream fos=new FileOutputStream(new File(path));
            wb.write(fos);
            fos.close();
            JOptionPane.showMessageDialog(rootPane, "Data Exported Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "The File is Being Used by Other Application");
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

        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(200, 9, 9));
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

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 51, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setAutoscrolls(false);
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 190, 305, 30));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(153, 51, 0));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setAutoscrolls(false);
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 238, 305, 30));

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(153, 51, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setAutoscrolls(false);
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jTextField6.setSelectionColor(new java.awt.Color(200, 96, 253));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 287, 305, 30));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 51, 0));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setAutoscrolls(false);
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 333, 305, 30));

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 51, 0));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setAutoscrolls(false);
        jTextField11.setBorder(null);
        jTextField11.setOpaque(false);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 332, 300, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 51, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setAutoscrolls(false);
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 285, 300, 30));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 51, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 238, 300, 30));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 51, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 300, 32));

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

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 0, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Search Type", "Book Id", "Student Id" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 133, 260, 35));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 395, 1080, 220));

        jButton7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/grid_update.png"))); // NOI18N
        jButton7.setText("Refresh");
        jButton7.setFocusPainted(false);
        jButton7.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, 180, 40));

        jButton8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/exportexcel.png"))); // NOI18N
        jButton8.setText("Export All to Excel");
        jButton8.setFocusPainted(false);
        jButton8.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 230, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Issue_details.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        if(jTextField7.getText().equals(""))
        fetch_issue();
    }//GEN-LAST:event_jTextField7KeyTyped

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
            jTextField11.setText("");
            jTextField9.setText("");
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
                    JOptionPane.showMessageDialog(rootPane, "No Book Return info. available with This Id");
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int selectedindx=jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(selectedindx, 3).toString());
        jTextField2.setText(model.getValueAt(selectedindx, 4).toString());
        jTextField3.setText(model.getValueAt(selectedindx, 5).toString());
        jTextField4.setText(model.getValueAt(selectedindx, 0).toString());
        jTextField5.setText(model.getValueAt(selectedindx, 1).toString());
        jTextField6.setText(model.getValueAt(selectedindx, 2).toString());
        jTextField9.setText(model.getValueAt(selectedindx, 7).toString());
        jTextField11.setText(model.getValueAt(selectedindx, 6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        fetch_issue();
        jTextField7.setText("");
        jTextField7.requestFocus();
        jComboBox1.setSelectedIndex(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField11.setText("");
        jTextField9.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(model.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(rootPane, "No Data Found to Export");
        }
        else
        {
            JFileChooser file= new JFileChooser();
            file.setCurrentDirectory(new File("user.home"));
            file.setDialogTitle("Export Issue Book Details");
            FileNameExtensionFilter filter =new FileNameExtensionFilter("*.File","xls", "xlsx", "xlsm");
            file.setFileFilter(filter);
            SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
            file.setSelectedFile(new File("Issue_Book_Details_"+s.format(new Date())));
            int result=file.showSaveDialog(this);
            try
            {
                if(result==JFileChooser.APPROVE_OPTION)
                {
                    jButton7.doClick();
                    File selectedfile =file.getSelectedFile();
                    String path =selectedfile.getAbsolutePath();
                    
                    if(path.endsWith(".xls"))
                        path=path.substring(0, path.length()-4);
                    else if(path.endsWith(".xlsx")||path.endsWith(".xlsm"))
                        path=path.substring(0, path.length()-5);
                    
                    if(path.endsWith("_"))
                        path=path.substring(0,path.length()-1)+".xlsx";
                    else if(path.substring(path.length()-8).equals(s.format(new Date())))
                        path=path+".xlsx";
                    else
                        path=path+"_"+s.format(new Date())+".xlsx";
                    returnexport(path);
                }
                else
                {
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(issue_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issue_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issue_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issue_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issue_detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

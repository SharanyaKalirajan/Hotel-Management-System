import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.*;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
        
public class CustomerDetailsBill extends javax.swing.JFrame {

    public CustomerDetailsBill() {
        initComponents();
        SimpleDateFormat myFormat=new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal=Calendar.getInstance();
        jTextField1.setText(myFormat.format(cal.getTime()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("CUSTOMER DETAILS BILL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 38, 387, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sruthi\\Desktop\\project image\\pngkey.com-visto-png-4088745.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search by check out date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 109, 235, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 106, 267, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("SEARCH");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 106, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setFont(new java.awt.Font("Segoe UI", 3, 8)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile number", "nationality", "Gender", "Email", "IdProof", "Address", "Check IN Date", "Room Number", "Bed", "Room Type", "Price Per Day", "Number of days stayed", "Total Amount", "Check Out Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 1080, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sruthi\\Desktop\\project image\\oorr-watervilla-bedroom-2-1170x731.jpg")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 740));

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        setVisible(false);
    }                                        

    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
        // TODO add your handling code here:
        String checkoutDate=jTextField1.getText();
        ResultSet rs=Select.getData("select *from customer where checkOut='"+checkoutDate+"'");
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        try
        {
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)});
            }
            rs.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }                                   

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int index=jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        String id=model.getValueAt(index,1).toString();
        try
        {
            if((new File("E:\\"+id+".pdf")).exists())
            {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler E:\\"+id+".pdf");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"File not exists");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }                                    

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDetailsBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDetailsBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}

package librarymanagementsystem.GUI;

import librarymanagementsystem.Toolkit.SerialConnection;
import librarymanagementsystem.BUS.QLAdminBUS;
import librarymanagementsystem.BUS.QLNhanVienBUS;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class loginRFID extends javax.swing.JFrame {
    
    int x_Mouse, y_Mouse; // For Moving Window
    
    public loginRFID() {
        initComponents();
        setBounds(0, 0, 300, 500);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        
        /** testing part **
         * Note: Khi listening để read data thì frame bị stop lại để chờ read xong RFID mới chạy tiếp => Giải pháp: phân luồng :)
        SerialConnection RFID_login = new SerialConnection();
        String tkDangNhap = RFID_login.readData();
        System.out.println(tkDangNhap);
        **/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoHeader_Label = new javax.swing.JLabel();
        logoMain_Label = new javax.swing.JLabel();
        //loadingIcon_Label = new javax.swing.JLabel();
        WareIcon_Label = new javax.swing.JLabel();
        exit_btn = new javax.swing.JLabel();
        movingWindow_Label = new javax.swing.JLabel();
        loginGUI_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        logoHeader_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/icon_Header_100_100.png"))); // NOI18N
        logoHeader_Label.setBounds(100, 70, 100, 100); // NOI18N
        jPanel1.add(logoHeader_Label);

        logoMain_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/icon_main_80_80.png"))); // NOI18N
        logoMain_Label.setBounds(115, 245, 80, 80); // NOI18N
        jPanel1.add(logoMain_Label);
        
        /** not working with Serial Connection 
        loadingIcon_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/loading_icon_244_244.gif"))); // NOI18N
        loadingIcon_Label.setBounds(30, 160, 244, 244); // NOI18N
        jPanel1.add(loadingIcon_Label);
        **/
        
        WareIcon_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/ware_icon_220_220.png"))); // NOI18N
        WareIcon_Label.setBounds(42, 172, 220, 220); // NOI18N
        jPanel1.add(WareIcon_Label);
        
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/exit_btn_30_30.png"))); // NOI18N
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_btnMouseClicked(evt);
            }
        });
        exit_btn.setBounds(255, 450, 30, 30);
        jPanel1.add(exit_btn);

        movingWindow_Label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                movingWindow_LabelMouseDragged(evt);
            }
        });
        movingWindow_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                movingWindow_LabelMousePressed(evt);
            }
        });
        movingWindow_Label.setBounds(0, 0, 300, 130);
        jPanel1.add(movingWindow_Label);

        loginGUI_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/login_RFID_300_492.png"))); // NOI18N
        loginGUI_Label.setBounds(0, 0, 300, 500); // NOI18N
        jPanel1.add(loginGUI_Label);
        jPanel1.setBounds(0, 0, 300, 500);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>                        

    public String kiemTraDangNhap(String RFID_code){
        QLAdminBUS tkadmin = new QLAdminBUS();
        String admin = tkadmin.kiemTraTaiKhoan_RFID_code(RFID_code);
        if (!admin.equals("")){
            return admin;
        }
        
        
        QLNhanVienBUS tknhanvien = new QLNhanVienBUS();
        String nhanvien = tknhanvien.kiemTraTaiKhoan_RFID_code(RFID_code);
        if (!nhanvien.equals("")){
            //current_session = nhanvien;
            return nhanvien;
        }
        
        return "";
    }
    
    public String login_by_RFID(){
        SerialConnection RFID_login = new SerialConnection();
        if (RFID_login.kiemTraPort()){
            String tkDangNhap = RFID_login.readData();
            System.out.println(tkDangNhap);
            return kiemTraDangNhap(tkDangNhap);
        }
        else{
            System.out.println("Không tìm thấy RFID Module");
            return "";
        }
        /** Thread fail :(((
        RFID_login_thread thread = new RFID_login_thread();
        thread.start();
        while (thread.isAlive())
        System.out.println(thread.getCurrent_ID() + "sads");
        return kiemTraDangNhap(thread.getCurrent_ID());
        **/
    }
    
    private void exit_btnMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        System.out.println("exit Clicked!");
        this.dispose();
    }

    private void movingWindow_LabelMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - x_Mouse, y - y_Mouse);
    }

    private void movingWindow_LabelMousePressed(java.awt.event.MouseEvent evt) {
        x_Mouse = evt.getX();
        y_Mouse = evt.getY();
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
            java.util.logging.Logger.getLogger(loginRFID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginRFID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginRFID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginRFID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginRFID().setVisible(true);
                /** testing part
                SerialConnection RFID_login = new SerialConnection();
                String tkDangNhap = RFID_login.readData();
                System.out.println(tkDangNhap);
                **/
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel exit_btn;
    private javax.swing.JPanel jPanel1;
    //private javax.swing.JLabel loadingIcon_Label;
    private javax.swing.JLabel WareIcon_Label;
    private javax.swing.JLabel loginGUI_Label;
    private javax.swing.JLabel logoHeader_Label;
    private javax.swing.JLabel logoMain_Label;
    private javax.swing.JLabel movingWindow_Label;
    // End of variables declaration                   
}

class RFID_login_thread extends Thread {

    static String current_ID = "";

    public String getCurrent_ID(){
        return current_ID;
    }

    public void run() {
        SerialConnection RFID_login = new SerialConnection();
        String tkDangNhap = RFID_login.readData();
        current_ID = tkDangNhap;
    }
}

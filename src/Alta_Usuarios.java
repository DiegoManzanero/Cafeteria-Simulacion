
/**
 *
 * @author Diego Manzanero
 */
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet; 

public class Alta_Usuarios extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/Lista_Usuarios";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "contraseña";
    
    PreparedStatement ps;
    ResultSet rs;
    Double Codigo;
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
            JOptionPane.showMessageDialog(null,"Conexion establecida");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
    private void LimpiarCajas()
    {
        txtNombre.setText(null);
    }
    
    public Alta_Usuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        Tipo = new javax.swing.JTextField();
        botsave = new javax.swing.JButton();
        botclean = new javax.swing.JButton();
        botreturn = new javax.swing.JButton();
        Titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(434, 248));
        setMinimumSize(new java.awt.Dimension(434, 248));
        getContentPane().setLayout(null);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(160, 90, 200, 20);

        Tipo.setEditable(false);
        Tipo.setBackground(new java.awt.Color(0, 204, 204));
        Tipo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Tipo.setForeground(new java.awt.Color(255, 255, 255));
        Tipo.setText("Nombre :");
        Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoActionPerformed(evt);
            }
        });
        getContentPane().add(Tipo);
        Tipo.setBounds(70, 90, 70, 24);

        botsave.setText("Guardar");
        botsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botsaveActionPerformed(evt);
            }
        });
        getContentPane().add(botsave);
        botsave.setBounds(40, 160, 71, 23);

        botclean.setText("Limpiar");
        botclean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcleanActionPerformed(evt);
            }
        });
        getContentPane().add(botclean);
        botclean.setBounds(160, 160, 70, 23);

        botreturn.setText("Regresar");
        botreturn.setMaximumSize(new java.awt.Dimension(600, 500));
        botreturn.setMinimumSize(new java.awt.Dimension(600, 500));
        botreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botreturnActionPerformed(evt);
            }
        });
        getContentPane().add(botreturn);
        botreturn.setBounds(280, 160, 80, 23);

        Titulo.setEditable(false);
        Titulo.setBackground(new java.awt.Color(0, 204, 204));
        Titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Registro Nuevo Cliente");
        Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloActionPerformed(evt);
            }
        });
        getContentPane().add(Titulo);
        Titulo.setBounds(110, 20, 200, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/671px-Add_user_icon_(blue).svg.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setMaximumSize(new java.awt.Dimension(300, 300));
        jLabel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 400));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -60, 570, 470);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/papel_color_plus_bahamas_azul_turquesa_180g_108_1_20160517151224.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 420, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoActionPerformed

    private void TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloActionPerformed

    private void botsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botsaveActionPerformed
        Connection con = null;
        try{
            con=getConnection();
            ps = con.prepareStatement("INSERT INTO Usuario(idUsuario,Nombre)VALUES(?,?)");
            ps.setString(1,Double.toString(Math.random()*1000));
            ps.setString(2,txtNombre.getText());
            int res = ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Usuario Guardado");
                LimpiarCajas();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al guardar");
            }
            con.close();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_botsaveActionPerformed

    private void botcleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcleanActionPerformed
        LimpiarCajas();
    }//GEN-LAST:event_botcleanActionPerformed

    private void botreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botreturnActionPerformed
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
        // AÑADIR EL REGRESO A LA PANTALLA PRINCIPAL CON ESTE BOTON
    }//GEN-LAST:event_botreturnActionPerformed

    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alta_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tipo;
    private javax.swing.JTextField Titulo;
    private javax.swing.JButton botclean;
    private javax.swing.JButton botreturn;
    private javax.swing.JButton botsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

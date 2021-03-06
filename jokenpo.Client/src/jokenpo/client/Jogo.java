/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokenpo.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import jokenpo.server.JokenpoServer;

/**
 *
 * @author nathy
 */
public class Jogo extends javax.swing.JFrame {

    private JokenpoServer server;
    private static String name; 
    private int tipoJogo = 0;
    private int rodadas = 0;
    private int finish = 5;
    
    /**
     * Creates new form Jogo
     */
    public Jogo() {
        initComponents();
        Inicio();
    }
    
    public void Jogar() {
        boolean result = true;
        name = txtNome.getText();
        
        if (tipoJogo == 1)
        {
            try
            {
                server = new JokenpoServer(name);
                String oponente = server.PlayOnline();
                while (oponente == null)
                {
                    System.out.println("Aguarde enquanto encontramos um oponente...");
                    oponente = server.PlayOnline();
                }
                lblOponente1.setText(oponente);
            }
            catch(Exception ex)
            {
                result = false;
            }
        }
        
        if (result == true)
        {
            pnlInicio.setVisible(false);
            pnlJogada.setVisible(true);
            btnSair.setVisible(true);
            pnlPlacar.setVisible(true);
            pnlJogadas.setVisible(true);
            pnlStart.setVisible(false);
            lblJogador1.setText(name);
        }
        else
            JOptionPane.showMessageDialog(this, "Não há jogadores disponíveis no momento!",
                                          "Atenção", JOptionPane.WARNING_MESSAGE);
    }
    
    public void Sair()
    {
        server.Sair();
        Inicio();
    }
    
    public void Inicio() {
        pnlInicio.setVisible(true);
        pnlJogada.setVisible(false);
        btnCPU.setEnabled((txtNome.getText() != null));
        btnJogador.setEnabled((txtNome.getText() != null));
        btnSair.setVisible(false);
        pnlPlacar.setVisible(false);
        pnlJogadas.setVisible(false);
        pnlStart.setVisible(true);
        pnlResultado.setVisible(false);
        ResetJogo();
    }
    
    private void GerarJogada()
    {
        String jogador1 = lblJogada1.getText();
        String jogador2 = null;
        
        if (tipoJogo == 0)
            jogador2 = GetRandom();
        else
        {
            jogador2 = server.Jogar(jogador1);
            while (jogador2 == null)
            {
                jogador2 = server.Oponente();
            }
        }
        
        int placar1 = Integer.parseInt(lblMeuPlacar.getText());
        int placar2 = Integer.parseInt(lblPlacarOponente.getText());
        boolean empate = false;
        rodadas += 1;
        boolean sair = false;
        
        if (jogador2.equals("EXIT"))
            sair = true;
        else
        {
            lblJogada2.setText(jogador2);

            if (jogador1.equals("Pedra"))
            {
                if (jogador2.equals("Papel"))
                    lblPlacarOponente.setText(String.valueOf(placar2 + 1));
                else if (jogador2.equals("Tesoura"))
                    lblMeuPlacar.setText(String.valueOf((placar1 + 1)));
                else
                    empate = true;
            }
            else if (jogador1.equals("Papel"))
            {
                if (jogador2.equals("Tesoura"))
                    lblPlacarOponente.setText(String.valueOf(placar2 + 1));
                else if (jogador2.equals("Pedra"))
                    lblMeuPlacar.setText(String.valueOf((placar1 + 1)));
                else
                    empate = true;
            }
            else
            {
                if (jogador2.equals("Pedra"))
                    lblPlacarOponente.setText(String.valueOf(placar2 + 1));
                else if (jogador2.equals("Papel"))
                    lblMeuPlacar.setText(String.valueOf((placar1 + 1)));
                else
                    empate = true;
            }
        }
        
        if (rodadas == finish || sair)
        {
            String mensagem = "Seu oponente saiu, você venceu! :)";
            if (!sair)
            {
                mensagem = "Você venceu! :)";
                if (placar1 == placar2)
                    mensagem = "Você empatou! ;)";
                else if (placar2 > placar1)
                    mensagem = "Você perdeu... :(";
            }
            lblResultado.setText(mensagem);
            pnlPlacar.setVisible(false);
            pnlJogada.setVisible(false);
            pnlJogadas.setVisible(false);
            pnlResultado.setVisible(true);
        }
    }
    
    private String GetRandom() 
    {
        int r = (int) (Math.random()*3);
        String name = new String [] {"Pedra", "Papel", "Tesoura"}[r];
        return name;
    }
    
    private void ResetJogo()
    {
        lblJogador1.setText("Jogador");
        lblOponente1.setText("CPU");
        lblMeuPlacar.setText("0");
        lblPlacarOponente.setText("0");
        lblJogada1.setText("");
        lblJogada2.setText("");
        rodadas = 0;
        tipoJogo = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNome = new javax.swing.JTextField();
        pnlJogada = new javax.swing.JPanel();
        btnPedra = new javax.swing.JButton();
        btnPapel = new javax.swing.JButton();
        btnTesoura = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        pnlPlacar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblJogador1 = new javax.swing.JLabel();
        lblMeuPlacar = new javax.swing.JLabel();
        lblPlacarOponente = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblOponente1 = new javax.swing.JLabel();
        pnlJogadas = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblJogada2 = new javax.swing.JLabel();
        lblJogada1 = new javax.swing.JLabel();
        pnlResultado = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();
        pnlStart = new javax.swing.JPanel();
        btnCPU = new javax.swing.JButton();
        btnJogador = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(230, 194, 81));

        jPanel1.setBackground(new java.awt.Color(243, 190, 42));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jokenpo/assets/logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 360, -1, -1));

        pnlInicio.setBackground(new java.awt.Color(243, 190, 43));
        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(75, 50, 39));
        jLabel3.setText("Pode me chamar de");
        pnlInicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));
        pnlInicio.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 52, 199, 10));

        txtNome.setBackground(new java.awt.Color(243, 190, 43));
        txtNome.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setBorder(null);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });
        pnlInicio.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 11, 170, 35));

        jPanel1.add(pnlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 407, 70));

        pnlJogada.setBackground(new java.awt.Color(243, 190, 43));
        pnlJogada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedra.setText("Pedra");
        btnPedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedraActionPerformed(evt);
            }
        });
        pnlJogada.add(btnPedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 19, 95, 123));

        btnPapel.setText("Papel");
        btnPapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPapelActionPerformed(evt);
            }
        });
        pnlJogada.add(btnPapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 19, 95, 123));

        btnTesoura.setText("Tesoura");
        btnTesoura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesouraActionPerformed(evt);
            }
        });
        pnlJogada.add(btnTesoura, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 19, 95, 123));

        jPanel1.add(pnlJogada, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 421, -1, -1));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 11, -1, -1));

        pnlPlacar.setBackground(new java.awt.Color(243, 190, 43));
        pnlPlacar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(75, 50, 39));
        jLabel5.setText("Placar");
        pnlPlacar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        lblNome.setBackground(new java.awt.Color(243, 190, 42));
        lblNome.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(241, 90, 41));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPlacar.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 55, 99, -1));

        lblJogador1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblJogador1.setForeground(new java.awt.Color(241, 90, 41));
        lblJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJogador1.setText("Jogador");
        pnlPlacar.add(lblJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 100, -1));
        lblJogador1.getAccessibleContext().setAccessibleName("Jogador");

        lblMeuPlacar.setBackground(new java.awt.Color(255, 0, 51));
        lblMeuPlacar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMeuPlacar.setForeground(new java.awt.Color(255, 255, 255));
        lblMeuPlacar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMeuPlacar.setText("0");
        pnlPlacar.add(lblMeuPlacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 45, 31));

        lblPlacarOponente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPlacarOponente.setForeground(new java.awt.Color(255, 255, 255));
        lblPlacarOponente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlacarOponente.setText("0");
        pnlPlacar.add(lblPlacarOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 45, 31));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(75, 50, 39));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X");
        pnlPlacar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 45, 53, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(75, 50, 39));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("X");
        pnlPlacar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 45, 53, -1));

        lblOponente1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblOponente1.setForeground(new java.awt.Color(241, 90, 41));
        lblOponente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOponente1.setText("CPU");
        pnlPlacar.add(lblOponente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 40, 90, -1));

        jPanel1.add(pnlPlacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        pnlJogadas.setBackground(new java.awt.Color(243, 190, 42));
        pnlJogadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(75, 50, 39));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X");
        pnlJogadas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 53, -1));

        lblJogada2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnlJogadas.add(lblJogada2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, 110));

        lblJogada1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pnlJogadas.add(lblJogada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, 110));

        jPanel1.add(pnlJogadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 400, 140));

        pnlResultado.setBackground(new java.awt.Color(243, 190, 42));
        pnlResultado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblResultado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblResultado.setForeground(new java.awt.Color(75, 50, 39));
        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlResultado.add(lblResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 65, 330, -1));

        jPanel1.add(pnlResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 500, 140));

        pnlStart.setBackground(new java.awt.Color(243, 190, 42));
        pnlStart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCPU.setText("CPU");
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });
        pnlStart.add(btnCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 143, 48));

        btnJogador.setText("Jogador");
        btnJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogadorActionPerformed(evt);
            }
        });
        pnlStart.add(btnJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 143, 48));

        jPanel1.add(pnlStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 390, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPUActionPerformed
        tipoJogo = 0;
        Jogar();
    }//GEN-LAST:event_btnCPUActionPerformed

    private void btnJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogadorActionPerformed
        tipoJogo = 1;
        Jogar();
    }//GEN-LAST:event_btnJogadorActionPerformed

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        Inicio();
    }//GEN-LAST:event_txtNomeKeyTyped

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        Sair();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedraActionPerformed
        lblJogada1.setText("Pedra");
        GerarJogada();
    }//GEN-LAST:event_btnPedraActionPerformed

    private void btnPapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPapelActionPerformed
        lblJogada1.setText("Papel");
        GerarJogada();
    }//GEN-LAST:event_btnPapelActionPerformed

    private void btnTesouraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesouraActionPerformed
        lblJogada1.setText("Tesoura");
        GerarJogada();
    }//GEN-LAST:event_btnTesouraActionPerformed

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
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnJogador;
    private javax.swing.JButton btnPapel;
    private javax.swing.JButton btnPedra;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTesoura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblJogada1;
    private javax.swing.JLabel lblJogada2;
    private javax.swing.JLabel lblJogador1;
    private javax.swing.JLabel lblMeuPlacar;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOponente1;
    private javax.swing.JLabel lblPlacarOponente;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlJogada;
    private javax.swing.JPanel pnlJogadas;
    private javax.swing.JPanel pnlPlacar;
    private javax.swing.JPanel pnlResultado;
    private javax.swing.JPanel pnlStart;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

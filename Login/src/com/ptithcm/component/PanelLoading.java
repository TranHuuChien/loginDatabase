/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ptithcm.component;

import com.ptithcm.model.ModelUser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
/**
 *
 * @author ImMonster
 */
public class PanelLoading extends javax.swing.JLayeredPane {
    
   private boolean slideLeft;
    private float animate = 1f;
    private boolean  ismessage;
    private final Animator animator;
    private ModelUser data;
    
    public PanelLoading() {
        initComponents();
        loading.setVisible(true);
        message.setVisible(false);
        profile.setVisible(false);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
               if(ismessage)
               {
                   message.setVisible(true);
               }
               else{
                   profile.setVisible(true);
               }
            }

            @Override
            public void timingEvent(float fraction) {
                if (ismessage) {
                    message.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                } else {
                    profile.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                }
                repaint();
            }
            
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        
         //setOpaque(false);
    }
    public void  setAnimate(boolean slideLeft, float animate)
    {
        this.animate = animate;
        this.slideLeft = slideLeft;
    }
    
    public void addEventBack(ActionListener event)
    {
        cmdCancel.addActionListener(event);
        cmdCancel1.addActionListener(event);
        cmdCancel2.addActionListener(event);
        
    }
    public void doneLogin(ModelUser data)
    {
         this.data = data;
         imageAvatar1.setIcon(data.getProfile());
         cmdContinue.setText("Contine with" + data.getUserName());
         animator.start();
    }
    public void addEventContinue(ActionListener e)
    {
        cmdContinue.addActionListener(e);
    }
    
    public void showError(String ms)
    {
        LbMessage.setText(ms);
        ismessage = true;
        animator.start();
        
    }
    public void reset()
    {
      
        loading.setAlpha(1f);
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loading = new com.raven.swing.PanelTransparent();
        cmdCancel = new com.raven.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        message = new com.raven.swing.PanelTransparent();
        cmdCancel2 = new com.raven.swing.Button();
        LbMessage = new javax.swing.JLabel();
        profile = new com.raven.swing.PanelTransparent();
        cmdCancel1 = new com.raven.swing.Button();
        imageAvatar1 = new com.raven.swing.ImageAvatar();
        cmdContinue = new com.raven.swing.Button();

        setBackground(new java.awt.Color(51, 255, 255));
        setLayout(new java.awt.CardLayout());

        cmdCancel.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Cancel");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptithcm/icon/loading.gif"))); // NOI18N

        javax.swing.GroupLayout loadingLayout = new javax.swing.GroupLayout(loading);
        loading.setLayout(loadingLayout);
        loadingLayout.setHorizontalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingLayout.createSequentialGroup()
                .addGroup(loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loadingLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        loadingLayout.setVerticalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        add(loading, "card2");

        cmdCancel2.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel2.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel2.setText("Cancel");

        LbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbMessage.setText("Thong Bao");

        javax.swing.GroupLayout messageLayout = new javax.swing.GroupLayout(message);
        message.setLayout(messageLayout);
        messageLayout.setHorizontalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageLayout.createSequentialGroup()
                .addGroup(messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messageLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(messageLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        messageLayout.setVerticalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(LbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        add(message, "card3");

        cmdCancel1.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel1.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel1.setText("Cancel");

        imageAvatar1.setBorderSize(3);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ptithcm/icon/user.png"))); // NOI18N

        cmdContinue.setBackground(new java.awt.Color(102, 255, 0));
        cmdContinue.setText("Cotntinue");

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profileLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmdContinue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdCancel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(cmdContinue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        add(profile, "card4");
    }// </editor-fold>//GEN-END:initComponents


    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        if (slideLeft) {
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(width, y);
            p.lineTo(width, height);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.fill(p);
        } else {
            g2.fillRect(x, y, width, height);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        if (slideLeft) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }
    
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbMessage;
    private com.raven.swing.Button cmdCancel;
    private com.raven.swing.Button cmdCancel1;
    private com.raven.swing.Button cmdCancel2;
    private com.raven.swing.Button cmdContinue;
    private com.raven.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.PanelTransparent loading;
    private com.raven.swing.PanelTransparent message;
    private com.raven.swing.PanelTransparent profile;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ptithcm.component;
import com.mysql.jdbc.PreparedStatement;
import com.ptithcm.Dao.ConnectDatabase;
import com.ptithcm.Dao.DatabaseConnection;
import com.ptithcm.main.Main;
import com.ptithcm.model.ModelUser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Path2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class PanelSlice extends javax.swing.JLayeredPane {

    private boolean slideLeft;
    private final Animator animator;
    private float animate = 1f;
    private final PanelLogin login;
    private final PanelLoading loading;

    private Thread th;

    private MigLayout layout;
private JFrame fram;

    public void setFram(JFrame fram) {
        this.fram = fram;
    }
    public PanelSlice() {
        initComponents();
        setPreferredSize(new Dimension(350, 450));
        Color color = new Color(67, 99, 132);
        setBackground(color);
        layout = new MigLayout("inset 0", "[fill]", "[fill]");
        setLayout(layout);
        login = new PanelLogin();
        loading = new PanelLoading();
        loading.setVisible(false);
        loading.setBackground(color);

        TimingTarget target = new TimingTargetAdapter() {

            @Override
            public void end() {
                if (slideLeft) {
                    login.setVisible(false);
                } else {
                    loading.setVisible(false);
                    loading.reset();
                }
            }

            @Override
            public void begin() {
                if (slideLeft) {
                    loading.setVisible(true);
                } else {
                    login.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                double width = getWidth();
                animate = fraction;
                float a = easeOutQuint(fraction);
                int x = (int) (a * width);
                loading.setAnimate(slideLeft, fraction);
                layout.setComponentConstraints(loading, "pos " + x + " 0 100% 100%");
                revalidate();
                repaint();
            }

        };
        animator = new Animator(1000, target);
        animator.setResolution(0);
        add(login);
        add(loading, "pos 0 0 0 0,w 0!");
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    if (login.checkUser()) {
                        showSlice(true);
                        login(login.getName(), login.getPassword());
                    }
                }
            }
        });
        
        loading.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                fram.dispose();
            }
        });
        loading.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    th.interrupt();
                    showSlice(false);

                }
            }
        });
    }

    public void showSlice(boolean show) {
        slideLeft = show;
        animator.start();

    }

    public void login(String username, String password) {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    String sql = "select * from TAI_KHOAN where UserName=? and Password=?";
                    ConnectDatabase myConnection = new ConnectDatabase();
                    Connection conn = myConnection.openConnection();
                    java.sql.PreparedStatement p = conn.prepareStatement(sql);
                    p.setString(1, username);
                    p.setString(2, password);
                    ResultSet r = p.executeQuery();
                    if (r.next()) {
                        String userName = r.getString("UserName");
                        int id = r.getInt("IDQuyen");
                        Icon profile;
                        profile = new ImageIcon(getClass().getResource("/com/ptithcm/icon/user.png"));
                        ModelUser data = new ModelUser(23, userName, profile);
                        loading.doneLogin(data);
                    } else {
                        loading.showError("UserName or Password Incorrect");
                    }
                    r.close();
                    p.close();
//                    if (true) {
//                        loading.showError("user and password incorrect");
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        th.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs) {

        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        float x = easeOutQuint(animate) * width;
        float y = 0;
        int centerY = height / 2;
        Path2D.Float p = new Path2D.Float();
        p.moveTo(x, y);
        p.lineTo(x, height);
        p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
        g2.setColor(getBackground());
        g2.fill(p);
        g2.dispose();

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

    private float easeOutQuint(float x) {
        double v = 1 - Math.pow(1 - x, 5);
        if (slideLeft) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

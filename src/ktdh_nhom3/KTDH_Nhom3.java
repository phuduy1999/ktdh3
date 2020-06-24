/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_nhom3;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import pkg3d_ktdh.Frame3D;
//import pkg3d_ktdh.HopChuNhat;
//import pkg3d_ktdh.HinhCau;

/**
 *
 * @author Administrator
 */
public class KTDH_Nhom3 extends javax.swing.JFrame {

    HinhDacBiet hd1;
    int hetoado = 2;
    int chonHinh = 0;
    boolean play = false;

    public KTDH_Nhom3() {
        initComponents();
        setTitle("Vẽ hình cơ bản nhóm 3");
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = jPanel_draw.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.translate(300, 300);
        g2d.scale(1.0, -1.0); //Đổi hướng trục Oy
        if (hetoado == 2) {
            trucOxy(g2d);
            if (chonHinh == 1) {
                drawHD1(g2d);
            }
        } else {
            trucOxyz(g2d);
        }
    }

    Point tamMoi;
    int change = 0;

    public void drawHD1(Graphics2D g2d) {
        //ve hbh
        g2d.setColor(Color.WHITE);
        drawLine(g2d, hd1.getHbh().getA().x, hd1.getHbh().getA().y, hd1.getHbh().getB().x, hd1.getHbh().getB().y);
        drawLine(g2d, hd1.getHbh().getC().x, hd1.getHbh().getC().y, hd1.getHbh().getA().x, hd1.getHbh().getA().y);
        drawLine(g2d, hd1.getHbh().getC().x, hd1.getHbh().getC().y, hd1.getHbh().getD().x, hd1.getHbh().getD().y);
        drawLine(g2d, hd1.getHbh().getD().x, hd1.getHbh().getD().y, hd1.getHbh().getB().x, hd1.getHbh().getB().y);
        g2d.scale(1.0, -1.0);
        g2d.drawString("A(" + hd1.getHbh().getA().x / 5 + "," + hd1.getHbh().getA().y / 5 + ")",
                hd1.getHbh().getA().x, -hd1.getHbh().getA().y - 5);
        g2d.drawString("B(" + hd1.getHbh().getB().x / 5 + "," + hd1.getHbh().getB().y / 5 + ")",
                hd1.getHbh().getB().x, -hd1.getHbh().getB().y - 5);
        g2d.drawString("C(" + hd1.getHbh().getC().x / 5 + "," + hd1.getHbh().getC().y / 5 + ")",
                hd1.getHbh().getC().x-50, -hd1.getHbh().getC().y);
        g2d.drawString("D(" + hd1.getHbh().getD().x / 5 + "," + hd1.getHbh().getD().y / 5 + ")",
                hd1.getHbh().getD().x+5, -hd1.getHbh().getD().y+5);
        g2d.scale(1.0, -1.0);
        //ve chan ban
        drawLine(g2d, hd1.getLine1().getA().x, hd1.getHbh().getC().y, hd1.getLine1().getB().x, hd1.getLine1().getB().y);
        drawLineNetDut(g2d, hd1.getLine1().getA().x, hd1.getLine1().getA().y, hd1.getLine1().getB().x, hd1.getHbh().getC().y);
        drawLine(g2d, hd1.getLine2().getA().x, hd1.getLine2().getA().y, hd1.getLine2().getB().x, hd1.getLine2().getB().y);
        drawLine(g2d, hd1.getLine3().getA().x, hd1.getLine3().getA().y, hd1.getLine3().getB().x, hd1.getLine3().getB().y);
        drawLine(g2d, hd1.getLine4().getA().x, hd1.getLine4().getA().y, hd1.getLine4().getB().x, hd1.getLine4().getB().y);
        g2d.scale(1.0, -1.0);
        g2d.drawString("A1(" + hd1.getLine1().getB().x / 5 + "," + hd1.getLine1().getB().y / 5 + ")",
                hd1.getLine1().getB().x, -hd1.getLine1().getB().y+5);
        g2d.drawString("B1(" + hd1.getLine2().getB().x / 5 + "," + hd1.getLine2().getB().y / 5 + ")",
                hd1.getLine2().getB().x, -hd1.getLine2().getB().y+5);
        g2d.drawString("C1(" + hd1.getLine3().getB().x / 5 + "," + hd1.getLine3().getB().y / 5 + ")",
                hd1.getLine3().getB().x, -hd1.getLine3().getB().y+10);
        g2d.drawString("D1(" + hd1.getLine4().getB().x / 5 + "," + hd1.getLine4().getB().y / 5 + ")",
                hd1.getLine4().getB().x, -hd1.getLine4().getB().y+10);
        g2d.scale(1.0, -1.0);
        if (play == false) {
            //ve hinh tron
            g2d.setColor(Color.red);
            tamMoi = hd1.getTron().getP();
            drawCircle(g2d, 0, hd1.getTron().getR(), hd1.getTron().getR(), hd1.getTron().getP());
            //ve bong hinh elip
            g2d.setColor(Color.blue);
            drawEclipse(g2d, hd1.getElip().getA(), hd1.getElip().getB(), hd1.getElip().getP());
        } else {
            if (change % 10 == 0) {
                change = 0;
                hd1.getElip().setA(20);
                hd1.getElip().setB(10);
            }
            Point tt, tl_tamE, tamE;
            if (change < 5) {
                tt = tinhTien(tamMoi, 0, -20);
                tl_tamE = bienDoiTyLe(hd1.getElip().getP(), 1.2, 1.2);
                hd1.getElip().setA((int) (hd1.getElip().getA() * 1.2));
                hd1.getElip().setB((int) (hd1.getElip().getB() * 1.2));
            } else {
                tt = tinhTien(tamMoi, 0, 20);
                tl_tamE = bienDoiTyLe(hd1.getElip().getP(), 1 / 1.2, 1 / 1.2);
                hd1.getElip().setA((int) (hd1.getElip().getA() / 1.2));
                hd1.getElip().setB((int) (hd1.getElip().getB() / 1.2));
            }
            change++;
            tamMoi = tt;
            hd1.getTron().setP(tamMoi);
            g2d.setColor(Color.red);
            drawCircle(g2d, 0, hd1.getTron().getR(), hd1.getTron().getR(), hd1.getTron().getP());
            jLabel_tamO.setText("(" + hd1.getTron().getP().x / 5 + "," + hd1.getTron().getP().y / 5 + ")");
            jLabel_bk.setText(hd1.getTron().getR() / 5 + "");
            tamE = tinhTien(tl_tamE, hd1.getElip().getP().x - tl_tamE.x, hd1.getElip().getP().y - tl_tamE.y);
            g2d.setColor(Color.blue);
            drawEclipse(g2d, hd1.getElip().getA(), hd1.getElip().getB(), tamE);
            jLabel_tamE.setText("(" + hd1.getElip().getP().x / 5 + "," + hd1.getElip().getP().y / 5 + ")");
            jLabel_A.setText(hd1.getElip().getA() + "");
            jLabel_B.setText(hd1.getElip().getB() + "");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(KTDH_Nhom3.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }

    public void trucOxy(Graphics2D g2d) {
        g2d.setColor(Color.RED);

        //vẽ hệ tọa độ
        g2d.drawLine(-300, 0, 357, 0); //vẽ Ox
        g2d.drawLine(0, 300, 0, -300); //vẽ Oy

        g2d.drawString("O", -10, -5);
        g2d.drawString("X", 300, -10);

        g2d.scale(1.0, -1.0);
        g2d.drawString("Y", 10, -280);
        g2d.scale(1.0, -1.0);
    }

    public void trucOxyz(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        //Vẽ hệ tọa độ
        g2d.drawLine(0, 0, 0, 300); //Oy
        g2d.drawLine(0, 0, 300, 0); //Ox
        g2d.drawLine(0, 0, -225, -225); //Oz

        //Cài đặt điểm
        g2d.drawString("O", -10, 10);
        g2d.drawString("X", 275, 10);
        g2d.scale(1.0, -1.0);
        g2d.drawString("Y", 10, -275);
        g2d.drawString("Z", -230, 230);
        g2d.scale(1.0, -1.0);
    }

    public void putPixel(Graphics2D g2d, int x, int y) {
        g2d.fillRect(x, y, 1, 1);
    }

    public void drawLine(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        int Dx, Dy, p, Const1, Const2;
        int x, y;

        Dx = x2 - x1;
        Dy = y2 - y1;
        Dx = Math.abs(Dx);
        Dy = Math.abs(Dy);
        p = 2 * Dy - Dx;
        Const1 = 2 * Dy;
        Const2 = 2 * (Dy - Dx);
        x = x1;
        y = y1;
        putPixel(g2d, x, y);
        while (x < x2) {
            if (p < 0) {
                p += Const1;
            } else {
                p += Const2;
                y++;
            }
            x++;
            putPixel(g2d, x, y);
        }

        if (x1 == x2) {
            int ymax = y1;
            if (y1 < y2) {
                y = y1;
                ymax = y2;
            } else {
                y = y2;
                ymax = y1;
            }
            while (y != ymax) {
                y++;
                putPixel(g2d, x1, y);
            }
        }
    }

    public void drawLineNetDut(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        int Dx, Dy, p, Const1, Const2;
        int x, y;

        Dx = x2 - x1;
        Dy = y2 - y1;
        Dx = Math.abs(Dx);
        Dy = Math.abs(Dy);
        p = 2 * Dy - Dx;
        Const1 = 2 * Dy;
        Const2 = 2 * (Dy - Dx);
        x = x1;
        y = y1;
        putPixel(g2d, x, y);
        int dem = 0;
        while (x < x2) {
            if (p < 0) {
                p += Const1;
            } else {
                p += Const2;
                y++;
            }
            x++;
            if (dem % 10 == 0) {
                dem = 0;
            }
            if (dem < 5) {
                putPixel(g2d, x, y);
                dem++;
            }
        }

        dem = 0;
        if (x1 == x2) {
            int ymax = y1;
            if (y1 < y2) {
                y = y1;
                ymax = y2;
            } else {
                y = y2;
                ymax = y1;
            }
            while (y != ymax) {
                y++;
                if (y % 10 == 0) {
                    dem = 0;
                }
                if (dem < 5) {
                    putPixel(g2d, x1, y);
                    dem++;
                }
            }
        }
    }

    public void draw8Point(Graphics2D g2d, int x, int y, Point tamO) {
        putPixel(g2d, x + tamO.x, y + tamO.y);
        putPixel(g2d, -x + tamO.x, -y + tamO.y); //O
        putPixel(g2d, x + tamO.x, -y + tamO.y); //ox
        putPixel(g2d, -x + tamO.x, y + tamO.y); //oy
        putPixel(g2d, y + tamO.x, x + tamO.y);
        putPixel(g2d, -y + tamO.x, -x + tamO.y);
        putPixel(g2d, -y + tamO.x, x + tamO.y);
        putPixel(g2d, y + tamO.x, -x + tamO.y);
    }

    public void drawCircle(Graphics2D g2d, int x0, int y0, int R, Point tamO) {
        int x, y;
        int p = 3 - 2 * R;
        x = x0;
        y = y0;
        double limit = R * Math.sqrt(2) / 2;
        while (x <= limit) {
            if (p >= 0) {
                p = p + 4 * (x - y) + 10;
                y--;
            } else {
                p = p + 4 * x + 6;
            }
            draw8Point(g2d, x, y, tamO);
            x++;
        }
    }

    public void ve2DiemNuaDuoi(Graphics2D g2d, int x, int y, Point tamO) {
        putPixel(g2d, x + tamO.x, -y + tamO.y);
        putPixel(g2d, -x + tamO.x, -y + tamO.y);
    }

    public void ve2DiemNuaTren(Graphics2D g2d, int x, int y, Point tamO) {
        putPixel(g2d, x + tamO.x, y + tamO.y);
        putPixel(g2d, -x + tamO.x, y + tamO.y);
    }

    public void drawEclipse(Graphics2D g2d, int a, int b, Point tamO) {
        int x, y;
        float p, a2, b2;
        a2 = (float) pow(a, 2);
        b2 = (float) pow(b, 2);
        x = 0;
        y = b;
        p = 2 * ((float) b2 / a2) - (2 * b) + 1;
        //nua duoi
        //ve nhanh thu 1(tu tren xuong )
        while (((float) b2 / a2) * x <= y) {
            ve2DiemNuaDuoi(g2d, x, y, tamO);
            if (p < 0) {
                p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
            } else {
                p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
                y--;
            }
            x++;
        }
        //ve nhanh thu 2(tu duoi len )
        y = 0;
        x = a;
        p = 2 * ((float) a2 / b2) - 2 * a + 1;
        while (((float) a2 / b2) * y <= x) {
            ve2DiemNuaDuoi(g2d, x, y, tamO);
            if (p < 0) {
                p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
            } else {
                p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
                x = x - 1;
            }
            y = y + 1;
        }

        //nua tren
        x = 0;
        y = b;
        p = 2 * ((float) b2 / a2) - (2 * b) + 1;
        //ve nhanh thu 1(tu tren xuong )
        while (((float) b2 / a2) * x <= y) {
            if (p < 0) {
                p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
            } else {
                p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
                y--;
            }
            ve2DiemNuaTren(g2d, x, y, tamO);
            x++;
        }
        //ve nhanh thu 2(tu duoi len )
        y = 0;
        x = a;
        p = 2 * ((float) a2 / b2) - 2 * a + 1;
        while (((float) a2 / b2) * y <= x) {
            if (p < 0) {
                p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
            } else {
                p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
                x = x - 1;
            }
            ve2DiemNuaTren(g2d, x, y, tamO);
            y++;
        }
    }

    public Point tinhTien(Point p, int trX, int trY) {
        int[] maTranA = {p.x, p.y, 1};
        int[][] maTranTinhTien = {{1, 0, 0}, {0, 1, 0}, {trX, trY, 1}};
        int[] maTranB = new int[3];
        int dem = 0;
        for (int i = 0; i < 3; i++) {
            maTranB[i] = maTranA[0] * maTranTinhTien[0][dem]
                    + maTranA[1] * maTranTinhTien[1][dem] + maTranA[2] * maTranTinhTien[2][dem];
            dem++;
        }
        Point p1 = new Point(maTranB[0], maTranB[1]);
        return p1;
    }

    public Point bienDoiTyLe(Point p, double Sx, double Sy) {
        int[] maTranA = {p.x, p.y, 1};
        double[][] maTranTyLe = {{Sx, 0, 0}, {0, Sy, 0}, {0, 0, 1}};
        int[] maTranB = new int[3];
        int dem = 0;
        for (int i = 0; i < 3; i++) {
            maTranB[i] = (int) (maTranA[0] * maTranTyLe[0][dem]
                    + maTranA[1] * maTranTyLe[1][dem] + maTranA[2] * maTranTyLe[2][dem]);
            dem++;
        }
        Point p1 = new Point(maTranB[0], maTranB[1]);
        return p1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_2D = new javax.swing.ButtonGroup();
        buttonGroup_3D = new javax.swing.ButtonGroup();
        buttonGroup_23D = new javax.swing.ButtonGroup();
        jPanel_choose = new javax.swing.JPanel();
        jButton_play = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jRadioButton_HD1 = new javax.swing.JRadioButton();
        jRadioButton_HD2 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_tamO = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_bk = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_tamE = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_A = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_B = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3D = new javax.swing.JButton();
        jPanel_draw = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel_choose.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_choose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_play.setBackground(new java.awt.Color(0, 0, 102));
        jButton_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ktdh_nhom3/video.png"))); // NOI18N
        jButton_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_playActionPerformed(evt);
            }
        });

        jButton_clear.setBackground(new java.awt.Color(204, 0, 0));
        jButton_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ktdh_nhom3/delete.png"))); // NOI18N
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });

        buttonGroup_2D.add(jRadioButton_HD1);
        jRadioButton_HD1.setText("Hình động 1");
        jRadioButton_HD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_HD1ActionPerformed(evt);
            }
        });

        buttonGroup_2D.add(jRadioButton_HD2);
        jRadioButton_HD2.setText("Hình động 2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Chi tiết:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tâm hình tròn");

        jLabel_tamO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_tamO.setText("(0,0)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Bán kính R =");

        jLabel_bk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_bk.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tâm hình elip");

        jLabel_tamE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_tamE.setText("(0,0)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("cạnh a=");

        jLabel_A.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_A.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("cạnh b=");

        jLabel_B.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_B.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_tamO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_bk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_tamE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_tamO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_bk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_tamE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_A))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_B))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VẼ HÌNH");

        jLabel10.setBackground(new java.awt.Color(250, 250, 250));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CƠ BẢN");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("          Nhóm 3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hình 2D");

        jButton3D.setBackground(new java.awt.Color(102, 102, 102));
        jButton3D.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3D.setForeground(new java.awt.Color(255, 255, 255));
        jButton3D.setText("3D");
        jButton3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_chooseLayout = new javax.swing.GroupLayout(jPanel_choose);
        jPanel_choose.setLayout(jPanel_chooseLayout);
        jPanel_chooseLayout.setHorizontalGroup(
            jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_chooseLayout.createSequentialGroup()
                .addGroup(jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_chooseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_chooseLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton_play)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_clear)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel_chooseLayout.createSequentialGroup()
                        .addGroup(jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_chooseLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton_HD2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jRadioButton_HD1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                            .addGroup(jPanel_chooseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_chooseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3D, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel_chooseLayout.setVerticalGroup(
            jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_chooseLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton_HD1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton_HD2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_play)
                    .addComponent(jButton_clear))
                .addGap(22, 22, 22)
                .addComponent(jButton3D)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel_draw.setBackground(new java.awt.Color(10, 10, 10));
        jPanel_draw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_draw.setPreferredSize(new java.awt.Dimension(645, 2));

        javax.swing.GroupLayout jPanel_drawLayout = new javax.swing.GroupLayout(jPanel_draw);
        jPanel_draw.setLayout(jPanel_drawLayout);
        jPanel_drawLayout.setHorizontalGroup(
            jPanel_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        jPanel_drawLayout.setVerticalGroup(
            jPanel_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_draw, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_choose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_draw, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addComponent(jPanel_choose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_HD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_HD1ActionPerformed
        //Hinh binh hanh - mat ban
        Point a = new Point(100, 130);
        Point b = new Point(300, 130);
        Point c = new Point(50, 80);
        Point d = new Point(0, 0);
        d.x = b.x - a.x + c.x; // tinh diem thu 4 cua hbh
        d.y = c.y;
        MyParallelogram hbh = new MyParallelogram(a, b, c, d);
        int x_hbh = (a.x + d.x) / 2;
        int y_hbh = (a.y + d.y) / 2;
        Point tamHbh = new Point(x_hbh, y_hbh);
        //4 chan ban - 4 duong thang
        MyLine line1 = new MyLine(a, new Point(a.x, 30));
        MyLine line2 = new MyLine(b, new Point(b.x, 30));
        MyLine line3 = new MyLine(c, new Point(c.x, 0));
        MyLine line4 = new MyLine(d, new Point(d.x, 0));
        //hinh tron
        Point tamO = new Point(tamHbh.x, 240);
        int R = 50;
        MyCircle tron = new MyCircle(tamO, R);
        //hinh elip
        Point tam_elip = new Point(tamHbh.x, tamHbh.y);
        int a_elip = 20;
        int b_elip = 10;
        MyEclipse elip = new MyEclipse(tam_elip, a_elip, b_elip);
        hd1 = new HinhDacBiet(tron, elip, hbh, line1, line2, line3, line4);
        chonHinh = 1;
        repaint();
    }//GEN-LAST:event_jRadioButton_HD1ActionPerformed

    private void jButton_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_playActionPerformed
        // TODO add your handling code here:
        if (play == true) {
            play = false;
        } else {
            play = true;
        }
        repaint();
    }//GEN-LAST:event_jButton_playActionPerformed

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
        // TODO add your handling code here:
        play = false;
        buttonGroup_2D.clearSelection();
        chonHinh = 0;
        change = 0;
        repaint();
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jButton3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3DActionPerformed
        new Frame3D().setVisible(true);
        play=false;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3DActionPerformed

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
            java.util.logging.Logger.getLogger(KTDH_Nhom3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KTDH_Nhom3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KTDH_Nhom3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KTDH_Nhom3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KTDH_Nhom3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_23D;
    private javax.swing.ButtonGroup buttonGroup_2D;
    private javax.swing.ButtonGroup buttonGroup_3D;
    private javax.swing.JButton jButton3D;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_play;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_A;
    private javax.swing.JLabel jLabel_B;
    private javax.swing.JLabel jLabel_bk;
    private javax.swing.JLabel jLabel_tamE;
    private javax.swing.JLabel jLabel_tamO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_choose;
    private javax.swing.JPanel jPanel_draw;
    private javax.swing.JRadioButton jRadioButton_HD1;
    private javax.swing.JRadioButton jRadioButton_HD2;
    // End of variables declaration//GEN-END:variables
}

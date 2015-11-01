/**
 * Created by YWJamesLin on 2015/10/30.
 */
import com.sun.prism.Image;
import sun.misc.Cache;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.String;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends javax.swing.JFrame {

    int drawx, drawy, drawi, drawj, diffx, diffy, x, y;
    java.awt.Image[] image = new java.awt.Image[5];
    BasicBlock[][] scene = new BasicBlock[20][50];

    public static void main(String args[]) {
        new Main();
    }

    private Graphics grap;

    public Main () {
        int i, j;
        this.setTitle("Prototype_E");
        this.setSize(500, 330);
        this.setVisible(true);
        this.setResizable(false);
        this.addKeyListener(new KeyListener());

        for (i = 0; i < 5; ++ i) {
            String fname = "sources/" + Integer.toString (i + 1) + ".jpg";
            try {
                image[i] = ImageIO.read(new File (fname));
            } catch (Exception ex) {
                System.out.println (fname + " is not found.");
            }
        }
        for (i = 0; i < 20; ++ i) {
            for (j = 0; j < 50; ++ j) {
                scene[i][j] = new BasicBlock();
            }
        }
        x = 2500;
        y = 1000;
        drawView(x, y);
    }

    private void drawView (int x, int y) {
        grap = getGraphics();
        int lbx, lby, ubx, uby, begx, begy;
        lbx = x - 250 - (x - 250) % 100;
        lby = y - 150 - (y - 150) % 100;
        ubx = (x + 300) / 100;
        ubx *= 100;
        uby = (y + 200) / 100;
        uby *= 100;
        begx = lbx - (x - 250);
        begy = lby - (y - 150);
        int i, j, k, l;
        for (i = lbx, k=begx; i < ubx; i += 100, k += 100) {
            for (j = lby, l=begy; j < uby; j += 100, l += 100) {
                drawi = i / 100;
                drawj = j / 100;
                grap.drawImage(image[scene[drawj][drawi].getType()], k, l + 30, null);
            }
        }
    }

    class KeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();

            switch (k) {
                case KeyEvent.VK_UP:
                    if (y >= 175) {
                        y -= 25;
                        drawView(x, y);
                        System.out.println("UP");
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (y <= 1825) {
                        y += 25;
                        drawView(x, y);
                        System.out.println ("Down");
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (x >= 275) {
                        x -= 25;
                        drawView(x, y);
                        System.out.println("Left");
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (x <= 4725) {
                        x += 25;
                        drawView(x, y);
                        System.out.println("Right");
                    }
                    break;
            }
        }
    }
}

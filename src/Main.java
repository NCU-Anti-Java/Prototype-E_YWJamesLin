/**
 * Created by YWJamesLin on 2015/10/30.
 */
import com.sun.prism.Image;
import sun.misc.Cache;

import java.io.File;
import java.lang.String;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends javax.swing.JFrame {

    int drawx, drawy, drawi, drawj, diffx, diffy;
    java.awt.Image[] image = new java.awt.Image[5];
    BasicBlock[][] scene = new BasicBlock[20][50];

    public static void main(String args[]) {
        new Main();
    }

    public Main () {
        int x, y, i, j;
        this.setTitle("Prototype_E");
        this.setSize(1280, 720);
        this.setVisible(true);

        for (i = 0; i < 5; ++ i) {
            String fname = "sources/" + Integer.toString (i + 1) + ".jpg";
            try {
                image[i] = ImageIO.read(new File (fname));
            } catch (Exception ex) {
                System.out.println (fname + " is not found.");
            }
        }
        Graphics grap = getGraphics();
        for (i = 0; i < 20; ++ i) {
            for (j = 0; j < 50; ++ j) {
                scene[i][j] = new BasicBlock();
            }
        }
        x = 2500;
        y = 1000;
        diffx = x - 250;
        diffy = y - 150;
        for (i = x - 250; i < x + 250; i += 100) {
            for (j = y - 150; j < y + 150; j += 100) {
                drawi = Math.floorDiv(i, 100);
                drawj = Math.floorDiv(j, 100);
                drawx = i - diffx;
                drawy = j - diffy;
                update (grap);
            }
        }
    }

    public void paint (Graphics g) {
        g.drawImage(image[scene[drawj][drawi].getType()], drawx + 50, drawy + 50, null);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author grandj
 */
public class Canvas extends JPanel {

    ArrayList<MonPoint> listePoint;
    int taillePoint = 16;

    public Canvas() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        listePoint = new ArrayList<MonPoint>();
        EcouteurDeCanvas edc = new EcouteurDeCanvas(this);
        this.addMouseListener(edc);
        this.addMouseMotionListener(edc);
        this.addMouseWheelListener(edc);
    }

    public MonPoint ajouterPoint(Point point) {
        MonPoint mp = new MonPoint(this, point);
        listePoint.add(mp);
        return mp;
    }

    public void remiseAZero() {
        for (int i = 0; i < listePoint.size(); i++) {
            this.remove(listePoint.get(i));
        }

        listePoint.clear();
        this.repaint();
    }

    public void tracerCtrl(Graphics2D d, Point p1, Point ctrl1) {
        d.setColor(Color.red);
        d.drawLine(p1.x, p1.y, ctrl1.x, ctrl1.y);
        d.drawOval(ctrl1.x - taillePoint / 8,
                ctrl1.y - taillePoint / 8,
                taillePoint / 4,
                taillePoint / 4);
        d.setColor(Color.black);
    }

    public void tracerLignes(Graphics2D d) {
        if (listePoint.size() < 1) {
            return;
        }
        // dessiner lignes
        MonPoint courant;
        MonPoint ancien = listePoint.get(0);
        Point p1, p2, ctrl1, ctrl2;
        CubicCurve2D curve;
        if (ancien.getCtrl() != null) {
            p1 = new Point(ancien.getX() + taillePoint / 2,
                    ancien.getY() + taillePoint / 2);
            ctrl1 = ancien.getCtrl();
            tracerCtrl(d, p1, ctrl1);
        }
        for (int i = 1; i < listePoint.size(); i++) {
            courant = listePoint.get(i);
            if (ancien.getCtrl() != null) {
                p1 = new Point(ancien.getX() + taillePoint / 2,
                        ancien.getY() + taillePoint / 2);
                ctrl1 = ancien.getCtrl();
                tracerCtrl(d, p1, ctrl1);

                if (courant.getCtrl() != null) {
                    p2 = new Point(courant.getX() + taillePoint / 2,
                            courant.getY() + taillePoint / 2);
                    ctrl2 = courant.getCtrlInverse();

                    curve = new CubicCurve2D.Double(
                            p1.x, p1.y,
                            ctrl1.x, ctrl1.y,
                            ctrl2.x, ctrl2.y,
                            p2.x, p2.y);
                    d.draw(curve);
                    tracerCtrl(d, p2, ctrl2);
                    ctrl2 = courant.getCtrl();
                    tracerCtrl(d, p2, ctrl2);
                }

                ancien = courant;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d = (Graphics2D) g;
        // effacer lignes
        repaint();
        tracerLignes(d);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author grandj
 */
public class MonPoint extends JPanel {

    Canvas can;
    Point p;
    Dimension dim;
    Point ctrl;
    JPanel panelCtrl;

    public MonPoint(Canvas c, Point pp) {
        this.can = c;
        this.ctrl = null;
        this.setBackground(Color.BLACK);
        dim = new Dimension(can.taillePoint, can.taillePoint);
        this.setSize(dim);
        setPoint(pp);
        //Ajout au canvas
        can.add(this);
        //ajout des écouteurs
        EcouteurDePoint e = new EcouteurDePoint(this);
        this.addMouseListener(e);
        this.addMouseMotionListener(e);
        this.addMouseWheelListener(e);
    }

    public void setPoint(Point pp) {
        this.p = pp;
        int placeW = (int) (p.x - (dim.getWidth() / 2));
        int placeH = (int) (p.y - (dim.getHeight() / 2));
        this.setLocation(placeW, placeH);
    }

    public Point getPoint() {
        return p;
    }

    public void setCtrl(Point ctrl) {
        this.ctrl = ctrl;
        if (panelCtrl == null) {
            panelCtrl = new JPanel();
            panelCtrl.setBackground(Color.red);
            panelCtrl.setSize(can.taillePoint / 2, can.taillePoint / 2);
            EcouteurDeCtrl e = new EcouteurDeCtrl(can, this);
            panelCtrl.addMouseListener(e);
            panelCtrl.addMouseMotionListener(e);
            can.add(panelCtrl);
        }
        panelCtrl.setLocation(
                ctrl.x - can.taillePoint / 4,
                ctrl.y - can.taillePoint / 4);
        can.repaint();
    }

    public Point getCtrl() {
        return ctrl;
    }

    public Point getCtrlInverse() {
        Point ret = new Point(p);

        int dx = Math.abs(ctrl.x - p.x);
        int dy = Math.abs(ctrl.y - p.y);

        if (ctrl.x < p.x) {
            ret.x += dx;
        } else {
            ret.x -= dx;
        }

        if (ctrl.y < p.y) {
            ret.y += dy;
        } else {
            ret.y -= dy;
        }

        return ret;
    }
}

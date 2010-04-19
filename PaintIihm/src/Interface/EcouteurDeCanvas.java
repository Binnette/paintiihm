/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author grandj
 */
public class EcouteurDeCanvas extends MouseInputAdapter {

    Canvas can;
    MonPoint courant;

    public EcouteurDeCanvas(Canvas c) {
        can = c;
        courant = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if(courant != null){
            courant.setCtrl(e.getPoint());
            can.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Point p = e.getPoint();
        if (p.x - can.taillePoint / 2 < 0) {
            p.x = can.taillePoint / 2;
        }
        if (p.y - can.taillePoint / 2 < 0) {
            p.y = can.taillePoint / 2;
        }
        if (p.x + can.taillePoint / 2 > can.getWidth()) {
            p.x = can.getWidth() - can.taillePoint / 2;
        }
        if (p.y + can.taillePoint / 2 > can.getHeight()) {
            p.y = can.getHeight() - can.taillePoint / 2;
        }
        courant = can.ajouterPoint(p);
        courant.setCtrl(p);
        can.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Point p = e.getPoint();
        if (p.x - can.taillePoint / 2 < 0) {
            p.x = can.taillePoint / 2;
        }
        if (p.y - can.taillePoint / 2 < 0) {
            p.y = can.taillePoint / 2;
        }
        if (p.x + can.taillePoint / 2 > can.getWidth()) {
            p.x = can.getWidth() - can.taillePoint / 2;
        }
        if (p.y + can.taillePoint / 2 > can.getHeight()) {
            p.y = can.getHeight() - can.taillePoint / 2;
        }

        courant.setCtrl(p);
        can.repaint();

    }
}

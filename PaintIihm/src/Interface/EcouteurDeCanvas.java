/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author grandj
 */
public class EcouteurDeCanvas extends MouseInputAdapter {

    Canvas can;

    public EcouteurDeCanvas(Canvas c) {
        can = c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Point p = e.getPoint();
        System.out.println("before " + p);
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
        System.out.println("after " + p);

        can.ajouterPoint(p);
        can.repaint();
    }
}

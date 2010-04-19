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
 * @author manoela
 */
public class EcouteurDeCtrl extends MouseInputAdapter {

    MonPoint monPoint;
    Point pointInit;
    Canvas can;
    State etat;

    public enum State {

        INIT, PRESSED, DRAGGED
    };

    public EcouteurDeCtrl(Canvas can, MonPoint mp) {
        this.can = can;
        this.monPoint = mp;
        etat = State.INIT;
        pointInit = new Point(0, 0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        switch (etat) {
            case INIT:
                etat = State.PRESSED;
                pointInit = monPoint.getLocation();
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Point canv = can.getLocationOnScreen();
        canv.x += (int) (monPoint.panelCtrl.getWidth() / 2);
        canv.y += (int) (monPoint.panelCtrl.getHeight() / 2);
        Point fin = e.getLocationOnScreen();

        fin.x -= canv.x;
        fin.y -= canv.y;
        switch (etat) {
            case PRESSED:
                etat = State.DRAGGED;
                break;

            case DRAGGED:
                calculPoint(fin);
                monPoint.setCtrl(fin);
                pointInit = monPoint.getLocation();
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Point canv = monPoint.can.getLocationOnScreen();
        canv.x += (int) (monPoint.panelCtrl.getWidth() / 2);
        canv.y += (int) (monPoint.panelCtrl.getHeight() / 2);
        Point fin = e.getLocationOnScreen();
        fin.x -= canv.x;
        fin.y -= canv.y;
        switch (etat) {
            case DRAGGED:
                etat = State.INIT;
                calculPoint(fin);
                monPoint.setCtrl(fin);
                break;
        }
    }

    public void calculPoint(Point fin) {
        fin.x -= pointInit.x;
        fin.y -= pointInit.y;
        fin.x += monPoint.p.x;
        fin.y += monPoint.p.y;
        if (fin.x - monPoint.panelCtrl.getWidth() / 2 < 0) {
            fin.x = monPoint.panelCtrl.getWidth() / 2;
        }
        if (fin.y - monPoint.panelCtrl.getHeight() / 2 < 0) {
            fin.y = monPoint.panelCtrl.getHeight() / 2;
        }
        if (fin.x + monPoint.panelCtrl.getWidth() / 2 > monPoint.can.getWidth()) {
            fin.x = monPoint.can.getWidth() - monPoint.panelCtrl.getWidth() / 2;
        }
        if (fin.y + monPoint.panelCtrl.getHeight() / 2 > monPoint.can.getHeight()) {
            fin.y = monPoint.can.getHeight() - monPoint.panelCtrl.getHeight() / 2;
        }

    }

}

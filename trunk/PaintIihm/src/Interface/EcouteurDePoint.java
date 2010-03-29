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
public class EcouteurDePoint extends MouseInputAdapter {

    MonPoint monPoint;
    Point pointInit;
    State etat;

    public enum State {
        INIT, PRESSED, DRAGGED
    };

    public EcouteurDePoint(MonPoint mp) {
        monPoint = mp;
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
        Point canv = monPoint.c.getLocationOnScreen() ;
        canv.x += (int)(monPoint.dim.getWidth()/2);
        canv.y += (int)(monPoint.dim.getHeight()/2);
        Point fin = e.getLocationOnScreen();

        fin.x -= canv.x;
        fin.y -= canv.y;
        switch (etat) {
            case PRESSED:
                etat = State.DRAGGED;
                break;

            case DRAGGED:
                calculPoint(fin);
                monPoint.setPoint(fin);
                pointInit = monPoint.getLocation();
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        Point canv = monPoint.c.getLocationOnScreen() ;
        canv.x += (int)(monPoint.dim.getWidth()/2);
        canv.y += (int)(monPoint.dim.getHeight()/2);
        Point fin = e.getLocationOnScreen();
        fin.x -= canv.x;
        fin.y -= canv.y;
        switch (etat) {
            case DRAGGED:
                etat = State.INIT;
                calculPoint(fin);
                monPoint.setPoint(fin);
                break;
        }
    }

    public void calculPoint(Point fin) {
        fin.x -= pointInit.x;
        fin.y -= pointInit.y;
        fin.x += monPoint.p.x;
        fin.y += monPoint.p.y;
        if (fin.x - monPoint.getWidth() / 2 < 0) {
            fin.x = monPoint.getWidth()/2;
        }
        if (fin.y - monPoint.getHeight() / 2 < 0) {
            fin.y = monPoint.getHeight() / 2;
        }
        if (fin.x + monPoint.getWidth() / 2 > monPoint.c.getWidth()) {
            fin.x = monPoint.c.getWidth() - monPoint.getWidth() / 2;
        }
        if (fin.y + monPoint.getHeight() / 2 > monPoint.c.getHeight()) {
            fin.y = monPoint.c.getHeight() - monPoint.getHeight() / 2;
        }

    }
}


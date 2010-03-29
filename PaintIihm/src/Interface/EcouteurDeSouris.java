/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author grandj
 */
public class EcouteurDeSouris extends MouseInputAdapter {

    Canvas dessin;

    public EcouteurDeSouris(Canvas p){
        dessin = p;
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
        //System.out.println("eee 2 "+e.getLocationOnScreen());
        dessin.ajouterPoint(e.getPoint());
        dessin.repaint();
    }

}

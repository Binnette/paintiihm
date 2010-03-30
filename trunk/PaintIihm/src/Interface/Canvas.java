/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author grandj
 */
public class Canvas extends JPanel {

    ArrayList<MonPoint> listePoint;
    int taillePoint = 20;

    public Canvas() {
        // ppté canvas
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        listePoint = new ArrayList<MonPoint>();
        EcouteurDeCanvas edc = new EcouteurDeCanvas(this);
        this.addMouseListener(edc);
        this.addMouseMotionListener(edc);
        this.addMouseWheelListener(edc);
    }

    public void ajouterPoint(Point point) {
        MonPoint mp = new MonPoint(this, point);
        listePoint.add(mp);
    }

    public void remiseAZero() {
        for (int i = 0; i < listePoint.size(); i++) {
            this.remove(listePoint.get(i));
        }

        listePoint.clear();
        this.repaint();
    }
}

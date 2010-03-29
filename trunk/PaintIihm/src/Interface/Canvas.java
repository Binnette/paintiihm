/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author grandj
 */
public class Canvas extends JPanel{

    ArrayList<MonPoint> listePoint;
    static final int tailleCarré = 10;

    public Canvas() {
        // ppté canvas
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        listePoint = new ArrayList<MonPoint>();
        EcouteurDeSouris edc = new EcouteurDeSouris(this);
        this.addMouseListener(edc);
        this.addMouseMotionListener(edc);
        this.addMouseWheelListener(edc);
    }

    public void ajouterPoint(Point point) {
        MonPoint mp = new MonPoint(this, point);
        listePoint.add(mp);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*Graphics2D d = (Graphics2D) g;
        MonPoint p;
        for (int i=0; i<listePoint.size();i++){
            p = listePoint.get(i);
            //d.fillRect(p.x-tailleCarré , p.y-tailleCarré , tailleCarré * 2, tailleCarré * 2);
            
        }*/
    }

    public void remiseAZero() {
        listePoint.clear();
        this.repaint();
    }

}

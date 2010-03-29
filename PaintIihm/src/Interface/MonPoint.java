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
public class MonPoint extends JPanel{
    Canvas c;
    Point p;
    Dimension dim;
    public MonPoint(Canvas c, Point pp){
        this.c = c;
        dim = new Dimension(20, 20);
        this.setBackground(Color.BLACK);
        this.setSize(dim);
        setPoint(pp);
        //Ajout au canvas
        c.add(this);
        //ajout des écouteurs
        EcouteurDePoint e = new EcouteurDePoint(this);
        this.addMouseListener(e);
        this.addMouseMotionListener(e);
        this.addMouseWheelListener(e);
    }

    public void setPoint(Point pp){
        this.p = pp;
        int placeW = (int) (p.x - (dim.getWidth() / 2));
        int placeH = (int) (p.y - (dim.getHeight() / 2));
        this.setLocation(placeW, placeH);
        //System.out.println(pp);
        //this.setLocation(p.x - (int)dim.height, p.y - (int) dim.width);
        //this.setLocation(p.x , p.y );
       //c.repaint();
    }

}

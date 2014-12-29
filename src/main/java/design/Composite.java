package design;

import java.util.List;
import java.util.ArrayList;

public class Composite {

    public static void main(String[] args) {

        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();
 
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
 
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
 
        graphic2.add(ellipse4);
 
        graphic.add(graphic1);
        graphic.add(graphic2);
 
        graphic.print();
    }
}

interface Graphic {
    public void print();
}
 
class Ellipse implements Graphic {
    public void print() {
        System.out.println("Ellipse");
    }
}

class CompositeGraphic implements Graphic {
 
    private List<Graphic> childGraphics = new ArrayList<Graphic>();
 
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }
 
    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }
 
    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }
}
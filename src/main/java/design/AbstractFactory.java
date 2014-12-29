package design;

public class AbstractFactory {

    public static void main(String[] args) {
    	int sys = 0;
    	if (args.length>0) {
    		sys = 1; //args[0];
    	}
        new Application(createOsSpecificFactory(sys));
    }
 
    public static GUIFactory createOsSpecificFactory(int sys) {
//        int sys = readFromConfigFile("OS_TYPE");
        if (sys == 0) return new WinFactory();
        else return new OSXFactory();
    }
}

interface Button {
    void paint();
}
 
interface GUIFactory {
    Button createButton();
}
 
class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
}
 
class OSXFactory implements GUIFactory {
    public Button createButton() {
        return new OSXButton();
    }
}
 
class WinButton implements Button {
    public void paint() {
        System.out.println("I'm a WinButton");
    }
}
 
class OSXButton implements Button {
    public void paint() {
        System.out.println("I'm an OSXButton");
    }
}
 
class Application {
    public Application(GUIFactory factory) {
        Button button = factory.createButton();
        button.paint();
    }
}
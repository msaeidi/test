package design;

import java.io.IOException;

public class LazyInitializationSingleton {

    private static volatile LazyInitializationSingleton instance = null;

    private LazyInitializationSingleton() {       }

    public static LazyInitializationSingleton getInstance() {
            if (instance == null) {
                    synchronized (LazyInitializationSingleton .class){
                            if (instance == null) {
                                    instance = new LazyInitializationSingleton ();
                            }
                  }
            }
            return instance;
    }
}

class EagerInitializationSingleton {
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();
 
    private EagerInitializationSingleton() {}
 
    public static EagerInitializationSingleton getInstance() {
        return instance;
    }
}

class StaticBlockInitializationSingleton {
	  private static final StaticBlockInitializationSingleton instance;
	 
	  static {
//	    try {
	      instance = new StaticBlockInitializationSingleton();
//	    } catch (IOException e) {
//	      throw new RuntimeException("Darn, an error occurred!", e);
//	    }
	  }
	 
	  public static StaticBlockInitializationSingleton getInstance() {
	    return instance;
	  }
	 
	  private StaticBlockInitializationSingleton() {
	    // ...
	  }
}

class BillPughSingleton {
    // Private constructor prevents instantiation from other classes
    private BillPughSingleton() { }

    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
            return SingletonHolder.INSTANCE;
    }
}

enum EnumSingleton {
    INSTANCE;
    public void execute (String arg) {
            //... perform operation here ...
    }
}

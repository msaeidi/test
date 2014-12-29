package singleton;

public final class EagerSingleton {
   
	private static volatile EagerSingleton INSTANCE;
    
	private EagerSingleton() {}
    
	public static EagerSingleton getInstance() {
        if(INSTANCE == null) {
           synchronized(EagerSingleton.class) {
               if(INSTANCE == null) {
                   INSTANCE = new EagerSingleton();
               }
           }
        }
        return INSTANCE;
    }
    //Access by EagerSingleton.getInstance()
}


package singleton;

public final class LazySingleton {
    private static volatile LazySingleton INSTANCE;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if(INSTANCE == null) {
           synchronized(LazySingleton.class) {
               if(INSTANCE == null) {
                   INSTANCE = new LazySingleton();
               }
           }
        }
        return INSTANCE;
    }
    //Access by LazySingleton.getInstance()
}


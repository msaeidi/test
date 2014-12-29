package singleton;

public enum Singleton {
	//Serialization is guaranteed by JVM
	//thread-safety is guaranteed
	INSTANCE;
	//Access by Singleton.INSTANCE
}

//public final class Sing {
final class Eager {
	//initialized during class loading
	private static final Eager INSTANCE = new Eager();
	private Eager() {}
	public static Eager getIntance() {
		return INSTANCE;
	}
    //Access by Eager.getInstance()
    //readResolve to prevent another instance of Singleton
    private Object readResolve() {
        return INSTANCE;
    }
}

//public final class LazySingleton {
final class Lazy {
    private static volatile Lazy INSTANCE;
    private Lazy() {}
    public static Lazy getInstance() {
        if(INSTANCE == null) {
           synchronized(Lazy.class) {
               if(INSTANCE == null) {
                   INSTANCE = new Lazy();
               }
           }
        }
        return INSTANCE;
    }
    //Access by Lazy.getInstance()
}


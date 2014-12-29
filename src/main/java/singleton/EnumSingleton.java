package singleton;

public enum EnumSingleton {
	//Serialization is guaranteed by JVM
	//thread-safety is guaranteed
	INSTANCE;
	//Access by EnumSingleton.INSTANCE
}
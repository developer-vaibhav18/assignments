package designPattern.singeltonDesignPattern;

public class SingletonDesignPatternLazy {
    public static SingletonDesignPatternLazy instance;
    public static SingletonDesignPatternLazy getInstance() {
        if (instance == null)
            return instance = new SingletonDesignPatternLazy();
        return instance;
    }
    private SingletonDesignPatternLazy() {

    };
}

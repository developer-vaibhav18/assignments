package designPattern.singeltonDesignPattern;

public class SingeltonDesignPatternEager {
    public static SingeltonDesignPatternEager instance = new SingeltonDesignPatternEager();
    public static SingeltonDesignPatternEager getInstance() {
        return instance;
    }
    private SingeltonDesignPatternEager() {

    };

}

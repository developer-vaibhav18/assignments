package designPattern.obseverDesignPattern;

/**
 * Observer Pattern is used when there are several observers for any particular information to change.
 * For Example, in flipkart site we have notify me button for products that are out of stock and it will
 * notify everyone who have clicked on the button once it gets into the stock.
 */
public interface Observable {
    void notifyAllObservers();
    void addObserver(Observer observer);
    void setData(int newData);
}

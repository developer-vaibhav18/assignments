package designPattern.obseverDesignPattern;

import java.util.List;

public class ObservableImpl implements Observable{
    int data;
    List<Observer> observerList;
    @Override
    public void notifyAllObservers() {
        System.out.println("data updated");
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void setData(int newData) {
        if (newData != data) {
            notifyAllObservers();
        }
        data = newData;
    }
}

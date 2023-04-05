package designPattern.strategyDesignPattern;

/**
 * Strategy pattern used when some base class implement any method in one way and other in different way,
 * but they will have something in common. For Example, here shape of cars is same thus SportsCar and NormalCar will
 * have same implementation of shape() method but bikes(Sports and Normal) will have different implementation.
 * Thus, there will be redundant code for both type of Bike and both type of Car. So, we can make another interface
 * which will have implementation for car type shape and bike type shape, here it is shapeOfVehicleInterface.
 */
public interface Vehicle {
    void shape();
}

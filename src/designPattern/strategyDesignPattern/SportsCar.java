package designPattern.strategyDesignPattern;

public class SportsCar implements Vehicle{

    @Override
    public void shape() {
        ShapeOfVehicleInterface shape = new ShapeOfCar();
        shape.shape();
    }
}

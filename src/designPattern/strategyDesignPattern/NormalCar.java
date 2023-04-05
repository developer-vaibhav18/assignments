package designPattern.strategyDesignPattern;

public class NormalCar implements Vehicle{

    @Override
    public void shape() {
        ShapeOfVehicleInterface shape = new ShapeOfCar();
    }
}

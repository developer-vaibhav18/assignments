package designPattern.strategyDesignPattern;

public class NormalBike implements Vehicle{

    @Override
    public void shape() {
        ShapeOfVehicleInterface shape = new ShapeOfBike();
        shape.shape();
    }
}

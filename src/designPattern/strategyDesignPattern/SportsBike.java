package designPattern.strategyDesignPattern;

public class SportsBike implements Vehicle{

    @Override
    public void shape() {
        ShapeOfVehicleInterface shape = new ShapeOfBike();
        shape.shape();
    }
}

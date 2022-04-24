package designpattern;

public class FactoryPattern {
  public static void main(String[] args) {
    SeaLogisticFactory seaLogisticFactory = new SeaLogisticFactory();
    Transport truck = seaLogisticFactory.createTransport("truck");
    if (truck == null) {
      System.out.println("not implemented for truck in sea");
    }
    seaLogisticFactory.createTransport("ship");

    RoadLogisticFactory roadLogisticFactory = new RoadLogisticFactory();
    Transport bike = roadLogisticFactory.createTransport("bike");
    bike.deliver();
  }
}


interface Transport {
  void deliver();
}


class Plane implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by Plane");
  }
}


class Ship implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by Ship");
  }
}


class Truck implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by Truck");
  }
}


class Bike implements Transport {

  @Override
  public void deliver() {
    System.out.println("Deliver by Bike");
  }
}


abstract class LogisticFactory {
  abstract Transport createTransport(String type);
}


class SeaLogisticFactory extends LogisticFactory {

  @Override
  Transport createTransport(String type) {
    if (type.equals("ship")) {
      return new Ship();
    }
    return null;
  }
}


class RoadLogisticFactory extends LogisticFactory {
  public Transport createTransport(String type) {
    if ("truck".equals(type)) {
      return new Truck();
    } else if ("bike".equals(type)) {
      return new Bike();
    }
    return null;
  }
}

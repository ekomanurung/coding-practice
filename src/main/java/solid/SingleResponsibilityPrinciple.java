package solid;

class Car {
  public void turnOn() {
    System.out.println("turn on the car");
  }
}

public class SingleResponsibilityPrinciple {
  public static void main(String[] args) {
    Car car = new Car();
    car.turnOn();
  }
}

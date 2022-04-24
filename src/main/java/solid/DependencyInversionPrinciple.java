package solid;

class StandardKeyboard implements Keyboard {
  private int numberOfTuts;

  @Override
  public int getNumberOfTuts() {
    return numberOfTuts;
  }

  @Override
  public String toString() {
    return "StandardKeyboard{" +
        "numberOfTuts=" + numberOfTuts +
        '}';
  }
}


class RGBMonitor implements Monitor {

  @Override
  public String getModel() {
    return "RGB";
  }
}


/**
 * depend on abstraction, no concretion
 * avoid coupling, use decoupling
 */
//class PersonalComputer {
//  private final StandardKeyboard standardKeyboard;
//  private final RGBMonitor rgbMonitor;
//
//  public PersonalComputer() {
//    this.standardKeyboard = new StandardKeyboard();
//    this.rgbMonitor = new RGBMonitor();
//  }
//}

interface Keyboard {
  int getNumberOfTuts();
}


interface Monitor {
  String getModel();
}


class PersonalComputer {
  private final Monitor monitor;
  private final Keyboard keyboard;

  public PersonalComputer(Monitor monitor, Keyboard keyboard) {
    this.monitor = monitor;
    this.keyboard = keyboard;
  }

  @Override
  public String toString() {
    return "PersonalComputer{" +
        "monitor=" + monitor +
        ", keyboard=" + keyboard +
        '}';
  }
}


class LEDMonitor implements Monitor {

  @Override
  public String getModel() {
    return "LED";
  }
}


class BluetoothKeyboard implements Keyboard {

  @Override
  public int getNumberOfTuts() {
    return 0;
  }
}


public class DependencyInversionPrinciple {
  public static void main(String[] args) {
    Monitor oldMonitor = new RGBMonitor();
    Keyboard oldKeyboard = new StandardKeyboard();
    PersonalComputer myOldPC = new PersonalComputer(oldMonitor, oldKeyboard);
    System.out.println(myOldPC);

    Monitor newMonitor = new LEDMonitor();
    PersonalComputer newPC = new PersonalComputer(newMonitor, oldKeyboard);
    System.out.println(newPC);
  }
}

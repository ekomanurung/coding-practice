package solid;

class Guitar {
  private String model;
  private String make;
  private int volume;

  public Guitar(String model, String make, int volume) {
    this.model = model;
    this.make = make;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "Guitar{" +
        "model='" + model + '\'' +
        ", make='" + make + '\'' +
        ", volume=" + volume +
        '}';
  }
}


/**
 * create new class and extend the base class so we are not modifying existing behaviour
 * open for extension, close for modification
 */
class GuitarWithFlames extends Guitar {
  private String flameColor;

  public GuitarWithFlames(String model, String make, int volume, String flameColor) {
    super(model, make, volume);
    this.flameColor = flameColor;
  }

  @Override
  public String toString() {
    return super.toString() + "GuitarWithFlames{" +
        "flameColor='" + flameColor + '\'' +
        '}';
  }
}


public class OpenClosedPrinciple {
  public static void main(String[] args) {
    Guitar standard = new Guitar("Gibson", "US", 10);
    GuitarWithFlames guitarWithFlames = new GuitarWithFlames("PRS", "US", 8, "blue");

    System.out.println(standard);
    System.out.println(guitarWithFlames);

  }
}

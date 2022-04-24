package designpattern;

public class BuilderPattern {

  public static void main(String[] args) {
    Student eko =
        new Student.StudentBuilder().buildName("Eko").buildNik("1050").buildAge(10).build();
    System.out.println(eko.toString());
  }

  public static class Student {
    private final String name;
    private final int age;
    private final String nik;

    private Student(StudentBuilder builder) {
      this.name = builder.name;
      this.nik = builder.nik;
      this.age = builder.age;
    }

    @Override
    public String toString() {
      return "Student{" +
          "name='" + name + '\'' +
          ", age=" + age +
          ", nik='" + nik + '\'' +
          '}';
    }

    public static class StudentBuilder {
      private String name;
      private int age;
      private String nik;

      public StudentBuilder buildName(String name) {
        this.name = name;
        return this;
      }

      public StudentBuilder buildAge(int age) {
        this.age = age;
        return this;
      }

      public StudentBuilder buildNik(String nik) {
        this.nik = nik;
        return this;
      }

      public Student build() {
        return new Student(this);
      }
    }
  }
}

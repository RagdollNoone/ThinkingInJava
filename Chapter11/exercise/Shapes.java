package master.Chapter11.exercise;
import java.util.*;

import static master.Common.Print.print;

abstract class Shape {
  void draw() { System.out.println(this + ".draw()"); }

  void rotate(Shape shape)
  {
    if (shape instanceof Circle) {
      print("Rotate Circle");
      return;
    }

    print("Nothing To Rotate");
  }

  abstract public String toString();
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

// new add
class Rhomboid extends Shape{
  public String toString() { return "Rhomboid"; }
}

public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle(), new Rhomboid()
    );


    for(Shape shape : shapeList) {

      // new add
//      if (shape instanceof Rhomboid)
//      {
//        try {
//          Circle circle = (Circle) shape;
//        }
//        catch(Exception e)
//        {
//          e.printStackTrace();
//        }
//      }

      // new add
      shape.rotate(shape);


      shape.draw();
    }
  }
}
/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

package master.Chapter11.exercise;
import static master.Common.Print.print;

class Candy {
  static { print("Loading Candy"); }
}

class Gum {
  static { print("Loading Gum"); }
}

class Cookie {
  static { print("Loading Cookie"); }
}

public class SweetShop {
  public static void main(String[] args) {
    // new add
    try {
        Class c = Class.forName(args[0]);
        c.newInstance();
    } catch (ClassNotFoundException e){
        print("Not Found " + args[0]);
    } catch (IllegalAccessException e) {
        print("IllegalAccessException Occur");
    } catch (InstantiationException e){
        print("InstantiationException Occur");
    }

    print("inside main");

    new Candy();

    print("After creating Candy");

    try {
      Class.forName("Gum");
    } catch(ClassNotFoundException e) {
      print("Couldn't find Gum");
    }

    print("After Class.forName(\"Gum\")");

    new Cookie();

    print("After creating Cookie");
  }
}
/* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
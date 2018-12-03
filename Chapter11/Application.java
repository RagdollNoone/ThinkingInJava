package master.Chapter11;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Vector;
import master.Common.Print;

public class Application {
    private static Vector m_shapeVec = new Vector();

    public static void main(String[] args)
    {
        try {
//            print();
//            constructShapes();
//            usgeOfClass();
//            testFindInheritObject();
            testPrintField();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void print()
    {
        m_shapeVec.clear();

        m_shapeVec.addElement(new Circle());
        m_shapeVec.addElement(new Square());
        m_shapeVec.addElement(new Triangle());

        Enumeration e = m_shapeVec.elements();
        while(e.hasMoreElements()) {

            Shape s = (Shape) e.nextElement();
            if (s instanceof Circle)
                s.draw();
        }
    }

    public static void constructShapes()
    {
        m_shapeVec.clear();

        Class[] shapeTypes = {
                Circle.class,
                Square.class,
                Triangle.class
        };

        try {
            for (int i = 0; i < 3; i++)
                shapeTypes[i].newInstance();
        }
        catch(InstantiationException e) {}
        catch (IllegalAccessException e) {}
    }

    public static void usgeOfClass()
    {
        Enumeration e = m_shapeVec.elements();
        while(e.hasMoreElements()) {
            Shape s = (Shape) e.nextElement();
            Class c = s.getClass();
            System.out.println(c.getName() + "is a interface " + c.isInterface());
            Method[] methods = c.getMethods();

            try {
                methods[0].invoke(s);
            }
            catch (IllegalAccessException ex) {}
            catch (InvocationTargetException ex) {}
        }
    }

    public static void testFindInheritObject()
    {
        class Base {}
        class A extends Base {}
        class B extends A {}
        class C extends B {}

        C o = new C();

        findInheritObject(o);
    }

    public static void findInheritObject(Object o)
    {
        Class classType = o.getClass();

        while (null != classType && null != classType.getSuperclass())
        {
            System.out.println("Inherit From Object " + classType.getSuperclass().getSimpleName());
            classType = classType.getSuperclass();
        }
    }

    public static void testPrintField()
    {
        class Base{
            public float f;
        }

        class B extends Base{
            public float f;
        }

        class A {
            public int i;
            public double d;
            public B b;

            private float f;
        }

        A object = new A();
        printField(object);
    }

    public static void printField(Object o)
    {
        Class classType = o.getClass();

        if (null != classType)
        {
            Field[] fieldsArr = classType.getFields();

            for(int i =0; i < fieldsArr.length; i++) {
                Class fieldClassInfo = fieldsArr[i].getType();
                master.Common.Print.print("FieldName: " + fieldsArr[i].getName() + " Field Type: " + fieldClassInfo.getSimpleName());

                while (null != fieldClassInfo && null != fieldClassInfo.getSuperclass())
                {
                    System.out.println("Inherit From Object " + fieldClassInfo.getSuperclass().getSimpleName());
                    fieldClassInfo = fieldClassInfo.getSuperclass();
                }
            }
        }
    }

    public static void testObjectOrCharArray()
    {
        class Base{
            int i = 1;
        }

        Base Object = new Base();

    }
}

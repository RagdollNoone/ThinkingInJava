package master.Chapter11.exercise.Coffee;

import master.Chapter11.exercise.Factory.Factory;

abstract public class Coffee
implements Factory<Coffee>{
  private static long counter = 0;
  private final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }

  abstract public Coffee create();
} ///:~

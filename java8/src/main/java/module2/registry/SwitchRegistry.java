package module2.registry;

import module2.factory.Factory;
import module2.model.*;

public class SwitchRegistry {
   public Factory<? extends Shape> buildShapeFactory(String shape) {
      switch (shape) {
         case "square":
            return () -> new Square();
         case "rectangle":
            return () -> new Rectangle();
         case "triangle":
            return () -> new Triangle();
         case "circle":
            return () -> new Circle();
         default:
            throw new IllegalArgumentException("Unknown shape " + shape);
      }
   }
}

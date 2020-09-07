package module2.registry;

import module2.factory.Factory;
import module2.model.Rectangle;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class SwitchRegistryTest {
   @Test
   public void testSwitchRegistry() {
      SwitchRegistry registry = new SwitchRegistry();

      Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

      System.out.println("Rectangle : " + rectangleFactory.newInstance());
   }
}
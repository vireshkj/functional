package module2.registry;

import module2.builder.Builder;
import module2.factory.Factory;
import module2.model.Rectangle;
import module2.model.Shape;
import module2.model.Triangle;
import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class RegistryTest {
   @Test
   public void testRegistry() {

      Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);
      Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);

      Consumer<Builder<Shape>> builderConsumer = consumer1.andThen(consumer2);

      Registry registry = Registry.createRegistry(builderConsumer);

      Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
      Factory<Triangle> triangleFactory = (Factory<Triangle>) registry.buildShapeFactory("triangle");

      System.out.println("Rectangle = " + rectangleFactory.newInstance());
      System.out.println("Triangle = " + triangleFactory.newInstance());
   }
}
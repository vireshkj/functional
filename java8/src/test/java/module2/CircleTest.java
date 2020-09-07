package module2;

import module2.factory.Factory;
import module2.model.Circle;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.List;

public class CircleTest {
   @Test
   public void testCircleFactory() {
      Factory<Circle> factory1 = Factory.createFactory(Circle::new, Color.RED);
      Factory<Circle> factory2 = Factory.createFactory(Circle::new);

      Circle circle = factory1.newInstance();

      System.out.println("Circle = " + circle);

      List<Circle> list = factory1.create5();

      Assert.assertThat(list.size(), Is.is(5));
      System.out.println("List = " + list);
   }
}
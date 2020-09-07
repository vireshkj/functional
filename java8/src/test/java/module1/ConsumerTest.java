package module1;

import module1.Consumer;
import org.junit.Test;

public class ConsumerTest {

   @Test
   public void useConsumer() {
      Consumer<String> c1 = s -> System.out.println("c1 = " + s);
      Consumer<String> c2 = s -> System.out.println("c2 = " + s);

      c1.accept("Hello");
      c2.accept("Hello2");
   }

   @Test
   public void chainConsumer() {
      Consumer<String> c1 = s -> System.out.println("c1 = " + s);
      Consumer<String> c2 = s -> System.out.println("c2 = " + s);

      Consumer<String> c3 = s -> {
         c1.accept(s);
         c2.accept(s);
      };

      Consumer<String> c4 = c1.andThen(c2);

      c4.accept("Hello");
   }
}
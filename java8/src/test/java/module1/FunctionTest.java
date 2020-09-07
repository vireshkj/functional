package module1;

import module1.Function;
import module1.Meteo;
import org.junit.Test;

public class FunctionTest {
   @Test
   public void testFunction() {
      Meteo meteo = new Meteo(23);
      Function<Meteo, Integer> celsius = Meteo::getTemperature;
      Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32;

      Function<Meteo, Double> fahrenHeit = celsius.andThen(celsiusToFahrenheit);

      System.out.println("module1.Meteo in fahrenheit " + fahrenHeit.apply(meteo));


   }

   @Test
   public void composeFunction() {
      Meteo meteo = new Meteo(23);
      Function<Meteo, Integer> celsius = Meteo::getTemperature;
      Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32;

      Function<Meteo, Double> fahrenHeit = celsiusToFahrenheit.composing(celsius);

      System.out.println("module1.Meteo in fahrenheit " + fahrenHeit.apply(meteo));
   }

   @Test
   public void multiComposeFunction() {
      Meteo meteo = new Meteo(23);
      Function<Meteo, Integer> celsius = Meteo::getTemperature;
      Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32;
      Function<Double, Integer> fahrenheitToCelsius = t -> (int) ((t-32)*5d/9d);
      Function<Meteo, Double> fahrenHeit = celsiusToFahrenheit.composing(celsius);


      Function<Meteo, Integer> meteoIntegerFunction = celsiusToFahrenheit.composing(celsius).andThen(fahrenheitToCelsius);

      System.out.println("module1.Meteo in celcius " + celsius.apply(meteo));
      System.out.println("module1.Meteo in fahrenheit " + fahrenHeit.apply(meteo));
      System.out.println("module1.Meteo back in celcius " + meteoIntegerFunction.apply(meteo));
   }

   @Test
   public void identityFunction() {
      Function<String, String> identity = Function.identity();


      System.out.println("identity " + identity.apply("Text"));
//      ("identity " + identity.apply("Text"));
   }
}
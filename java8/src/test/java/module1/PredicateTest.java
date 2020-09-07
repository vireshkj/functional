package module1;

import module1.Predicate;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class PredicateTest {
   @Test
   public void testPredicate() {
      Predicate<String> nonNull = Objects::nonNull;
      Predicate<String> isEmpty = String::isEmpty;

      Predicate<String> notNullAndNotEmpty = nonNull.and(isEmpty.negate());

      assertTrue(notNullAndNotEmpty.test("Help"));
      assertFalse(notNullAndNotEmpty.test(null));
      assertFalse(notNullAndNotEmpty.test(""));
   }
}
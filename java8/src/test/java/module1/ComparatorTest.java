package module1;

import module1.Comparator;
import module1.Function;
import module1.Person;
import org.junit.Test;

public class ComparatorTest {

   @Test
   public void comparatorTest() {

      Function<Person, String> getName = Person::getName;
      Function<Person, Integer> getAge = Person::getAge;

      Comparator<Person> cmpName = Comparator.comparing(getName);
      Comparator<Person> cmpAge = Comparator.comparing(getAge);

      Comparator<Person> cmpNameReversed = cmpName.reversed();

      Person mary = new Person("Mary", 28);
      Person john = new Person("John", 22);
      Person linda = new Person("Linda", 26);
      Person james = new Person("James", 32);
//
//      System.out.println("Mary > John: " + (cmpName.compare(mary, john) > 0));
//      System.out.println("Mary > John: " + (cmpName.compare(john, james) > 0));
//      System.out.println("Mary > John: " + (cmpName.compare(linda, john) > 0));
//
//      System.out.println("Mary > John: " + (cmpNameReversed.compare(mary, john) > 0));
//      System.out.println("Mary > John: " + (cmpNameReversed.compare(john, james) > 0));
//      System.out.println("Mary > John: " + (cmpNameReversed.compare(linda, john) > 0));

      System.out.println("Mary > John: " + (cmpAge.compare(mary, john) > 0));
      System.out.println("Mary > John: " + (cmpAge.compare(john, james) > 0));
      System.out.println("Mary > John: " + (cmpAge.compare(linda, john) > 0));
   }

   @Test
   public void comparatorTestCombined() {

      Function<Person, String> getName = Person::getName;
      Function<Person, Integer> getAge = Person::getAge;

      Comparator<Person> cmpName = Comparator.comparing(getName);
      Comparator<Person> cmpAge = Comparator.comparing(getAge);

      Comparator<Person> nameAndThenAge = cmpName.thenComparing(cmpAge);

      Person mary = new Person("Mary", 28);
      Person john = new Person("John", 22);
      Person linda = new Person("Linda", 26);
      Person james = new Person("James", 32);
      Person jamesBis = new Person("James", 26);
      Person jamesLis = new Person("James", 36);

      System.out.println("Mary > John: " + (nameAndThenAge.compare(mary, john) > 0));
      System.out.println("Mary > John: " + (nameAndThenAge.compare(john, james) > 0));
      System.out.println("Mary > John: " + (nameAndThenAge.compare(linda, john) > 0));
      System.out.println("James > JamesBis: " + (nameAndThenAge.compare(james, jamesBis) > 0));
      System.out.println("James > JamesLis: " + (nameAndThenAge.compare(james, jamesLis) > 0));
   }

   @Test
   public void comparatorTestCombinedCleanup() {

      Comparator<Person> nameAndThenAge = Comparator.comparing(Person::getName)
                                                  .thenComparing(Person::getAge)
                                                  .thenComparing(Person::getName);

      Person mary = new Person("Mary", 28);
      Person john = new Person("John", 22);
      Person linda = new Person("Linda", 26);
      Person james = new Person("James", 32);
      Person jamesBis = new Person("James", 26);
      Person jamesLis = new Person("James", 36);

      System.out.println("Mary > John: " + (nameAndThenAge.compare(mary, john) > 0));
      System.out.println("Mary > John: " + (nameAndThenAge.compare(john, james) > 0));
      System.out.println("Mary > John: " + (nameAndThenAge.compare(linda, john) > 0));
      System.out.println("James > JamesBis: " + (nameAndThenAge.compare(james, jamesBis) > 0));
      System.out.println("James > JamesLis: " + (nameAndThenAge.compare(james, jamesLis) > 0));
   }
}
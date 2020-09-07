package module1;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

   int compare(T t1, T t2);

   static <T, R extends Comparable<R>> Comparator<T> comparing(Function<T, R> keyExtractor) {
      Objects.requireNonNull(keyExtractor);
      return (p1, p2) -> {
         R s1 = keyExtractor.apply(p1);
         R s2 = keyExtractor.apply(p2);
         return s1.compareTo(s2);
      };
   }

   default Comparator<T> reversed() {
      return (p1, p2) -> this.compare(p2, p1);
   }

   default Comparator<T> thenComparing(Comparator<T> other) {
      Objects.requireNonNull(other);
      return (T t1, T t2) -> {
         int compare = this.compare(t1, t2);
         if (compare == 0) {
            return other.compare(t1, t2);
         } else {
            return compare;
         }
      };
   }

   default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
      Objects.requireNonNull(keyExtractor);
      Comparator<T> other = comparing(keyExtractor);
      return this.thenComparing(other);
   }
}

package module2.builder;

import module2.factory.Factory;


public interface Builder<T> {
   void register(String label, Factory<T> factory);
}

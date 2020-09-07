package module2.model;

import java.awt.*;

public class Circle extends Shape {
   private Color color;

   public Circle() {
      this(Color.WHITE);
   }

   public Circle(Color color) {
      this.color = color;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   @Override public String toString() {
      return "Circle{" +
                     "color=" + color +
                     '}';
   }
}

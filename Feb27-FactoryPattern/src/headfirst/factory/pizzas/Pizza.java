package headfirst.factory.pizzas;

import java.util.ArrayList;

/**
 * Elon Pizza
 * 
 * @author dpowell2
 * @version 1.0
 */
public class Pizza {
  protected String name;
  protected String dough;
  protected String sauce;
  protected ArrayList<String> toppings = new ArrayList<String>();

  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }

  public void prepare() {
    System.out.println("Preparing " + name);
  }

  public void bake() {
    System.out.println("Baking " + name);
  }

  public void cut() {
    System.out.println("Cutting " + name);
  }

  public void box() {
    System.out.println("Boxing " + name);
  }

  public String toString() {
    // code to display pizza name and ingredients
    StringBuffer display = new StringBuffer();
    display.append("---- " + name + " ----\n");
    display.append(dough + "\n");
    display.append(sauce + "\n");
    for (int i = 0; i < toppings.size(); i++) {
      display.append((String) toppings.get(i) + "\n");
    }
    return display.toString();
  }
}

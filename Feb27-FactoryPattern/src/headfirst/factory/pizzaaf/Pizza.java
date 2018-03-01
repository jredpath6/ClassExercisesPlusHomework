package headfirst.factory.pizzaaf;

public abstract class Pizza {
  Cheese cheese;
  Clams clam;
  Dough dough;
  String name;
  Pepperoni pepperoni;
  Sauce sauce;
  /**
     */
  Veggies veggies[];

  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("---- " + name + " ----\n");
    if (dough != null) {
      result.append(dough);
      result.append("\n");
    }
    if (sauce != null) {
      result.append(sauce);
      result.append("\n");
    }
    if (cheese != null) {
      result.append(cheese);
      result.append("\n");
    }
    if (veggies != null) {
      for (int i = 0; i < veggies.length; i++) {
        result.append(veggies[i]);
        if (i < veggies.length - 1) {
          result.append(", ");
        }
      }
      result.append("\n");
    }
    if (clam != null) {
      result.append(clam);
      result.append("\n");
    }
    if (pepperoni != null) {
      result.append(pepperoni);
      result.append("\n");
    }
    return result.toString();
  }

  void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }

  void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  /**
   * @return Returns the name.
   */
  String getName() {
    return name;
  }

  abstract void prepare();

  /**
   * @param name The name to set.
   */
  void setName(String name) {
    this.name = name;
  }
}

package headfirst.factory.pizzanovice;

public class PizzaStore {

  public PizzaStore() {
    // intentionally empty
  }

  public Pizza orderPizza(String type) {
    Pizza pizza;
    if (type.equals("cheese")) {
      pizza = new CheesePizza();
    } else if (type.equals("pepperoni")) {
      pizza = new PepperoniPizza();
    } else if (type.equals("veggie")) {
      pizza = new VeggiePizza();
    } else if (type.equals("clam")) {
      pizza = new ClamPizza();
    } else {
      pizza = new CheesePizza();
    }

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

}

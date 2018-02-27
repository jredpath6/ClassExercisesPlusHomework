package headfirst.factory.pizzas;

/**
 * Pizza store is passed the factory on creation
 * 
 * @author dpowell2
 * @version 1.0
 */
public class PizzaStore {
  SimplePizzaFactory factory;

  public PizzaStore(SimplePizzaFactory factory) {
    this.factory = factory;
  }

  public Pizza orderPizza(String type) {
    Pizza pizza;
    pizza = factory.createPizza(type);
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

}

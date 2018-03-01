package headfirst.factory.pizzas;

public class PizzaStore {

	public PizzaStore() {

	}

	public Pizza orderPizza(String type) {
		SimplePizzaFactory instance = SimplePizzaFactory.getInstance();
		Pizza pizza;
		pizza = instance.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}

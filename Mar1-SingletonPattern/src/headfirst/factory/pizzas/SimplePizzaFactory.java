package headfirst.factory.pizzas;

public class SimplePizzaFactory {
	// This acts as the Singleton
	private static SimplePizzaFactory uniqueInstance;

	private SimplePizzaFactory() {

	}

	// Double checked locking method
	public static SimplePizzaFactory getInstance() {
		if (uniqueInstance == null) {
			synchronized (SimplePizzaFactory.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SimplePizzaFactory();
				}
			}
		}
		return uniqueInstance;
	}

	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}
}

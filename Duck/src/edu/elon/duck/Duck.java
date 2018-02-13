package edu.elon.duck;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {	
	}
	
	public abstract void display();
	
	public void performFly() {		//FLY
		flyBehavior.fly();
	}
	
	public void performQuack() {		//Quack
		quackBehavior.quack();
	}
	
	public void swim() {		//Swim
		System.out.println("All ducks float, even decoys!");
	}
	
	public void setFlyBehavior (FlyBehavior fb) {		//Set Duck Flying Behavior
		flyBehavior = fb;
	}
	
	public void setQuackBehavior (QuackBehavior qb) {		//Set Duck Quacking Behavior
		quackBehavior = qb;
	}
}

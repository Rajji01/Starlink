package com.starlink.backend.lld.decorator;

public class ExtraSpice extends PizzaDecorator{
    BasePizza pizza;

    public ExtraSpice(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return 13+this.pizza.cost();
    }
}

package com.starlink.backend.lld.decorator;

public class ExtraCheese extends PizzaDecorator{
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return 11+this.pizza.cost();
    }
}

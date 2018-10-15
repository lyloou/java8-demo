package com.example.dish;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dish {
    public static final List<Dish> dishMenu = Arrays.asList(
            new Dish("salmon", false, 450, Dish.Type.FISH),
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH)
    );

    private final String name;
    private final boolean vagetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vagetarian, int calories, Type type) {
        this.name = name;
        this.vagetarian = vagetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vagetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vagetarian=" + vagetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dish)) {
            return false;
        }
        return ((Dish) obj).getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}

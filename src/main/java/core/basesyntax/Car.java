package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = deepCopy(wheels);
        this.engine = engine == null ? null : engine.clone();
    }
    //implement this class

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    public Car changeEngine(Engine otherMaker) {
        return new Car(year, color, deepCopy(wheels),otherMaker);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = deepCopy(wheels);
        newWheels.add(wheel);
        return new Car(year, color, newWheels,engine.clone());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        return deepCopy(wheels);
    }

    private List<Wheel> deepCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    public Car changeColor(String color) {
        return new Car(year, color, deepCopy(wheels), engine.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}

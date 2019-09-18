package effectivejava.chapter2.item2.hierarchicalbuilder4;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        /**
         * Pizza.Builder 是一个带有递归类型参数（ recursive type parameter）（详见第 30 条）的泛型类型。
         * 这与抽象的 self 方法一起，允许方法链在子类中正常工作，而不需要强制转换。
         * Java 缺乏自我类型的这种变通解决方法被称为模拟自我类型（simulated self-type）。
         * @return
         */
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

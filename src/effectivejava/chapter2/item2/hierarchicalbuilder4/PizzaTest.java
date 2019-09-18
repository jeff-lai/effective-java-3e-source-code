package effectivejava.chapter2.item2.hierarchicalbuilder4;
import static effectivejava.chapter2.item2.hierarchicalbuilder4.Pizza.Topping.*;
import static effectivejava.chapter2.item2.hierarchicalbuilder4.NyPizza.Size.*;
public class PizzaTest {

    /**
     * 　builder 对构造方法的一个微小的优势是，builder 可以有多个可变参数，因为每个参数都是在它自己的方法中指定的。
     *              或者，builder 可以将传递给多个调用的参数聚合到单个属性中，如前面的 addTopping 方法所演示的那样。
     *
     * 　　Builder 模式非常灵活。 单个 builder 可以重复使用来构建多个对象。
     *             builder 的参数可以在构建方法的调用之间进行调整，以改变创建的对象。
     *             builder 可以在创建对象时自动填充一些属性，例如每次创建对象时增加的序列号。
     *
     * 　　Builder 模式也有缺点。为了创建对象，首先必须创建它的 builder。
     *             虽然创建这个 builder 的成本在实践中不太可能被注意到，但在看中性能的场合下这可能就是一个问题。
     *             而且，builder 模式比伸缩构造方法模式更冗长，因此只有在有足够的参数时才值得使用它，比如四个或更多。
     *             但是请记住，你可能在以后会想要添加更多的参数。
     *             但是，如果你一开始是使用的构造方法或静态工厂，当类演化到参数数量失控的时候再转到Builder模式，过时的构造方法或静态工厂就会面临尴尬的处境。
     *             因此，通常最好从一开始就创建一个 builder。
     *
     * 　　总而言之，当设计类的构造方法或静态工厂的参数超过几个时，Builder 模式是一个不错的选择，特别是如果许多参数是可选的或相同类型的。builder模式客户端代码比使用伸缩构造方法（telescoping constructors）更容易读写，并且builder模式比 JavaBeans 更安全。
     * 
     */
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}

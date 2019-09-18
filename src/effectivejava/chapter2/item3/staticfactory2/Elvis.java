package effectivejava.chapter2.item3.staticfactory2;

/**
 * 　静态工厂方法优点:
 *      第一，它提供了灵活性：在不改变其 API 的前提下，我们可以改变该类是否应该为单例的想法。
 * 工厂方法返回该类的唯一实例，但是，它很容易被修改，比如，改为每个调用该方法的线程返回一个唯一的实例。
 *      第二,如果你的应用程序需要它，可以编写一个泛型单例工厂（generic singleton factory ）（详见第30 条）。
 *      第三，可以通过方法引用（method reference）作为提供者，例如 Elvis::instance 等同于 Supplier<Elvis>。
 *  除非满足以上任意一种优势，否则还是优先考虑公有域（public-field）的方法。
 */
// Singleton with static factory (Page 17)
public class Elvis {

    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }


    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();

        elvis.leaveTheBuilding();
    }


}

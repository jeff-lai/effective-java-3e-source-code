package effectivejava.chapter2.item3.enumtype3;

/**
 * 　这种方式类似于公共属性方法，但更简洁，无偿地提供了序列化机制，并提供了防止多个实例化的坚固保证，即使是在复杂的序列化或反射攻击的情况下。
 * 这种方法可能感觉有点不自然，但是 单一元素枚举类通常是实现单例的最佳方式。
 * 注意，如果单例必须继承 Enum 以外的父类 (尽管可以声明一个 Enum 来实现接口)， * 那么就不能使用这种方法。
 */
// Enum singleton - the preferred approach (Page 18)
public enum  Elvis {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

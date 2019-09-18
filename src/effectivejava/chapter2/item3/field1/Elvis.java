package effectivejava.chapter2.item3.field1;

/**
 * 特权客户端可以使用 AccessibleObject.setAccessible 方法，以反射方式调用私有构造方法（详见第 65 条）。
 * 如果需要防御此攻击，请修改构造函数，使其在请求创建第二个实例时抛出异常。
 */
// Singleton with public final field  (Page 17)
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

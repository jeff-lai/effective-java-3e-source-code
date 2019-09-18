package effectivejava.chapter2.item2.javabeans2;

// JavaBeans 模式- 允许可变性，强调可变性

/**
 * JavaBeans 模式本身有严重的缺陷。
 * 由于构造方法被分割成了多次调用，所以在构造过程中 JavaBean 可能处于不一致的状态。
 * 该类没有通过检查构造参数参数的有效性来强制一致性的选项。
 * 在不一致的状态下尝试使用对象可能会导致一些错误，这些错误与平常代码的BUG很是不同，因此很难调试。
 * 一个相关的缺点是，JavaBeans 模式排除了让类不可变的可能性（详见第 17 条），并且需要程序员增加工作以确保线程安全。
 */
// JavaBeans Pattern - allows inconsistency, mandates mutability  (pages 11-12)
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFacts() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }

}

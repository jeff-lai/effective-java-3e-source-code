package effectivejava.chapter2.item2.telescopingconstructor1;


//可伸缩（telescoping constructor）构造方法模式,不能很好的扩展

/**
 * 简而言之，可伸缩构造方法模式是有效的，但是当有很多参数时，很难编写客户端代码，而且很难读懂它。
 * 读者不知道这些值是什么意思，并且必须仔细地去数参数才能找到答案。一长串相同类型的参数可能会导致一些细微的 bug。
 * 如果客户端不小心写反了两个这样的参数，编译器并不会报错，但是程序在运行时会出现错误行为 （详见第 51 条）。
 */

//Telescoping constructor pattern - does not scale well!(Pages 10-11)
public class NutritionFacts {
    private final int servingSize; //(ml) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional  卡路里
    private final int fat; // (g/serving) optional 脂肪
    private final int sodium; // (mg/serving) optional 钠
    private final int carbohydrate; // (g/serving) optional  碳水化合物


    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, 0,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat,0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium,0);
    }



    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola =
                new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
}


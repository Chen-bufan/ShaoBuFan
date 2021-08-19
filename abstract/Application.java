/*
* 在设计程序时经常会使用abstract类，其原因是abstract类只关心操作，而不关心这些具体操作的实现细节可以使程序的设计者把主要精力放在程
* 序的设计上，而不必拘泥于细节的实现。将这些细节留给子类的设计者。即避免设计者把大量的时间和精力花费在具体的算法上。例如在设计地图时
* ，首先考虑地图最重要的轮廓，不必去考虑诸如城市中的街道牌号等细节，细节应当由抽象类的非抽象子类去实现。这些子类可以给出具体的实例来
* 完成程序功能的具体实现，在设计一个程序时，可以通过在abstract类中声明若干个abstract方法，表明这些方法在整个系统设计中的重要性，方
* 法体的内容细节由它的非abstract子类去完成。
*
* 例如我们要现在设计一个圆类，用getArea来返回面积值。我们设计一个柱类用getVolume()方法来
* 返回体积。在柱内求体积的方法当中，必须要用到圆类的面积返回值。但是在某个时刻，用户希望柱类能够创建出底是三角形的柱体。然而这就需要
* 重写，圆类面积的返回值或者柱类当中应用的面积。由于柱类当中体积的运算也会用到底面积，这样修改十分的麻烦。于是为了应对用户的需求，我
* 们将抽象出一个类这个类专门去应对他们共有的特点，获得面积方法。在抽象类当中只抽象出一个抽象方法，那就是获得面积函数。具体是什么形状
* 的面积，就由被他继承的子类来完成具体的方法。实例展示。*/

abstract class Geometry {
    public abstract double getArea();
}

class Circle extends Geometry{
    double r;
    Circle(double r){
        this.r=r;
    }

    public double getArea() {
        return (3.14*r*r);
    }
}

class Rectangle extends Geometry{
    double a,b;
    Rectangle(double a,double b){
        this.a=a;
        this.b=b;
    }
    public double getArea() {
        return a*b;
    }
}
/*
* 注意到，当增加了Circle和Recangle类后，我们就不必需改Pillar类的代码。
* 现在，我们就可以用Pillar类创建出具有矩形底和圆形底的柱体了。*/
class Pillar {
    Geometry bottom;
    double height;
    Pillar (Geometry bottom,double height) {
        this.bottom = bottom;
        this.height = height;
    }
    public double getVolume(){
        if(bottom == null){
            System.out.println("无底");
            return -1;
        }
        return bottom.getArea()*height;
    }
}

public class Application {
    public static void main(String[] args) {
        Pillar pillar;
        Geometry bottom = null;//null无底的柱体
        pillar = new Pillar(bottom,100);
        System.out.println("体积:"+pillar.getVolume());

        bottom = new Rectangle(12,22);//矩形底柱体
        pillar = new Pillar(bottom,58);
        System.out.println("体积:"+pillar.getVolume());

        bottom = new Circle(10);//圆形底柱体
        pillar = new Pillar(bottom,58);
        System.out.println("体积:"+pillar.getVolume());
    }
}
/*
* 通过前面的代码，我们可以得出如下结论：
* 面向抽象编程的目的是为了应对用户需求的变化，将某个类的经常因需求变化而需要改动的代码，
* 从该类中分离出去，面向抽象的编程的核心，是让类中每个可能变化对应的交给抽象类的一个子类去负责，
* 从而让该类的设计者不去关心，具体实现，避免所设计的类依赖于具体的实现，面向抽象编程时设计的类，
* 容易应对用户的需求变化。*/

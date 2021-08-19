abstract class GirlFriend {
    //抽象类，封装了两个行为标准
    abstract void speak();

    abstract void cooking();
}

class ChinaGirlFriend extends GirlFriend {
    void cooking() {
        System.out.println("鱼");
    }

    void speak() {
        System.out.println("你好");
    }
}

class AmericanGirlFriend extends GirlFriend{
    void cooking() {
        System.out.println("beef");
    }

    void speak() {
        System.out.println("hello");
    }
}

class Boy {

    GirlFriend girlFriend;
    void setGirlFriend(GirlFriend friend){
        girlFriend=friend;
    }

    void showGirFriend(){
        girlFriend.speak();
        girlFriend.cooking();
    }
}
public class Example {
    public static void main(String[] args) {
        GirlFriend girl = new ChinaGirlFriend();
        Boy boy = new Boy();
        boy.setGirlFriend(girl);
        boy.showGirFriend();
    }
}

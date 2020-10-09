package com.hyomee.example08;

/**
 * - 이름 없는 클래스
 *    : Method 안에 만들어짐
 *    : 클래스를 정의하지 않고 필요할 때 이름없이 즉시 선언하고 인스턴스화 해서 사용
 *    : 객체 안에 민드는 로컬 클래스와 동일 하다, ( 이름이 없는 것을 제외 하면 )
 *    : 형식 :: new 클래스이름(or 인터페이스 이름) (…) {…}
 *    : new 수식이 올 수 있는 곳 어디든지 사용 가능하나 생성자는 정의 할 수 없음
 *    : 익명 클래스내부에서 외부의 메소드 내 변수를 참조할 때는 메소드의 지역 변수 중 final로 선언된 변수만 참조 가능
 *      - 변수는 Stack에 있고 객체는 Heap에 있음, 즉 Method 실행 이 끝나고 Stack는 사라지지만  Heap에 있는 Method는 사라지지 않기 때문 *
 * - 해당 클래스나 인터페이스를 정의하여 사용 할 때 여러 곳에서 사용되는 것이 아니라 단 한번만 정의해서 사용 하는 경우에 유용
 */
public class AnnoymousClassMain {

    interface AnnoymisClass {
        public void printClassType();
    }

    public void sayHello(String name) {
        // 로컬 클래스
        class LocalClass implements AnnoymisClass {
            public void printClassType() {
                System.out.println("Hello " + name);
            }
        }

        AnnoymisClass localClass = new LocalClass();
        localClass.printClassType();

        // 익명 클래스
        AnnoymisClass annoymisClass = new AnnoymisClass() {
            public void printClassType() {
                System.out.println("익명 ~ " + name);
            }
        };

        annoymisClass.printClassType();
    }


    public static void main(String... args) {
        AnnoymousClassMain myApp = new  AnnoymousClassMain();
        myApp.sayHello("클래스");

    }
}



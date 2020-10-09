package com.hyomee.example07;

/*
 * 설명 : 상속
 * -  클래스를 확장하여 새로운 자식 클래스를 만드는 것
 *   : 부모 – 자식 관계
 *   : 부모 클래스의 기능(필드, 메소드)를 사용 ( 코드 재사용
 *   : private로 선언된 것 아닌 것에만 접근 가능 함
 *   : extends 키워드를 사용 해서 오직 한 개만 상속이 가능 함
 *   : final 키워드로 상속을 막을 수 있음
 *   : protected로 선언된 Method는 상속된 객체만 사용
 * - 생성자
 *   : 생성자는 상속 되지 않지만 , 자식 클래스의 생정자에 의해 호출 ( super(..) )
 *      - 부모 클래스의 멤버를 초기화 할 수 있
 *      - super(…) : 상위 클래스의 생성자를 명시적으로 호출
 *   : 자식 클래스가 생성 될 때 부모 상속 받은 변수를 저장할 수 있는 메모리를 포함하여 객체 할당
 * - 추상 Method
 *   : Method 선언만 있고 구현이 없는 Method
 *   : abstract 리턴타입 Method명 () ;
 *   : 자식 클래스에서 구현 해야 함 ( Overriding )
 */
public class ExtendsMain {
    public static void main(String[] name) {
        Room room = new Room("홍길동",  "18", "7");
        room.printName();
        room.printRoom();
        System.out.println("==========================================");
        AbstractRoom abstractRoom = new AbstractRoom("홍길동",  "18", "7");
        abstractRoom.printName();
        abstractRoom.printRoom();
        abstractRoom.work();
        System.out.println("==========================================");
        PrintNm[] printNms = new PrintNm[3];
        printNms[0] = new Mammalia();
        printNms[1] = new Reptile();
        printNms[2] = new Pisces();

        for(PrintNm printNm : printNms) {
            printNm.printing();
        }

    }
}


class User {
    public String name;
    private String ages;

    public User(String ages) {
        this.ages = ages;
    }

    public void printName() {
        System.out.println(String.format("이름 : %s", this.name));
        System.out.println(String.format("나이 : %s", this.ages));
    }
}

class Room extends User {
    private String roomNum ;

    public Room(String name, String ages, String roomNum) {
        super(ages);
        this.name = name;
        this.roomNum = roomNum;
    }

    public void printRoom() {
        System.out.println(String.format("%s 은 %s번방에 있습니다", this.name, roomNum));
    }

}


abstract class AbstractUser {
    public String name;
    private String ages;

    public AbstractUser(String ages) {
        this.ages = ages;
    }

    public void printName() {
        System.out.println(String.format("이름 : %s", this.name));
        System.out.println(String.format("나이 : %s", this.ages));
    }

    // 추상 메소드
    abstract void work();
}

class AbstractRoom extends AbstractUser {
    private String roomNum ;

    public AbstractRoom(String name, String ages, String roomNum) {
        super(ages);
        this.name = name;
        this.roomNum = roomNum;
    }

    // 추상 메소드 구현
    @Override
    void work() {
        System.out.println(String.format("추상 :: %s 은 %s번방에서 일하고 있습니다", this.name, roomNum));
    }

    public void printRoom() {
        System.out.println(String.format("%s 은 %s번방에 있습니다", this.name, roomNum));
    }
}


interface PrintNm {
    void printing();
}

class Mammalia implements PrintNm {
    @Override
    public void printing() {
        System.out.println(String.format("포유류"));
    }
}
class Reptile implements PrintNm {
    @Override
    public void printing() {
        System.out.println(String.format("파출류"));
    }
}
class Pisces implements PrintNm {
    @Override
    public void printing() {
        System.out.println(String.format("어류"));
    }
}
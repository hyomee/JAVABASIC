package com.hyomee.cleancode;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class MagicNumber {
    public static void main(String[] agrs) {
        MagicSpeedControl magicSpeedControl = new MagicSpeedControl();

        magicSpeedControl.setAction(0);
        System.out.println(String.format("magicSpeedControl :: 최고 속도는 %s Km 입니다." , magicSpeedControl.getMaximumSpeed()));

        StaticSpeedControl staticSpeedControl = new StaticSpeedControl();
        staticSpeedControl.setAction(3);
        System.out.println(String.format("staticSpeedControl :: 최고 속도는 %s Km 입니다." , staticSpeedControl.getMaximumSpeed()));

        EnumSpeedControl enumSpeedControl = new EnumSpeedControl();
        enumSpeedControl.setAction(3);
        System.out.println(String.format("enumSpeedControl :: 최고 속도는 %s Km 입니다." , enumSpeedControl.getMaximumSpeed()));

        int maxSpeed = EnumSpeedControl.SPEED_CONTROL.getMaxSpeed(2);
        System.out.println(String.format("EnumSpeedControl.SPEED_CONTROL :: 최고 속도는 %s Km 입니다." , maxSpeed));

        maxSpeed = EnumSpeedControl.SPEED_CONTROL.getMaxSpeed(4);
        System.out.println(String.format("EnumSpeedControl.SPEED_CONTROL :: 최고 속도는 %s Km 입니다." , maxSpeed));


    }
}

class MagicSpeedControl {
    private int maximumSpeed;

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    private void setMaximumSpeed(int speedUnit) {
        this.maximumSpeed = speedUnit;
    }

    public void setAction(int speedUnit) {
        if (speedUnit == 1) {
            setMaximumSpeed(30);
        } else if (speedUnit == 2) {
            setMaximumSpeed(60);
        } else if (speedUnit == 3) {
            setMaximumSpeed(100);
        } else {
            setMaximumSpeed(0);
        }
    }
}


class StaticSpeedControl {
    
    private static final int UNIT_SPEED_STOP = 0;
    private static final int UNIT_SPEED_LOW = 1;
    private static final int UNIT_SPEED_MIDDLE = 2;
    private static final int UNIT_SPEED_MAX  = 3;

    private static final int MAX_SPEED_STOP = 0;
    private static final int MAX_SPEED_LOW = 30;
    private static final int MAX_SPEED_MIDDLE = 60;
    private static final int MAX_SPEED_MAX  = 100;
    
    private int maximumSpeed;

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    private void setMaximumSpeed(int speedUnit) {
        this.maximumSpeed = speedUnit;
    }

    public void setAction(int speedUnit) {
        if (speedUnit == UNIT_SPEED_LOW) {
            setMaximumSpeed(MAX_SPEED_LOW);
        } else if (speedUnit == UNIT_SPEED_MIDDLE) {
            setMaximumSpeed(MAX_SPEED_MIDDLE);
        } else if (speedUnit == UNIT_SPEED_MAX) {
            setMaximumSpeed(MAX_SPEED_MAX);
        } else {
            setMaximumSpeed(MAX_SPEED_STOP);
        }
    }
}

class EnumSpeedControl {

    enum SPEED_CONTROL {
        STOP(0, 0),
        LOW(1, 30),
        MIDDLE(2, 60),
        MAX(3, 100);

        private int UNIT;
        private int MAXSPEED;

        SPEED_CONTROL(int unit, int max) {
            this.UNIT = unit;
            this.MAXSPEED = max;
        }

        public static int getMaxSpeed(int speedUnit) {
            SPEED_CONTROL[] speed_controls = SPEED_CONTROL.values();
            SPEED_CONTROL speedcontrol =  Arrays.stream(speed_controls)
                    .filter(speed_control -> speedUnit == speed_control.UNIT).findFirst()
                    .orElse(SPEED_CONTROL.STOP);
            return speedcontrol.MAXSPEED;
        }
    }


    private int maximumSpeed;

    public int getMaximumSpeed() {
        return this.maximumSpeed;
    }

    private void setMaximumSpeed(int speedUnit) {
        this.maximumSpeed = speedUnit;
    }

    public void setAction(int speedUnit) {
        if (speedUnit == SPEED_CONTROL.LOW.UNIT) {
            setMaximumSpeed(SPEED_CONTROL.LOW.MAXSPEED);
        } else if (speedUnit == SPEED_CONTROL.MIDDLE.UNIT) {
            setMaximumSpeed(SPEED_CONTROL.MIDDLE.MAXSPEED);
        } else if (speedUnit == SPEED_CONTROL.MAX.UNIT) {
            setMaximumSpeed(SPEED_CONTROL.MAX.MAXSPEED);
        } else {
            setMaximumSpeed(SPEED_CONTROL.STOP.MAXSPEED);
        }
    }
}
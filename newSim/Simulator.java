package newSim;

import java.util.Vector;

//import java.swing.*;
public class Simulator {
    public static volatile boolean debug = false;
    public static final int MAX_PEOPLE = 200;
    public static final int MAX_TIME = 60;
    private static volatile int counter;

    public static void stopProgram() {
        counter = MAX_TIME;
    }

    public static int getTimeRemaing() {
        return (MAX_TIME - counter) / 2;
    }

    public static int getElapsedTime() {
        return counter / 2;
    }

    public static void main(String[] args) {
        //Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        String source = null;
        if (args.length > 0)
            source = args[0];
        ElevatorConsole console = new ElevatorConsole(source);
        Vector people = new Vector();
        Building b = new Building();
        console.setBuilding(b);
        Person.setBuilding(b);
        for (int i = 0; i < MAX_PEOPLE; i++) {
            Person p = new Person(i + 1);
            people.add(p);
            p.start();
        }
        for (counter = 0; counter <= MAX_TIME; counter++) {
            console.updateDisplay();
            try {
                Thread.currentThread().sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < people.size(); i++) {
            ((Person) people.get(i)).setStopRunning();
        }
        debug = false;
        b.stopElevators();
        System.out.println("Progam ended");
    }

} // end Simulator




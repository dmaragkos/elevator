package newSim;

import javax.swing.JApplet;

public class SimApplet extends JApplet {
    public SimApplet() {
    }

    public void start() {
        Simulator.main(new String[]{"Applet"});
    }
}
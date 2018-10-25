package homeWorkTwoGUI;
//**************************************************************************************************

// CLASS: Main2
//instantiates an object of the View class
//**************************************************************************************************
import javax.swing.JFrame;

public class Main2 {

    public static void main(String[] pArgs) {
        new Main2().run();
    }

    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        View view = new View();
    }

}
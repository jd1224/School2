import java.awt.*;
import javax.swing.*;
public class GridFrame extends NiceFrame{
   public GridFrame() {
      super("Grid Frame", 300, 200);
      setLayout(new GridLayout(5, 5, 10, 10));
      for (int i = 0; i < 25; i++)
         add(new JButton("b" + i));
   }
   public static void main(String[] args) {
      GridFrame f = new GridFrame();
      f.display();
   }
}
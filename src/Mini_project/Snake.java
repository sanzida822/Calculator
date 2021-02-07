package Mini_project;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Snake extends JFrame {

    JTextField result;

    Snake() {
        Board b = new Board();

        add(b);
        pack();
        setLocationRelativeTo(null);

        setTitle("Snake Game");

        setResizable(false);

    }

}

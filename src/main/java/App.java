import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    protected boolean isAlive = true;

    public App(final int SIZE) {
        setTitle("Bombs and Deaths");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }

        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setText("???");
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        button.setText("\u2620");
                        button.setFont(button.getFont().deriveFont(40.F));
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);
                        isAlive = false;
                        for (int x = 0; x < SIZE; x++) {
                            for (int y = 0; y < SIZE; y++) {
                                if (bombs[x][y] && buttons[x][y].getBackground() != Color.RED) {
                                    buttons[x][y].setText("\u2620");
                                    buttons[x][y].setFont(buttons[x][y].getFont().deriveFont(40.F));
                                    buttons[x][y].setBackground(Color.MAGENTA);
                                    buttons[x][y].setForeground(Color.WHITE);
                                }
                            }
                        }
                    } else {
                        int count = 0;

                        if (((ii - 1) >= 0) && ((jj - 1) >= 0) && bombs[ii - 1][jj - 1]) count++;
                        if (((jj - 1) >= 0) && bombs[ii][jj - 1]) count++;
                        if (((ii - 1) >= 0) && bombs[ii - 1][jj]) count++;

                        if (((ii + 1) < SIZE) && ((jj + 1) < SIZE) && bombs[ii + 1][jj + 1]) count++;
                        if (((jj + 1) < SIZE) && bombs[ii][jj + 1]) count++;
                        if ((ii + 1) < SIZE && bombs[ii + 1][jj]) count++;

                        if (((ii + 1) < SIZE) && ((jj - 1) >= 0) && bombs[ii + 1][jj - 1]) count++;
                        if (((ii - 1) >= 0) && ((jj + 1) < SIZE) && bombs[ii - 1][jj + 1]) count++;

                        String str = (count == 0) ? "" : String.valueOf(count);
                        button.setText(str);
                        button.setBackground(Color.GREEN);
                    }
                });
                add(button);
            }
        }
        setVisible(true);
    }
}


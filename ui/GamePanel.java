package rpg.ui;

import rpg.game.Game;
import rpg.game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    private final MapPanel mapPanel;
    private final Player player;

    public GamePanel(Game game) {
        this.setLayout(new BorderLayout());

        // Retrieve the player from the game
        this.player = game.getPlayer();

        // Add MapPanel to GamePanel, pass the player to MapPanel
        this.mapPanel = new MapPanel(game.getMap(), player);
        this.add(mapPanel, BorderLayout.NORTH);

        this.initcomponents();
    }

    private void initcomponents() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.mapPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        player.move(0, -1);
                        break;
                    case KeyEvent.VK_DOWN:
                        player.move(0, 1);
                        break;
                    case KeyEvent.VK_LEFT:
                        player.move(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.move(1, 0);
                        break;
                }
                mapPanel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.mapPanel.setFocusable(true);
        this.mapPanel.requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }
}


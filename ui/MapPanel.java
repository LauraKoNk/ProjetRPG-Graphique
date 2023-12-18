package rpg.ui;

import rpg.game.Map;
import rpg.game.Player;

import javax.swing.*;
import java.awt.*;

import java.util.Objects;

public class MapPanel extends JPanel {

    static final int cellSize = 24;

    private int[][] mapGrid;
    private Image playerImage;

    private Image monsterImage;
    private Image shopImage;
    private final Player player;


    public MapPanel(Map map, Player player) {
        this.mapGrid = map.getMap();
        this.player = player;

        ImageIcon monsterImg = new ImageIcon("/Users/laurakn/IdeaProjects/rpg 3/monster.png");
        this.monsterImage = monsterImg.getImage();
        ImageIcon shopImg = new ImageIcon("/Users/laurakn/IdeaProjects/rpg 3/shop.png");
        this.shopImage = shopImg.getImage();

        ImageIcon img = new ImageIcon("/Users/laurakn/IdeaProjects/rpg 3/link.png");
        this.playerImage = img.getImage();
    }

    public Image getPlayerImage() {
        return this.playerImage;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int CoordX = 200;
        int CoordY = 50;

        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                Color color;
                switch (this.mapGrid[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 2:
                        color = Color.CYAN;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
                g.setColor(Color.BLACK); // contours
                g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);

                if (this.mapGrid[row][col] == 3) {
                     g.drawImage(this.monsterImage, CoordX + cellSize * col, CoordY + cellSize * row, null);
                } else if (this.mapGrid[row][col] == 4) {
                    g.drawImage(this.shopImage, CoordX + cellSize * col, CoordY + cellSize * row, null);
                }
            }
        }

        int playerX = player.getX();
        int playerY = player.getY();
        g.drawImage(this.getPlayerImage(), CoordX + cellSize * playerX, CoordY + cellSize * playerY, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }


    public void haut() {
        bouger(-1, 0);
    }

    public void bas() {
        bouger(1, 0);
    }

    public void gauche() {
        bouger(0, -1);
    }

    public void droite() {
        bouger(0, 1);
    }

    private void bouger(int rowOffset, int colOffset) {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];

        int newX = x + rowOffset;
        int newY = y + colOffset;

        if (newX >= 0 && newX < this.mapGrid.length && newY >= 0 && newY < this.mapGrid[0].length
                && !Objects.equals(this.mapGrid[newX][newY], 0)) {


            this.repaint();
        }

    }

    private int[] getPlayerCoord() {

        int[] coord = new int[2];
        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                if (Objects.equals(this.mapGrid[row][col], 0)) {
                    coord[0] = row;
                    coord[1] = col;
                }
            }
        }
        return coord;
    }

}
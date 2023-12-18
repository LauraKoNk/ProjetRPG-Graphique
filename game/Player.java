package rpg.game;

public class Player {

    private String name;
    private PlayerCast cast;
    private int x; // Position en X
    private int y; // Position en Y

    public Player(String n, PlayerCast c) {
        this.name = n;
        this.cast = c;
        this.x = 0; // Position initiale en X
        this.y = 0; // Position initiale en Y
    }

    public String getName() {
        return this.name;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}


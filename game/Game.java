package rpg.game;

public class Game {

    private Map map;
    private Player player;

    public Game(GameInputs gameInputs) {
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast());
        this.map = new Map();
    }

    public Map getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }

    // Ajoutez ces méthodes pour permettre le déplacement du joueur
    public void movePlayer(int newX, int newY) {
        // Ajoutez des vérifications pour vous assurer que les nouvelles coordonnées sont valides
        this.player.move(newX, newY);
    }

    public int getPlayerX() {
        return this.player.getX();
    }

    public int getPlayerY() {
        return this.player.getY();
    }
}

// Decision table

// |                 |              |         |             |        |
// |-----------------|--------------|---------|-------------|--------|
// | **Collider**    | Ghost        | Player  | Player      | Player | 
// | **Collidee**    | Pellet       | Ghost   | Pellet      | Wall   |
// | **Consequence** | Pellet       | Game    | Player      | Move   |
// |                 | temporarily  | over    | gains points| fails  |
// |                 | disappears   |         | Pellet      |        |
// |                 |              |         | disappears  |        |

import nl.tudelft.jpacman.level.PlayerCollisions;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.Ghost;
import nl.tudelft.jpacman.level.Pellet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerCollisionsTest {

    private Player player;
    private Ghost ghost;
    private Pellet pellet;
    private PlayerCollisions collisions;

    @BeforeEach
    void setUp() {
        player = new Player();
        ghost = new Ghost();
        pellet = new Pellet(1); 
        collisions = new PlayerCollisions();
    }

    @Test
    void testPlayerCollidesWithPellet() {
        // Arrange
        int initialScore = player.getScore();
        
        // Act
        collisions.collide(player, pellet);

        // Assert
        assertEquals(initialScore + pellet.getValue(), player.getScore(), "Player gains points when colliding with Pellet.");
        assertFalse(pellet.isVisible(), "Pellet disappears after the collision.");
    }

    @Test
    void testPlayerCollidesWithGhost() {
        // Arrange
        assertTrue(player.isAlive(), "Player is alive.");
        
        // Act
        collisions.collide(player, ghost);

        // Assert
        assertFalse(player.isAlive(), "Player die, game over.");
    }

    @Test
    void testGhostCollidesWithPlayer() {
        // Arrange
        assertTrue(player.isAlive(), "Player is alive");
        
        // Act
        collisions.collide(ghost, player);

        // Assert
        assertFalse(player.isAlive(), "Player die, game over.");
    }

}

// Dans la classe PlayerCollisions, on a juste l'implémentation des collisions Player et Ghost et Player et Pellet, 
// on n'a pas les collisions entre Ghost et Pellet et Player et Wall 
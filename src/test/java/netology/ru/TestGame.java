package netology.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {
    Game game = new Game();

    Player player1 = new Player(1, "Николай", 5);
    Player player2 = new Player(2, "Светлана", 2);
    Player player3 = new Player(3, "Василий", 4);
    Player player4 = new Player(4, "Ольга", 7);
    Player player5 = new Player(5, "Владимир", 4);

    @Test
    public void testForAnExceptionIfTheFirstPlayerIsNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player3");
        });
    }

    @Test
    public void testForAnExceptionIfTheFifthPlayerIsNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player2", "Player5");
        });
    }

    @Test
    public void testMustReturnTwoIfPlayerTwoWon() {
        game.register(player3);
        game.register(player4);
        Assertions.assertEquals(2, game.round("Василий", "Ольга"));

    }

    @Test
    public void testMustReturnOneIfPlayerTwoOne() {
        game.register(player1);
        game.register(player2);
        Assertions.assertEquals(1, game.round("Николай", "Светлана"));

    }

    @Test
    public void testMustReturnZeroIfDraw() {
        game.register(player3);
        game.register(player5);
        Assertions.assertEquals(0, game.round("Василий", "Владимир"));

    }
}

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.view.ConsoleView;
import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.controllers.MoveController;

public class Main {

	public static void main(String... args) {
		final Point p = new Point();
		p.x = 2;
		p.y = 3;

		final Player player = new Player();
		player.name = "Slava";
		player.figure = "X";

		final Game game = new Game();
		game.player1 = new Player();
		game.player2 = new Player();
		game.name = "XO";
		game.field = new Field();

		final Field field = new Field();
		field.f00 = "X";
		field.f01 = "X";
		field.f02 = "X";

		field.f10 = "X";
		field.f11 = "X";
		field.f12 = "X";

		field.f20 = "X";
		field.f21 = "X";
		field.f22 = "X";

		final ConsoleView cv = new ConsoleView();
		final CurrentMoveController cmc = new CurrentMoveController();
		final MoveController mc = new MoveController();
		final WinnerController wc = new WinnerController();
	}
}

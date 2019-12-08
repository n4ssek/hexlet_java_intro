public class Main {

	public static void main(String... args) {
		final Point p = new Point();
		p.x = 20000;
		p.y = 3000;

		final Player player = new Player();
		player.name = "Slava";
		player.figure = "X";
		player.age = 12;
		player.mail = "test@a.com";
		player.address = "Malin 12 app";
		player.score = 12;
		player.nick = "b0noi";
		player.uuid = "sdfj348f39h8r";

		final Game game = new Game();
		game.player1 = new Player();
		game.player2 = new Player();
		game.name = "XO";
		game.field = new Field();
	}
}

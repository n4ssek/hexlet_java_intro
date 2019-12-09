import io.hexlet.xo.model.*;
import io.hexlet.xo.model.exceptions.*;
import io.hexlet.xo.view.*;
import io.hexlet.xo.controllers.*;

public class Main {

	public static void main(String... args) {
		final Field field = new Field();
		final CurrentMoveController cmc = new CurrentMoveController();
		ConsoleView print = new ConsoleView();

		final Point p = new Point();
		p.x = 1;
		p.y = 1;

		if (!cmc.currentMove(field).equals("X")){
			throw new RuntimeException("do not returns X when the field is empty");
		}
		final TempTest tt = new TempTest();

		for (int i = 0; i < field.getSize(); i++)
			for (int i2 = 0; i2 < field.getSize(); i2++) {
				p.x = i;
				p.y = i2;
				final String figure = (i * 3 + i2) % 2 == 0 ? "X" : "O";
				field.setFigure(p, figure);
				//System.out.printf("putting figure: %s to the: X:%d Y:%d\n", figure, p.x, p.y);
				if (cmc.currentMove(field).equals(figure)){
					throw new RuntimeException(String.format("returns %s for the field: \n%s", figure, print.show(field)));
				}
			}

		tt.checkField(null, null, null, null, null, null, null, null, null, null);
		// одинаковые поля блоками. Разница в заподнении по строкам или по столбцам.
		// для понимания, что нет в этом разницы
		tt.checkField(null, "X", "O", "X", "X", "O", "O", "O", "X", "X");
		tt.checkField(null, "X", "X", "O", "O", "O", "X", "X", "O", "X");

		tt.checkField(null, "X", null, "X", null, "O", null, "O", null, "X");
		tt.checkField(null, null, null, "X", null, "O", null, "X", null, "O");

		tt.checkField("X", "X", "X", "X", null, "O", null, "O", null, null);// или по строкам или по столбцам
		tt.checkField("X", "X", null, "O", "X", "O", null, "X", null, null);// или по строкам или по столбцам

		tt.checkField("O", "X", null, "X", "O", "O", "O", "X", null, null);
		tt.checkField("O", "X", "O", "X", null, "O", null, "X", "O", null);

		tt.checkField("X", null, "X", null, null, "X", null, null, "X", null);
		tt.checkField("X", null, null, null, "X", "X", "X", null, null, null);

		tt.checkField("O", null, null, "O", null, null, "O", null, null, "O");
		tt.checkField("O", null, null, null, null, null, null, "O", "O", "O");

		tt.checkField("O", "O", "X", "X", null, "O", null, "X", null, "O");
		tt.checkField("O", "O", null, "X", "X", "O", null, "X", null, "O");

		tt.checkField("X", "X", "O", "X", "O", "X", null, "X", null, "O");// эти две строки хорошо демонстрируют,
		tt.checkField("X", "X", "O", "X", "O", "X", null, "X", null, "O");// что не важно какая координата будет х, а какая у

		tt.checkField("O", "X", null, "O", "X", "O", "X", "O", null, "O");
		tt.checkField("O", "X", "X", "O", null, "O", null, "O", "X", "O");
	}
}
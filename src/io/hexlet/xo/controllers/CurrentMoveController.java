package io.hexlet.xo.controllers;

import io.hexlet.xo.model.*;

public class CurrentMoveController {

	public String currentMove(final Field  field) {

		int countX = 0;
		int countO = 0;

		for (int i = 0; i < field.getSize(); i++) {
			for (int j = 0; j < field.getSize(); j++) {
				Point point = new Point(i, j);

				if (field.getFigure(point) == "X" && field.getFigure(point) != null)
					countX++;
				if (field.getFigure(point) == "O" && field.getFigure(point) != null)
					countO++;

			}
		}

		if ((countX <= countO) || (countX == 0 && countO == 0)) {
			return "X";
		}

		return "O";


}

package io.hexlet.xo.controllers;

import io.hexlet.xo.model.*;

public class WinnerController {

	private String winner;

	private int fieldSize;
	private int counterX;
	private int counterO;
	private String tempFigure;
	private Point tempPoint = new Point();

	public String getWinner(final Field field) {
		winner = null;
		fieldSize = field.getSize();
		checkRow(field);
		if (winner != null) return winner;

		checkColumn(field);
		if (winner != null) return winner;

		checkFirstDiagonal(field);
		if (winner != null) return winner;

		checkSecondDiagonal(field);
		return winner;
	}

	private void checkRow(final Field field) {


		for (int rowNumber = 0; rowNumber < fieldSize; rowNumber++) {
			counterX = 0; // в каждом ряду считаем фигурки заново
			counterO = 0;
			for (int row = 0; row < fieldSize; row++) {
				tempPoint.x = rowNumber;
				tempPoint.y = row;
				tempFigure = field.getFigure(tempPoint);

				if (tempFigure == null) break; // прекращаем этот цикл если есть хоть один null в ряду

				switch (tempFigure) {
					case "X":
						counterX++;
						break;
					case "O": counterO++;
				}
			}

			if (counterX == fieldSize) { // "X" занимает весь ряд?
				winner = "X";
				return; // тут же прекращаем работу метода
			}
			if (counterO == fieldSize) { // "O" занимает весь ряд?
				winner = "O";
				return; // тут же прекращаем работу метода
			}
		}
	}

	private void checkColumn(final Field field) {

		for (int columnNumber = 0; columnNumber < fieldSize; columnNumber++) {
			counterX = 0; // в каждой колонке считаем заново фигурки
			counterO = 0;
			for (int cellInTheColumn = 0; cellInTheColumn < fieldSize; cellInTheColumn++) {
				tempPoint.x = cellInTheColumn;
				tempPoint.y = columnNumber;
				tempFigure = field.getFigure(tempPoint);

				if (tempFigure == null) break; // прекращаем этот цикл если есть хоть один null в колонке

				switch (tempFigure) {
					case "X":
						counterX++;
						break;
					case "O": counterO++;
				}
			}

			if (counterX == fieldSize) { // "X" занимает всю колонку?
				winner = "X";
				return; // тут же прекращаем работу метода
			}

			if (counterO == fieldSize) { // "O" занимает всю колонку?
				winner = "O";
				return; // тут же прекращаем работу метода
			}
		}
	}

	private void checkFirstDiagonal(final Field field) {

		counterX = 0;
		counterO = 0;
		for (int i = 0; i < fieldSize; i++) {
			tempPoint.x = i;
			tempPoint.y = i;
			tempFigure = field.getFigure(tempPoint);

			if (tempFigure == null) break; // прекращаем этот цикл если есть хоть один null в диагонале

			switch (tempFigure) {
				case "X":
					counterX++;
					break;
				case "O": counterO++;
			}
		}

		if (counterX == fieldSize) { // "X" занимает всю диагональ?
			winner = "X";
			return; // тут же прекращаем работу метода
		}

		// "O" занимает всю диагональ?
		if (counterO == fieldSize) winner = "O";
		// если нет, то метод оставит winner без изменений
	}

	private void checkSecondDiagonal(final Field field) {
		int j = fieldSize - 1;

		counterX = 0; // в каж
		counterO = 0;
		for (int i = 0; i < fieldSize; i++) {
			tempPoint.x = i;
			tempPoint.y = j--;// после присвоения сразу уменшаем j на единицу
			tempFigure = field.getFigure(tempPoint);

			if (tempFigure == null) break; // прекращаем этот цикл если есть хоть один null в диагонале

			switch (tempFigure) {
				case "X":
					counterX++;
					break;
				case "O": counterO++;
			}
		}

		if (counterX == fieldSize) { // "X" занимает всю диагональ?
			winner = "X";
			return; // тут же прекращаем работу метода
		}

		// "O" занимает всю диагональ?
		if (counterO == fieldSize) winner = "O";
		// если нет, то метод оставит winner без изменений
	}

}

package pieces;

import main.ChessBoard;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
            return false;

        if (line == toLine && column == toColumn) return false;

        int lineChange = Math.abs(toLine - line);
        int columnChange = Math.abs(toColumn - column);

        return (lineChange == 2 && columnChange == 1) || (lineChange == 1 && columnChange == 2);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

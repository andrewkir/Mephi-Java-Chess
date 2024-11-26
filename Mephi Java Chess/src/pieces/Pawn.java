package pieces;

import main.ChessBoard;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
            return false;

        if (column != toColumn) return false;

        int lineDirection = getColor().equals("White") ? 1 : -1;

        if (line + lineDirection == toLine) {
            return true;

        } else if ((getColor().equals("White") && line == 1) || (getColor().equals("Black") && line == 6)) {
            return line + lineDirection * 2 == toLine;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
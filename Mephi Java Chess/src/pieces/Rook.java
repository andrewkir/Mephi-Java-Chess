package pieces;

import main.ChessBoard;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
            return false;

        int lineDirection = line == toLine ? 0 : (int) Math.signum(toLine - line);
        int columnDirection = column == toColumn ? 0 : (int) Math.signum(toColumn - column);

        if (lineDirection == columnDirection) return false;

        int currentLine = line + lineDirection;
        int currentColumn = column + columnDirection;

        while (currentLine != toLine || currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) return false;
            currentColumn += columnDirection;
            currentLine += lineDirection;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

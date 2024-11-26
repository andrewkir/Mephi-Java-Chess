package pieces;

import main.ChessBoard;

public abstract class ChessPiece {
    protected String color;
    public Boolean check = true;

    ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}

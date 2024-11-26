package pieces;

import main.ChessBoard;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
            return false;

        int lineAbs = Math.abs(toLine - line);
        int columnAbs = Math.abs(toColumn - column);

        return lineAbs <= 1 && columnAbs <= 1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(this.getColor()) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

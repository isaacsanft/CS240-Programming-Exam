package chess.piececalculators;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator implements PieceMovesCalculator{
    @Override
    public Collection<ChessMove> calculate_moves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> moves = new ArrayList<>();
        ChessGame.TeamColor team_color = board.getPiece(position).getTeamColor();

        int x = position.getRow();
        int y = position.getColumn();

        if (team_color == ChessGame.TeamColor.BLACK) {
            x -= 1;
            ChessPosition target = new ChessPosition(x, y);
            ChessPiece target_piece = board.getPiece(target);
            if (target_piece == null) {
                if (x > 1) {
                    moves.add(new ChessMove(position, target, null));
                }
                else if (x == 1) {
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.BISHOP));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.ROOK));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.KNIGHT));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.QUEEN));
                }
            }
            if (position.getRow() == 7) {
                ChessPosition target1 = new ChessPosition(x, y);
                ChessPiece target1_piece = board.getPiece(target1);
                ChessPosition target2 = new ChessPosition(x - 1, y);
                ChessPiece target2_piece = board.getPiece(target2);
                if (target2_piece == null && target1_piece == null) {
                    moves.add(new ChessMove(position, target2, null));
                }
            }
            int[][] directions = {{-1,-1},{-1,1}};
            for (int[] direction : directions) {
                x = position.getRow() + direction[0];
                y = position.getColumn() + direction[1];
                if (y > 8 || y < 1) {
                    continue;
                }
                target = new ChessPosition(x, y);
                target_piece = board.getPiece(target);
                if (target_piece != null && target_piece.getTeamColor() != team_color && x > 1) {
                    moves.add(new ChessMove(position, target, null));
                }
                else if (target_piece != null && target_piece.getTeamColor() != team_color && x == 1) {
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.BISHOP));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.ROOK));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.KNIGHT));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.QUEEN));
                }
            }
        }
        else if (team_color == ChessGame.TeamColor.WHITE) {
            x += 1;
            ChessPosition target = new ChessPosition(x, y);
            ChessPiece target_piece = board.getPiece(target);
            if (target_piece == null) {
                if (x < 8) {
                    moves.add(new ChessMove(position, target, null));
                }
                else if (x == 8) {
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.BISHOP));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.ROOK));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.KNIGHT));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.QUEEN));
                }
            }
            if (position.getRow() == 2) {
                ChessPosition target1 = new ChessPosition(x, y);
                ChessPiece target1_piece = board.getPiece(target1);
                ChessPosition target2 = new ChessPosition(x + 1, y);
                ChessPiece target2_piece = board.getPiece(target2);
                if (target2_piece == null && target1_piece == null) {
                    moves.add(new ChessMove(position, target2, null));
                }
            }
            int[][] directions = {{1,-1},{1,1}};
            for (int[] direction : directions) {
                x = position.getRow() + direction[0];
                y = position.getColumn() + direction[1];
                if (y > 8 || y < 1) {
                    continue;
                }
                target = new ChessPosition(x, y);
                target_piece = board.getPiece(target);
                if (target_piece != null && target_piece.getTeamColor() != team_color && x < 8) {
                    moves.add(new ChessMove(position, target, null));
                }
                else if (target_piece != null && target_piece.getTeamColor() != team_color && x == 8) {
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.BISHOP));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.ROOK));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.KNIGHT));
                    moves.add(new ChessMove(position, target, ChessPiece.PieceType.QUEEN));
                }
            }
        }
        return moves;
    }
}




/*
set collect, x, y
if black
    iter down
    set target
    if target = null
        if x == 1
            promote
        else if x>1
            add normal
    if x == 7
        add two targets
        if both null
            add second target
    int[][] directions
    for (directions)
        reinit x, y
        if (y out of bounds)
            continue
        set target
        if (target != null, color != team color, x > 1)
            add normal
        else if (target != null, color != team color, x == 1)
            add normal


 */
package it.uniba.game.pieces;



public final class Rook extends Piece{
	//Sub-class of Piece representing the rook

	//new Attributes eventually to be added
	
	//Methods
	public Rook(Color col) {
		
		super(col);
		if (col == Piece.Color.BLACK) {
			symbol="♜";
			
		} else {
			symbol="♖";
			
		}
		//eventually there will be introduced other inits
		
	}
	
	public it.uniba.game.Coordinates reverseMove(it.uniba.game.Coordinates endingPos){
		
		return new it.uniba.game.Coordinates(-1,-1);
		//it returns an invalid value since it can't be moved for now
	}

}

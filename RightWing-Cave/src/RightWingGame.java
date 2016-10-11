
public class RightWingGame {
	
	public static void main(String[] args){
		int[] play = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
		
		System.out.println(solveGameRecursively(play, 0, 0));
	}
	
	public static boolean solveGameRecursively(int[] game, int index, int oldValue){
		
		if (game[index] <= 0){
			return true;
		}
		if (index + game[index] < game.length){
			return solveGameRecursively(game, index + game[index], game[index]);
		}else if (index - game[index] >= 0){	
			if (oldValue == game[index]) {
				return false;
			}
			return solveGameRecursively(game, index - game[index], game[index]);
		}
		
		return false;
		}
	}

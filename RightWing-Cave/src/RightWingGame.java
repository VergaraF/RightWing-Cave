/*
 * Author: Fabian Vergara
 * 
 */
public class RightWingGame {
	public static final int DEFAULT_VALUE = 0;
	public static DoublyLinkedList<Integer> gameToPlay = new DoublyLinkedList<Integer>();
	
	public static void main(String[] args){
		//[5] 8 2 3 1 5 0
		int[] play = {5, 8, 2, 3, 1, 5, 0};
		
		int[] listPlay = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
		
		//gameToPlay.addLast(1);
		
		createGame(listPlay);
		
		System.out.println(gameToPlay);
		//System.out.println(solveGameRecursively(play, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE));
	}
	
	public static void createGame(int [] game){
		for (int number : game){
			gameToPlay.addLast(number);
		}
	}
	
	
	public static boolean solveGameRecursively(int[] game, int index, int oldValue, int oldIndex){
		if (game[index] <= 0){
			return true;
		}
		if (index + game[index] < game.length && (index + game[index] != oldIndex)){
			return solveGameRecursively(game, index + game[index], game[index], index);
		}else if (index - game[index] >= 0){	
			return solveGameRecursively(game, index - game[index], game[index], index);
		}
		
		return false;
		}
	}

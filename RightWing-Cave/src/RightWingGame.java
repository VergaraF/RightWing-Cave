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
		
		int[] listPlay = {4, 8, 5, 2, 4, 5, 1, 6, 2, 0};
		
		//gameToPlay.addLast(1);
		
		createGame(play);
		
		System.out.println(gameToPlay);
		//System.out.println(gameToPlay.first);
		System.out.println(solveGameUsingDataStructure());
		//System.out.println(gameToPlay.moveForward(4, gameToPlay.first));
		//System.out.println(solveGameRecursively(play, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE));
	}
	
	public static void createGame(int [] game){
		for (int number : game){
			gameToPlay.addLast(number);
		}
	}
	
	public static boolean solveGameUsingDataStructure(){
		Node<Integer> current = gameToPlay.first;
		Node<Integer> old = new Node<Integer>(null);
		int counter = 0;
		//current != null && current.data != 0
		while (current != null && current.data != 0){
			//System.out.println(current);
		    if (gameToPlay.canMoveForward(current.data, current) && current.data != old.data){
				System.out.println("Moving forward " + current.data + " spaces.");
				old = current;
				current = gameToPlay.moveForward(current.data, current);
			}else if (gameToPlay.canMoveBackward(current.data, current)){
				System.out.println("Moving backward " + current.data + " spaces.");

				old = current;
				current = gameToPlay.moveBackward(current.data, current);
			}else{
				return false;
			}
		
			//System.out.println("It didn't move forward, nor backward");
		}
		
		if (current.data == 0){
			return true;
		}
		
		return false;
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

/*
 * Author : Fabian Vergara
 * Date   : Wednesday, October 19, 2016
 * 
 */
public class RightWingGame {
	public static final int DEFAULT_VALUE = 0;
	public static DoublyLinkedList<Integer> gameToPlay = new DoublyLinkedList<Integer>();
	
	public static void main(String[] args){
		//[5] 8 2 3 1 5 0
		int[] play1 = {5, 8, 2, 3, 1, 5, 0};
		int[] play2 = {4, 8, 5, 2, 4, 5, 1, 6, 2, 0};
		int[] play3 = {3, 3, 3 ,3 ,3, 3, 3, 0};
		int[] play4 = {2, 3, 4, 5, 2, 7, 4, 8, 2, 9, 1, 4, 9, 0};
		int[] play5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6 ,5 ,4, 6, 0};
		int[] play6 = {3, 3, 3, 5, 2, 4, 6, 3, 2, 1, 4, 6, 9, 3, 4, 2, 1, 0};
		int[] play7 = {3,3,3,3,3,3,3,2,2,2,0};

		/*int[] play8
		int[] play9
		int[] play10
		int[] play11
		int[] play12
		int[] play13
		int[] play14
		int[] play15
		int[] play16
		int[] play17
		int[] play18
		int[] play19
		int[] play20*/

		
		
		//gameToPlay.addLast(1);
		
		createGame(play6);
		
		System.out.println(gameToPlay);
		//System.out.println(gameToPlay.first);
		System.out.println(solveGameUsingDataStructure());
		//System.out.println(gameToPlay.moveForward(4, gameToPlay.first));
		//System.out.println(solveGameRecursively(play6, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE));
	}
	
	public static void createGame(int [] game){
		for (int number : game){
			gameToPlay.addLast(number);
		}
	}
	
	public static boolean solveGameUsingDataStructure(){
		Node<Integer> current       = gameToPlay.first;
		Node<Integer> old           = new Node<Integer>(null);
		Node<Integer> possibleCycle = new Node<Integer>(null);
		

		while (current != null && current.data != 0){
			//System.out.println(current);
			if (current == possibleCycle){
				return false;
			}
		    if (gameToPlay.canMoveForward(current.data, current)     && 
		    	gameToPlay.moveForward(current.data, current) != old && 
		    	current != possibleCycle){
				System.out.println("Moving forward " + current.data + " spaces.");
				old = current;
				current = gameToPlay.moveForward(current.data, current);
				//gameToPlay.canMoveBackward(current.data, current)
		     
			}else if (gameToPlay.canMoveBackward(current.data, current)){
				if ( gameToPlay.moveBackward(current.data, current) == old){
			    	possibleCycle = current;
				}
				System.out.println("Moving backward " + current.data + " spaces.");
				old = current;
				current = gameToPlay.moveBackward(current.data, current);
			}else{
				return false;
			}

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

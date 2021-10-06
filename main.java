package othello;

import java.util.Scanner;

public class main {
	public static void main (String[] args) {
		Board board = new Board();
		System.out.println("-----GAME　START-----");
		board.setInitial();
		board.showBoard();
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(board.onGame) {
	
			System.out.println("石を置く横の座標（1~8)を入力してください:");
		    int x = scanner.nextInt();
		    
		    System.out.println("石を置く縦の座標(1~8)を入力してください:");
		    int y = scanner.nextInt();
		    
		    board.evaluateStone(x, y);
			
			
		    if(!board.truePlace) {
		    	System.out.println("***そこに石を置くことはできません");
		    	while(!board.truePlace) {
			    	 System.out.println("石を置く横の座標（1~8)を入力してください:");
					    x = scanner.nextInt();
					    
					    System.out.println("石を置く縦の座標(1~8)を入力してください:");
					    y = scanner.nextInt();
					    board.evaluateStone(x, y);
					    if(board.truePlace) {
				    		 break;
				    	 }
					    System.out.println("***そこに石を置くことはできません");
					    
					   
					    
			    }
		    }
		    System.out.println("横が["+x+"]で縦が["+y+"]の座標に"+board.getStone()+"を置きました");
		    System.out.println("----------------------");
		    board.processGame(x, y);
		}
		
	}
}

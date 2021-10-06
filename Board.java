package othello;

public class Board {
	
	private String[][] board = {
			{"　","１","２","３","４","５","６","７","８","　"},
			{"１","・","・","・","・","・","・","・","・","　"},
			{"２","・","・","・","・","・","・","・","・","　"},
			{"３","・","・","・","・","・","・","・","・","　"},
			{"４","・","・","・","○" ,"●" ,"・","・","・","　"},
			{"５","・","・","・","●" ,"○" ,"・","・","・","　"},
			{"６","・","・","・","・","・","・","・","・","　"},
			{"７","・","・","・","・","・","・","・","・","　"},
			{"８","・","・","・","・","・","・","・","・","　"},
			{"　","　","　","　","　","　","　","　","　","　"}
	};	
	boolean onGame;
	private String playStone;
	private String nextStone;
	boolean truePlace = false;
	boolean turnAble = false;
	public void setInitial () {
		onGame = true;
		playStone = "●";
		nextStone = "○";
		String[][] board = {
				{"　","ａ","ｂ","ｃ","ｄ","ｅ","ｆ","ｇ","ｈ","　"},
				{"１","・","・","・","・","・","・","・","・","　"},
				{"２","・","・","・","・","・","・","・","・","　"},
				{"３","・","・","・","・","・","・","・","・","　"},
				{"４","・","・","・","○" ,"●" ,"・","・","・","　"},
				{"５","・","・","・","●" ,"○" ,"・","・","・","　"},
				{"６","・","・","・","・","・","・","・","・","　"},
				{"７","・","・","・","・","・","・","・","・","　"},
				{"８","・","・","・","・","・","・","・","・","　"},
				{"　","　","　","　","　","　","　","　","　","　"}
		};	
	}
	
	public String getStone() {
		return this.playStone;
	}
	
	public void adaptX(String x) {
		 switch(x) {
	      case "a": 
	      }
	}
	public void showBoard () {
		int countBlack = 0;
		int countWhite = 0;
		boolean isEmpty = false;
		
		for (int i=0; i<=9; i++) {//盤の表示
			for (int j=0; j<=9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
		for(String[] s :board) {//白玉、黒玉の数の判定
			for(String s1 : s) {
				if(s1.equals("・")) {
					isEmpty = true;
				}else if(s1.equals("○")){
					countWhite ++;
				}else if(s1.equals("●")){
					countBlack ++;
				}
			}
		}
		System.out.println(" --------");
		System.out.println("| ●の数:"+ countBlack+" |");
		System.out.println("| ○の数:"+ countWhite+" |");
		System.out.println(" --------");
		
		if(isEmpty) {
			System.out.println(">>>"+playStone+"のターン");
		}else {
			System.out.println("!!!ゲーム終了!!!");
			if(countBlack>countWhite) {
				System.out.println("🎉~~勝者は「●」~~🎉");
			}else if(countBlack<countWhite) {
				System.out.println("🎉~~勝者は「○」~~🎉");
			}
			onGame = false;
		}
		
		
	}
	public void evaluateStone(int x, int y) {
		
		if(x>8||y>8) {
			truePlace = false;
		}
		turnAble = false;
		truePlace = false;
		
		for(int i = -1;i < 2;i++) {
			
			for(int j = -1;j < 2 ; j++) {
				if(board[y+i][x+j].equals(nextStone)) {
					judgeStone(x,y);
				}
			}
		}
		if(board[y][x].equals("○")||board[y][x].equals("●")) {
			truePlace = false;
		}
	}
	public void processGame(int x, int y){
		
		if(board[y][x].equals("・")) {
			if(playStone.equals("●")) {
				board[y][x] = "●";
			}else if(playStone.equals("○")) {
				board[y][x] = "○";
			}
		}
		
		
		turnStone(x,y);
		String tenStorn = playStone;
		playStone = nextStone;
		nextStone = tenStorn;
		showBoard();
	}
	
	public void turnStone(int x, int y) {
		turnAble = true;
		turnN(x,y);
		turnNE(x,y);
		turnE(x,y);
		turnSE(x,y);
		turnS(x,y);
		turnSW(x,y);
		turnW(x,y);
		turnNW(x,y);

	}
	
	public void judgeStone(int x, int y) {
		
		turnN(x,y);
		turnNE(x,y);
		turnE(x,y);
		turnSE(x,y);
		turnS(x,y);
		turnSW(x,y);
		turnW(x,y);
		turnNW(x,y);

	}
	
	public void turnN(int x, int y) {
		if (y > 2) {
		      String besideStone = board[y - 1][x];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y - i < 1 || board[y - i][x].equals("・")) {
		            break;
		          } else if (board[y - i][x].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		 board[y - i2][x] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		            }
		            break;
		          }
		        }
		      }
		}

	}
	public void turnNE(int x, int y) {
		if (y > 2 && x < 7) {
		      String besideStone = board[y - 1][x + 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y - i < 1 || x + i > 8 || board[y - i][x + i].equals("・")) {
		            break;
		          } else if (board[y - i][x + i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if (turnAble) {
		            		board[y - i2][x + i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		              
		            }
		            break;
		          }
		        }
		      }
		}
	}
	public void turnE(int x, int y) {
		if (x < 7) {
		      String besideStone = board[y][x + 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (x + i > 8 || board[y][x + i].equals("・")) {
		            break;
		          } else if (board[y][x + i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		board[y][x+i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		              
		            }
		            break;
		          }
		        }
		      }
		}

	}
	public void turnSE(int x, int y) {
		if (y < 7 && x < 7) {
		      String besideStone = board[y + 1][x + 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y + i > 8 || x + i > 8 || board[y + i][x + i].equals("・")) {
		            break;
		          } else if (board[y + i][x + i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		board[y + i2][x + i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		              
		            }
		            break;
		          }
		        }
		      }
		}
	}
	public void turnS(int x, int y) {
		if (y < 7) {
		      String besideStone = board[y + 1][x];
		     
		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y + i > 8|| board[y + i][x].equals("・")) {
		            break;
		          } else if (board[y + i][x].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		 board[y + i2][x] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		             
		            }
		            break;
		          }
		        }
		      }
		}
	}
	public void turnSW(int x, int y) {
		if (y < 7 && x > 2) {
		      String besideStone = board[y + 1][x - 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y + i > 8 || x - i < 1 || board[y + i][x - i].equals("・")) {
		            break;
		          } else if (board[y + i][x - i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		board[y + i2][x - i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		              
		            }
		            break;
		          }
		        }
		      }
		}
	}
	public void turnW(int x, int y) {
		if (x > 2) {
		      String besideStone = board[y][x - 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (x - i < 1|| board[y][x - 1].equals("・")) {
		            break;
		          } else if (board[y][x - i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		 board[y][x - i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		             
		            }
		            break;
		          }
		        }
		      }
		}
	}
	public void turnNW(int x, int y) {
		if (y > 2 && x > 2) {
		      String besideStone = board[y - 1][x - 1];

		      if (besideStone.equals(nextStone)) {
		        for (int i = 2;; i++) {
		          if (y - i < 1 || x - i < 1 || board[y - i][x - i].equals("・")) {
		            break;
		          } else if (board[y - i][x - i].equals(playStone)) {
		            for (int i2 = 1; i2 < i; i2++) {
		            	if(turnAble) {
		            		 board[y - i2][x - i2] = playStone;
		            	}else {
		            		truePlace = true;
		            	}
		             
		            }
		            break;
		          }
		        }
		      }
		}
	}
	
	

}

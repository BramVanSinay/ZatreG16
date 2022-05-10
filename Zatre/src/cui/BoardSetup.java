package cui;
import domein.Board;
import java.util.Arrays;
 
public class BoardSetup {
 
    public static void main(String[] args) {
        Board anotherBoard = new Board();
 
    	int columnnumber = 1;
    	int columnnumber2 = 13;
        for (int i=1; i<14; i++) {
            anotherBoard.addList(i, columnnumber, "G");
            anotherBoard.addList(i, columnnumber2, "G");
            columnnumber++;
            columnnumber2--;
        }
        
        anotherBoard.addList(0, 6, "G");
        anotherBoard.addList(0, 8, "G");
        
        anotherBoard.addList(6, 0, "G");
        anotherBoard.addList(6, 14, "G");
        anotherBoard.addList(8, 0, "G");
        anotherBoard.addList(8, 14, "G");
        
        anotherBoard.addList(14, 5, "G");
        anotherBoard.addList(14, 8, "G");
        
  
        String[][] GameBoard = anotherBoard.getList();
        
        for (int count = 0; count < 15; count++) {
            for (int count2 = 0; count2 < 15; count2++) {
            	if (GameBoard[count][count2] == null)
            		GameBoard[count][count2] = "w";
            }
        }
  
        for (int e=0; e<4; e++) {
        	anotherBoard.addList(e, 0, " ");
        	anotherBoard.addList(14-e, 0, " ");
        	anotherBoard.addList(e, 14, " ");
        	anotherBoard.addList(14-e, 14, " ");
        	
        	anotherBoard.addList(0, e, " ");
        	anotherBoard.addList(0, 14-e, " ");
        	anotherBoard.addList(14, 14-e, " ");
        }
        
    	anotherBoard.addList(0, 7, " ");
    	anotherBoard.addList(7, 0, " ");
    	anotherBoard.addList(7, 14, " ");
    	anotherBoard.addList(14, 6, " ");
    	anotherBoard.addList(14, 7, " ");
    	
    	for (int e=0; e<3; e++) {
        	anotherBoard.addList(14, e, " ");
    	}
        
        
		for (int i=0; i<15; i++) {
			System.out.println(Arrays.toString(GameBoard[i]));
		}
		
		

    }
}
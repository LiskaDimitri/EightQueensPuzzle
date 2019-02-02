package eightqueenspuzzle;

/**
 *
 * @author Dimitri Liska
 */
public class EightQueensPuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Board differentSizes = new Board(10);
        Board eightByEight = new Board();
        
    //    System.out.println(sixBysix);
        
        boolean solved = eightByEight.solve();
        if (solved){
            System.out.println("A solution was found!");
            eightByEight.printBoard();
        }
        else{
            System.out.println("No solution, Try a different board size");
        }
        
//        boolean solved2 = differentSizes.solve();
//        if (solved2){
//            System.out.println("A solution was found!");
//            differentSizes.printBoard();
//        }
//        else{
//            System.out.println("No solution, Try a different board size");
//            differentSizes.printBoard();
//        }
    }
    
}

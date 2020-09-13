

import java.io.BufferedReader;
import java.util.*;

public class GameOfLifeCycle {
    public static void main(String[]args){
        Board board = new Board();

        board.createBoard();
        board.countAliveNeighbours(2,2);
        board.nextCycle();

//        BufferedReader bufferedReader = new BufferedReader(System.in);


        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to generate new cycle?");
        while (true) {
            String answer = sc.nextLine();
            if(answer.equals("No")){
                break;
            }
            board.nextCycle();
            System.out.println("Do you want to generate new cycle?");

        }

            System.out.println("The end of cycle");

    }






}

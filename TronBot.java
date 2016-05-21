import java.util.*;
import java.io.*;
/**
 * 
 * Vaed Prasad
 * 
 *  Send your move.  
 *  This can be Tron.Direction.NORTH,
 *  Tron.Direction.SOUTH, 
 *  Tron.Direction.EAST, or
 *  Tron.Direction.WEST.    
 */

public class TronBot {
    private static boolean isGreatMove = false;
    private static int[] myPos = new int[2];
    private static ArrayList<ArrayList<Tron.Tile>> map;

    public static void main(String[] args) {
        Tron.init();        // Call this to initialize networking and the debug file
        // We can't print to console, because that channel is used for IO with the environment.
        // We therefore print to either debug1.log or debug2.log. The first is for player1, the second for player two
        // Use log() rather than print.
        while (true) {         // Execute loop forever (or until game ends)
            map = Tron.getMap();
            ArrayList<Tron.Direction> goods = new ArrayList<Tron.Direction>();
            myPos = TronUtils.findMe(map);
            moveFirstFree();
        }
    }

    public static void moveFirstFree() {
        boolean moveFound = false;
        for (int i = 1; i <= 4; i++) {
            if (isGoodMove(i)) {
                moveFound = true;
                move(i);
                break;
            }
        }
        if (!moveFound) move(0);
    }

    public static boolean isGoodMove(int dir) {
        return TronUtils.isFree(map, TronUtils.movedPos(myPos,dir)) && !moveWillTrap(dir);
    }
    
    public static boolean moveWillTrap(int dir) {
        int[] nextPos = TronUtils.movedPos(myPos, dir);
        return TronUtils.adjacentFree(map, nextPos).isEmpty();
    }

    
    public static void move(int dir) {
        switch(dir) {
            case 1: 
                up();
                break;
            case 2:
                down();
                break;
            case 3:
                left();
                break;
            case 4:
                right();
                break;
            default:
                move((int)(Math.random() * 4) + 1);
        }
    }
    public static void up() {
        Tron.sendMove(Tron.Direction.SOUTH);
    }

    public static void down() {
        Tron.sendMove(Tron.Direction.NORTH);
    }   

    public static void left() {
        Tron.sendMove(Tron.Direction.WEST);
    }   

    public static void right() {
        Tron.sendMove(Tron.Direction.EAST);
    }
    
    

}
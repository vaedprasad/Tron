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
    private static int[] myPos = new int[2];
    private static ArrayList<ArrayList<Tron.Tile>> map;
    /*
    public static void main(String[] args) {
        Tron.init();
        while (true) {         // Execute loop forever (or until game ends)
            map = Tron.getMap();
            ArrayList<Tron.Direction> goods = new ArrayList<Tron.Direction>();
            myPos = TronUtils.findMe(map);
            moveFirstFree();
        }
    }*/
    
    public static void main(String[] args) {
        Tron.init();
        int count = 0;
        
        while (true) {
            count++;
           
            ArrayList<ArrayList<Tron.Tile>> mList = Tron.getMap();
            int[][] m = new int[mList.size()][mList.get(0).size()];
            for (int i = 0; i < mList.size(); i++) {
                for (int j = 0; j < mList.get(i).size(); j++) {
                    m[i][j] = mList.get(i).get(j).ordinal();
                }
            }
            
            int myLocX = 0, myLocY = 0;
            for(int y = 0; y < 16; y++)  {
                for(int x = 0; x < 16; x++) {
                    if(Tron.Tile.values()[m[y][x]] == Tron.Tile.ME) {
                        myLocX = x;
                        myLocY = y;
                    }
                }
            }
            
            boolean [] safe = emptyAdjacentSquares(m, myLocX, myLocY);
            
            int [] dirEmptyCount = new int[4];
            for(int a = 0; a < 4; a++) {
                if(safe[a]) {
                    int[] possibleSquare = getLocation(myLocX, myLocY, a);
                    if(possibleSquare[0] != -1 && possibleSquare[1] != -1) {
                        boolean [] around = emptyAdjacentSquares(m, possibleSquare[0], possibleSquare[1]);
                        dirEmptyCount[a] = 0;
                        for(int b = 0; b < 4; b++) if(around[b]) dirEmptyCount[a]++;
                    }
                }
                else dirEmptyCount[a] = 5;
            }
            
            
            int minVal = 1000, minValLoc = 0;
            for(int a = 0; a < 4; a++) {
                if(dirEmptyCount[a] < minVal) {
                    minVal = dirEmptyCount[a];
                    minValLoc = a;
                }
            }
            Tron.sendMove(Tron.Direction.values()[minValLoc]);
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
        if (!moveFound){
            for (int i = 1; i <= 4; i++) {
                if (isFineMove(i)) {
                    moveFound = true;
                    move(i);
                    break;
                }
            } 
        }
        if (!moveFound)move(0);
    }

    public static boolean isGoodMove(int dir) {
        return TronUtils.isFree(map, TronUtils.movedPos(myPos,dir)) && !moveWillTrap(dir);
    }

    public static boolean isFineMove(int dir) {
        return TronUtils.isFree(map, TronUtils.movedPos(myPos,dir));
    }

    public static boolean moveWillTrap(int dir) {
        int[] nextPos = TronUtils.movedPos(myPos, dir);
        return TronUtils.adjacentFree(map, nextPos).isEmpty();
    }

    public static void move(int dir) {
        switch(dir) {
            case 1: up();
            break;
            case 2:down();            
            break;
            case 3:left();           
            break;
            case 4:right();            
            break;
            default:move((int)(Math.random() * 4) + 1);        
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
    
    public static String stringFromDirection(int dir) {
        return dir == 0 ? "NORTH" : dir == 1 ? "EAST" : dir == 2 ? "SOUTH" : dir == 3 ? "WEST" : "NONSENSE";
    }
    
    public static boolean [] emptyAdjacentSquares(int [][] map, int locX, int locY) {
        boolean [] empty = new boolean[4];
        empty[0] = locY != 15 && map[locY + 1][locX] == 0;
        empty[1] = locX != 15 && map[locY][locX + 1] == 0;
        empty[2] = locY != 0 && map[locY - 1][locX] == 0;
        empty[3] = locX != 0 && map[locY][locX - 1] == 0;
        return empty;
    }
    
    public static int[] getLocation(int locX, int locY, int dir) {
        if(dir == 0) return locY == 15 ? new int[]{ -1, -1 } : new int[]{ locX, locY + 1 };
        if(dir == 1) return locX == 15 ? new int[]{ -1, -1 } : new int[]{ locX + 1, locY };
        if(dir == 2) return locY == 0 ? new int[]{ -1, -1 } : new int[]{ locX, locY - 1 };
        if(dir == 3) return locX == 0 ? new int[]{ -1, -1 } : new int[]{ locX - 1, locY };
        return new int[]{ -1, -1 };
    }
    
}
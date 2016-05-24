
/**
 * Write a description of class Notes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notes
{
    /**public static boolean isGreatMove(ArrayList<ArrayList<Tron.Tile>> gameMap, Tron.Direction move) {
        int[] position = null;
        for(int y = 0; y < gameMap.size(); y++) {
            for(int x = 0; x < gameMap.size(); x++) {
                if(gameMap.get(y).get(x) == Tron.Tile.ME){
                    position = new int[] {x,y};
                    Tron.logln(position[0]+" , "+position[1]);
                }
            }
        }  

        int[] newPosition = position;
        if(move== Tron.Direction.NORTH) 
            newPosition[1] += 1;
        if(move== Tron.Direction.SOUTH) 
            newPosition[1] -= 1;
        if(move== Tron.Direction.WEST) 
            newPosition[0] -= 1;
        if(move== Tron.Direction.EAST) 
            newPosition[0] += 1;

        return newPosition[0] >= 0 && newPosition[0] < 16 && newPosition[1] >= 0 && newPosition[1] < 16 && gameMap.get(newPosition[1]).get(newPosition[0]) == Tron.Tile.EMPTY;

    }

    /** 
     * Get an integer map of the field. Each int
     * can either be Tron.Tile.EMPTY, Tron.Tile.ME, 
     * Tron.Tile.OPPONENT, Tron.Tile.TAKEN_BY_ME, or
     * Tron.Tile.TAKEN_BY_OPPONENT.
     * 
     *
     */
    /**public static void findPos(ArrayList<ArrayList<Tron.Tile>> gameMap) {
        for(int y = 0; y < gameMap.size(); y++) {
            for(int x = 0; x < gameMap.size(); x++) {
                if(gameMap.get(y).get(x) == Tron.Tile.ME) {     
                    Tron.log("position: " + x + ", " + y);
                    pos[0] = x;
                    pos[1] = y;
                }
                else if(gameMap.get(y).get(x) == Tron.Tile.OPPONENT) {     
                    //Tron.log("position: " + x + ", " + y);
                    posOpponent[0] = x;
                    posOpponent[1] = y;
                }
            }
        }
    }
    
    /**
     *  Send your move.  
     *  This can be Tron.Direction.NORTH,
     *  Tron.Direction.SOUTH, 
     *  Tron.Direction.EAST, or
     *  Tron.Direction.WEST.   
     *
    public static void move(int input) {
        if (input == 1) {
            up();
        }
        else if (input == 2) {
            down();
        }
        else if (input == 3) {
            left();
        }
        else if (input == 4) {
            right();
        }
    }

    public static void random(ArrayList<ArrayList<Tron.Tile>> gameMap) {
        Random random = new Random();
        int randomDir = -1;
        ArrayList<Integer> dirs = new ArrayList<Integer>();
        dirs.add(1);
        dirs.add(2);
        dirs.add(3);
        dirs.add(4);
        for (int i = 1; i <= 4; i++) {
            randomDir = dirs.get(random.nextInt(dirs.size()));            //pick a random direction
            int tempX = x;
            int tempY = y;
            switch (randomDir) {
                case 1:
                tempY-=1;
                break;
                case 2:
                tempY+=1;
                break;
                case 3:
                tempX-=1;
                break;
                case 4:
                tempX+=1;
                break;
            }
            if (!(tempX > 15 || tempX < 0 || tempY > 15 || tempY < 0)) {
                if (gameMap.get(tempY).get(tempX) == Tron.Tile.EMPTY) 
                    break; //if the direction's valid, go with it
                else dirs.remove(randomDir);
            }
            else dirs.remove(randomDir);
        }
        if (randomDir == -1) randomDir = 1;
        move(randomDir);
    }*/
}

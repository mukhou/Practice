package matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPathInMaze {

    private class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    List<Point> getPath(boolean[][] maze) {
        if(maze == null || maze.length == 0){
            return null;
        }

        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();

        if(getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)){
            return path;
        }
        return null;


    }

    private boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> failedPoints) {

        //boundary conditions
        if(row < 0 || col < 0 | !maze[row][col]){
            return false;
        }

        Point p =  new Point(row, col);
        boolean isAtOrigin = (row == 0) || (col == 0);

        if(failedPoints.contains(p)){
            return false;
        }

        //If there's a path from start to my current location, addCharacter my l o c a t i o n .
        if(isAtOrigin || getPath(maze, row - 1, col, path, failedPoints) ||
                getPath(maze, row, col - 1, path, failedPoints)){
            path.add(p);
            return true;
        }

        //otherwise addCharacter point
        failedPoints.add(p);
        return false;

    }
}

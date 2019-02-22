package dev.henry.maze;

import java.util.ArrayList;
import java.util.List;

public class DepthFirst {
    private List<Integer> path;
    private int[][] maze;
    private int x;
    private int y;

    public DepthFirst(int[][] maze, int x, int y) {
        path = new ArrayList<>();
        this.maze = maze;
        this.x = x;
        this.y = y;
        depthFirst(this.maze, this.x, this.y, path);
        System.out.println("Path found using Deep First Search 'DFS'");
    }

    public List<Integer> getPath() {
        return path;
    }

    private boolean depthFirst(int[][] maze, int x, int y, List<Integer> path) {
        if (maze[x][y] == 8) {
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[x][y] == 0) {
            maze[x][y] = 5;


            if (depthFirst(maze, x - 1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            if (depthFirst(maze, x + 1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            if (depthFirst(maze, x, y + 1, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            if (depthFirst(maze, x, y - 1, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }

}
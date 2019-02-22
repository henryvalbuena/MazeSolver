package dev.henry.maze;

public class SolveMaze {

    public static void main(String[] args) {
        ImageProcess img = new ImageProcess(78, 79); // Provide the position x, y to exit the maze

        /* DFS */
        DepthFirst dfs = new DepthFirst(img.getMaze(), 1, 0); // Provide the starting point of the maze

        for (int i = 0; i < dfs.getPath().size() - 2; i += 2) {
            img.setImage(dfs.getPath().get(i), dfs.getPath().get(i + 1));
        }

        img.printImage();
    }
}

package dev.henry.maze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcess {
    private BufferedImage image;
    private int width;
    private int height;
    private int[][] maze;

    public ImageProcess(int x, int y) {
        try {
            image = ImageIO.read(new File("path/images/Maze04.png"));
            width = image.getWidth();
            height = image.getHeight();
            maze = new int[width][height];

            for (int i = 0; i  < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(i + ", " + y + ", ");
                    /* load image */
                    if (image.getRGB(i, j) == -1) { /* if this pixel is white */
                        maze[i][j] = 0;
                    }
                    else maze[i][j] = 1;
                }
            }
            maze[x][y] = 8;

        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
    public int[][] getMaze() {
        System.out.println("Image processed.");
        return maze;
    }
    public void setImage(int row, int col) {
        image.setRGB(row, col, new Color(0, 200, 20).getRGB());
    }

    public void printImage() {
        System.out.println("********** Printing ************");
        try {
            File file = new File("path/images/puzzleDone.png");
            ImageIO.write(image, "png", file);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Done...");
    }

}
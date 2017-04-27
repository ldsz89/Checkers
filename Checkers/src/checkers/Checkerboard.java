/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author LeAndre
 */
public class Checkerboard {
    
    private int numRows;
    private int numCols;
    
    private double boardWidth;
    private double boardHeight;
    
    private double rectWidth;
    private double rectHeight;
    
    private Color lightColor;
    private Color darkColor;
    
    private AnchorPane board = null;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
        rectWidth = boardWidth/numCols;
        rectHeight = boardHeight/numRows;
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    /* Builds board UI and returns AnchorPane as root object */
    public AnchorPane build() {
        //board.getChildren().clear();
        board = new AnchorPane();
        
        Rectangle rect;
        
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                if(row % 2 == 0) {
                    if(col % 2 == 0) {
                        rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else {
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                }
                else {
                    if (col % 2 == 1) {
                        rect = new Rectangle(rectWidth, rectHeight, lightColor);
                    }
                    else {
                        rect = new Rectangle(rectWidth, rectHeight, darkColor);
                    }
                }
                
                rect.setX(col * rectWidth);
                rect.setY(row * rectHeight);
                
                board.getChildren().add(rect);
            }
        }
        board.setMaxHeight(boardHeight);
        board.setMaxWidth(boardWidth);
        
        return board;
    }
    
    /* Returns the AnchorPane made by build() or null if one hasn't been built yet */
    public AnchorPane getBoard() {
        if(board == null) {
            return null;
        }
        return board;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectWidth;
    }
    
    public double getRectangleHeight() {
        return rectHeight;
    }
    
}
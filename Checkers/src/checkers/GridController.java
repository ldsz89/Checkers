/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LeAndre
 */
public class GridController implements Initializable {
    
    @FXML
    private VBox background = new VBox();
    @FXML
    private MenuBar menubar = new MenuBar();
    @FXML
    private StackPane stackpane = new StackPane();
    
    private Checkerboard board;
    
    private Stage stage;
    private Scene scene;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void ready(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
        
        ChangeListener<Number> listener = new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                clearBoard();
                render(board.getNumRows(), board.getNumCols(), board.getLightColor(), board.getDarkColor());
            } 
        };
        
        scene.widthProperty().addListener(listener);
        scene.heightProperty().addListener(listener);
        
        render(8, 8);
    }
    
    public void render(int rows, int cols) {
        board = new Checkerboard(rows, cols, scene.getWidth(), scene.getHeight() - menubar.getHeight());
        stackpane.getChildren().add(board.build());
    }
    
    public void render(int rows, int cols, Color light, Color dark) {
        if(scene.getWidth() > scene.getHeight())
            board = new Checkerboard(rows, cols, scene.getHeight() - menubar.getHeight(), scene.getHeight() - menubar.getHeight(), light, dark);
        else
            board = new Checkerboard(rows, cols, scene.getWidth(), scene.getWidth(), light, dark);
        
//        background.setAlignment(Pos.CENTER);
        stackpane.setAlignment(Pos.CENTER);
        stackpane.getChildren().add(board.build());
    }
    
    @FXML
    public void selectSize(ActionEvent event) {
        clearBoard();
        MenuItem menuItem = (MenuItem)(event.getSource());
        switch(menuItem.getId()) {
            case "16 x 16":
                render(16, 16, board.getLightColor(), board.getDarkColor());
                break;
            case "10 x 10":
                render(10, 10, board.getLightColor(), board.getDarkColor());
                break;
            case "8 x 8":
                render(8, 8, board.getLightColor(), board.getDarkColor());
                break;
            case "3 x 3":
                render(3, 3, board.getLightColor(), board.getDarkColor());
                break;
            default:
                render(8, 8, board.getLightColor(), board.getDarkColor());
        }
    }
    
    @FXML
    public void handleColorDefault(ActionEvent event) {
        clearBoard();
        render(board.getNumRows(), board.getNumCols(), Color.RED, Color.BLACK);
    }
    
    @FXML
    public void handleColorBlue(ActionEvent event) {
        clearBoard();
        render(board.getNumRows(), board.getNumCols(), Color.SKYBLUE, Color.DARKBLUE);
    }
    
    public void clearBoard() {
        board.getBoard().getChildren().clear();
    }
}

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by osama on 8/23/16.
 * The main class
 */
public class Main extends Application{
    public static int[][] data=new int[10][10];
    private int google=-1;
    Drawer drawer=new Drawer(400,400);
    Button btn =new Button("Start");
    Button clr;
    BFS bfs=new BFS();
   static Graph g = new Graph(9);
    ComboBox selecter;
    public static void main(String[] args){

        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(2,4);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        btn.setOnAction(actionEvent ->{
            next();

        });
        selecter=new ComboBox();
        ObservableList<Integer> items= FXCollections.observableArrayList(list);
        selecter.setItems(items);
        selecter.setOnAction(actionEvent -> {
            bfs.setRoot((int)selecter.getValue());
            // color the root as queued
            int tmp[]={(int)selecter.getValue()};
            drawer.fillBox(-1,tmp);
            selecter.setDisable(true);
        });
        HBox hbox=new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(new Label("Select Root"),selecter,btn);
       clr=new Button("Reset");
        clr.setOnAction(actionEvent -> {
            reset();
        });
        clr.setDisable(true);

        vBox.getChildren().addAll(drawer.drawGraph(),hbox,clr);
        Scene scene=new Scene(vBox,400,400);
        stage.setScene(scene);
        stage.setTitle("Graph demo");
        stage.show();

    }
    private void next(){
        if(google==-1){
            bfs.searchNonRecursive();
        }
        btn.setText("next");
        google++;
        if(data[google][0]==0){
            btn.setDisable(true);
            clr.setDisable(false);
            Alert x=new Alert(Alert.AlertType.WARNING);
            x.setTitle("No more next");
            x.setContentText("All nodes are visited");
            x.showAndWait();
        }

        int parent;
        int[] tmp=new int[10];
        for (int j = 1; j < data[google].length; j++) {
            tmp[j-1]=data[google][j];
        }
        parent=data[google][0];
        drawer.fillBox(parent,tmp);
    }
    private void reset(){
        selecter.setDisable(false); // enable selector
        btn.setText("start"); // change button text to start from next
        btn.setDisable(false); // ensure that button is enabled
        google=-1;          // reset google to default
        data=new int[10][10]; // reset the data
        drawer.reset(); // reset the canvas
        g.reset(); // reset the Graph
        clr.setDisable(true);


    }

}

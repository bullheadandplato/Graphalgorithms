import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by osama on 8/25/16.
 * use the canvas to draw the graph
 */
public class Drawer{
    private Canvas canvas;

    private static int[] box1={100,200};
    private static int[] box2={100,300};
    private static int[] box3={300,200};
    private static int[] box4={300,300};
    private static int[] box5={200,250};

    private static int[] text1={115,225};
    private static int[] text2={115,325};
    private static  int[] text3={315,225};
    private static int[] text4={315,325};
    private static int[] text5={215,275};

    private GraphicsContext graphicsContext;

    Drawer(int width,int height){
        canvas=new Canvas(width,height);
        graphicsContext=canvas.getGraphicsContext2D();


    }
    public Canvas drawGraph(){
        graphicsContext.clearRect(0,0,canvas.getHeight(),canvas.getHeight());

       graphicsContext.fillText("1",115,225);
       graphicsContext.fillText("2",115,325);
       graphicsContext.fillText("3",315,225);
       graphicsContext.fillText("4",315,325);
       graphicsContext.fillText("5",215,275);

       graphicsContext.strokeRoundRect(100,200,40,40,40,40);
       graphicsContext.strokeRoundRect(100,300,40,40,40,40);
       graphicsContext.strokeRoundRect(300,200,40,40,40,40);
       graphicsContext.strokeRoundRect(300,300,40,40,40,40);
       graphicsContext.strokeRoundRect(200,250,40,40,40,40);

       graphicsContext.strokeLine(120,240,120,300);
       graphicsContext.strokeLine(140,220,300,220);
       graphicsContext.strokeLine(320,240,242,270);
       graphicsContext.strokeLine(320,240,320,300);
       graphicsContext.strokeLine(140,320,300,320);

       graphicsContext.stroke();
        return canvas;
    }
    public void fillBox(int number,int[] enqueud){
        graphicsContext.setFill(Color.BLACK);

        switch (number){
            case 1:{
                graphicsContext.fillRoundRect(box1[0],box1[1],40,40,40,40);
                graphicsContext.setFill(Color.WHEAT);
                graphicsContext.fillText("1",text1[0],text1[1]);
                break;
            }
            case 2:{
                graphicsContext.fillRoundRect(box2[0],box2[1],40,40,40,40);
                graphicsContext.setFill(Color.WHEAT);
                graphicsContext.fillText("2",text2[0],text2[1]);
                break;
            }case 3:{
                graphicsContext.fillRoundRect(box3[0],box3[1],40,40,40,40);
                graphicsContext.setFill(Color.WHEAT);
                graphicsContext.fillText("3",text3[0],text3[1]);
                break;
            }case 4:{
                graphicsContext.fillRoundRect(box4[0],box4[1],40,40,40,40);
                graphicsContext.setFill(Color.WHEAT);
                graphicsContext.fillText("4",text4[0],text4[1]);
                break;
            }case 5:{
                graphicsContext.fillRoundRect(box5[0],box5[1],40,40,40,40);
                graphicsContext.setFill(Color.WHEAT);
                graphicsContext.fillText("5",text5[0],text5[1]);
                break;
            }
        }
        for (int n:
                enqueud) {
            if (n==0)
                break;

            graphicsContext.setFill(Color.GREY);
            switch (n){
                case 1:{
                    graphicsContext.fillRoundRect(box1[0],box1[1],40,40,40,40);
                    graphicsContext.setFill(Color.GREENYELLOW);
                    graphicsContext.fillText("1",text1[0],text1[1]);
                    break;
                }case 2:{
                    graphicsContext.fillRoundRect(box2[0],box2[1],40,40,40,40);
                    graphicsContext.setFill(Color.GREENYELLOW);
                    graphicsContext.fillText("2",text2[0],text2[1]);
                    break;
                }case 3:{
                    graphicsContext.fillRoundRect(box3[0],box3[1],40,40,40,40);
                    graphicsContext.setFill(Color.GREENYELLOW);
                    graphicsContext.fillText("3",text3[0],text3[1]);
                    break;
                }case 4:{
                    graphicsContext.fillRoundRect(box4[0],box4[1],40,40,40,40);
                    graphicsContext.setFill(Color.GREENYELLOW);
                    graphicsContext.fillText("4",text4[0],text4[1]);
                    break;
                }
                case 5:{
                    graphicsContext.fillRoundRect(box5[0],box5[1],40,40,40,40);
                    graphicsContext.setFill(Color.GREENYELLOW);
                    graphicsContext.fillText("5",text5[0],text5[1]);
                    break;
                }
            }
        }

    }
    public void reset(){
        graphicsContext.clearRect(0,0,canvas.getHeight(),canvas.getHeight());

        graphicsContext.fillText("1",115,225);
        graphicsContext.fillText("2",115,325);
        graphicsContext.fillText("3",315,225);
        graphicsContext.fillText("4",315,325);
        graphicsContext.fillText("5",215,275);

        graphicsContext.strokeRoundRect(100,200,40,40,40,40);
        graphicsContext.strokeRoundRect(100,300,40,40,40,40);
        graphicsContext.strokeRoundRect(300,200,40,40,40,40);
        graphicsContext.strokeRoundRect(300,300,40,40,40,40);
        graphicsContext.strokeRoundRect(200,250,40,40,40,40);

        graphicsContext.strokeLine(120,240,120,300);
        graphicsContext.strokeLine(140,220,300,220);
        graphicsContext.strokeLine(320,240,242,270);
        graphicsContext.strokeLine(320,240,320,300);
        graphicsContext.strokeLine(140,320,300,320);

        graphicsContext.stroke();
    }

}

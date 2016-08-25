import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by osama on 8/23/16.
 * <p>
 *     This class as by name will handle the backend details.
 * </p>
 */
public class Graph {
    private static LinkedList<GraphItem> adj[];     //create a adjacency list
    private static ArrayList<GraphItem> items=new ArrayList<>();
    private int numberOfVertices; //number of vertices in graph
    Graph(int v){
        numberOfVertices=v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>(); // for each vertices initialize a adjacency list.
        }
    }
    Graph(){

    }

    /**
     * add edge in the graph
     * @param parent the vertex to which new vertex will be attached
     * @param newNode the new vertex to add
     */
    public void addEdge(int parent,int newNode){
        int trackerParent=0;
        int trackerNew=0;
        GraphItem pa=null;
        GraphItem ne=null;
        for (GraphItem x:
             items) {
            if(x.getValue()==parent){
                pa=x;
                trackerParent++;
            }

            if(x.getValue()==newNode){
                trackerNew++;
                ne=x;
            }
        }
        if(trackerParent==0 && trackerNew==0){
            pa=new GraphItem();
            pa.setValue(parent);
            ne=new GraphItem();
            ne.setValue(newNode);
        }else if(trackerNew==0){
            ne=new GraphItem();
            ne.setValue(newNode);
        }else if(trackerParent==0){
            pa=new GraphItem();
            pa.setValue(parent);
        }
        for (GraphItem x:
             items) {
            if(x==pa){
                trackerParent=2;
            }if(x==ne){
                trackerNew=2;
            }
        }
        if(trackerNew!=2 && trackerParent==2){
            items.add(ne);
        }else if(trackerNew==2 && trackerParent!=2){
            items.add(pa);
        }else if(trackerNew!=2 && trackerParent !=2){
            items.add(pa);
            items.add(ne);
        }
        adj[parent].add(ne);
        adj[newNode].add(pa);
    }

    public static LinkedList<GraphItem>[] getAdj() {
        return adj;
    }
    public void adjforgoogle(int item){
        for (GraphItem x:
             adj[item]) {
            System.out.print(x.getValue());
        }
    }
    public void reset(){
        for (GraphItem x:
             items) {
            x.setDistance(Constants.INFINITY);
        }
    }

}

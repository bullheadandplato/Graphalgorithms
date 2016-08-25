import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by osama on 8/23/16.
 * <p>
 *     Implementation of Breadth First Search
 * </p>
 */
public class BFS {
    private GraphItem root;
    private Queue queue=new Queue();
    public void setRoot(int v){
        LinkedList<GraphItem>  xx[]= Graph.getAdj();
        int tmp=0;
        for (LinkedList<GraphItem> y:
             xx) {
            for (GraphItem x:
                 y) {
                if(x.getValue()==v){
                    root=x;
                    tmp++;
                    break;
                }
            }
            if (tmp!=0){
                break;
            }
        }
    }
    class Queue{
        private ArrayList<GraphItem> queue=new ArrayList<>();
        void enQueue(GraphItem vertex){
            queue.add(vertex);
        }
        void deQueue(){
           queue.remove(queue.get(0)); // remove the last element
        }
        int size(){
            return queue.size();
        }
        GraphItem getLast(){
            return queue.get(0);
        }

    }
    public void searchNonRecursive(){
        //non algorithmic stuff just for the interface
        int index=0;
        int indexParent=0;
        // set the properties to root
        root.setDistance(0);
        root.setParent(null);
        queue.enQueue(root);
        while (queue.size() != 0){
            index=0;
            // be sure to fuck the interface before moving
            GraphItem parent = queue.getLast();
            Main.data[indexParent][index++]=parent.getValue();
            System.out.println("Vertex: "+parent.getValue()+" Distance: "+parent.getDistance());
            queue.deQueue();
            Iterator i = Graph.getAdj()[parent.getValue()].listIterator();
            while (i.hasNext()){
                GraphItem item=(GraphItem) i.next();
                if(item.getDistance() == Constants.INFINITY){
                    item.setParent(parent);
                    item.setDistance(item.getParent().getDistance()+1);
                    queue.enQueue(item);
                    Main.data[indexParent][index++]=item.getValue();
                    System.out.println("Enqueue: "+item.getValue());
                }

            }
            indexParent++;
        }
    }



}

/**
 * Created by osama on 8/23/16.
 * every item in graph
 */
public class GraphItem {
    private int distance=Constants.INFINITY; //lets say -1 is infinity here
    private GraphItem parent; //lets say -1 is NIL here
    private int value=Constants.INFINITY; //let -1 is null

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public GraphItem getParent() {
        return parent;
    }

    public void setParent(GraphItem parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.LinkedList;

class Graph {
    int v;
    LinkedList<Edge>[] adjacencyList;

    Graph(int v) {
        this.v = v;
        this.adjacencyList = new LinkedList[v];

        for(int i = 0; i < v; ++i) {
            this.adjacencyList[i] = new LinkedList();
        }

    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        this.adjacencyList[src].addFirst(edge);
        edge = new Edge(dest, src, weight);
        this.adjacencyList[dest].addFirst(edge);
    }

    public void getMST() {
        boolean[] inHeap = new boolean[this.v];
        ResultSet[] resultSet = new ResultSet[this.v];
        int[] key = new int[this.v];
        HeapNode[] heapNodes = new HeapNode[this.v];

        for(int i = 0; i < this.v; ++i) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = 2147483647;
            resultSet[i] = new ResultSet();
            resultSet[i].parent = -1;
            inHeap[i] = true;
            key[i] = 2147483647;
        }

        heapNodes[0].key = 0;
        MinHeap minHeap = new MinHeap(this.v);

        for(int i = 0; i < this.v; ++i) {
            minHeap.insert(heapNodes[i]);
        }

        while(!minHeap.isEmpty()) {
            HeapNode extractedNode = minHeap.extractMin();
            int extractedVertex = extractedNode.vertex;
            inHeap[extractedVertex] = false;
            LinkedList<Edge> list = this.adjacencyList[extractedVertex];

            for(int i = 0; i < list.size(); ++i) {
                Edge edge = (Edge)list.get(i);
                if (inHeap[edge.dest]) {
                    int dest = edge.dest;
                    int newKey = edge.weight;
                    if (key[dest] > newKey) {
                        this.decreaseKey(minHeap, newKey, dest);
                        resultSet[dest].parent = extractedVertex;
                        resultSet[dest].weight = newKey;
                        key[dest] = newKey;
                    }
                }
            }
        }

        this.printMST(resultSet);
    }

    public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {
        int index = minHeap.indexes[vertex];
        HeapNode node = minHeap.minH[index];
        node.key = newKey;
        minHeap.moveUp(index);
    }

    public void printMST(ResultSet[] resultSet) {
        int total_min_weight = 0;
        String[] towns = new String[this.v];
        towns[0] = "Eskildstrup";
        towns[1] = "Haslev";
        towns[2] = "Holbæk";
        towns[3] = "Jægerspris";
        towns[4] = "Kalundborg";
        towns[5] = "Korsør";
        towns[6] = "Køge";
        towns[7] = "Maribo";
        towns[8] = "Næstved";
        towns[9] = "Ringsted";
        towns[10] = "Slagelse";
        towns[11] = "Nykøbing F";
        towns[12] = "Vordingborg";
        towns[13] = "Sorø";
        towns[14] = "Roskilde";
        towns[15] = "Nakskov";
        System.out.println("Minimum Spanning Tree: ");

        int total_price;
        for(total_price = 1; total_price < this.v; ++total_price) {
            System.out.println("Edge: " + towns[total_price] + " - " + towns[resultSet[total_price].parent] + " km: " + resultSet[total_price].weight);
            total_min_weight += resultSet[total_price].weight;
        }

        System.out.println("Total minimum km: " + total_min_weight);
        total_price = total_min_weight * 100 * 1000;
        NumberFormat myFormat = NumberFormat.getInstance();
        PrintStream var10000 = System.out;
        String var10001 = myFormat.format((long)total_price);
        var10000.println("The total price is: " + var10001 + " DKK");
    }
}

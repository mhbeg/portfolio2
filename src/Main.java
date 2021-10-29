public class Main {

    public static void main(String[] args) {
        int v = 16;

        Graph graf = new Graph(v);

        graf.addEdge(0, 7, 28);
        graf.addEdge(0, 11, 13);
        graf.addEdge(0, 12, 25);
        graf.addEdge(1, 5, 60);
        graf.addEdge(1, 6, 24);
        graf.addEdge(1, 8, 25);
        graf.addEdge(1, 9, 19);
        graf.addEdge(1, 14, 47);
        graf.addEdge(1, 10, 48);
        graf.addEdge(1, 13, 34);
        graf.addEdge(1, 12, 40);
        graf.addEdge(2, 3, 34);
        graf.addEdge(2, 4, 44);
        graf.addEdge(2, 5, 66);
        graf.addEdge(2, 9, 36);
        graf.addEdge(2, 14, 32);
        graf.addEdge(2, 10, 46);
        graf.addEdge(2, 13, 34);
        graf.addEdge(3, 5, 94);
        graf.addEdge(3, 6, 58);
        graf.addEdge(3, 9, 56);
        graf.addEdge(3, 14, 33);
        graf.addEdge(3, 10, 74);
        graf.addEdge(3, 13, 63);
        graf.addEdge(4, 9, 62);
        graf.addEdge(4, 14, 70);
        graf.addEdge(4, 10, 39);
        graf.addEdge(4, 13, 51);
        graf.addEdge(5, 8, 45);
        graf.addEdge(5, 10, 20);
        graf.addEdge(6, 8, 45);
        graf.addEdge(6, 9, 28);
        graf.addEdge(6, 14, 25);
        graf.addEdge(6, 12, 60);
        graf.addEdge(7, 15, 27);
        graf.addEdge(7, 11, 26);
        graf.addEdge(8, 14, 57);
        graf.addEdge(8, 9, 26);
        graf.addEdge(8, 10, 37);
        graf.addEdge(8, 13, 32);
        graf.addEdge(8, 12, 28);
        graf.addEdge(9, 14, 31);
        graf.addEdge(9, 13, 15);
        graf.addEdge(9, 12, 58);
        graf.addEdge(10, 13, 14);

        graf.getMST();
    }
}

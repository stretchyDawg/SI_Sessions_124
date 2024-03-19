package si.session_activities.mock_practicums.test03.set1.problem03;

import si.algorithms.bfs_dfs.weighted_graphs.WAdjacencyGraph;
import si.algorithms.bfs_dfs.weighted_graphs.WGraph;

public class NetworkMaker {
    public static Network makeNetwork() {
        WGraph<String> network = new WAdjacencyGraph<>();

        // add all of the computers to the network
        network.add("Apple");
        network.add("Banana");
        network.add("Cherry");
        network.add("Cherry");
        network.add("Date");
        network.add("Elderberry");
        network.add("Fig");
        network.add("Grape");
        network.add("Honeydew");

        // connect the computers together with weighted edges; the weight of
        // each edge indicates the latency of the connection.
        network.connect("Apple","Banana",1);
        network.connect("Apple","Date",3);
        network.connect("Apple","Grape",15);
        network.connect("Banana","Cherry",6);
        network.connect("Banana","Date",4);
        network.connect("Cherry","Fig",2);
        network.connect("Cherry","Grape",3);
        network.connect("Date","Elderberry",10);
        network.connect("Date","Fig",3);
        network.connect("Elderberry","Cherry",4);
        network.connect("Honeydew","Apple",3);

        return new Network(network);
    }

    public static void main(String[] args) {
        Network network = makeNetwork();
        network.getNetworkHops();

        System.out.println(network.getNetworkHops() + "\n\n");
        System.out.println(network.getNetworkLatency());
    }
}

package si.session_activities.mock_practicums.test03.set1.problem03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import si.algorithms.graphs_bfs_dfs.weighted_graphs2023.WGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2023.WPath;

public class Network {

    private final WGraph<String> network;

    public Network(WGraph<String> network) {
        this.network = network;
    }

    public WGraph<String> gNetwork() {
        return this.network;
    }

    public Map<String,Integer> getNetworkHops() {
        Map<String, Integer> hopMap = new HashMap<>();
        
        List<String> valueList = this.network.values();
        valueList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        for(int i = 0; i < valueList.size(); i++){
            for(int j = i+1; j < valueList.size(); j++){
                String mapString = valueList.get(i) + ":" + valueList.get(j);
                Integer hops = this.network.dijkstrasPath(valueList.get(i), valueList.get(j)).size();
                hopMap.put(mapString, hops);
            }
        }

        return hopMap;
    }

    public Map<String,Integer> getNetworkLatency() {
        Map<String, Integer> latencyMap = new HashMap<>();

        List<String> valueList = this.network.values();
        valueList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < valueList.size(); i++){
            for(int j = i+1; j < valueList.size(); j++){
                String mapString = valueList.get(i) + ":" + valueList.get(j);
                WPath<String> dPath = this.network.dijkstrasPath(valueList.get(i), valueList.get(j));
                double latency = dPath.distance();
                Integer latencyInt = (int)latency;
                latencyMap.put(mapString, latencyInt);
            }
        }
        
        return latencyMap;
    }
}

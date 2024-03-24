package si.graph_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.PathTuple;
import si.algorithms.graphs_bfs_dfs.weighted_graphs2024.WVertex;

@Testable
public class PathTupleTest {
    @Test
    public void create() {
        // setup
        WVertex<String> vertex = new WVertex<>("abc");

        // invoke
        PathTuple<String> tuple = new PathTuple<>(vertex);

        // analyze
        assertEquals(vertex, tuple.getVertex());
        assertEquals(null, tuple.getPredecessor());
        assertEquals(Double.POSITIVE_INFINITY, tuple.getDistance());
    }

    @Test
    public void update() {
        // setup
        WVertex<String> vertex = new WVertex<>("abc");
        PathTuple<String> tuple = new PathTuple<>(vertex);
        WVertex<String> predecessor = new WVertex<>("123");
        double distance = 1000d;

        // invoke
        tuple.update(predecessor, distance);

        // analyze
        assertEquals(predecessor, tuple.getPredecessor());
        assertEquals(distance, tuple.getDistance());
    }

    @Test
    public void updateIgnored() {
        // setup
        WVertex<String> vertex = new WVertex<>("abc");
        PathTuple<String> tuple = new PathTuple<>(vertex);
        WVertex<String> predecessor = new WVertex<>("abc");
        double distance = 1000d;
        tuple.update(predecessor, distance);
        WVertex<String> farther = new WVertex<>("def");
        double fartherDistance = 1001d;

        // invoke
        tuple.update(farther, fartherDistance);

        // analyze
        assertEquals(predecessor, tuple.getPredecessor());
        assertEquals(distance, tuple.getDistance());
    }

    @Test
    public void toStringNew() {
        // setup
        WVertex<String> vertex = new WVertex<>("abc");
        PathTuple<String> tuple = new PathTuple<>(vertex);
        String expected = "abc:(null, Infinity)";

        // invoke
        String actual = tuple.toString();

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void toStringUpdated() {
        // setup
        WVertex<String> vertex = new WVertex<>("abc");
        PathTuple<String> tuple = new PathTuple<>(vertex);
        WVertex<String> predecessor = new WVertex<>("def");
        double distance = 1001;
        tuple.update(predecessor, distance);
        String expected = "abc:(def, 1001.0)";

        // invoke
        String actual = tuple.toString();

        // analyze
        assertEquals(expected, actual);
    }
}
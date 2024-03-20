package si.graph_tests;

import org.junit.jupiter.api.Test;

import si.algorithms.graphs_bfs_dfs.mains.GraphMaker;
import si.algorithms.graphs_bfs_dfs.weighted_graps2024.WGraph;
import si.algorithms.graphs_bfs_dfs.weighted_graps2024.WPath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DijkstrasPathTest {
    @Test
    public void testGraphAAToE() {
        // setup
        WGraph<String> graph = GraphMaker.makeGraphA();

        // invoke
        WPath<String> path = graph.dijkstrasPath("A", "E");

        // analyze
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(10, path.getDistance(), 0.0);
        assertEquals("A", path.get(0));
        assertEquals("C", path.get(1));
        assertEquals("G", path.get(2));
        assertEquals("E", path.get(3));
    }

    @Test
    public void testGraphADToG() {
        // setup
        WGraph<String> graph = GraphMaker.makeGraphA();

        // invoke
        WPath<String> path = graph.dijkstrasPath("D", "G");

        // analyze
        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(8, path.getDistance(), 0.0);
        assertEquals("D", path.get(0));
        assertEquals("A", path.get(1));
        assertEquals("C", path.get(2));
        assertEquals("G", path.get(3));
    }

    @Test
    public void testGraphBAToG() {
        // setup
        WGraph<String> graph = GraphMaker.makeGraphB();

        // invoke
        WPath<String> path = graph.dijkstrasPath("A", "G");

        // analyze
        assertNotNull(path);
        assertEquals(5, path.size());
        assertEquals(17, path.getDistance(), 0.0);
        assertEquals("A", path.get(0));
        assertEquals("B", path.get(1));
        assertEquals("E", path.get(2));
        assertEquals("F", path.get(3));
        assertEquals("G", path.get(4));
    }

    @Test
    public void testGraphBAToK() {
        // setup
        WGraph<String> graph = GraphMaker.makeGraphB();

        // invoke
        WPath<String> path = graph.dijkstrasPath("A", "K");

        // analyze
        assertNull(path);
    }
}
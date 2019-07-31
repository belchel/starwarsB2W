//package br.b2w;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import br.b2w.entity.Edge;
//import br.b2w.entity.Graph;
//import br.b2w.helper.RouteCalculation;
//import br.b2w.viewobject.Route;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class RouteCalculationTest {
// 
//	 List<Edge> edges = new ArrayList<Edge>();
//	 Graph graph = new Graph();
//	
//	 
// 
//    @Before
//    public void init() {
//    	 edges.add(new Edge("A","B",5));
//         edges.add(new Edge("B","C",4));
//         edges.add(new Edge("C","D",8));
//         edges.add(new Edge("D","C",8));
//         edges.add(new Edge("D","E",6));
//         edges.add(new Edge("A","D",5));
//         edges.add(new Edge("C","E",2));
//         edges.add(new Edge("E","B",3));
//         edges.add(new Edge("A","E",7));
//         graph.setEdges(edges);
//    }
//    
//    
//
//    @Test
//    public void origemC_destinoC_3paradas_thenReturn0()
//      throws Exception {
//        String init = "C";
//        String end = init;
//        int maxStops = 3;
//    	graph.arrangeGraph() ;   	
//    	RouteCalculation calculation = new RouteCalculation();
//    	LinkedList<String> visited = new LinkedList<String>();
//		visited.add(init);
//    	calculation.calculate(graph, visited, end, maxStops);
//    	
//    	assertThat( calculation.getRoutes().size(), is(0)) ;
//    }
//    
//    @Test
//    public void origemA_destinoC_4paradas_thenReturnList()
//      throws Exception {
//        String origem = "A";
//        String destino = "C";
//        int maxStops = 4;
//    	graph.arrangeGraph() ;   	
//    	RouteCalculation calculation = new RouteCalculation();
//    	LinkedList<String> visited = new LinkedList<String>();
//		visited.add(origem);
//    	calculation.calculate(graph, visited, destino, maxStops);
//    	Map<String, Integer > finalRoutes = new HashMap<String, Integer>();
//    	finalRoutes.put("ABC",2);
//    	finalRoutes.put("ADC",2);
//    	finalRoutes.put("AEBC",3);
//    	finalRoutes.put("ADEBC",4);
//    	
//    	boolean verifica = true;
//    	
//    	for(Route route: calculation.getRoutes())
//    	{
//    		if(!finalRoutes.containsKey(route.getRoute()))
//    			verifica = false;
//    	}
//    	
//    	assertThat( verifica && finalRoutes.size() == calculation.getRoutes().size(), is(true)) ;
//    }
//}
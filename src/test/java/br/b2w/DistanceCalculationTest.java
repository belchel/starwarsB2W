//package br.b2w;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import br.b2w.entity.Edge;
//import br.b2w.entity.Graph;
//import br.b2w.helper.DistanceCalculation;
//import br.b2w.helper.Util;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class DistanceCalculationTest {
//
//	List<Edge> edges = new ArrayList<Edge>();
//	DistanceCalculation calculation;
//
//	@Before
//	public void init() {
//		try {
//			calculation = new DistanceCalculation(5);
//		
//			calculation.insertArc("A", "B", 5);
//			calculation.insertArc("B", "C", 4);
//			calculation.insertArc("C", "D", 8);
//			calculation.insertArc("D", "C", 8);
//			calculation.insertArc("D", "E", 6);
//			calculation.insertArc("A", "D", 5);
//			calculation.insertArc("C", "E", 2);
//			calculation.insertArc("E", "B", 3);
//			calculation.insertArc("A", "E", 7);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void distanciaMinima_A_C_thenReturn9_and_ABC() throws Exception {
//		String init = "A";
//		String end = "C";
//
//		boolean assertion = true; 
//		if (calculation.calculate(init, end) != 9 || !String.join("", calculation.getPath()).trim().equals("ABC") )
//			assertion = false;
//
//		assertThat(assertion, is(true));
//	}
//	
//	@Test
//	public void distanciaMinima_B_B_thenReturn0() throws Exception {
//		String init = "B";
//		String end = "B";
//
//		boolean assertion = true; 
//		if (calculation.calculate(init, end) != 0 || !String.join("", calculation.getPath()).trim().equals("") )
//			assertion = false;
//
//		assertThat(assertion, is(true));
//	}
//	
//}

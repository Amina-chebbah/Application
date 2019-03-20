package org.gIsid.xspeedIt.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.gIsid.xspeedIt.service.RobotService;
import org.gIsid.xspeedIt.util.RobotUtils;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class OptimizedRobotTest {


	 String chaineArticle = "163841689525773";
	 String chaineArticleEmballerRobotActuel = "163/8/41/6/8/9/52/5/7/73";
	 
	 
	 @Mock
	 RobotUtils gUtilsXspeedit;
	 
	 @InjectMocks
    RobotService gOptimizedRobot;
	
	 
	@Test
	public void testOptimizedRobot() {
		when(gUtilsXspeedit.convertirChainEnIntegerArray(chaineArticle)).thenReturn(new int[] {1,6,3,8,4,1,6,8,9,5,2,5,7,7,3});
		
		String[] vRp= gOptimizedRobot.resolveCards(chaineArticle);
		
		assertEquals(8, vRp.length);
		
	}
}

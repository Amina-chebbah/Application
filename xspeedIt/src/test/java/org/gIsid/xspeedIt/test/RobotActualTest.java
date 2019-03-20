package org.gIsid.xspeedIt.test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.gIsid.xspeedIt.service.RobotService;
import org.gIsid.xspeedIt.util.RobotUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class RobotActualTest {



@RunWith(MockitoJUnitRunner.class)
public class RobotActuelleTest {

	 String chaineArticle = "163841689525773";
	 String chaineArticleEmballerRobotActuel = "163/8/41/6/8/9/52/5/7/73";

	 
	 @Mock
	 RobotUtils gUtilsXspeedit;
	 
	 @InjectMocks
     RobotService gInjectRobotActuel;
   
    
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
	}

	
	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testRobotActuel() {
		when(gUtilsXspeedit.convertirChainEnIntegerArray(chaineArticle)).thenReturn(new int[] {1,6,3,8,4,1,6,8,9,5,2,5,7,7,3});
		gInjectRobotActuel.resolveCards(chaineArticle);
		verify( gUtilsXspeedit, times(1) ).convertirChainEnIntegerArray(chaineArticle);
		
		assertEquals(chaineArticleEmballerRobotActuel, gInjectRobotActuel.resolveCards(chaineArticle));
				
	}
		
		
		
	}

}

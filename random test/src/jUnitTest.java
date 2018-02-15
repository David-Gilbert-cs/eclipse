import org.junit.Test;


import static org.junit.Assert.assertEquals;;


public class jUnitTest {

	@Test
	public void testAbsZero()
	{
		assertEquals(0, Math.abs(0));
	}
	
	@Test
	public void testabspos()
	{
		assertEquals(1, Math.abs(1));
	}
	
	@Test
	public void testabsneg()
	{
		assertEquals(-1, Math.abs(-1));
	}
	
	

}

import static org.junit.Assert.*;

import org.junit.Test;

import DBUtil.DBUtility;

public class DBUtilTesting {

	@Test
	public void getNumberOfColTest() {
		System.out.println(DBUtility.getNumberOfCol("customers"));
		assertTrue(DBUtility.getNumberOfCol("customers")!=0);
	}
	@Test
	public void getColNamesTest(){
		System.out.println(DBUtility.getColNames("customers"));
		assertTrue(DBUtility.getColNames("customers").length()!=0);
	}
}

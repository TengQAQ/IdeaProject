import org.junit.Test;

import static com.hxzy.util.MD5Utils.getSaltMD5;
import static com.hxzy.util.MD5Utils.getSaltVerifyMD5;

public class MD5UtilsTest {

	@Test
	public void test() {
		String passward = "123456";
		String saltMD5 = getSaltMD5(passward);
		System.out.println(saltMD5);
		boolean saltverifyMD5 = getSaltVerifyMD5(passward, saltMD5);
		System.out.println(saltverifyMD5);
	}
}
package modernj;

import com.google.common.base.Strings;

public class Main {
	public static void main(String[] args) {
		System.out.println(triple("Hello World!"));
		System.out.println("My name is " + System.getProperty("modernj.name"));
	}

	static String triple(String str) {
		return Strings.repeat(str, 3);
	}
}

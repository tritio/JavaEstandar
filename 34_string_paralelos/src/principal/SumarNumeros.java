package principal;

import java.util.stream.LongStream;

public class SumarNumeros {

	public static void main(String[] args) {
		System.out.println(LongStream.rangeClosed(0, 1000000)
			.parallel()
			.sum());
	}

}

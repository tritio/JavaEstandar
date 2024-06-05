package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TestCached {

	public static void main(String[] args) {
		 ExecutorService executor = Executors.newCachedThreadPool();  // ver apuntes		
		executor.submit(()-> IntStream.rangeClosed(1, 100).forEach(n-> System.out.println(Thread.currentThread().getName())));
		executor.submit(()-> IntStream.rangeClosed(-100, -1).forEach(n->System.out.println(Thread.currentThread().getName())));
		executor.shutdown(); 

		// sale los nombres de los números pero alternadondo por ser newCachedThreadPool()
	}

}

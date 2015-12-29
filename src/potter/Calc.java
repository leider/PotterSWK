package potter;

import java.util.Arrays;
import java.util.Collection;

public class Calc {

	public static int minimum(Integer... zahlen) {
		return minimum(Arrays.asList(zahlen));
	}

	public static int minimum(Collection<Integer> zahlen) {
		return zahlen.stream().reduce(Integer.MAX_VALUE, Integer::min);
	}

}

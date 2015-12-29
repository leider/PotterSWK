package potter;

import static potter.Calc.minimum;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BookCount {

	private Map<Buch, Integer> count = new HashMap<>();

	public BookCount(Buch... bücher) {
		for (Buch buch : bücher) {
			count.merge(buch, 1, (v, newValue) -> v + 1);
		}

	}

	public int popTuples(int size) {
		if (count.size() < size) {
			return 0;
		}
		int minimum = minimum(count.values());
		count.replaceAll((k, v) -> v - minimum);
		removeEmptyBooks();
		return minimum;
	}

	private void removeEmptyBooks() {
		count = count.keySet().stream().filter(buch -> count.get(buch) > 0).collect(Collectors.toMap(k -> k, k -> count.get(k)));
	}
}

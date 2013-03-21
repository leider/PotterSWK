package potter;

import static potter.MinimumTest.minimum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookCount {

	private Map<Buch, Integer> count = new HashMap<Buch, Integer>();

	public BookCount(Buch... bücher) {
		for (Buch buch : bücher) {
			if (!count.containsKey(buch)) {
				count.put(buch, 0);
			}
			count.put(buch, count.get(buch) + 1);
		}
	}

	public int popTuples(int size) {
		if (count.size() < size)
			return 0;

		int minimum = minimum(count.values().toArray(new Integer[0]));

		Iterator<Buch> iterator = count.keySet().iterator();
		while (iterator.hasNext()) {
			Buch buch = iterator.next();
			int newCount = count.get(buch) - minimum;
			if (newCount > 0) {
				count.put(buch, newCount);
			} else {
				iterator.remove();
			}
		}

		return minimum;
	}
}

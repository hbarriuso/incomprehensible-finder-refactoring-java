package algorithm;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Pair> find(final Criteria criteria) {
		return createPairs()
				.reduce(criteria::choose);
	}

	private Stream<Pair> createPairs() {
		return range(0, people.size() - 1)
				.mapToObj(this::constructRemainingPairs)
				.flatMap(i -> i);
	}

	private Stream<Pair> constructRemainingPairs(int i) {
		return range(i + 1, people.size()).mapToObj(j -> pair(i, j));
	}

	private Pair pair(int i, int j) {
		Person one = people.get(i);
		Person two = people.get(j);
		return one.bornBefore(two) ? new Pair(one, two) : new Pair(two, one);
	}
}

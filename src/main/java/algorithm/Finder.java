package algorithm;
import java.util.List;
import java.util.Optional;

import static algorithm.Result.from;
import static java.util.stream.IntStream.range;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Result> find(final Criteria criteria) {
		return range(0, people.size() - 1)
				.mapToObj(i -> range(i + 1, people.size())
						.mapToObj(j -> from(people.get(i), people.get(j))))
				.flatMap(i -> i)
				.reduce(criteria::choose);
	}
}

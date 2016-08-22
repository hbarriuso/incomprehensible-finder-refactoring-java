package algorithm;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Result> find(final Criteria criteria) {
		return IntStream.range(0, people.size() - 1)
				.mapToObj(i -> IntStream.range(i + 1, people.size())
						.mapToObj(j -> Result.from(people.get(i), people.get(j))))
				.flatMap(i -> i)
				.reduce(criteria::choose);
	}
}

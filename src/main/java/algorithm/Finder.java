package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Result> find(final Criteria criteria) {
		Optional<Result> answer = Optional.empty();

		List<Result> tr = new ArrayList<Result>();
		if (people.size() > 1) {

			for (int i = 0; i < people.size() - 1; i++) {
				for (int j = i + 1; j < people.size(); j++) {
					Result r = Result.from(people.get(i), people.get(j));
					tr.add(r);
				}
			}
		}

		return tr.stream().reduce(criteria::choose);
	}
}

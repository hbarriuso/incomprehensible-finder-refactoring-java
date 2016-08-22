package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Result find(final Criteria criteria) {
		Result answer = Result.empty();

		if (people.size() > 1) {
			List<Result> tr = new ArrayList<Result>();

			for (int i = 0; i < people.size() - 1; i++) {
				for (int j = i + 1; j < people.size(); j++) {
					Result r = Result.from(people.get(i), people.get(j));
					tr.add(r);
				}
			}

			answer = tr.stream().reduce(tr.get(0), (a, r) -> criteria.choose(a, r));
		}


		return answer;
	}
}

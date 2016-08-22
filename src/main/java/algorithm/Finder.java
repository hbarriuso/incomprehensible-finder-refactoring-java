package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Result find(Criteria criteria) {
		List<Result> tr = new ArrayList<Result>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Result r = new Result();
				if (people.get(i).bornBefore(people.get(j))) {
					r.first = people.get(i);
					r.second = people.get(j);
				} else {
					r.first = people.get(j);
					r.second = people.get(i);
				}
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new Result();
		}

		Result answer = tr.get(0);
		for (Result result : tr) {
			answer = criteria.choose(answer, result);
		}

		return answer;
	}
}

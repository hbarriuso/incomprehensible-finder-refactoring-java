package algorithm;
public class Result {
	private static final Result EMPTY = new Result(null, null);
	public final Person first;
	public final Person second;

	private Result(Person first, Person second) {
		this.first = first;
		this.second = second;
	}

	long calculateDistanceBetweenBirthdates() {
		return second.getBirthDate().getTime() - first.getBirthDate().getTime();
	}

	public static Result from(Person one, Person two) {
		Result result;
		if (one.bornBefore(two)) {
			result = new Result(one, two);
		} else {
			result = new Result(two, one);
		}
		return result;
	}

	public static Result empty() {
		return EMPTY;
	}
}

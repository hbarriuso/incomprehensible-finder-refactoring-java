package algorithm;
public class Pair {
	public final Person first;
	public final Person second;

	public Pair(Person first, Person second) {
		this.first = first;
		this.second = second;
	}

	long calculateDistanceBetweenBirthdates() {
		return second.getBirthDate().getTime() - first.getBirthDate().getTime();
	}
}

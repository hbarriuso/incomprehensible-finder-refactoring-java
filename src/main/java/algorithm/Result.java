package algorithm;
public class Result {
	public Person first;
	public Person second;

	long calculateDistanceBetweenBirthdates() {
		return second.getBirthDate().getTime() - first.getBirthDate().getTime();
	}
}

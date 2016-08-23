package algorithm;
public enum Criteria {
	CLOSEST {
		@Override
		public Pair choose(Pair answer, Pair pair) {
			return pair.calculateDistanceBetweenBirthdates() < answer.calculateDistanceBetweenBirthdates() ? pair : answer;
		}
	},
	FURTHEST {
		@Override
		public Pair choose(Pair answer, Pair pair) {
			return pair.calculateDistanceBetweenBirthdates() > answer.calculateDistanceBetweenBirthdates() ? pair : answer;
		}
	};

	public abstract Pair choose(Pair answer, Pair pair);
}

package algorithm;
public enum Criteria {
	CLOSEST {
		@Override
		public Result choose(Result answer, Result result) {
			return result.calculateDistanceBetweenBirthdates() < answer.calculateDistanceBetweenBirthdates() ? result : answer;
		}
	},
	FURTHEST {
		@Override
		public Result choose(Result answer, Result result) {
			return result.calculateDistanceBetweenBirthdates() > answer.calculateDistanceBetweenBirthdates() ? result : answer;
		}
	};

	public abstract Result choose(Result answer, Result result);
}

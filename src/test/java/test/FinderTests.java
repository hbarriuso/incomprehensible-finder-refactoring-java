package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import algorithm.Pair;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	Person sue = new Person("Sue", new Date(50, 0, 1));
	Person greg = new Person("Greg", new Date(52, 5, 1));
	Person sarah = new Person("Sarah", new Date(82, 0, 1));
	Person mike = new Person("Mike", new Date(79, 0, 1));

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<>();
		Finder finder = new Finder(list);

		Optional<Pair> result = finder.find(Criteria.CLOSEST);

		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<>();
		list.add(sue);

		Finder finder = new Finder(list);

		Optional<Pair> result = finder.find(Criteria.CLOSEST);

		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Pair pair = finder.find(Criteria.CLOSEST).get();

		assertEquals(sue, pair.first);
		assertEquals(greg, pair.second);
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Pair pair = finder.find(Criteria.FURTHEST).get();

		assertEquals(greg, pair.first);
		assertEquals(mike, pair.second);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Pair pair = finder.find(Criteria.FURTHEST).get();

		assertEquals(sue, pair.first);
		assertEquals(sarah, pair.second);
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Pair pair = finder.find(Criteria.CLOSEST).get();

		assertEquals(sue, pair.first);
		assertEquals(greg, pair.second);
	}

}

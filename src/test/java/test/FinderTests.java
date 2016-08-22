package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import algorithm.Result;
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
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		Optional<Result> result = finder.find(Criteria.CLOSEST);

		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		Optional<Result> result = finder.find(Criteria.CLOSEST);

		assertFalse(result.isPresent());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.find(Criteria.CLOSEST).get();

		assertEquals(sue, result.first);
		assertEquals(greg, result.second);
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.find(Criteria.FURTHEST).get();

		assertEquals(greg, result.first);
		assertEquals(mike, result.second);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.find(Criteria.FURTHEST).get();

		assertEquals(sue, result.first);
		assertEquals(sarah, result.second);
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.find(Criteria.CLOSEST).get();

		assertEquals(sue, result.first);
		assertEquals(greg, result.second);
	}

}

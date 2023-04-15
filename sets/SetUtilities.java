/*
 * Copyright 2021 Marc Liberatore.
 */

package sets;

import java.util.HashSet;
import java.util.Set;

public class SetUtilities {
	/**
	 * Returns a new set representing the union of s and t.
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the union of s and t
	 */
	public static <E> Set<E> union(Set<E> s, Set<E> t) {
		Set<E> unionSet = new HashSet<E>();
		for(E e : s) {
			unionSet.add(e);
		}
		for(E e : t) {
			if (!unionSet.contains(e)) {
				unionSet.add(e);
			}
		}
		return unionSet;
	}

	/**
	 * Returns a new set representing the intersection of s and t.
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the intersection of s and t
	 */
	public static <E> Set<E> intersection(Set<E> s, Set<E> t) {
		Set<E> interSet = new HashSet<E>();
		if (s.size() != 0 && t.size() != 0)
			for (E e : s){
				if(t.contains(e))
					interSet.add(e);
			}
		return interSet;
	}

	/**
	 * Returns a new set representing the set difference s and t,
	 * that is, s \ t (or s - t).
	 * 
	 * Does not modify s or t.
	 * @param s
	 * @param t
	 * @return a new set representing the difference of s and t
	 */
	public static <E> Set<E> setDifference(Set<E> s, Set<E> t) {
		Set<E> differSet = new HashSet<E>();
		for (E e : s) {
			differSet.add(e);
		}
		for (E e : t){
			if(differSet.contains(e)){
				differSet.remove(e);
			}
		}
		return differSet;
	}
	
	/**
	 * Returns the Jaccard index of the two sets s and t.
	 * 
	 * It is defined as 1 if both sets are empty.
     *
	 * Otherwise, it is defined as the size of the intersection of the sets, 
	 * divided by the size of the union of the sets.
	 * 
	 * Does not modify s or t.
	 * 
	 * @param s
	 * @param t
	 * @return the Jaccard index of s and t
	 */
	public static <E> double jaccardIndex(Set<E> s, Set<E> t) {
		if (s.size() == 0 && t.size() == 0) return 1.0;
		if (s.containsAll(t)) return 1.0;
		if (intersection(s, t) == null) return 0.0;
		double checkHalf = (double) intersection(s, t).size()/ (double) union(s, t).size();
		if (checkHalf == 0.5) return 0.5;
		return checkHalf;
	}
}

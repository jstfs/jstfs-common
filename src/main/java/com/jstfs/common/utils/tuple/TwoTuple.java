package com.jstfs.common.utils.tuple;

public class TwoTuple<A, B> {
	private A first;
	private B second;
	
	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}
	
	
}

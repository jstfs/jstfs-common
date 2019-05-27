package com.jstfs.common.utils.tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	private C third;
	
	public ThreeTuple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}

	public C getThird() {
		return third;
	}
}

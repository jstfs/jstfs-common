package com.jstfs.common.utils.tuple;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	private D fourth;
	
	public FourTuple(A first, B second, C third, D fourth) {
		super(first, second, third);
		this.fourth = fourth;
	}

	public D getFourth() {
		return fourth;
	}
}

import tester.Tester;

public class Examples {
	Examples() {}
	
	
	boolean test1(Tester t) {
		MtHeap<Integer> h = new MtHeap<Integer>();
		return t.checkExpect(h.isAddValid(5), true);
	}
	
	boolean test2(Tester t) {
		DataHeap<Integer> h = new DataHeap<Integer>(5, 
				new MtHeap<Integer>(), new DataHeap<Integer>(2));
		return t.checkExpect(h.isHeap(), false);
	}
	
	boolean test3(Tester t) {
		DataHeap<Integer> h = new DataHeap<Integer>(3, new MtHeap<Integer>(), new MtHeap<Integer>());
		return t.checkExpect(h.isRemMinValid(), true);
	}
	
	boolean test4(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
					new DataHeap<Integer>(7,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new MtHeap<Integer>()
			);
		return t.checkExpect(h.isHeap(), true);
	}

	boolean test5(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
					new DataHeap<Integer>(7,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new MtHeap<Integer>()
			);
		return t.checkExpect(h.isAddValid(4), true);
	}

	boolean test6(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
					new DataHeap<Integer>(7,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new MtHeap<Integer>()
			);
		return t.checkExpect(h.isRemMinValid(), true);
	}

	boolean test7(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			),
			new DataHeap<Integer>(3,
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new DataHeap<Integer>(52,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new DataHeap<Integer>(6,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			)
		);
		return t.checkExpect(h.isRemMinValid(), true);
	}

	boolean test8(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			),
			new DataHeap<Integer>(3,
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new DataHeap<Integer>(52,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new DataHeap<Integer>(6,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			)
		);
		return t.checkExpect(h.isAddValid(99), true);
	}

	boolean test9(Tester t) {
		DataHeap<Integer> h = 
			new DataHeap<Integer>(2, 
				new DataHeap<Integer>(5, 
					new DataHeap<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			),
			new DataHeap<Integer>(3,
				new DataHeap<Integer>(7,
					new MtHeap<Integer>(),
					new DataHeap<Integer>(52,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new DataHeap<Integer>(6,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			)
		);
		return t.checkExpect(h.isAddValid(1), true);
	}

	boolean test10(Tester t) {
		TestHeap1<Integer> h = 
			new TestHeap1<Integer>(2, 
				new TestHeap1<Integer>(5, 
					new TestHeap1<Integer>(6, 
						new MtHeap<Integer>(), 
						new MtHeap<Integer>()
					),
				new TestHeap1<Integer>(7,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			),
			new TestHeap1<Integer>(3,
				new TestHeap1<Integer>(7,
					new MtHeap<Integer>(),
					new TestHeap1<Integer>(52,
						new MtHeap<Integer>(),
						new MtHeap<Integer>()
					)
				),
				new TestHeap1<Integer>(6,
					new MtHeap<Integer>(),
					new MtHeap<Integer>()
				)
			)
		);
		return t.checkExpect(h.isAddValid(1), false);
	}

	boolean test11(Tester t) {
		TestHeap4<Integer> h = 
				new TestHeap4<Integer>(2, 
						new TestHeap4<Integer>(5, 
								new TestHeap4<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap4<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap4<Integer>(3,
										new TestHeap4<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap4<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap4<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isAddValid(1), false);
	}

	boolean test12(Tester t) {
		TestHeap6 h = 
				new TestHeap6(2, 
						new TestHeap6(5, 
								new TestHeap6(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap6(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap6(3,
										new TestHeap6(7,
												new MtHeap<Integer>(),
												new TestHeap6(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap6(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isAddValid(1), false);
	}

	boolean test13(Tester t) {
		TestHeap5 h = 
				new TestHeap5(2, 
						new TestHeap5(5, 
								new TestHeap5(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap5(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap5(3,
										new TestHeap5(7,
												new MtHeap<Integer>(),
												new TestHeap5(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap5(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isRemMinValid(), false);
	}

	boolean test14(Tester t) {
		TestHeap2<Integer> h = 
				new TestHeap2<Integer>(2, 
						new TestHeap2<Integer>(5, 
								new TestHeap2<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap2<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap2<Integer>(3,
										new TestHeap2<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap2<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap2<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isRemMinValid(), false);
	}

	boolean test15(Tester t) {
		TestHeap3<Integer> h = 
				new TestHeap3<Integer>(2, 
						new TestHeap3<Integer>(5, 
								new TestHeap3<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap3<Integer>(3,
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap3<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap3<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isRemMinValid(), false);
	}
	
	boolean test16(Tester t) {
		TestHeap3<Integer> h = 
				new TestHeap3<Integer>(2, 
						new TestHeap3<Integer>(5, 
								new TestHeap3<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap3<Integer>(3,
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap3<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap3<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isAddValid(1), false);
	}

	boolean test17(Tester t) {
		TestHeap3<Integer> h = 
				new TestHeap3<Integer>(2, 
						new TestHeap3<Integer>(5, 
								new TestHeap3<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap3<Integer>(3,
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap3<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap3<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isAddValid(20), false);
	}

	boolean test18(Tester t) {
		TestHeap3<Integer> h = 
				new TestHeap3<Integer>(2, 
						new TestHeap3<Integer>(5, 
								new TestHeap3<Integer>(6, 
										new MtHeap<Integer>(), 
										new MtHeap<Integer>()
										),
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new MtHeap<Integer>()
												)
								),
								new TestHeap3<Integer>(3,
										new TestHeap3<Integer>(7,
												new MtHeap<Integer>(),
												new TestHeap3<Integer>(52,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
												),
												new TestHeap3<Integer>(6,
														new MtHeap<Integer>(),
														new MtHeap<Integer>()
														)
										)
						);
		return t.checkExpect(h.isHeap(), false);
	}
}
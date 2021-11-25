package main.java.guru.learning.javaconcepts.anonymousclass.impl;

import main.java.guru.learning.javaconcepts.anonymousclass.HelloAnonyms;

public class HelloAnonymsImpl {

	public abstract class Abstract {

		public void helloAbstract() {
			System.out.println("Poda " + x);
			name();
		}
	}

	int x = 45;

	public void name() {
		System.out.println("Accessing");
	}

	public static void main(String[] args) {

		int x = 40;
		HelloAnonyms hh = new HelloAnonyms() {

			@Override
			public void helloEveryOne() {
				System.out.println("aaa" + x);

			}

		};

		hh.helloEveryOne();
		HelloAnonymsImpl hah = new HelloAnonymsImpl();
		Abstract aa = hah.new Abstract() {

			@Override
			public void helloAbstract() {
				// TODO Auto-generated method stub
				super.helloAbstract();
			}

		};
		aa.helloAbstract();
	}

}

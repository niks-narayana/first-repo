package com.niks.hibernateTest.main;

public class TrialMain {

	public static void main(String[] args) {
		for(int i = 0 ; i < 100 ; i++) {
			long num = Math.round(Math.random()*10000);
			if(num < 1000) {
				num += 1000;
			}
			System.out.println(num);
		}
	}

}

package com.coursecube.jdbc.util;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		char[] arr1;
		char[] arr2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st string value : ");
		String word1=sc.nextLine();
		word1=word1.replace(" ", "");
		word1=word1.toLowerCase();		
		char a[]=word1.toCharArray();
		Arrays.sort(a);
		System.out.println("Enter 2nd string value : ");
		String word2=sc.nextLine();
		word2=word2.replace(" ", "");
		word2=word2.toLowerCase();
		char b[]=word2.toCharArray();
		Arrays.sort(b);
		if(a.length==b.length) {
			if(Arrays.equals(a, b)) {
				System.out.println("Given string is an anagram.");
			}
			else {
				System.out.println("Given string is not an anagram");
			}
			
		}
		else
			System.out.println("Given string is not an anagram");
	}
}

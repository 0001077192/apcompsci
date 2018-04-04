package com.jke.script.base;

public class Runner
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
		System.out.println( new SyntaxErrorException( "script.txt", "n / 0", 1, "/ 0", "Divide by zero" ) );
	}
}

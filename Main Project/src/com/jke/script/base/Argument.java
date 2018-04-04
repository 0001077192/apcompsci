package com.jke.script.base;

public class Argument<T extends ArgumentType>
{
	public final Class<T> type;
	private T value;
	
	public Argument( Class<T> t )
	{
		type = t;
	}
	
	@SuppressWarnings( "unchecked" )
	private void setValue( Object obj )
	{
		value = ( T ) obj;
	}
	
	public Argument<T> parse( String line )
	{
		Argument<T> arg = new Argument<T>( type );
		arg.setValue( line );
		return arg;
	}
}

interface Executor
{
	public void execute( Argument... args );
}

package com.jke.script.base;

public class ArgumentType
{
	public static final ArgumentType INTEGER = new INTEGER(), DOUBLE = new DOUBLE(), BOOLEAN = new BOOLEAN(), STRING = new STRING();
	
	private Parser p;
	
	private ArgumentType( Parser p )
	{
		this.p = p;
	}
	
	public Object parse( String arg )
	{
		try {
			return p.parse( arg );
		} catch( NumberFormatException e ) {
			return null;
		}
	}
	
	class INTEGER extends ArgumentType
	{
		public INTEGER()
		{
			super( ( arg ) -> Integer.parseInt( arg ) );
		}
	}
	
	class DOUBLE extends ArgumentType
	{
		public DOUBLE()
		{
			super( ( arg ) -> Double.parseDouble( arg ) );
		}
	}
	
	class BOOLEAN extends ArgumentType
	{
		public BOOLEAN()
		{
			super( ( arg ) -> Boolean.parseBoolean( arg ) );
		}
	}
	
	class STRING extends ArgumentType
	{
		public STRING()
		{
			super( ( arg ) -> arg );
		}
	}
}

interface Parser
{
	public Object parse( String arg );
}

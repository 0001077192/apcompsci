package com.jke.script.base;

public class SyntaxErrorException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String name, line, description;
	private int linenum, start = -1, end = -1;
	
	public SyntaxErrorException( String name, String line, int linenum, int start, int end, String description )
	{
		this.name = name;
		this.line = line;
		this.linenum = linenum;
		this.start = start;
		this.end = end;
		this.description = description;
	}
	
	public SyntaxErrorException( String name, String line, int linenum, int start, String description )
	{
		this.name = name;
		this.line = line;
		this.linenum = linenum;
		this.start = start;
		this.end = -1;
		this.description = description;
	}
	
	public SyntaxErrorException( String name, String line, int linenum, String token, String description )
	{
		this.name = name;
		this.line = line;
		this.linenum = linenum;
		this.start = line.indexOf( token );
		this.end = start + token.length();
		this.description = description;
	}
	
	public String toString()
	{
		String dummy = "SYNTAX ERROR: " + name + " @ Line " + linenum + ":\n\t" + line;
		
		if( start > -1 && end > start )
		{
			dummy += "\n\t";
			for( int i = 0; i < start; i++ )
				dummy += ' ';
			if( end > -1 && end <= line.length() )
				for( int i = start; i < end; i++ )
					dummy += '^';
			else
				for( int i = start; i < line.length(); i++ )
					dummy += '^';
		}
		
		dummy += "\n\t" + description;
		return dummy;
	}
}

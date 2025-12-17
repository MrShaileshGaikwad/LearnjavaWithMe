package Java.Literal;


/*
 * 
 * What is Literal in Java?
A literal is a fixed value assigned directly to a variable in the code. 
It represents constant values that are used directly in the code without computation.
Think of it as the actual value you assign:int age = 25; // 25 is a literal


Escape Sequences
Escape
Meaning
\n
New line
\t
Tab
\'
Single quote
\"
Double quote
\\
Backslash
System.out.println("Hello\nWorld");
 * 
 * */
public class Literal {
public static void main(String[] args) {
	int a = 10;
	int b =075;
	int c = 0xFF;
	boolean isJavaFun = true;
	boolean isRaining = false;
	
	int dec = 100; // Decimal literal
	int oct = 0123; // Octal (83)
	int hex = 0x7B; // Hex (123)
	int bin = 0b1010; // Binary (10)
	long big = 10000000000L; // Long literal
	float pi = 3.14f; // Float literal
	double price = 9.99e2; // 999.0 (scientific)
	//char c = 'A';
	char unicodeChar = '\u0042'; // 'B'
//	/boolean isJavaFun = true;
	String message = "Hello\nJava!";
	String str = null;
	System.out.println(message);
	
	
	System.out.println(a);

	System.out.println(b);

	System.out.println(c);
	
	System.err.println(isJavaFun);
System.err.println(isRaining);
	System.out.println(a+b+c);
	System.out.println("Hello\nWorld/t my ame \\is \"shailesh \'from pune");
}
}

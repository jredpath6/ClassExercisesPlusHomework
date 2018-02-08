import java.util.HashMap;
import java.util.Scanner;

public class Interpreter {
	// The symbol table is a dictionary of variable identifiers to bindings.
	private HashMap<String, Object> mySymbolTable = new HashMap<String, Object>();
	private Parser myParser;
	
	public Interpreter(){
		mySymbolTable = new HashMap<String,Object>();
		myParser = new Parser();
	}
	
	/*
	 * Continually ask the user to enter a line of code.
	 */
	public void promptLoop(){
		System.out.println("This is a simple interpreter.  I'm not a good compiler, so be careful and follow my special rules:\n" +
				"Each class name should be fully qualified, \n"+
				"I only create objects and call methods. \n" +
				"I only use literals of integers and Strings. \n"+
				"Enter 'Q' to quit.");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while(!line.equalsIgnoreCase("q")){
			// Find the important words out of the line.
			ParseResults parse = myParser.parse(line);
			// Do the command, and give a String response telling what happened.
			String answer = process(parse);
			System.out.println(answer);
			line = scan.nextLine();
		}
		scan.close();
	}
	
	/*
	 * This method does the work of carrying out the intended command.
	 * The input is a ParseResults object with all the important information
	 * from the typed line identified.  The output is the String to print telling
	 * the result of carrying out the command.
	 */
	public String process(ParseResults parse){
		//System.out.println(parse);
		if (parse.isMethodCall){
			return callMethod(parse);
		}
		else return makeObject(parse);
	}
	
	/*
	 * TODO: convertNameToInstance
	 * Given a name (identifier or literal) return the object.
	 * If the name is in the symbol table, you can just return the object it is 
	 * associated with.  If it's not in the symbol table, then it is either 
	 * a String literal or it is an integer literal.  Check to see if the 
	 * first character is quotation marks.  If so, create a new String object to
	 * return that has the same characters as the name, just without the quotes.
	 * If there aren't quotation marks, then it is an integer literal.  Use Integer.parseInt
	 * to turn the String into an int.
	 * 
	 * Examples:  Suppose symbol table has:
	 * "x" -> 3
	 * convertNameToInstance("x") returns 3.
	 * convertNameToInstance("4") returns 4.
	 * convertNameToInstance(""hey"") returns "hey"
	 */
	public Object convertNameToInstance(String name) {
		Object objName = mySymbolTable.get(name); //Find name in mySymbolTable hashmap
		if(objName == null) { //Checks if obj is null
			return objName; //If null, return
		} else if(name.charAt(0) == '"') {
			return name.substring(1, name.length()-1); //If name is a String, return name w/ out quotes
		} else { //Otherwise name = Integer, return the int
			return Integer.parseInt(name);
		}
	}
	
	/*TODO: convertNameToInstance.  
	 * Takes an array of Strings and converts all of them to their associated objects.
	 * Simply call the other helper method of the same name on each item in the array.
	 */
	public Object[] convertNameToInstance(String[] names){
		Object[] array = new Object[names.length]; //Array of objects w/ size = length of names
		for(int i = 0; i < names.length; i++) {
			array[i] = convertNameToInstance(names[i]); //Insert names into object array
		}
		return array; //Return the populated array
	}
	
	/* TODO: makeObject
	 * This method does the "process" job for making objects.
	 * This is where we use the ReflectionUtilities.
	 * Don't forget to add the new object to the symbol table.
	 * The String that is returned should be a basic message telling what happened.
	 */
	public String makeObject(ParseResults parse){	
		String className = parse.className;	//Set class and object names as String
		String objectName = parse.objectName;
		Object[] arguments = convertNameToInstance(parse.argumentNames);
		Object obj = ReflectionUtilities.createInstance(className, arguments);
		mySymbolTable.put(objectName, obj);
		return "Created new " + className + " called " + objectName;
	}
	
	/*
	 * TODO: callMethod
	 * This method does the "process" job for calling methods.
	 * You MUST use the ReflectionUtilities to call the method for 
	 * this to work, because ints can't be directly transformed into Objects.
	 * When you call a method, if it has an output, be sure to 
	 * either create a new object for that output or change the 
	 * existing object.  This will require either adding a new 
	 * thing to the symbol table or removing what is currently there
	 * and replacing it with something else.
	 */
	public String callMethod(ParseResults parse){
		String objectName = parse.objectName; //Use parse to call methods and create strings for object
		String methodName = parse.methodName; //Method
		String answerName = parse.answerName; //And answer
		Object[] argumentsArray = convertNameToInstance(parse.argumentNames); //use convertName() to create an array of argument names
		Object object = mySymbolTable.get(objectName); //Get objectName from hashmap, this value will be passed to RelectionUtilities.callMethod 
		Object methodCall = ReflectionUtilities.callMethod(object, methodName, argumentsArray); //Pass values to callMethod() located in the ReflectionUtilites class
		if(!(methodCall == null)) {  //Check if methodCall is empty
			if(mySymbolTable.containsKey(answerName)) { //If not empty and the hashmap already contains answer
				mySymbolTable.put(answerName, methodCall); //Replace the previous object with methodCall
				return "Value has been changed to " + answerName + ". Result is: " + methodCall + ".";
			} else { //Otherwise, create a new object
				mySymbolTable.put(parse.answerName, methodCall);
				return "Created a new object called " + parse.answerName + ". Result is: " + methodCall + ".";
			}
		}
		return "Method has been called. The result is: " + methodCall + ".";
	}
}

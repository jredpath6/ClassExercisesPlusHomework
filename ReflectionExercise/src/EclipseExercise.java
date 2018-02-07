import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * EclipseExercise.java 1.0 Feb 1, 2018
 *
 * Copyright (c) 2018 Jack Redpath. All Rights Reserved
 * Campus Box 8499, Elon University, Elon, NC 27244
 */

/**
 * Start each class or interface with a summary description line
 *
 * @author jredpath
 * @version 1.0
 *
 */
public class EclipseExercise {
	/**
	 * @param args
	 */

	ArrayList<String> propList = new ArrayList<String>();
	ArrayList<String> staticList = new ArrayList<String>();

	public static void main(String[] args) {
		new EclipseExercise().popUp();

		// Eclipse prints the non-static fields, then the non-static methods
		// Then the static fields, then static methods.
	}

	public void popUp() {
		System.out.print("Enter the name of the class: ");
		Scanner scan = new Scanner(System.in);
		String className = scan.nextLine();
		try {
			Class theClass = Class.forName(className);
			Field[] classFields = theClass.getFields(); // Declare fields array
			for (int i = 0; i < theClass.getFields().length; i++) {
				String fieldName = classFields[i].getName(); // Get properties
				String fieldType = classFields[i].getGenericType().toString();
				String fieldDeclaringClass = classFields[i].getDeclaringClass().toString();
				if (java.lang.reflect.Modifier.isStatic(classFields[i].getModifiers())) {
					staticList.add("S:" + fieldName + " : " + fieldType + " - "
							+ fieldDeclaringClass.replace("class ", ""));
				} else {
					propList.add(fieldName + " : " + fieldType + " - "
							+ fieldDeclaringClass.replace("class ", ""));
				}
			}
			Method[] classMethods = theClass.getMethods(); // Declare methods
															// array
			for (int i = 0; i < theClass.getMethods().length; i++) {
				String methodName = classMethods[i].getName();
				Class<?>[] methodParams = classMethods[i].getParameterTypes();
				ArrayList<String> params = new ArrayList<String>();
				for (int j = 0; j < methodParams.length; j++) {
					params.add(methodParams[j].getName());
				}
				String methodReturn = classMethods[i].getReturnType().toString();
				String methodDeclaringClass = classMethods[i].getDeclaringClass().toString();
				if (java.lang.reflect.Modifier.isStatic(classMethods[i].getModifiers())) {
					staticList.add("S:" + methodName + "("
							+ params.toString().replace("[", "").replace("]", "") + ") : "
							+ methodReturn + " - " + methodDeclaringClass.replace("class ", ""));
				} else {
					propList.add(methodName + "("
							+ params.toString().replace("[", "").replace("]", "") + ") : "
							+ methodReturn + " - " + methodDeclaringClass.replace("class ", ""));
				}

			}
			Collections.sort(propList); // sort non-static list
			Collections.sort(staticList); // sort static list
			for (int i = 0; i < propList.size(); i++) {
				System.out.println(propList.get(i)); // print each non-static
														// item
			}
			for (int i = 0; i < staticList.size(); i++) {
				System.out.println(staticList.get(i)); // print each static item
			}

		} catch (ClassNotFoundException e) {
			System.err.println("I dont know the name of that class: " + className);
		}
	}
}

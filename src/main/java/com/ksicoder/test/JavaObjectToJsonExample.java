package com.ksicoder.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * Hello Earth!
 *
 */
public class JavaObjectToJsonExample {
	public static void main(String[] args) {
		// Person person = new Person();
		// person.doSomething();

		Gson gson = new Gson();
		Staff staff = createStaffObject();
		String json = gson.toJson(staff); // Java objects to String
		System.out.println("Java object to String : " + json);

		Gson gsonPrettyStyle = new GsonBuilder().setPrettyPrinting().create();
		String jsonPretty = gsonPrettyStyle.toJson(staff); // Java objects to String pretty style
		System.out.println("Java object to String with Pretty style: " + jsonPretty);

		try {
			FileWriter writer = new FileWriter("c:\\projects\\staff.json");
			gson.toJson(staff, writer); // Java objects to File
		} catch (IOException e) {
			e.printStackTrace();
		}

		// JSON to java object convert start
		Gson gson2 = new Gson();
		try {
			Reader reader = new FileReader("c:\\projects\\staff.json");
			Staff staff2 = gson2.fromJson(reader, Staff.class); // Convert JSON File to Java Object
			System.out.println("JSON to java object : " + staff2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// JSON to java object convert end

		// Convert to json element start here
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create(); // pretty print
		try {
			Reader reader2 = new FileReader("c:\\projects\\staff.json");
			JsonElement jsonElement = gson3.fromJson(reader2, JsonElement.class);
			String jsonInString = gson3.toJson(jsonElement);
			System.out.println(jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Convert to json element end here

	}

	public static Staff createStaffObject() {
		Staff staff = new Staff();
		staff.setName("ksi");
		staff.setAge(44);
		staff.setPosition(new String[] { "Founder", "CTO", "Writter" });

		Map<String, BigDecimal> salary = new HashMap<String, BigDecimal>();
		salary.put("2016", new BigDecimal(22000));
		salary.put("2018", new BigDecimal(24000));
		salary.put("2020", new BigDecimal(27000));

		staff.setSalary(salary);
		staff.setSkills(
				Arrays.asList("java", "python", "android", "c++", "c", "angular", "angularJs", "assembly language"));

		return staff;
	}
}

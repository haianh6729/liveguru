package resources;

import com.github.javafaker.Faker;

public class TestData {
	Faker fake = new Faker();

	public String getName(String typeName) {
		if (typeName.equals("firstname")) {
			return fake.name().firstName();
		} else if (typeName.equals("lastname")) {
			return fake.name().lastName();
		}
		return fake.name().fullName();
	}
	
	public String getEmail() {
		return fake.internet().emailAddress();
	}
	
	public String getPassword() {
		return fake.internet().password();
	}
	
	static TestData data = new TestData();
	public static String firstname = data.getName("firstname");
	public static String lastname = data.getName("lastname");
	public static String email = data.getEmail();
	public static String password = data.getPassword();
}

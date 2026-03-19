package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();
	public String createRandomUserName() {
		return faker.name().username();
	}
	
	public String createRandomPassword() {
		return faker.internet().password();
	}
	
	public String createRandomEmail() {
		return faker.internet().emailAddress();
	}
	
	public String createRandomAddress() {
		return faker.address().fullAddress();
	}
	
	public String createFullName() {
		return faker.name().fullName();
	}

	public String createRandomNews()
	{
		return faker.job().title();
	}
}

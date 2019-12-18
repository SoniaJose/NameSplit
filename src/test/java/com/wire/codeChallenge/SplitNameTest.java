package com.wire.codeChallenge;
import java.util.ArrayList;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class to check the split of name string into Salutation, First name, Middle name, Last name, Suffix.
 * 
 * @author Sonia
 *
 */

public class SplitNameTest {

	/**
	 * Method: To check the split of address for simple name strings.
	 * 
	 */
	@Test
	public void splitTestSimple() {
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONObject json3 = new JSONObject();
		JSONObject json4 = new JSONObject();
		json.put("salutation", JSONObject.NULL);
		json.put("firstname", "Frida");
		json.put("middlename", JSONObject.NULL);
		json.put("lastname", "Kahlo");
		json.put("suffix",JSONObject.NULL);

		json2.put("salutation", JSONObject.NULL);
		json2.put("firstname", "Oscar");
		json2.put("middlename", "Claude");
		json2.put("lastname", "Monet");
		json2.put("suffix", JSONObject.NULL);

		json3.put("salutation", JSONObject.NULL);
		json3.put("firstname", "Vincent");
		json3.put("middlename", "Willem");
		json3.put("lastname", "van Gogh");
		json3.put("suffix", JSONObject.NULL);
		
		json4.put("salutation", "Mr.");
		json4.put("firstname", "George");
		json4.put("middlename", JSONObject.NULL);
		json4.put("lastname", JSONObject.NULL);
		json4.put("suffix", JSONObject.NULL);

		SplitName sObject = new SplitName();
		ArrayList<String> list = new ArrayList<String>(); // Created an Array list to store the input name string.
		ArrayList<JSONObject> list2 = new ArrayList<JSONObject>(); // Created an Array list to store the expected JSON
																	// object for result verification.
		list.add("Frida Kahlo");
		list.add("Oscar Claude Monet");
		list.add("Vincent Willem van Gogh");
		list.add("Mr. George");
		
		list2.add(json);
		list2.add(json2);
		list2.add(json3);
		list2.add(json4);
		for (int counter = 0; counter < list.size(); counter++) {
			System.out.println(list.get(counter).toString());
			System.out.println(list2.get(counter).toString());
			System.out.println(sObject.split(list.get(counter).toString()));
			Assert.assertEquals(list2.get(counter).toString(), sObject.split(list.get(counter)).toString());

		}
	}
	/**
	 * Method: To check the split of address for complex name string.
	 * 
	 */ 
	@Test
	public void splitTestComplex() {		
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONObject json3 = new JSONObject();
		JSONObject json4 = new JSONObject();
		JSONObject json5 = new JSONObject();
		json.put("salutation", "Mrs.");
		json.put("firstname", "Anisha");
		json.put("middlename", JSONObject.NULL);
		json.put("lastname", "Thomas");
		json.put("suffix", JSONObject.NULL);

		json2.put("salutation", JSONObject.NULL);
		json2.put("firstname", "Daniel");
		json2.put("middlename", JSONObject.NULL);
		json2.put("lastname", "George");
		json2.put("suffix", "Jr.");

		json3.put("salutation", "Mr.");
		json3.put("firstname", "Vincent");
		json3.put("middlename", "Willem");
		json3.put("lastname", "van Gogh");
		json3.put("suffix", "Sr.");

		json4.put("salutation", "Ms.");
		json4.put("firstname", "Berthe");
		json4.put("middlename", JSONObject.NULL);
		json4.put("lastname", "Morisot");
		json4.put("suffix", JSONObject.NULL);

		json5.put("salutation", "Mr.");
		json5.put("firstname", "George");
		json5.put("middlename", "John");
		json5.put("lastname", "Antony");
		json5.put("suffix", "Jr.");

		SplitName sObject = new SplitName();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<JSONObject> list2 = new ArrayList<JSONObject>();
		list.add("Mrs. Anisha Thomas");
		list.add("Daniel George, Jr.");
		list.add("Mr. Vincent Willem van Gogh, Sr.");
		list.add("Ms. Berthe Morisot");
		list.add("Mr. George John Antony, Jr.");

		list2.add(json);
		list2.add(json2);
		list2.add(json3);
		list2.add(json4);
		list2.add(json5);
		for (int counter = 0; counter < list.size(); counter++) {
			System.out.println(list.get(counter).toString());
			System.out.println(list2.get(counter).toString());
			System.out.println(sObject.split(list.get(counter).toString()));
			Assert.assertEquals(list2.get(counter).toString(), sObject.split(list.get(counter)).toString());

		}
	}
}

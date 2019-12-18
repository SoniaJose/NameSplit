package com.wire.codeChallenge;

import org.json.JSONObject;

/**
 * Class for defining the logic for split of a 'name' string.
 * 
 * @author Sonia
 *
 */
public class SplitName {
	/**
	 * Method: To define the logic for split of a 'name' string.
	 * 
	 */
	public JSONObject split(String name) {
		JSONObject nameObject = new JSONObject();
		String result[] = name.split("\\s", 3);// Split the String until 3 elements
		int counter = result.length;
		int indexPoint = result[0].indexOf(".");
		int indexComma = result[0].indexOf(",");

		// If the split results 2 strings then its First name and Last name and check
		// for the presence of salutation or suffix.

		if (counter == 2) {

			if (indexPoint == -1 && indexComma == -1) {

				nameObject.put("salutation", JSONObject.NULL);
				nameObject.put("firstname", result[0]);
				nameObject.put("middlename", JSONObject.NULL);
				nameObject.put("lastname", result[1]);
				nameObject.put("suffix", JSONObject.NULL);
				return nameObject;
			} else if (indexPoint != -1 & indexComma == -1) {
				nameObject.put("salutation", result[0]);
				nameObject.put("firstname", result[1]);
				nameObject.put("middlename", JSONObject.NULL);
				nameObject.put("lastname", JSONObject.NULL);
				nameObject.put("suffix", JSONObject.NULL);
				return nameObject;
			} else if (indexPoint == -1 & indexComma != -1) {
				nameObject.put("salutation", JSONObject.NULL);
				nameObject.put("firstname", result[0]);
				nameObject.put("middlename", JSONObject.NULL);
				nameObject.put("lastname", JSONObject.NULL);
				nameObject.put("suffix", result[1].trim());
				return nameObject;

				// If more than 2 strings, check for the presence of salutation or suffix else
				// divide the names to First name , Middle Name or Last Name.
			}
		} else if (counter > 2) {

			String resultActual[] = name.split("\\s");
			int counterActual = resultActual.length;

			if (counterActual <= 3) {
				indexComma = result[counter - 2].indexOf(",");// If the number of names if <= 3, then the position of
			} // ',' is in the n-2 position of String result[].
			else {
				indexComma = result[counter - 1].indexOf(",");// If the number of names if > 3, then the position of ','
			} // is in the n-1 position of String result[].
			if (indexPoint == -1 && indexComma == -1) {
				nameObject.put("salutation", JSONObject.NULL);
				nameObject.put("firstname", result[0]);
				nameObject.put("middlename", result[1]);
				nameObject.put("lastname", result[counter - 1]);
				nameObject.put("suffix", JSONObject.NULL);
				return nameObject;
			} else if (indexPoint != -1 && indexComma == -1) {
				nameObject.put("salutation", result[0]);
				nameObject.put("firstname", result[1]);
				String resultSubString[] = result[2].split("\\s");
				int counterSubString = resultSubString.length;
				if (counterSubString > 1) {
					nameObject.put("middlename", resultSubString[0]);
					nameObject.put("lastname", resultSubString[1]);
				} else {
					nameObject.put("middlename", JSONObject.NULL);
					nameObject.put("lastname", result[2]);
				}
				nameObject.put("suffix", JSONObject.NULL);
				return nameObject;
			} else if (indexPoint == -1 && indexComma != -1) {
				nameObject.put("salutation", JSONObject.NULL);
				nameObject.put("firstname", result[0]);
				String resultSubString[] = result[2].split(",");
				int counterSubString = resultSubString.length;
				if (counterSubString >= 2) {
					nameObject.put("middlename", result[1]);
					nameObject.put("lastname", resultSubString[0].replace(",", ""));
					nameObject.put("suffix", resultSubString[counterSubString - 1].trim());
				} else {
					nameObject.put("middlename", JSONObject.NULL);

					nameObject.put("lastname", result[1].replace(",", ""));
					nameObject.put("suffix", result[counter - 1].trim());
				}

				return nameObject;
			} else if (indexPoint != -1 && indexComma != -1) {
				nameObject.put("salutation", result[0]);
				nameObject.put("firstname", result[1].replace(",", ""));
				String resultSubString[] = result[2].split(",");
				int counterSubString = resultSubString.length;
				if (counterSubString >= 2) {
					String resultMiddleSubString[] = resultSubString[0].split("\\s", 2);
					nameObject.put("middlename", resultMiddleSubString[0]);
					nameObject.put("lastname", resultMiddleSubString[1].replace(",", ""));
				} else {
					nameObject.put("middlename", JSONObject.NULL);
					nameObject.put("lastname", JSONObject.NULL);
				}
				nameObject.put("suffix", resultSubString[counterSubString - 1].trim());
				return nameObject;
			} else
				return null;
		} else
			nameObject.put("salutation", JSONObject.NULL);
		nameObject.put("firstname", result[0]);
		nameObject.put("middlename", JSONObject.NULL);
		nameObject.put("lastname", JSONObject.NULL);
		nameObject.put("suffix", JSONObject.NULL);
		return nameObject;
	}

}

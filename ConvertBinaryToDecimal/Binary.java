public class Binary {
	private String input;

	Binary(String input){
		this.input = input;
	}

	/**
	 *  Given a binary input string, this program will produce a decimal output
	 * @return decimal value for the given binary input
	 */
	public int getDecimal(){
		int decimalValue = 0;
		if(null != input && checkIfNumber(input) && isBinary(Integer.parseInt(input))){
			int base = 1;
			for (int k= input.length()-1; k>=0; k--){
				decimalValue += base * (input.charAt(k) - '0');
				base *= 2;
			}
		}
		return decimalValue;
	}

	/**
	 *  Given a number, this program will validate binary  
	 * @return true if input is binary
	 */
	private boolean isBinary(int number) {
		int copyOfInput = number;

		while (copyOfInput != 0) {
			if (copyOfInput % 10 > 1) {
				return false;
			}
			copyOfInput = copyOfInput / 10;
		}
		return true;
	}

	/**
	 *  Given a number, this program will validate for a number  
	 * @return true if input is number
	 */
	public boolean checkIfNumber(String number) {

		try {

			Integer.parseInt(number);

		} catch (NumberFormatException ex) {
			return false;
		}

		return true;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Robot {
	private static final String ALPHABETLIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Set<String> GENERATED_NAMES = new HashSet<>();
	private String name;

	/**
	 *  Given a binary input string, this program will produce a decimal output
	 * @return unique robot name
	 */
	public String getName() {
		if(name == null) {
			do {
				name = generateName();
			} while(GENERATED_NAMES.contains(name));
			GENERATED_NAMES.add(name);
		}
		return name; 
	}

	public void reset() {
		name = null;    
	}

	private String generateName() {
		StringBuilder builder = new StringBuilder(5);
		for (int i = 0; i < 2; i++) {
			builder.append(ALPHABETLIST.charAt(generateRandomInRange(0, 25)));
		}
		for (int i = 0; i < 3; i++) {
			builder.append(generateRandomInRange(0, 9));
		}
		return builder.toString();
	}

	private int generateRandomInRange(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
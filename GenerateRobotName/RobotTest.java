import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;

public class RobotTest {

 	private static final Pattern EXPECTED_ROBOT_NAME_PATTERN = Pattern.compile("[A-Z]{2}\\d{3}");
    private final Robot robot = new Robot();

    @Test
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Test
    public void differentRobotsHaveDifferentNames() {
        assertThat(robot.getName(), not(equalTo(new Robot().getName())));
    }

    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name, not(equalTo(name2)));
        assertIsValidName(name2);
    }

    private static void assertIsValidName(String name) {
    	boolean matches = EXPECTED_ROBOT_NAME_PATTERN.matcher(name).matches();
        assertTrue("Name does not match the expected pattern", matches);
    }
}
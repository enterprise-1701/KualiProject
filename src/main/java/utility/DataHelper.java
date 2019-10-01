package utility;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {

    Faker faker;

    public DataHelper() {
        faker = new Faker();
    }

    /**
     * Create unique email
     *
     * @return email
     */
    public String getUniqueEmail() {
        String email = faker.internet().emailAddress();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = dateFormat.format(date.getTime());
        email = email.replace("@", "+" + dateString + "@");

        return email;
    }

    /**
     * Create random first name
     *
     * @return first name
     */
    public String getFirstName() {
        String firstName = faker.name().firstName();
        return firstName;
    }

    /**
     * Create random last name
     *
     * @return last name
     */
    public String getLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }
}

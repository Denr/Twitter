import org.junit.Before;
import org.junit.Test;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class TwitsTest {

    @Before
    public void setUp() throws Exception {
        setBaseUrl("http://localhost:8080/twit");
    }

    @Test
    public void testRegistration() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("reg");
        assertFormElementPresent("reg_login");
        assertFormElementPresent("reg_pass");
        setTextField("reg_login", "Tester4");
        setTextField("reg_pass", "123");
        submit();
        assertTextPresent("Вы успешно зарегестрированы!");
    }

    @Test
    public void testSignUp() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("sign");
        assertFormElementPresent("sign_login");
        assertFormElementPresent("sign_pass");
        setTextField("sign_login", "Medvedev");
        setTextField("sign_pass", "Medvedev");
        submit();
        assertTitleEquals("Ваш твиттер");
    }


    @Test
    public void testFailSignUp() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("sign");
        assertFormElementPresent("sign_login");
        assertFormElementPresent("sign_pass");
        setTextField("sign_login", "Medvedev");
        setTextField("sign_pass", "123");
        submit();
        assertTextPresent("Неверный логин и/или пароль!");
    }

    @Test
    public void testFailRegistration() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("reg");
        assertFormElementPresent("reg_login");
        assertFormElementPresent("reg_pass");
        setTextField("reg_login", "Medvedev");
        setTextField("reg_pass", "Medvedev");
        submit();
        assertTextPresent("Такой логин уже зарегестрирован!");
    }

    @Test
    public void testTwit() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("sign");
        assertFormElementPresent("sign_login");
        assertFormElementPresent("sign_pass");
        setTextField("sign_login", "Medvedev");
        setTextField("sign_pass", "Medvedev");
        submit();
        assertFormPresent("twit");
        assertFormElementPresent("text_twit");
        setTextField("text_twit", "Test twit");
        submit();
        assertTextPresent("Затвичено!");
    }

    @Test
    public void testLogOut() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("sign");
        assertFormElementPresent("sign_login");
        assertFormElementPresent("sign_pass");
        setTextField("sign_login", "Medvedev");
        setTextField("sign_pass", "Medvedev");
        submit();
        setWorkingForm("logout");
        submit();
        assertTextPresent("Вы разлогиниь!");
    }

    @Test
    public void testDeleteTwit() throws Exception {
        beginAt("index.jsp");
        assertTitleEquals("Twits");
        assertFormPresent("sign");
        assertFormElementPresent("sign_login");
        assertFormElementPresent("sign_pass");
        setTextField("sign_login", "Medvedev");
        setTextField("sign_pass", "Medvedev");
        submit();
        setWorkingForm("delete");
        submit();
        assertTextPresent("Твит удален!");
    }
}
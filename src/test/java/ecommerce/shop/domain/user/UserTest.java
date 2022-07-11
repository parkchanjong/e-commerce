package ecommerce.shop.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {

    @BeforeAll
    static void setup() {
    }

    @Test
    void update_test() {
        //given
        String email = "asdf@asdf.asdf";
        String password = "asdf";
        String name = "qwer";

        //when
        User user = User.builder().email(email).password(password).build();
        user.update(name);

        //then
        assertThat(user.getName()).isEqualTo(name);
    }

    @Test
    void randomWord_test() {
        //given
        String email = "asdf@asdf.asdf";
        String password = "asdf";

        //when
        User user = User.builder().email(email).password(password).build();
        String randomWord = user.randomWord();

        //then
        assertEquals(7, randomWord.length());
    }

    @Test
    void encrypt_test() throws Exception {
        //given
        String email = "asdf@asdf.asdf";
        String password = "asdf";

        //when
        User user = User.builder().email(email).password(password).build();
        String randomWord = user.getSalt();
        String encryptPassword = user.encrypt(password + randomWord);

        //then
        assertThat(user.getPassword()).isEqualTo(encryptPassword);
    }

    @Test
    void builder_test() {
        //given
        String email = "asdf@asdf.asdf";
        String password = "asdf";

        //when
        User user = User.builder().email(email).password(password).build();

        //then
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
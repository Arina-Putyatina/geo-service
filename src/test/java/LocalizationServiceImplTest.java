import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {

    LocalizationServiceImpl sut;

    @BeforeEach
    public void init() {
        sut = new LocalizationServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("source")
    void test_byIp(Country country, String expected) {
        //act
        String result = sut.locale(country);

        //assert
        assertEquals(result, expected);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"));
    }
}

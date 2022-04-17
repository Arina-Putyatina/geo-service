import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {

    GeoServiceImpl sut;

    @BeforeEach
    public void init() {
        sut = new GeoServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("source")
    void test_byIp(String ip, Location expected) {
        //act
        Country result = sut.byIp(ip).getCountry();

        //assert
        assertEquals(result, expected.getCountry());
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of("172.0.32.10", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.44.183.150", new Location("New York", Country.USA, null, 0)));
    }
}

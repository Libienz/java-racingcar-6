package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.InputValidator;
import racingcar.domain.validator.RoundNumberValidator;

@DisplayName("입력 테스트")
class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        InputValidator<String> roundNumberValidator = new RoundNumberValidator();
        InputValidator<List<String>> carNamesValidator = new CarNamesValidator();
        inputView = new InputView(roundNumberValidator, carNamesValidator);
        Console.close();
    }

    @DisplayName("자동차 이름 입력 테스트")
    @Test
    void testReadCarNames() throws InterruptedException {

        String input = "pobi,jun,woni\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<String> carNames = inputView.readCarNames();
        assertThat(carNames).containsExactly("pobi", "jun", "woni");
    }

    @DisplayName("라운드 횟수 입력 테스트")
    @Test
    void testReadNumberOfRounds() {
        String input = "5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int numberOfRounds = inputView.readNumberOfRounds();
        assertEquals(5, numberOfRounds);
    }


}

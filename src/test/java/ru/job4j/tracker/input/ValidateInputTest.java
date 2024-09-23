package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;


import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
             new String[] {"7"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(7);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        String[] values = new String[] {"5", "7", "9", "11", "27"};
        int[] numbers = {5, 7, 9, 11, 27};
        Input in = new MockInput(values);
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(7);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(9);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(11);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(27);
    }

    @Test
    void whenNegativeNumberInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-9"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-9);
    }
}
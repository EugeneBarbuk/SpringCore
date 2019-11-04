
import org.testng.Assert;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Grow {
    public static void main(String[] args) {

        List<Integer> listOfOddNumbers = Stream.of(1, 2, 3)
                .collect(filtering(i -> i % 2 != 0, toList()));

        Assert.assertThat(listOfOddNumbers)
                .hasSize(2)
                .containsOnly(1, 3);
    }
}

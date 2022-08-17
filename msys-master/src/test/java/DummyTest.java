import com.chaossnow.ms.dto.UserDTO;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DummyTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<User> users = new ArrayList<>();
        // (UserDTO) new UserDTO().convertFrom(user)
        System.out.println(filtered.toString());

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3,2,1,45,21,555);

        List<Integer> squaresList = numbers.stream().map(i -> i*i ).collect(Collectors.toList());
        System.out.println(squaresList.toString());

    }

}



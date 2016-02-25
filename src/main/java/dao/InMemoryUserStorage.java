package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryUserStorage implements UserStorage {
    private List<User> userStorage = new ArrayList<>();

    public InMemoryUserStorage() {
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setName("user " + i + " marked");
            user.setMarked(true);

            userStorage.add(user);
        }
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("user " + i + " UnMarked");
            user.setMarked(false);

            userStorage.add(user);
        }
    }

    public InMemoryUserStorage(List<User> userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public List<User> getMarked() {
        return userStorage.stream()
                .filter(User::getMarked)
                .collect(Collectors.toList());
    }
}

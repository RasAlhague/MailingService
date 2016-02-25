package dao;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InMemoryUserStorageTest {

    @Test
    public void testGetMarked() throws Exception {
        UserStorage userStorage = new InMemoryUserStorage();
        List<User> marked = userStorage.getMarked();
        for (User user : marked) {
            assertTrue(user.getMarked());
        }
    }
}
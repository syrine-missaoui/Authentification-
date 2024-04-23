//package com.intraconnect.usermanagementms;
//
//import com.intraconnect.usermanagementms.entities.Role;
//import com.intraconnect.usermanagementms.entities.User;
//import com.intraconnect.usermanagementms.repository.UserRepo;
//import com.intraconnect.usermanagementms.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//
//@SpringBootTest
//class UserManagementMsApplicationTests {
//    @Mock
//    private UserRepo userRepo;
//
//    private UserService userService;
//
//    @BeforeEach
//    public void setup() {
//        userRepo = mock(UserRepo.class);
//        userService = new UserService(userRepo);
//    }
//
//    @Test
//    void testSignUp() {
//        User user = new User(
//                "syrine",
//                "missaoui",
//                "2000-10-03",
//                "exemple@example.com",
//                "123 rue de la bourse",
//                "1232365",
//                "password123",
//                Role.USER
//        );
//        when(userRepo.save(any(User.class))).thenReturn(user);
//        User savedUser = userService.signUp(user);
//        verify(userRepo, times(1)).save(any(User.class));
//        assertEquals(user.getFirstName(), savedUser.getFirstName());
//        assertEquals(user.getLastName(), savedUser.getLastName());
//        assertEquals(user.getDateOfBirth(), savedUser.getDateOfBirth());
//        assertEquals(user.getEmail(), savedUser.getEmail());
//        assertEquals(user.getAdresse(), savedUser.getAdresse());
//        assertEquals(user.getContactNumber(), savedUser.getContactNumber());
//        assertEquals(user.getPassword(), savedUser.getPassword());
//
//    }
//}
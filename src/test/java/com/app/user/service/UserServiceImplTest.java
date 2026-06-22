import com.app.user.dto.UserRegistrationRequest;
import com.app.user.dto.UserResponse;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testRegisterUser_HappyPath() {
        UserRegistrationRequest request = new UserRegistrationRequest("John", "Doe", "john.doe@example.com", "password123", "1234567890");
        when(userRepository.existsByEmail(request.email())).thenReturn(false);
        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn("encoded-password");

        UserResponse response = userService.registerUser(request);

        verify(userRepository).save(any(User.class));
        assertEquals("john.doe@example.com", response.email());
        assertEquals("John", response.firstName());
        assertEquals("Doe", response.lastName());
    }

    @Test
    public void testRegisterUser_DuplicateEmail() {
        UserRegistrationRequest request = new UserRegistrationRequest("Jane", "Doe", "jane.doe@example.com", "password123", "0987654321");
        when(userRepository.existsByEmail(request.email())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(request));
    }
}
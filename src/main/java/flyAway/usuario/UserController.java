package flyAway.usuario;

import flyAway.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<NewIdDTO> register(@RequestBody RegisterUserDto newUser) {

        if (userService.findByEmail(newUser.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User user = modelMapper.map(newUser, User.class);

        User saved = userService.save(user);

        String token = jwtService.generateToken(saved.getEmail());
        System.out.println("Token generado: " + token);

        NewIdDTO dto = modelMapper.map(saved, NewIdDTO.class);
        return ResponseEntity.ok(dto);
    }
}

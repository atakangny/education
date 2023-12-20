package com.atakanguney.education.auth;

import com.atakanguney.education.entity.UserEntity;
import com.atakanguney.education.enums.AccountStatus;
import com.atakanguney.education.enums.Role;
import com.atakanguney.education.repository.UserRepository;
import com.atakanguney.education.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.UNASSIGNED)
                .status(AccountStatus.WAITING_APPROVAL)
                .isExpired(false)
                .isLocked(false)
                .build();
        UserEntity savedUser = userRepository.save(user);

        // Use generated id in code
        savedUser.setUserCode("U" + savedUser.getId().toString());
        userRepository.save(savedUser);

        String jwtToken = jwtService.generateToken(null, savedUser);
        System.out.println(savedUser.getUserCode());
        System.out.println(savedUser.getPassword());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserEntity user = userRepository.findByUserCode(request.getUserCode()).orElseThrow();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserCode(), request.getPassword())
        );

        String jwtToken = jwtService.generateToken(null, user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

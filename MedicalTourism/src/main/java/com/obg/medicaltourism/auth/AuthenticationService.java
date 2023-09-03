package com.obg.medicaltourism.auth;

import com.obg.medicaltourism.config.JwtService;
import com.obg.medicaltourism.database.entity.Patient;
import com.obg.medicaltourism.database.repository.PatientRepository;
import com.obg.medicaltourism.utility.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PatientRepository patientRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var patient = Patient.builder()
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .bankAccountBalance(registerRequest.getBankAccountBalance())
                .role(Role.USER)
                .build();
        patientRepository.save(patient);
        var jwtToken = jwtService.generateToken(patient);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var patient = patientRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(patient);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

package odium.dar.DarServer.controller;

import odium.dar.DarServer.auth.UserDetailsImpl;
import odium.dar.DarServer.model.Role;
import odium.dar.DarServer.model.User;
import odium.dar.DarServer.model.enums.ERole;
import odium.dar.DarServer.pojo.JwtResponse;
import odium.dar.DarServer.pojo.LoginRequest;
import odium.dar.DarServer.pojo.MessageResponse;
import odium.dar.DarServer.pojo.SignupRequest;
import odium.dar.DarServer.repository.RoleRepository;
import odium.dar.DarServer.repository.UserRepository;
import odium.dar.DarServer.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

        @Autowired
        UserRepository userRespository;

        @Autowired
        RoleRepository roleRepository;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        JwtUtils jwtUtils;

        @PostMapping("/signin")
        public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles));
        }

        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {

            if (userRespository.findByUsername(signupRequest.getUsername()).isPresent()) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is exist"));
            }

            if (userRespository.findUserByEmail(signupRequest.getEmail()).isPresent()) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Email is exist"));
            }

            User user = new User(signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    passwordEncoder.encode(signupRequest.getPassword()));

         //   Set<String> reqRoles = signupRequest.getRoles();
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository
                    .findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
            roles.add(userRole);
/*            if (reqRoles == null) {
                Role userRole = roleRepository
                        .findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
                roles.add(userRole);
            } else {
                reqRoles.forEach(r -> {
                    switch (r) {
                        case "admin":
                            Role adminRole = roleRepository
                                    .findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
                            roles.add(adminRole);

                            break;
//                        case "mod":
//                            Role modRole = roleRepository
//                                    .findByName(ERole.ROLE_MODERATOR)
//                                    .orElseThrow(() -> new RuntimeException("Error, Role MODERATOR is not found"));
//                            roles.add(modRole);
//
//                            break;

                        default:
                            Role userRole = roleRepository
                                    .findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
                            roles.add(userRole);
                    }
                });
            }*/

            user.setRoles(roles);
            userRespository.save(user);
            return ResponseEntity.ok(new MessageResponse("User CREATED"));
        }
}

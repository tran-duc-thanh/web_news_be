package com.ptit.web_news_be;

import com.ptit.web_news_be.auth.jwt.JwtTokenProvider;
import com.ptit.web_news_be.auth.payload.LoginRequest;
import com.ptit.web_news_be.auth.payload.LoginResponse;
import com.ptit.web_news_be.auth.payload.RandomStuff;
import com.ptit.web_news_be.auth.user.CustomUserDetail;
import com.ptit.web_news_be.auth.user.User;
import com.ptit.web_news_be.auth.user.UserRepository;
import com.ptit.web_news_be.entity.MapRoleUserEntity;
import com.ptit.web_news_be.entity.RolesEntity;
import com.ptit.web_news_be.repository.MapRoleUserRepo;
import com.ptit.web_news_be.repository.RoleRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LodaRestController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private MapRoleUserRepo mapRoleUserRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        String username = userDetail.getUsername();
        List<RolesEntity> roles = getRolesByUsername(username);
        LoginResponse response = new LoginResponse(jwt, username);
        response.setRoles(roles);
        return response;
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    @PostMapping("/register")
    public LoginResponse register(@Valid @RequestBody LoginRequest loginRequest) {
        User user = new User();
		user.setUsername(loginRequest.getUsername());
		user.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
        user = userRepository.save(user);
        MapRoleUserEntity mapRoleUserEntity = new MapRoleUserEntity();
        mapRoleUserEntity.setRoleId(2L);
        mapRoleUserEntity.setUserId(user.getId());
        mapRoleUserRepo.save(mapRoleUserEntity);
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        String username = userDetail.getUsername();
        List<RolesEntity> roles = getRolesByUsername(username);
        LoginResponse response = new LoginResponse(jwt, username);
        response.setRoles(roles);
        return response;
    }
    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    private List<RolesEntity> getRolesByUsername (String username) {
        List<RolesEntity> roles = new ArrayList<>();
        User user = userRepository.findByUsername(username).get();
        List<MapRoleUserEntity> mapRoleUser = mapRoleUserRepo.findAllByUserId(user.getId());
        mapRoleUser.forEach(map -> {
            RolesEntity role = roleRepo.findById(map.getRoleId()).get();
            roles.add(role);
        });
        return roles;
    }
}

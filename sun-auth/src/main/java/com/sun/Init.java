package com.sun;


import com.google.common.collect.Sets;
import com.sun.domain.Authority;
import com.sun.domain.Role;
import com.sun.domain.User;
import com.sun.repository.AuthorityRepository;
import com.sun.repository.RoleRepository;
import com.sun.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by SuperS on 2017/9/25.
 *
 * @author SuperS
 */
@Component
@AllArgsConstructor
public class Init implements CommandLineRunner {
    private UserService userService;
    private AuthorityRepository authorityRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {

        //权限
        Authority authority = new Authority();
        authority.setName("查询");
        authority.setValue("query");
        authorityRepository.save(authority);

        //角色
        Role admin = new Role();
        admin.setName("管理员");
        admin.setValue("ROLE_ADMIN");
        admin.setAuthorities(Sets.newHashSet(authorityRepository.findOne(1L)));
        roleRepository.save(admin);

        Role role = new Role();
        role.setName("普通用户");
        role.setValue("ROLE_USER");
        roleRepository.save(role);


        //用户
        User fpf = new User();
        fpf.setUsername("fpf");
        fpf.setPassword("fpf");
        fpf.setRoles(Sets.newHashSet(roleRepository.findOne(1L)));
        userService.createUser(fpf);

        User wl = new User();
        wl.setUsername("wl");
        wl.setPassword("wl");
        wl.setRoles(Sets.newHashSet(roleRepository.findOne(2L)));
        userService.createUser(wl);


    }
}

// 代码生成时间: 2025-09-22 07:28:15
package com.example.micronaut.security;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller("/api/permissions")
@Introspected
public class UserPermissionService {

    // 模拟数据库中的用户权限数据
    private final List<UserPermission> userPermissions;

    public UserPermissionService() {
        this.userPermissions = Arrays.asList(
                new UserPermission(1, "user", Arrays.asList("READ", "WRITE")),
                new UserPermission(2, "admin", Arrays.asList("READ", "WRITE", "DELETE"))
        );
    }

    @Get("/user/{id}")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public UserPermission getUserPermissions(@PathVariable Integer id) {
        return userPermissions.stream()
                .filter(up -> up.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User permission not found"));
    }

    // 内部类，用于表示用户权限
    @Introspected
    public static class UserPermission {
        private Integer id;
        private String role;
        private List<String> permissions;

        public UserPermission(Integer id, String role, List<String> permissions) {
            this.id = id;
            this.role = role;
            this.permissions = permissions;
        }

        public Integer getId() {
            return id;
        }

        public String getRole() {
            return role;
        }

        public List<String> getPermissions() {
            return permissions;
        }
    }
}

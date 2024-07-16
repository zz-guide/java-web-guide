package org.zz.web.guide.servlet.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionUser {
    private Long id;
    private String name;
    private String roleName;
}

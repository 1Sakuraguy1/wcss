package com.example.mybatisplus.common.utls;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.WhitelistSetting;
import com.example.mybatisplus.model.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityUtils {
    /**
     * 获取当前用户
     *
     * @return
     */
    public static UserInfoDTO getUserInfo() {
        //获取session里的当前用户，然后根据当前用户进行封装id，name，type
        WhitelistSetting curUser = SessionUtils.getCurUser();
        //session里面有没有当前用户的信息，如果过没有登录需要模拟一个
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        if (curUser != null){
            userInfoDTO.setId(curUser.getId());
            userInfoDTO.setName(curUser.getName());
            userInfoDTO.setUserType(curUser.getRoleId());
        }else {
            userInfoDTO.setId(1L);
            userInfoDTO.setName("模拟用户");
            userInfoDTO.setUserType(1L);
        }
        return userInfoDTO;
    }
}

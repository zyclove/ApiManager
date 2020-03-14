package cn.crap.adapter;

import cn.crap.dto.UserDTO44;
import cn.crap.model.UserPO;
import cn.crap.utils.BeanUtil;
import cn.crap.utils.DateFormartUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户model适配器，将DTO转为Model，将Model转为DTO
 * 避免暴露敏感数据和修改不允许修改得数据
 */
public class UserAdapter {
    public static UserDTO44 getDto(UserPO user){
        if (user == null){
            return null;
        }

        UserDTO44 userDto = new UserDTO44();
        BeanUtil.copyProperties(user, userDto);
        userDto.setAuthName(user.getAuthName());
        userDto.setRoleName(user.getRoleName());
        if (user.getCreateTime() != null) {
            userDto.setCreateTimeStr(DateFormartUtil.getDateByTimeMillis(user.getCreateTime().getTime()));
        }
        return userDto;
    }

    public static List<UserDTO44> getDto(List<UserPO> users){
        if (users == null){
            return new ArrayList<>();
        }
        List<UserDTO44> userDtos = new ArrayList<>();
        for (UserPO user : users){
            userDtos.add(getDto(user));
        }
        return userDtos;
    }

    /**
     * 将前端不能修改得字段赋值为null
     * @param userDto
     * @return
     */
    public static UserPO getModel(UserDTO44 userDto){
        if (userDto == null){
            return null;
        }
        UserPO user = new UserPO();
        user.setId(userDto.getId());
        user.setAuth(userDto.getAuth());
        user.setAuthName(userDto.getAuthName());
        user.setAvatarUrl(userDto.getAvatarUrl());
        user.setEmail(userDto.getEmail());
        user.setRoleId(userDto.getRoleId());
        user.setRoleName(userDto.getRoleName());
        user.setThirdlyId(userDto.getThirdlyId());
        user.setTrueName(userDto.getTrueName());
        user.setType(userDto.getType());
        user.setUserName(userDto.getUserName());
        user.setStatus(userDto.getStatus());
        user.setLoginType(userDto.getLoginType());
        return user;
    }

}

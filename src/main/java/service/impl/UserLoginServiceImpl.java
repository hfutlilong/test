package service.impl;

import dao.gen.mapper.UserLoginPOMapperExt;
import dao.gen.po.UserLoginPO;
import dao.gen.po.UserLoginPOExample;
import entity.vo.UserLoginVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserLoginService;

import java.util.List;

/**
 * @Description 登录服务实现
 * @Author lilong
 * @Date 2019-04-05 17:30
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginPOMapperExt userLoginPOMapper;

    @Override
    public void register(UserLoginVO userLoginVO) {
        UserLoginPO userLoginPO = new UserLoginPO();
        BeanUtils.copyProperties(userLoginVO, userLoginPO);
        userLoginPOMapper.insertSelective(userLoginPO);
    }

    @Override
    public void updateAccountInfo(UserLoginVO userLoginVO) {
        UserLoginPO userLoginPO = new UserLoginPO();
        BeanUtils.copyProperties(userLoginVO, userLoginPO);
        userLoginPOMapper.updateByPrimaryKey(userLoginPO);
    }

    @Override
    public UserLoginVO queryUserById(Long id) {
        UserLoginPO userLoginPO =  userLoginPOMapper.selectByPrimaryKey(id);
        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(userLoginPO, userLoginVO);
        return userLoginVO;
    }

    @Override
    public UserLoginVO queryUserByNamePwd(String username, String password) {
        UserLoginPOExample example = new UserLoginPOExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<UserLoginPO> userLoginPOList = userLoginPOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userLoginPOList)) {
            return null;
        }

        UserLoginVO userLoginVO = new UserLoginVO();

        UserLoginPO userLoginPO = userLoginPOList.get(0);
        BeanUtils.copyProperties(userLoginPO, userLoginVO);
        return userLoginVO;
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        UserLoginPOExample example = new UserLoginPOExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserLoginPO> userLoginPOList = userLoginPOMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(userLoginPOList);
    }
}

//package service.impl;
//
//import dao.gen.mapper.User2MapperExt;
//import dao.gen.po.User2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import service.User2Service;
//
//@Service("user2Service")
//public class User2ServiceImpl implements User2Service {
//    @Autowired
//    User2MapperExt user2Mapper;
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequired(User2 user) {
//        user2Mapper.insert(user);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequiredException(User2 user) {
//        user2Mapper.insert(user);
//        throw new RuntimeException();
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void addRequiresNew(User2 user){
//        user2Mapper.insert(user);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void addRequiresNewException(User2 user){
//        user2Mapper.insert(user);
//        throw new RuntimeException();
//    }
//}

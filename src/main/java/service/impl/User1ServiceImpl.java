//package service.impl;
//
//import dao.gen.mapper.User1MapperExt;
//import dao.gen.po.User1;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import service.User1Service;
//
//@Service("user1Service")
//public class User1ServiceImpl implements User1Service {
//
//    @Autowired
//    User1MapperExt user1Mapper;
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void addRequired(User1 user) {
//        user1Mapper.insert(user);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void addRequiresNew(User1 user){
//        user1Mapper.insert(user);
//    }
//}

package service;

import dao.gen.po.User1;

public interface User1Service {
    void addRequired(User1 user);

    void addRequiresNew(User1 user);
}

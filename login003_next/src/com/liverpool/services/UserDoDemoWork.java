

package com.liverpool.services;

import com.liverpool.model.ModelUser;
import com.liverpool.model.ModelWork;
import com.liverpool.model.StatusType;
import com.liverpool.model.WorkType;

public class UserDoDemoWork {

    public UserDoDemoWork(ModelUser user) {
        
        int cnt = 0;
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.RESEARCH, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.THESIS, 0, StatusType.PENDING));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.RESEARCH, 0, StatusType.APPROVED));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.APPROVED));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.RESEARCH, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.THESIS, 0, StatusType.PENDING));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.RESEARCH, 0, StatusType.APPROVED));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.APPROVED));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.RESEARCH, 0, StatusType.REJECT));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.THESIS, 0, StatusType.PENDING));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.THESIS, 0, StatusType.APPROVED));
        user.addWork(new ModelWork("2022", "Demo Work " + ++cnt, user.getUserName(), WorkType.PROJECT, 0, StatusType.REJECT));

    }
    
}

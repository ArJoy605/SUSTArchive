
package com.liverpool.services;

import com.liverpool.model.ModelWork;
import com.liverpool.model.StatusType;
import com.liverpool.model.WorkType;
import java.util.ArrayList;

public class RecentDemoWorks {

    public RecentDemoWorks(ArrayList works) {
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.THESIS, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.THESIS, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.RESEARCH, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.THESIS, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.PROJECT, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.THESIS, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "E Hawa", "Shihab", WorkType.PROJECT, 0, StatusType.REJECT));
        works.add(new ModelWork("2022", "E Hawa", "Shihab", WorkType.RESEARCH, 0, StatusType.REJECT));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.PROJECT, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.RESEARCH, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.RESEARCH, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "E Hawa", "Shihab", WorkType.THESIS, 0, StatusType.PENDING));
        works.add(new ModelWork("2022", "E Hawa", "Shihab", WorkType.RESEARCH, 0, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.THESIS, 5000, StatusType.APPROVED));
        works.add(new ModelWork("2022", "Joy Bangla", "Sheikh Mujib", WorkType.PROJECT, 5000, StatusType.APPROVED));

    }
}

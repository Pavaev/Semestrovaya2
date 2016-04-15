package project.service;

import org.springframework.data.domain.Page;
import project.model.Complaint;

/**
 * Created by Daniel Shchepetov on 15.04.2016.
 */
public interface IComplaintLogService {
    Page<Complaint> getComplaintLog(Integer pageNum);
}

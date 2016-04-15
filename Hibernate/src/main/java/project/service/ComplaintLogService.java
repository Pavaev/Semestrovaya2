package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Complaint;
import project.repo.ComplaintRepository;

import javax.inject.Inject;

/**
 * Created by Daniel Shchepetov on 15.04.2016.
 */
@Service
@Transactional
public class ComplaintLogService implements IComplaintLogService {
private static final int PAGE_SIZE = 15;
    @Inject
    private ComplaintRepository complaintRepo;

    @Override
    public Page<Complaint> getComplaintLog(Integer pageNum) {
        PageRequest request =
                new PageRequest(pageNum - 1, PAGE_SIZE);
        return complaintRepo.findAll(request);
    }
}

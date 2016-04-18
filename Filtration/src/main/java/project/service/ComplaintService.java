package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Complaint;
import project.repo.ComplaintRepository;

/**
 * Created by Daniel Shchepetov on 15.04.2016.
 */
@Service
@Transactional
public class ComplaintService implements IComplaintService {
private static final int PAGE_SIZE = 5;
    @Autowired
    private ComplaintRepository complaintRepo;

    @Override
    public Page<Complaint> getPage(Integer pageNum) {
        PageRequest request =
                new PageRequest(pageNum - 1, PAGE_SIZE);
        return complaintRepo.findAll(request);
    }


}

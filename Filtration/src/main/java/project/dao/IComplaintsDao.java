package project.dao;

import project.model.Complaint;

/**
 * Created by Daniel Shchepetov on 11.04.2016.
 */
public interface IComplaintsDao {
    Complaint find(int id);

    void create(Complaint comp);

    void update(Complaint comp);

    void delete(String id);
}
package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.model.Complaint;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel Shchepetov on 11.04.2016.
 */
@Repository
public class ComplaintsDao implements IComplaintsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSource")
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Complaint find(int id) {

        String query = "SELECT * FROM complaints WHERE `id` = ?;";
return jdbcTemplate.queryForObject(
        query, new RowMapper<Complaint>() {
            public Complaint mapRow(ResultSet rs, int rowNum) throws SQLException{
                Complaint comp = new Complaint();
                comp.setId(rs.getInt(1));
                comp.setUser_id(rs.getInt(2));
                comp.setPost(rs.getString(3));
                comp.setImageURI(rs.getString(4));
                comp.setDate(rs.getString(5));
                return comp;
            }
        },
id
);
    }

    @Override
    public void create(Complaint comp) {
        String query = "INSERT INTO complaints(`post`,`header`, `company`) VALUES (?,?,?);";
        jdbcTemplate.update(query, comp.getPost(), comp.getHeader(), comp.getCompany());
    }


    @Override
    public void update(Complaint comp) {
        String query = "UPDATE complaints SET `header` = ?, `text` = ? WHERE `id` = ?;";
        jdbcTemplate.update(query, comp.getHeader(), comp.getPost(), comp.getId());
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM complaints WHERE `id` = ?;";
        jdbcTemplate.update(query, id);
    }
}

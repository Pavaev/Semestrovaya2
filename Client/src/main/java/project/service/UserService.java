package project.service;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import project.exception.ServerException;
import project.model.User;


import java.io.IOException;
import java.util.List;


public class UserService implements RestService<User> {


    private HttpClient client;
    private Header contentTypeHeader;
    private JsonConverter converter;

    public UserService() {
        this.converter = new JsonConverter();
        contentTypeHeader = new BasicHeader("Content-Type", "application/json; charset=UTF-8");
        client = HttpClientBuilder.create().build();
    }

    @Override
    public User getObject(int id) throws ServerException {
        try {
            HttpGet get = new HttpGet("http://localhost:8080/user/" + id);
            get.addHeader(contentTypeHeader);
            HttpResponse response = client.execute(get);
            throwException(response, 200);
            return converter.convert(response.getEntity().getContent());
        } catch (IOException e) {
            throw new ServerException(e.getMessage(), e, 500);
        }
    }

    @Override
    public User create(User user) throws ServerException {
        try {
            HttpPost post = new HttpPost("http://localhost:8080/user/");
            post.addHeader(contentTypeHeader);
            post.setEntity(new StringEntity(converter.convert(user)));
            HttpResponse response = client.execute(post);
            throwException(response, 201);
            return converter.convert(response.getEntity().getContent());
        } catch (IOException e) {
            throw new ServerException(e.getMessage(), e, 500);
        }
    }

    @Override
    public User update(int id, User object) throws ServerException {
        try {

            HttpPut put = new HttpPut("http://localhost:8080/user/" + id);
            put.addHeader(contentTypeHeader);
            put.setEntity(new StringEntity(converter.convert(object)));
            HttpResponse response = client.execute(put);
            throwException(response, 200);
            return converter.convert(response.getEntity().getContent());
        } catch (IOException e) {
            throw new ServerException(e.getMessage(), e, 500);
        }
    }

    @Override
    public void delete(int id) throws ServerException {
        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpDelete delete = new HttpDelete("http://localhost:8080/user/" + id);
            delete.addHeader(contentTypeHeader);
            HttpResponse response = client.execute(delete);
            throwException(response, 204);
        } catch (IOException e) {
            throw new ServerException(e.getMessage(), e, 500);
        }
    }


    @Override
    public List<User> getAll() throws ServerException {

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet("http://localhost:8080/user/");
            get.addHeader(contentTypeHeader);
            HttpResponse response = client.execute(get);
            throwException(response, 200);
            return converter.convertToList(response.getEntity().getContent());
        } catch (IOException e) {
            throw new ServerException(e.getMessage(), e, 500);
        }
    }



    private void throwException(HttpResponse response, int code) throws ServerException {
        if (response.getStatusLine().getStatusCode() == code) return;
        switch (response.getStatusLine().getStatusCode()) {
            case 204 :
                throw new ServerException("There is no content", 204);
            case 404 :
                throw new ServerException("User is not exists", 404);
            case 409 :
                throw new ServerException("The user already exists", 409);
            default:
                throw new ServerException("Server error", response.getStatusLine().getStatusCode());
        }
    }

}

package com.auth.service.dao;

import com.auth.service.entities.User;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UserDAO {
   
    private final MongoCollection<Document> collection;
    
    private final Gson gson = new Gson();

    public UserDAO(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void doAction() {
        this.updatePassword("a54f0642-3898-4b83-8379-86bc091fc69d", "BALAGAN");
        Long count = this.getUsersCount();
        System.out.println("user count is " + count);
    }

    public User save(User data) {
        UUID userId = UUID.randomUUID();
        data.setId(userId.toString());
        String json = gson.toJson(data);
        BasicDBObject document = (BasicDBObject) JSON.parse(json);
        collection.insertOne(new Document(document));
        return data;
    }

    public User findById(String id) {
        User entity = new User();
        Document query = new Document();
        query.put("id", id);
        for (Document doc : collection.find(query)) {
            entity = gson.fromJson(doc.toJson(), User.class);
        }
        return entity;
    }

    public List<User> findAll() {
        final List<User> userList = new ArrayList<>();
        @SuppressWarnings("UnusedAssignment")
        User entity = new User();
        String sort = "registeredDate";
        String order = "desc";
        Bson sortCriteria = new BasicDBObject(sort, "desc".equals(order) ? -1 : 1);
        Document query = new Document();
        for (Document doc : collection.find(query).sort(sortCriteria)) {
            entity = gson.fromJson(doc.toJson(), User.class);
            userList.add(entity);

        }
        return userList;
    }

    public boolean updatePassword(String id, String password) {
        Document document = new Document();
        document.append("$set", new BasicDBObject()
                .append("password", password));
        UpdateResult update = collection.updateOne(new BasicDBObject().append("id", id), document);
        System.out.println("updatePassword " + update.wasAcknowledged());
        return true;
    }

    public boolean updateProfile(String userId, User entity) {
        try {
            Document document = new Document();

            document.append("$set",
                    new BasicDBObject()
                            .append("email", entity.getEmail())
                            .append("firstname", entity.getFirstname())
                            .append("lastname", entity.getLastname()));

            UpdateResult update = collection.updateOne(new BasicDBObject().append("id", userId), document);
            System.out.println("updateProfile " + update.wasAcknowledged());
        } catch (Exception e) {

            return false;
        }
        return true;
    }

    public Long getUsersCount() {
        Long listCount = 0L;
        try {
            listCount = collection.count();
        } catch (Exception e) {
        }
        return listCount;
    }

    public Optional<User> login(String email, String passwd) {
        User entity = new User();
        Document query = new Document();
        query.put("email", email.trim());
        query.put("password", passwd.trim());
        for (Document doc : collection.find(query)) {
            entity = gson.fromJson(doc.toJson(), User.class);
        }
        return Optional.of(entity);
    }

    public void remove() {
        collection.drop();
    }

}

package com.dp.composite.dao;

import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataProvider {

    private Map<String, Request> requests;
    private Map<String, User> users;

    public DataProvider() {
        // 初始化数据
        users = new HashMap<String, User>();
        requests = new HashMap<>();
        // 创建用户对象，并添加到 Map 中
        User user1 = new User("admin", "123456", Arrays.asList("admin", "user"), Arrays.asList("read", "write", "delete"));
        User user2 = new User("user1", "123456", Arrays.asList("user"), Arrays.asList("read", "write"));
        User user3 = new User("user2", "123456", Arrays.asList("user"), Arrays.asList("read"));
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);
        users.put(user3.getUsername(), user3);

        // 创建请求对象，并添加到 Map 中
        Request request1 = new Request("/api/user/list", "GET", Arrays.asList("admin"), Arrays.asList("read"));
        Request request2 = new Request("/api/user/add", "POST", Arrays.asList("admin"), Arrays.asList("write"));
        Request request3 = new Request("/api/user/delete", "DELETE", Arrays.asList("admin"), Arrays.asList("delete"));
        Request request4 = new Request("/api/user/update", "PUT", Arrays.asList("user"), Arrays.asList("write"));
        requests.put(request1.getUrl(), request1);
        requests.put(request2.getUrl(), request2);
        requests.put(request3.getUrl(), request3);
        requests.put(request4.getUrl(), request4);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * 根据url获取请求信息
     * @param url
     * @return
     */
    public Request getRequestByPath(String url) {
        return requests.get(url);
    }
}

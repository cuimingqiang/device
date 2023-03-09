package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CurrentApp {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String uid;

    private String gid;

    private String context;

    private String groups;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return this.uid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGid() {
        return this.gid;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return this.context;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getGroups() {
        return this.groups;
    }
}
package com.oskarro.doortodoor.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    // we can use also long type, but Long could be null, while long not.
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

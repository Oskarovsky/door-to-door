package com.oskarro.doortodoor.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass // this established this as a base class to JPA
public class BaseEntity implements Serializable {

    // we can use also long type, but Long could be null, while long not.
    // @Id this annotation tells JPA that this is the ID value
    // @GeneratedValue [IDENTITY] - this going to provide us the identity value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

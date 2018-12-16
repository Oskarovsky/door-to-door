package com.oskarro.doortodoor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass // this established this as a base class to JPA
public class BaseEntity implements Serializable {

    // we can use also long type, but Long could be null, while long not.
    // @Id this annotation tells JPA that this is the ID value
    // @GeneratedValue [IDENTITY] - this going to provide us the identity value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }
}

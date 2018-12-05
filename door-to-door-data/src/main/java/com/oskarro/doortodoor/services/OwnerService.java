package com.oskarro.doortodoor.services;

import com.oskarro.doortodoor.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}

package com.genericstrentals.platform.u202014511.inventories.domain.exceptions;

/**
 * Exception thrown when a group is not found
 * @author Johan Principe Godoy u202014511
 * @version 1.0
 */
public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(Long groupId) {
        super("Group with ID %s not found".formatted(groupId));
    }
}

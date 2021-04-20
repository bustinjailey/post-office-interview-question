package com.postoffice;

import java.util.Set;

/**
 * Abstraction of the persistent data store used by PostOffice
 */
public class AddressDatabase {
    Set<String> addresses;

    public AddressDatabase(String dbConnectionString) {
        addresses = loadFromDatabase(dbConnectionString);
    }

    private Set<String> loadFromDatabase(String dbConnectionString) {
        return Set.of("Address 1", "Address 2");
    }

    public boolean select(String deliveryAddress) {
        return false;
    }

    public boolean delete(String deliveryAddress) {
        return false;
    }

    public boolean insert(String deliveryAddress) {
        return false;
    }
}

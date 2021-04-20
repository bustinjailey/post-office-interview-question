package com.postoffice;

import java.util.Set;

/**
 * Abstraction of a persistent data store used by PostOffice
 */
public class PackageDatabase {
    Set<Package> packages;

    public PackageDatabase(String dbConnectionString) {
        packages = loadFromDatabase(dbConnectionString);
    }

    private Set<Package> loadFromDatabase(String dbConnectionString) {
        return Set.of();
    }

    public Package select(Integer trackingNumber) {
        return null;
    }

    public boolean delete(Integer trackingNumber) {
        return false;
    }

    public boolean insert(Package pkg) {
        return false;
    }
}

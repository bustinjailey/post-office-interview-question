package com.postoffice;

import com.postoffice.config.PostOfficeConfig;

public class PostOffice {
    private final AddressDatabase deliveryAddressDatabase;
    private final PackageDatabase packageDatabase;

    /**
     * Create a new post office instance using the given application configuration
     */
    public PostOffice(PostOfficeConfig config) {
        this.deliveryAddressDatabase = new AddressDatabase(config.getDbConnectionString());
        this.packageDatabase = new PackageDatabase(config.getDbConnectionString());
    }

    /**
     * Add a new address to the post office's delivery area
     *
     * @return true if address was created successfully, otherwise false
     */
    public boolean createDeliveryAddress(String deliveryAddress) {
        return deliveryAddressDatabase.insert(deliveryAddress);
    }

    /**
     * Remove an existing address from the post office's delivery area
     *
     * @return true if address was removed successfully, otherwise false
     */
    public boolean deleteDeliveryAddress(String deliveryAddress) {
        return deliveryAddressDatabase.delete(deliveryAddress);
    }

    /**
     * Send a package to the package's delivery address
     *
     * @return true if package was sent successfully, otherwise false
     */
    public boolean mailPackage(Package pkg) {
        if (deliveryAddressDatabase.select(pkg.deliveryAddress)) {
            packageDatabase.insert(pkg);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks to see if a package has been delivered
     *
     * @return true if package was delivered, otherwise false
     */
    public boolean trackPackage(Integer trackingNumber) {
        return packageDatabase.select(trackingNumber).isDelivered;
    }
}

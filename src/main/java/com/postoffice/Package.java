package com.postoffice;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Package {
    public Integer trackingNumber;
    public LocalDate deliveryDate;
    public String deliveryAddress;
    public PackageContents contents;
    public boolean isDelivered;

    public Package(Integer trackingNumber, LocalDate deliveryDate, String deliveryAddress, PackageContents contents) {
        this.trackingNumber = trackingNumber;
        this.deliveryDate = deliveryDate;
        this.deliveryAddress = deliveryAddress;
        this.contents = contents;
    }

    public static Package createPackage(DeliveryPriority priority, String deliveryAddress, PackageContents contents) {
        LocalDate deliveryDate = null;
        switch (priority) {
            case CRITICAL:
                deliveryDate = LocalDate.now().plusDays(1);
                break;
            case HIGH:
                deliveryDate = LocalDate.now().plusDays(3);
                break;
            case LOW:
                deliveryDate = LocalDate.now().plusDays(5);
                break;
        }

        int trackingNumber = ThreadLocalRandom.current().nextInt(1, 5001);

        return new Package(trackingNumber, deliveryDate, deliveryAddress, contents);
    }
}

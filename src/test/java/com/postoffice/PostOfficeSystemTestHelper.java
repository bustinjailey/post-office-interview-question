package com.postoffice;

import com.postoffice.config.PostOfficeConfig;

public class PostOfficeSystemTestHelper {
    static PostOfficeConfig loadTestPostOfficeConfig() {
        return () -> "fake";
    }
}

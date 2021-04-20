package com.postoffice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

/**
 * Runs all tests in PostOfficeSystemTests using a live instance of the PostOffice application
 */
public class PostOfficeSystemTestHarness {
    private static final SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectClass(PostOfficeSystemTests.class))
                .build();

        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.discover(request);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        summary.printTo(new PrintWriter(System.out));
    }
}

/**
 * Initializes a 'live' instance of the PostOffice and verifies its functionality
 */
class PostOfficeSystemTests {
    public static PostOffice postOffice;

    @BeforeAll
    public static void initializePostOffice() {
        postOffice = new PostOffice(PostOfficeSystemTestHelper.loadTestPostOfficeConfig());
    }

}
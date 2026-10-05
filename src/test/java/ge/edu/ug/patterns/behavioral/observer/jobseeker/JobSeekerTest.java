package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: the test itself has to drive every checkForNewJobs() call. Monica checks
// once after two posts and misses "Dancer"; Erica only gets both jobs because she
// checks after every single post (and wastes a check when nothing is new).
class JobSeekerTest {

    @Test
    void jobSeekerWhoChecksRarelyMissesPosts() {
        EmploymentAgency agency = new EmploymentAgency();
        JobSeeker monica = new JobSeeker("Monica", agency);

        JobPost dancer = new JobPost("Dancer");
        JobPost musician = new JobPost("Musician");
        agency.postJob(dancer);
        agency.postJob(musician);
        monica.checkForNewJobs();

        assertEquals(List.of(musician), monica.getReceivedJobs());
    }

    @Test
    void jobSeekerMustPollAfterEveryPost() {
        EmploymentAgency agency = new EmploymentAgency();
        JobSeeker erica = new JobSeeker("Erica", agency);

        erica.checkForNewJobs();
        assertTrue(erica.getReceivedJobs().isEmpty(), "nothing posted yet - a wasted check");

        JobPost dancer = new JobPost("Dancer");
        agency.postJob(dancer);
        erica.checkForNewJobs();
        JobPost musician = new JobPost("Musician");
        agency.postJob(musician);
        erica.checkForNewJobs();

        assertEquals(List.of(dancer, musician), erica.getReceivedJobs());
    }
}

package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobSeekerTest {

    @Test
    void subscribedJobSeekerReceivesEveryPost() {
        EmploymentAgency agency = new EmploymentAgency();
        JobSeeker monica = new JobSeeker("Monica");
        agency.subscribe(monica);

        JobPost dancer = new JobPost("Dancer");
        JobPost musician = new JobPost("Musician");
        agency.postJob(dancer);
        agency.postJob(musician);

        assertEquals(List.of(dancer, musician), monica.getReceivedJobs());
    }

    @Test
    void unsubscribedJobSeekerStopsReceivingPosts() {
        EmploymentAgency agency = new EmploymentAgency();
        JobSeeker monica = new JobSeeker("Monica");
        JobSeeker erica = new JobSeeker("Erica");
        agency.subscribe(monica);
        agency.subscribe(erica);

        JobPost dancer = new JobPost("Dancer");
        agency.postJob(dancer);
        agency.unsubscribe(monica);
        JobPost musician = new JobPost("Musician");
        agency.postJob(musician);

        assertEquals(List.of(dancer), monica.getReceivedJobs());
        assertEquals(List.of(dancer, musician), erica.getReceivedJobs());
    }
}

package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import org.junit.jupiter.api.Test;

class JobSeekerTest {
    @Test
    public void testJobSeeker() {
        EmploymentAgency agency = new EmploymentAgency();

        Observer monica = new JobSeeker("Monica");
        agency.subscribe(monica);
        agency.subscribe(new JobSeeker("Erica"));
        agency.subscribe(new JobSeeker("Rita"));

        agency.postJob(new JobPost("Dancer"));

        agency.unsubscribe(monica);
        agency.postJob(new JobPost("Musician"));
    }

}

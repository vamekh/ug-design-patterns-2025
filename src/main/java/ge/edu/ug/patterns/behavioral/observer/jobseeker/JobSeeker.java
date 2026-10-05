package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import java.util.ArrayList;
import java.util.List;

// Concrete Observer
public class JobSeeker implements Observer {
    private String name;
    private final List<JobPost> receivedJobs = new ArrayList<>();

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void onJobPosted(JobPost jobPost) {
        System.out.printf("I'm %s and I'm notified that a new job has been posted: %s\n", name, jobPost.title);
        receivedJobs.add(jobPost);
    }

    public List<JobPost> getReceivedJobs() {
        return receivedJobs;
    }
}

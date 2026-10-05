package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import java.util.ArrayList;
import java.util.List;

public class JobSeeker {
    private String name;
    private final EmploymentAgency agency;
    private final List<JobPost> receivedJobs = new ArrayList<>();

    public JobSeeker(String name, EmploymentAgency agency) {
        this.name = name;
        this.agency = agency;
    }

    // Polling: the job seeker has to call this again and again
    public void checkForNewJobs() {
        JobPost latestJob = agency.getLatestJob();
        if (latestJob != null && !receivedJobs.contains(latestJob)) {
            onJobPosted(latestJob);
        }
    }

    private void onJobPosted(JobPost jobPost) {
        System.out.printf("I'm %s and I found out that a new job has been posted: %s\n", name, jobPost.title);
        receivedJobs.add(jobPost);
    }

    public List<JobPost> getReceivedJobs() {
        return receivedJobs;
    }
}

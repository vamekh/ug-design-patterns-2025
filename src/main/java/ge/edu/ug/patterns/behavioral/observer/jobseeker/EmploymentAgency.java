package ge.edu.ug.patterns.behavioral.observer.jobseeker;

// PROBLEM: the agency tells nobody about new jobs. Every JobSeeker has to keep
// asking getLatestJob(). Checking when nothing changed is wasted work, and if two
// jobs are posted between two checks, the first one is never seen.
public class EmploymentAgency {
    private JobPost latestJob;

    public void postJob(JobPost jobPost) {
        System.out.printf("Job has been posted! %s\n", jobPost.title);
        latestJob = jobPost;
    }

    public JobPost getLatestJob() {
        return latestJob;
    }
}

package ge.edu.ug.patterns.behavioral.observer.jobseeker;

public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void onJobPosted(JobPost jobPost) {
        System.out.printf("I'm %s and I'm notified that a new job has been posted: %s\n", name, jobPost.title);
    }
}

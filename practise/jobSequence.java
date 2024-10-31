package practise;

import java.util.*;
// import java.util.Arrays;
// import java.util.Collections;

public class jobSequence {

    public static class Job {
        int profit;
        int deadline;
        int id;

        public Job(int id, int pro, int dead) {
            this.deadline = dead;
            this.id = id;
            this.profit = pro;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println(seq);
        System.out.println(find(jobInfo));
    }

    public static List<Integer> find(int[][] jobsInfo) {
        int n = jobsInfo.length;
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int time = 0;
        List<Integer> seq = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (time < curr.deadline) {
                time++;
                seq.add(curr.id);
            }
        }
        return seq;
    }
}

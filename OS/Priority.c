#include <stdio.h>

int main() {
    int p[20], bt[20], pri[20], wt[20], tat[20], i, k, n, temp;
    float wtavg, tatavg;

    printf("Enter the number of processes --- ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        p[i] = i + 1;  // Process numbers starting from 1
        printf("Enter the Burst Time & Priority of Process %d --- ", i + 1);
        scanf("%d %d", &bt[i], &pri[i]);
    }

    // Sorting processes based on priority (Lower number = Higher priority)
    for (i = 0; i < n - 1; i++) {
        for (k = i + 1; k < n; k++) {
            if (pri[i] > pri[k]) {
                // Swap priority
                temp = pri[i];
                pri[i] = pri[k];
                pri[k] = temp;

                // Swap burst time
                temp = bt[i];
                bt[i] = bt[k];
                bt[k] = temp;

                // Swap process numbers
                temp = p[i];
                p[i] = p[k];
                p[k] = temp;
            }
        }
    }

    // Waiting Time & Turnaround Time Calculation
    wt[0] = wtavg = 0;
    tat[0] = tatavg = bt[0];

    for (i = 1; i < n; i++) {
        wt[i] = wt[i - 1] + bt[i - 1];
        tat[i] = wt[i] + bt[i];  // Corrected Turnaround Time Calculation
        wtavg += wt[i];
        tatavg += tat[i];
    }

    // Display Results
    printf("\nPROCESS\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME\n");
    for (i = 0; i < n; i++) {
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\n", p[i], pri[i], bt[i], wt[i], tat[i]);
    }

    printf("\nAverage Waiting Time is --- %.2f", wtavg / n);
    printf("\nAverage Turnaround Time is --- %.2f\n", tatavg / n);

    return 0;
}

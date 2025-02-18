#include <stdio.h>

int max[100][100], alloc[100][100], need[100][100], avail[100];
int n, r;

void input();
void show();
void cal();

int main() {
    printf("********** Banker's Algo ************\n");
    input();
    show();
    cal();
    return 0;
}

void input() {
    int i, j;
    printf("Enter the no of Processes: ");
    scanf("%d", &n);
    printf("Enter the no of Resources: ");
    scanf("%d", &r);

    printf("Enter the Max Matrix:\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < r; j++)
            scanf("%d", &max[i][j]);

    printf("Enter the Allocation Matrix:\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < r; j++)
            scanf("%d", &alloc[i][j]);

    printf("Enter the Available Resources:\n");
    for (j = 0; j < r; j++)
        scanf("%d", &avail[j]);
}

void show() {
    int i, j;
    printf("\nProcess\t Allocation\t Max\t Available\n");
    for (i = 0; i < n; i++) {
        printf("P%d\t ", i);
        for (j = 0; j < r; j++)
            printf("%d ", alloc[i][j]);

        printf("\t");
        for (j = 0; j < r; j++)
            printf("%d ", max[i][j]);

        printf("\t");
        if (i == 0)
            for (j = 0; j < r; j++)
                printf("%d ", avail[j]);

        printf("\n");
    }
}

void cal() {
    int finish[100] = {0}, safe[100], flag = 1, c1 = 0, i, j, k;

    for (i = 0; i < n; i++)
        for (j = 0; j < r; j++)
            need[i][j] = max[i][j] - alloc[i][j];

    printf("\nSafe Sequence: ");
    while (flag) {
        flag = 0;
        for (i = 0; i < n; i++) {
            int c = 0;
            for (j = 0; j < r; j++) {
                if (finish[i] == 0 && need[i][j] <= avail[j])
                    c++;
            }
            if (c == r) {
                for (k = 0; k < r; k++)
                    avail[k] += alloc[i][k];

                safe[c1++] = i;
                finish[i] = 1;
                flag = 1;
            }
        }
    }

    if (c1 == n) {
        for (i = 0; i < n; i++)
            printf("P%d -> ", safe[i]);
        printf("\nThe system is in a safe state.\n");
    } else {
        printf("\nProcesses are in deadlock. The system is in an unsafe state.\n");
    }
}

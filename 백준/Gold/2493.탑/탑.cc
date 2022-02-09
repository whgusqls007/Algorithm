#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int num[500000], st[500000][2], top = -1;

int main() {
    int N, state = 1;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) scanf("%d", &num[i]);
    for (int i = 0; i < N - 1; i++) {
        if (state == 1) {
            while (num[i] > st[top][0] && top != -1) top--;
            if (top >= 0) printf("%d ", st[top][1] + 1);
            else printf("0 ");
            if (num[i] > num[i + 1]) {
                st[++top][0] = num[i];
                st[top][1] = i;
                state = 0;
            }
        }
        else if (state == 0) {
            st[++top][0] = num[i];
            st[top][1] = i;
            printf("%d ", i);
            if (num[i] < num[i + 1]) state = 1;
        }
    }
    if (state == 0) printf("%d ", N - 1);
    else {
        while (num[N - 1] > st[top][0] && top != -1) top--;
        if (top >= 0) printf("%d ", st[top][1] + 1);
        else printf("0 ");
    }
    return 0;
}
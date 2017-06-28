package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrayY = scanner.nextInt();
        int arrayX = scanner.nextInt();
        int rectCount = scanner.nextInt();

        scanner.nextLine();

        List<Integer[][]> rectAreaList = new ArrayList<>();
        for (int cnt=0; cnt<rectCount; cnt++) {
            Integer rect[][] = new Integer[2][2];
            for (int i=0; i<rect.length; i++) {
                for (int j=0; j<rect.length; j++) {
                    rect[i][j] = scanner.nextInt();
                }
            }
            rectAreaList.add(rect);
        }

        GettingAreaForSubmit ga = new GettingAreaForSubmit();

        int[][] filledArea = ga.fillArea(ga.initializeArea(arrayX, arrayY), rectAreaList);

        ga.showEmptyAreaList(filledArea);
    }
}

class GettingAreaForSubmit {

    public static final int EMPTY = 0;
    public static final int FILL = 1;
    public static final int PASSED = 2;

    private int cnt = 0;
    private List<Integer> rectSizeList;

    public GettingAreaForSubmit() {
        rectSizeList = new ArrayList<>();
    }

    public int[][] fillArea(final int[][] area, List<Integer[][]> rectvisitedList) {

        int[][] filledArea = new int[area.length][area[0].length];
        for (Integer[][] rect : rectvisitedList) {
            for (int i=0; i<area.length; i++) {
                for (int j=0; j<area[i].length; j++) {
                    int y = (area[i].length-1) - j;
                    if ((rect[0][0] <= i && i < rect[1][0]) &&
                            (rect[0][1] <= j && j < rect[1][1]))
                        filledArea[i][y] = FILL;
                    else {
                        if (filledArea[i][y] != FILL)
                            filledArea[i][y] = area[i][j];
                    }
                }
            }
        }

        return filledArea;
    }

    public int[][] initializeArea(int x, int y) {
        int[][] area = new int[x][y];

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                area[i][j] = EMPTY;
            }
        }

        return area;
    }

    public List<Integer> showEmptyAreaList(int[][] area) {

        int[] start = new int[2];
        while (start != null) {
            cnt = 0;
            start = getEmptyPosition(area, 0, 0);
            if (start != null) {
                next(area, start[0], start[1]);

                rectSizeList.add(cnt);
            }
        }

        System.out.println(rectSizeList.size());
        for (int i=0; i<rectSizeList.size(); i++)
            System.out.print(rectSizeList.get(i) + " ");

        return rectSizeList;
    }

    private void next(int[][] area, int x, int y) {

        cnt++;
        area[x][y] = PASSED;

        if (x+1 < area.length && area[x+1][y] <= area.length && area[x+1][y] == EMPTY)
            next(area, x+1, y);

        if (x-1 >= 0 && area[x-1][y] >= 0 && area[x-1][y] == EMPTY)
            next(area, x-1, y);

        if (y+1 < area[x].length && area[x][y+1] <= area[x].length && area[x][y+1] == EMPTY)
            next(area, x, y+1);

        if (y-1 >= 0 && area[x][y-1] >= 0 && area[x][y-1] == EMPTY)
            next(area, x, y-1);

    }

    private int[] getEmptyPosition(int[][] area, int x, int y) {
        int[] start = new int[2];
        for (int i=x; i<area.length; i++) {
            for (int j=y; j<area[0].length; j++) {
                if (area[i][j] == EMPTY) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private void showGraph(int[][] area) {
        for (int j=0; j<area[0].length; j++) {
            System.out.println();
            for (int i=0; i<area.length; i++) {
                System.out.print(area[i][j]);
            }
        }
    }
}

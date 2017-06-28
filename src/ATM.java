import java.util.*;

public class ATM {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        scanner.nextLine();

        List<Integer> peopleList = new ArrayList<>();
        for (int i=0; i<num; i++) {
            peopleList.add(scanner.nextInt());
        }

        Ascending ascending = new Ascending();
        Collections.sort(peopleList, ascending);

        int sum = 0;
        int time = 0;
        for (int people : peopleList) {
            time += people;
            sum += time;
        }

        System.out.println(sum);
    }

    static class Ascending implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    }
}

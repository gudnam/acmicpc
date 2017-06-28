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

        Collections.sort(peopleList);

        int sum = 0;
        int time = 0;
        for (int people : peopleList) {
            time += people;
            sum += time;
        }

        System.out.println(sum);
    }
}

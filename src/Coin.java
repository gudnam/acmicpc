import java.util.*;

public class Coin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int coinTypeNum = scanner.nextInt();
        int sum = scanner.nextInt();

        scanner.nextLine();

        List<Integer> coinTypes = new ArrayList<>();

        for (int i=0; i<coinTypeNum; i++) {
            coinTypes.add(scanner.nextInt());
            scanner.nextLine();
        }

        Collections.reverse(coinTypes);

        int coin = 0;
        int count = 0;

        for (int i=0; i<coinTypes.size(); i++) {

            while (coin < sum) {
                int temp = coin + coinTypes.get(i);

                if (temp > sum) {
                    break;
                } else {
                    coin = temp;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

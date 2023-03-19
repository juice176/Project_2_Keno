public class Odds {
    public static String gameChart(int spots, int matched, int bet) {
        int amount = 0;

        switch (spots) {

            case 1:
                switch (matched) {
                    case 1:
                        amount = 2;
                        break;
                    default:
                        amount = 0;
                        break;
                }
                break;

            case 4:
                switch (matched) {
                    case 2:
                        amount = 1;
                        break;
                    case 3:
                        amount = 5;
                        break;
                    case 4:
                        amount = 75;
                        break;
                    default:
                        amount = 0;
                        break;
                }
                break;

            case 8:
                switch (matched) {
                    case 4:
                        amount = 2;
                        break;
                    case 5:
                        amount = 12;
                        break;
                    case 6:
                        amount = 50;
                        break;
                    case 7:
                        amount = 750;
                        break;
                    case 8:
                        amount = 10000;
                        break;
                    default:
                        amount = 0;
                        break;
                }
                break;

            case 10:
                switch (matched) {
                    case 0:
                        amount = 5;
                        break;
                    case 5:
                        amount = 2;
                        break;
                    case 6:
                        amount = 15;
                        break;
                    case 7:
                        amount = 40;
                        break;
                    case 8:
                        amount = 450;
                        break;
                    case 9:
                        amount = 4250;
                        break;
                    case 10:
                        amount = 100000;
                        break;
                    default:
                        amount = 0;
                        break;
                }
                break;

            default:
                amount = 0;
                break;
        }

        return Integer.toString(amount * bet);
    }
}

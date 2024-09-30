public class nome {

        public static void main(String[] args) {

            if(args.length == 1) {
                System.out.println("Array not long enough");
                System.exit(0);
            }

            int[] numbers;


            if(args.length > 1) {

                numbers = new int[args.length];
                for(int i = 0 ; i < args.length ; i++)
                {
                    numbers[i] = Integer.parseInt(args[i]);
                }



            } else {

                numbers = new int[]{0, 5, 1209, 6, 2, 111, 112, 33};

            }

            print(numbers);
        }

        public static void print(int[] numbers) {

            System.out.print("Sequência:");
            for(int number : numbers) {
                System.out.print(" " + number);
            }
            System.out.println();

        }
    }


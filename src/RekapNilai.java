import java.util.scanner;

public class RekapNilai {

    static final int SELESAI = -1;

    public static void main (String[] args) {
        Scanner scanner =new Scanner(System.in);

        int jumlahSah = 0;
        int total = 0;
        int nilai;

        do{
            System.out.print("Nilai ke-" + (jumlahSah + 1) + " : ");
            nilai = scanner.nextInt();

            if (nilai < 0 || nilai > 100)   {
                if (nilai != SELESAI)   {
                    System.out.println("  Ditolak, nilai harus 0-100");

                }
            }
        }
    }
}
import java.util.Scanner;

public class RekapNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int jumlahSah = 0;
        double total = 0;
        int nilai;

        // do-while lebih pas karena nilai pertama harus diminta dulu sebelum ada yang bisa dicek.
        do {
            System.out.print("Nilai ke-" + (jumlahSah + 1) + " : ");
            nilai = scanner.nextInt();

            if (nilai < 0 || nilai > 100) {
                if (nilai != SELESAI) {
                    System.out.println("  ditolak - nilai harus 0..100");
                }
                // continue di do-while lompat ke kondisi while, jumlahSah tidak ikut naik
                continue;
            }

            char grade;
            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }
            // Percobaan urutan dibalik (nilai >= 60 ditaruh paling atas), nilai 85:
            // hasilnya Grade D, bukan B. Java berhenti di cabang pertama yang true,
            // jadi semua nilai >= 60 masuk D dan cabang A, B, C tidak pernah dicek.

            String keterangan = switch (grade) {
                //menggunakan switch lambda sehingga berbeda dengan switch lama dimana menggunakan panah dan tanpa break
                //juga langsung menghasilkan nilai yang disimpan di variabel
                //menggunakan default agar semua kemungkinan di tangani dan default jatoh ke 'E'
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };


                System.out.println("  Grade " + grade + " - " + keterangan);

                total += nilai;
                jumlahSah++;
            } while (nilai != SELESAI);

            // menjaga kasus belum ada nilai sah, menggunakan double gar tidak perlu casting lagi dan langsung desimal
            // (langsung ketik -1) supaya tidak bagi nol
            double rata = jumlahSah == 0 ? 0 : total / jumlahSah;
            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";

            System.out.println();
            System.out.println("Nilai sah : " + jumlahSah);
            System.out.println("Rata-rata : " + String.format("%.2f", rata));
            System.out.println("Status : " + status);

            scanner.close();
        }
    }

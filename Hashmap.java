import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {

    public static void main(String[] args) throws Exception {

        String namaBarang;
        String nama_barang;
        int jumlahBarang;
        
        HashMap <String, Integer> barang =  new HashMap<>();

        Scanner input = new Scanner(System.in);
        
        while (true){
            System.out.println("\n1. Tambahkan Barang");
            System.out.println("2. Update Stok");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Cari Barang");
            System.out.println("5. Daftar Barang");
            System.out.println("0. Keluar");

            System.out.print("\nPilihan Anda: ");
            String pilihan = input.nextLine();

            //tambah barang
            if(pilihan.equals("1")){
                pilihan = null;
                System.out.println("\nTambahkan Barang (0 = kembali ke Menu Utama)");
                
                while(true){
                    System.out.print("\nNama Barang: ");
                    nama_barang = input.nextLine();
                    namaBarang = nama_barang.toUpperCase();

                    if(!barang.containsKey(namaBarang) && !namaBarang.equals("0")){
                        System.out.print("Jumlah Barang: ");
                        jumlahBarang = input.nextInt();
                        input.nextLine();

                        barang.put(namaBarang, jumlahBarang);
                        System.out.println(namaBarang + " Berhasil Ditambahkan");
                    }

                    else if(namaBarang.equals("0")){
                        break;
                    }

                    else {
                        System.out.println("\nBarang Sudah Ada");
                    }
                }
            }

            //tambah stock
            else if(pilihan.equals("2")){
                System.out.println("\nUpdate Stock (0 = kembali ke Menu Utama)");
                
                while (true){
                    System.out.print("\nNama Barang: ");
                    nama_barang = input.nextLine();
                    namaBarang = nama_barang.toUpperCase();

                    if(barang.containsKey(namaBarang)){
                        System.out.println("\nStok Sekarang: " + barang.get(namaBarang));
                        System.out.println("\nSilahkan Tambahkan Stock");
                        System.out.print("Tambahan Stock: ");
                        jumlahBarang = input.nextInt();
                        input.nextLine();

                        int jumlahSekarang = barang.get(namaBarang);
                        barang.put(namaBarang, jumlahSekarang + jumlahBarang);
                        System.out.println("\nStock Berhasil DItambahkan Menjadi " + barang.get(namaBarang));
                    }

                    else if(namaBarang.equals("0")){
                        break;
                    }

                    else{
                        System.out.println("\nBarang Tidak Ditemukan");
                    }
                }
            }

            //hapus barang
            else if(pilihan.equals("3")){
                System.out.println("\nHapus Barang (0 = kembali ke Menu Utama)");
                
                while (true){
                    System.out.print("\nNama Barang: ");
                    nama_barang = input.nextLine();
                    namaBarang = nama_barang.toUpperCase();

                    if(barang.containsKey(namaBarang)){
                        System.out.println("\nYakin Ingin Menghapus Barang?");
                        System.out.print("Y/N: ");
                        String YN = input.nextLine();
                        String YesNO = YN.toUpperCase();

                        if(YesNO.equals("Y")){
                            barang.remove(namaBarang);
                            System.out.println("\n" + namaBarang + " Berhasil Dihapus");
                        }

                        else if (YesNO.equals("N")){
                            System.out.println("\nPenghapusan Dibatalkan");
                        }

                        else{
                            System.out.println("Pilihan Hanya Y/N");
                        }
                    }

                    else if(namaBarang.equals("0")){
                        break;
                    }

                    else{
                        System.out.println("\nBarang Tidak Ditemukan");
                    }
                }
            }

            //cari barang
            else if (pilihan.equals("4")){
                System.out.println("\nCari Barang (0 = kembali ke Menu Utama)");
                
                while(true){
                    System.out.print("\nNama Barang: ");
                    nama_barang = input.nextLine();
                    namaBarang = nama_barang.toUpperCase();

                    if(barang.containsKey(namaBarang)){
                        System.out.println("\nBarang Ditemukan");
                        
                        System.out.println("Nama Barang: " + namaBarang + "\nJumlah Barang: " + barang.get(namaBarang));
                    }

                    else if(namaBarang.equals("0")){
                        break;
                    }

                    else{
                        System.out.println("\nBarang Tidak Ditemukan");
                    }
                }
            }

            //Daftar Barang
            else if (pilihan.equals("5")){
                if(barang.size() > 0 ){
                    System.out.println("\nTotal Jenis Barang: " + barang.size() + "\n");
                    for (String i : barang.keySet()){
                        System.out.println("Nama Barang: " + i + "(" + barang.get(i) + ")");
                    }                    
                }

                else{
                    System.out.println("Tidak Ada Barang yang Disimpan");            
                }
            }
            
            //keluar
            else if(pilihan.equals("0")){
                break;
            }   
        }
        input.close();
    }
}